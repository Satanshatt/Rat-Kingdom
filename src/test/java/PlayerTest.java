import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private static final int START_POS_X = 5;
    private static final int START_POS_Y = 5;
    private static final int DEFAULT_VALUE_HEALTH = 100;
    private static final int DEFAULT_VALUE_MANA = 100;
    private static final int DEFAULT_VALUE_STRENGTH = 10;
    private static final int DEFAULT_VALUE_DEXTERITY = 10;
    private static final int DEFAULT_VALUE_INTELLIGENCE = 10;
    private static final int DEFAULT_VALUE_XP = 0;
    private static final int DEFAULT_VALUE_LEVEL = 1;
    private static final int XP_MAX_VALUE = 100;
    private static final int NEGATIVE_INPUT = -1;
    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;
    private static final int HEALTH_MAX_VALUE = 100;

    @Test
    public void increase_Xp_Success () {
        Player player = new Player();
        int xpBefore = player.getXp();
        player.increaseXp(10);
        int xpAfter = player.getXp();
       // assertTrue(b);

    }

    @Test
    public void player_defaultValue_Is_Correct () {
        Player player = new Player();
        assertEquals(DEFAULT_VALUE_HEALTH, player.getHealth());
        assertEquals(DEFAULT_VALUE_MANA, player.getMana());
        assertEquals(DEFAULT_VALUE_STRENGTH, player.getStrength());
        assertEquals(DEFAULT_VALUE_DEXTERITY, player.getDexterity());
        assertEquals(DEFAULT_VALUE_INTELLIGENCE, player.getIntelligence());
        assertEquals(DEFAULT_VALUE_XP, player.getXp());
        assertEquals(DEFAULT_VALUE_LEVEL, player.getLevel());
        assertEquals(START_POS_X, player.getPosX());
        assertEquals(START_POS_Y, player.getPosY());
    }

    @Test
    public void player_Moves_One_Step_To_Right () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();

        int xBefore = player.getPosX();
        player.move(room, Direction.RIGHT);
        int xAfter = player.getPosX();

        assertTrue(xBefore != xAfter);
    }

    @Test
    public void player_Moves_One_Step_Upwards () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();

        int yBefore = player.getPosY();
        player.move(room, Direction.UPWARDS);
        int yAfter = player.getPosY();

        assertTrue(yBefore != yAfter);
    }

    @Test
    public void player_Moves_room_is_null_error () {
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                Room room = null;
                player.move(room, Direction.UPWARDS);
            }
        });
    }

    @Test
    public void player_Try_Move_To_Occupied_coordinate_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom("ground").createWallsAndDoors().generate();

                npc.setPosX(START_POS_X);
                npc.setPosY(START_POS_Y+1);
                room.addEntity(npc);

                player.move(room, Direction.UPWARDS);
            }
        });
    }
    //Snacka med Hannes
    @Test
    public void player_Try_Walk_Outside_Room_Error () {
    }

    @Test
    public void player_Dies () {
        Player player = new Player();
        player.increaseLevel();
        int higherLevel = player.getLevel();
        player.die();
        assertTrue(higherLevel > DEFAULT_VALUE_LEVEL);
    }

    @Test
    public void player_Use_Door () {}

    //funkar ej ännu pga av npc-kordinater
    @Test
    public void player_Fret_NPC () {
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        int npcStartDamage = npc.getHealth();
        npc.setPosY(START_POS_Y);
        npc.setPosX(START_POS_X+1);
        player.fret(npc);
        int npcDamageAfterAttack = npc.getHealth();
        assertTrue(npcStartDamage > npcDamageAfterAttack);
    }

    @Test
    public void player_Try_Use_Weapon_On_NPC_Out_Of_Range_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                npc.setPosX(START_POS_X + 3);
                player.useWeaponOnNPC(npc);
            }
        });
    }

    @Test
    public void player_Try_Fret_NPC_Out_Of_Range_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                npc.setPosX(START_POS_X + 3);
                player.fret(npc);
            }
        });
    }

    //Ej klar, behöver metod i NPC som skadar en player
    @Test
    public void player_Gets_Hurt_By_NPC () {
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

        int playerStartHealth = player.getHealth();
        System.out.println("start: " + playerStartHealth);
        npc.damagePlayer(player);
        int playerHealthAfterAttack = player.getHealth();
        System.out.println("After: " + playerHealthAfterAttack);

        assertTrue(playerStartHealth > playerHealthAfterAttack);
    }

    @Test
    public void add_Over_Health_Maxvalue () {
        Player player = new Player();
        player.increaseHealth(HEALTH_MAX_VALUE + 1);
        assertEquals(HEALTH_MAX_VALUE, player.getHealth());
    }

    /*
    När spelaren dör startar man om på ruta ett igen, dvs tillbaka till nivå 1.
     */
    @Test
    public void health_Goes_Under_Zero_Player_Dies () {
        Player player = new Player();
        player.increaseLevel();
        int higherLevel = player.getLevel();
        player.playerTakesDamage(player.getHealth() + 1);
        assertTrue(higherLevel > DEFAULT_VALUE_LEVEL);
    }

    @Test
    public void mana_Increase_By_Level () {
        Player player = new Player();
        int manaBefore = player.getMana();
        player.increaseLevel();
        int manaAfter = player.getMana();
        assertTrue(manaBefore < manaAfter);

    }

    //Går ej igenom pga NPC kordinater är 0,0
    @Test
    public void kill_NPC_With_fret_And_Increase_Xp () {
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

        int xPBefore = player.getXp();
        while(!npc.isDead()) {
            player.attack(npc, AttackChoice.FRET);
        }
        int xPAfter = player.getXp();

        assertTrue(xPBefore < xPAfter);
    } //Eller annat än xp

    @Test
    public void level_Upgrade_With_Xp_Success(){
        Player player = new Player();
        int levelUp = 1;
        player.increaseXp( XP_MAX_VALUE +1);
        assertEquals(DEFAULT_VALUE_LEVEL + levelUp, player.getLevel());
    }

    @Test
    public void pick_Up_Weapon_And_Activate () {
        Player player = new Player();
        Weapon weapon = Mockito.mock(Weapon.class, Mockito.CALLS_REAL_METHODS);
        player.pickUpWeapon(weapon);
        assertEquals(weapon, player.getActiveWeapon());
    }

    @Test
    public void increase_With_Negative_Health_input_Error () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseHealth(NEGATIVE_INPUT);
            }
        });

    }

    @Test
    public void player_Pick_Up_MagicRing () {
        Player player = new Player();
        MagicRing magicRing = Mockito.mock(MagicRing.class, Mockito.CALLS_REAL_METHODS);
        player.pickUpMagicRing(magicRing);
        assertEquals(magicRing, player.getActiveMagicRing());
    }

    @Test
    public void player_Choose_Trade_Builder () {
        Player player = new Player();
        Trade builder = new Builder(player);
        player.chooseTrade(TradeChoice.BUILDER);
        assertEquals(builder.getName(), player.getTrade().getName());
    }

    @Test
    public void player_Choose_Trade_CircusArtist () {
        Player player = new Player();
        Trade circusArtist = new CircusArtist(player);
        player.chooseTrade(TradeChoice.CIRCUS_ARTIST);
        assertEquals(circusArtist.getName(), player.getTrade().getName());
    }

    @Test
    public void player_Choose_Trade_Storyteller () {
        Player player = new Player();
        Trade storyteller = new Storyteller(player);
        player.chooseTrade(TradeChoice.STORYTELLER);
        assertEquals(storyteller.getName(), player.getTrade().getName());
    }

    @Test
    public void player_Choose_Race_BrownRat () {
        Player player = new Player();
        Race brownRat = new BrownRat(player);
        player.chooseRace(RaceChoice.BROWN_RAT);
        assertEquals(brownRat.getName(), player.getRace().getName());
    }

    @Test
    public void player_Choose_Race_WhiteRat () {
        Player player = new Player();
        Race whiteRat = new WhiteRat(player);
        player.chooseRace(RaceChoice.WHITE_RAT);
        assertEquals(whiteRat.getName(), player.getRace().getName());
    }

    @Test
    public void player_Choose_Race_BlackRat () {
        Player player = new Player();
        Race blackRat = new BlackRat(player);
        player.chooseRace(RaceChoice.BLACK_RAT);
        assertEquals(blackRat.getName(), player.getRace().getName());
    }



}

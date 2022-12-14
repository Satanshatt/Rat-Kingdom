import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
    private static final int XP_BONUS = 10;
    private static final int NEGATIVE_INPUT = -1;
    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 20;
    private static final int HEALTH_MAX_VALUE = 100;
    private static final int MANA_BONUS = 15;

    @Test
    public void Should_IncreaseXP_InputIs10 () {
        Player player = new Player();
        int xpBefore = player.getXp();
        player.increaseXp(10);
        int xpAfter = player.getXp();
        assertTrue(xpBefore < xpAfter);
    }

    @Test
    public void Should_GiveCorrectValueToPlayer_When_CreatePlayer () {
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
    public void Should_BeTrue_When_NPCIsWithinReach_OneXCoordinateAway (){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

        npc.setPosX(3);
        npc.setPosY(2);
        player.setPosX(4);
        player.setPosY(2);

        assertTrue(player.isNPCWithinReach(npc));
    }

    @Test
    public void Should_BeTrue_When_NPCIsWithinReach_OneYCoordinateAway (){
        Player player = new Player();
        NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);

        npc.setPosX(2);
        npc.setPosY(3);
        player.setPosX(2);
        player.setPosY(2);

        assertTrue(player.isNPCWithinReach(npc));
    }

    @Test
    public void Should_BeTrue_When_PlayerMoveOneStepRight () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();

        int xBefore = player.getPosX();
        player.move(room, Direction.RIGHT);
        int xAfter = player.getPosX();
        assertThat(xAfter, is(equalTo(xBefore + 1)));
    }

    @Test
    public void Should_BeTrue_When_PlayerMoveOneStepLeft () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();

        int xBefore = player.getPosX();
        player.move(room, Direction.LEFT);
        int xAfter = player.getPosX();
        assertThat(xAfter, is(equalTo(xBefore - 1)));
    }

    @Test
    public void Should_BeTrue_When_PlayerMoveOneStepUpwards () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();

        int yBefore = player.getPosY();
        player.move(room, Direction.UPWARDS);
        int yAfter = player.getPosY();

        assertThat(yAfter, is(equalTo(yBefore - 1)));
    }

    @Test
    public void Should_BeTrue_When_PlayerMoveOneStepDownwards () {
        Player player = new Player();
        Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();

        int yBefore = player.getPosY();
        player.move(room, Direction.DOWNWARDS);
        int yAfter = player.getPosY();

        assertThat(yAfter, is(equalTo(yBefore + 1)));
    }

    @Test
    public void Should_ThrowException_When_PlayerMovesToOccupiedCordinate () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();

                npc.setPosX(START_POS_X);
                npc.setPosY(START_POS_Y-1);
                room.addEntity(npc);

                player.move(room, Direction.UPWARDS);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_PlayerTryWalkOutsideRoom () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                Room room = new RoomGenerator(MAP_WIDTH,MAP_HEIGHT).fillRoom().createWallsAndDoors().generate();

                player.setPosY(1);
                player.move(room, Direction.UPWARDS);
            }
        });
    }

    @Test
    public void Should_BeTrue_When_PlayerDies () {
        Player player = new Player();
        player.increaseLevel();
        int higherLevel = player.getLevel();
        player.die();
        assertTrue(higherLevel > DEFAULT_VALUE_LEVEL);
    }

    @Test
    public void Should_DamageNPC_When_PlayerAttacksWithFret () {
        Player player = new Player();
        //NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
        Enemy ant = new Ant(START_POS_X, START_POS_Y);

        ant.setPosY(START_POS_Y);
        ant.setPosX(START_POS_X + 1);

        int beforeAttack = ant.getHealth();
        player.attack(ant, AttackChoice.FRET);
        int afterAttack = ant.getHealth();

        assertTrue(beforeAttack > afterAttack);
    }

    @Test
    public void Should_ThrowException_When_DamageInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.playerTakesDamage(NEGATIVE_INPUT);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_PlayerUseWeapon_AndNPCIsOutOfRange () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                NPC npc = Mockito.mock(NPC.class, Mockito.CALLS_REAL_METHODS);
                npc.setPosX(START_POS_X + 5);
                player.useWeaponOnNPC(npc);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_PlayerFret_AndNPCIsOutOfRange () {
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

    @Test
    public void Should_DamagePlayer_When_NPCAttacksPlayer () {
        Player player = new Player();
        Enemy ant = new Ant(START_POS_X, START_POS_Y);

        int playerStartHealth = player.getHealth();
        ant.damagePlayer(player);
        int playerHealthAfterAttack = player.getHealth();

        assertTrue(playerStartHealth > playerHealthAfterAttack);
    }

    @Test
    public void Should_NotGoOverMaxValue_When_HealthGoesOver100 () {
        Player player = new Player();
        player.increaseHealth(HEALTH_MAX_VALUE + 1);
        assertThat(player.getHealth(), is(equalTo(HEALTH_MAX_VALUE)));
    }

    @Test
    public void Should_KillPlayer_When_PlayersHealthGoesUnderZero () {
        Player player = new Player();
        player.increaseLevel();
        int higherLevel = player.getLevel();
        player.playerTakesDamage(player.getHealth() + 1);
        assertTrue(higherLevel > DEFAULT_VALUE_LEVEL);
    }

    @Test
    public void Should_ThrowException_When_DexterityInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseDexterity(-10);
            }
        });
    }

    @Test
    public void Should_DamageNPC_When_PlayerAttacksWithWeapon () {
        Player player = new Player();
        Enemy ant = new Ant(START_POS_X + 1, START_POS_Y);
        Weapon axe = new Axe();

        player.setActiveWeapon(axe);
        axe.setPlayer(player);

        int beforeAttack = ant.getHealth();
        player.attack(ant, AttackChoice.WITH_WEAPON);
        int afterAttack = ant.getHealth();

        assertTrue(beforeAttack > afterAttack);
    }

    @Test
    public void Should_ThrowException_When_IntelligenceInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseIntelligence(NEGATIVE_INPUT);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_StrengthInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseStrength(NEGATIVE_INPUT);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_ManaInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseMana(NEGATIVE_INPUT);
            }
        });
    }

    @Test
    public void Should_IncreaseMana_When_LevelUpgrade () {
        Player player = new Player();
        int manaBefore = player.getMana();
        player.increaseLevel();
        int manaAfter = player.getMana();
        assertThat(manaAfter, is(equalTo(manaBefore+MANA_BONUS)));
    }

    @Test
    public void Should_GivePlayerXP_When_PlayerKillsNPCWithFret () {
        Player player = new Player();
        Enemy ant = new Ant(START_POS_X, START_POS_X);

        ant.setPosX(START_POS_X);
        ant.setPosY(START_POS_Y + 1);

        int A = ant.getHealth();
        int xPBefore = player.getXp();
        while(!ant.isDead()) {
            player.attack(ant, AttackChoice.FRET);
        }
        int xPAfter = player.getXp();

        assertThat(xPAfter, is(equalTo(xPBefore + XP_BONUS)));

    }

    @Test
    public void Should_UpgradeLevel_When_XPGoesOverMaxValue(){
        Player player = new Player();
        int levelUp = 1;
        player.increaseXp( XP_MAX_VALUE +1);
        assertEquals(DEFAULT_VALUE_LEVEL + levelUp, player.getLevel());
    }

    @Test
    public void Should_ActivateWeapon_When_PickUpWeapon () {
        Player player = new Player();
        //Weapon weapon = Mockito.mock(Weapon.class, Mockito.CALLS_REAL_METHODS);
        Weapon axe = new Axe();
        axe.setPlayer(player);
        player.pickUpWeapon(axe);
        assertEquals(axe, player.getActiveWeapon());
    }

    @Test
    public void Should_ThrowException_When_RoomIsNull () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.setActiveWeapon(null);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_HealthInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseHealth(NEGATIVE_INPUT);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_XPInputIsNegative () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseXp(NEGATIVE_INPUT);
            }
        });
    }

    @Test
    public void Should_ThrowException_When_HealthInputIsZero () {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Player player = new Player();
                player.increaseHealth(0);
            }
        });
    }

    //Oklart
    @Test
    public void Should_AddMagicRingToPlayer_When_PlayerPickUpMagicRing () {
        Player player = new Player();
        MagicRing magicRing = Mockito.mock(MagicRing.class, Mockito.CALLS_REAL_METHODS);
        player.pickUpMagicRing(magicRing);
        assertEquals(magicRing, player.getActiveMagicRing());
    }

    @Test
    public void Should_GivePlayerBuilderTrade_When_ChoosingBuilder () {
        Player player = new Player();
        Trade builder = new Builder(player);
        player.chooseTrade(TradeChoice.BUILDER);
        assertEquals(builder.getName(), player.getTrade().getName());
    }

    @Test
    public void Should_GivePlayerCircusArtistTrade_When_ChoosingCircusArtist () {
        Player player = new Player();
        Trade circusArtist = new CircusArtist(player);
        player.chooseTrade(TradeChoice.CIRCUS_ARTIST);
        assertEquals(circusArtist.getName(), player.getTrade().getName());
    }

    @Test
    public void Should_GivePlayerStorytellerTrade_When_ChoosingStoryteller () {
        Player player = new Player();
        Trade storyteller = new Storyteller(player);
        player.chooseTrade(TradeChoice.STORYTELLER);
        assertEquals(storyteller.getName(), player.getTrade().getName());
    }

    @Test
    public void Should_MakePlayerBrownRat_When_ChoosingBrownRat () {
        Player player = new Player();
        Race brownRat = new BrownRat(player);
        player.chooseRace(RaceChoice.BROWN_RAT);
        assertEquals(brownRat.getName(), player.getRace().getName());
    }

    @Test
    public void Should_MakePlayerWhiteRat_When_ChoosingWhiteRat () {
        Player player = new Player();
        Race whiteRat = new WhiteRat(player);
        player.chooseRace(RaceChoice.WHITE_RAT);
        assertEquals(whiteRat.getName(), player.getRace().getName());
    }

    @Test
    public void Should_MakePlayerBlackRat_When_ChoosingBlackRat () {
        Player player = new Player();
        Race blackRat = new BlackRat(player);
        player.chooseRace(RaceChoice.BLACK_RAT);
        assertEquals(blackRat.getName(), player.getRace().getName());
    }

    @Test
    public void Should_BeFalse_When_PlayerNotDead () {
        Player player = new Player();
        assertFalse(player.isDead());
    }





}

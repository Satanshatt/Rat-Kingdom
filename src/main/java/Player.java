import java.util.List;

public interface Player {
    int getStrength();
    int getHealth();
    int getMana();

    int getDexterity();
    int getIntelligence();
    int getXp();
    int getLevel();
    int getPosX();
    int getPosY();
    List <Equipment> getEquipment();
    void addEquipment(Equipment ... equipment);
    void increaseStrength(int strength);
    void setHealth(int health);
    void increaseMana(int mana);
    void increaseDexterity(int dexterity);
    void increaseIntelligence(int intelligence);
    void increaseXp(int xp);
    void levelUpgrade();
    void walkLeft(int steps);
    void walkRight(int steps);
    void walkForward(int steps);
    void useWeaponOnNPC(Weapon weapon, NPC npc);
    boolean isDead();
    void die();

}

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
    Weapon getActiveWeapon();
    List <Equipment> getEquipment();
    void addEquipment(Equipment ... equipment);
    void increaseStrength(int strength);
    void setHealth(int health);
    void setActiveWeapon(Weapon weapon);
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
    void getWeapon(Weapon weapon);
    void chooseTrade(String tradeName);
    void chooseRace(String raceName);
}

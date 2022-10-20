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
    void setStrength(int strength);
    void setHealth(int health);
    void setMana(int mana);
    void setDexterity(int dexterity);
    void setIntelligence(int intelligence);
    void setXp(int xp);
    void setLevel(int level);
    void walkLeft(int steps);
    void walkRight(int steps);

}

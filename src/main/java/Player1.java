import java.util.List;

public interface Player1 {
    int getStrength();
    int getHealth();
    int getMana();
    int getDexterity();
    int getIntelligence();
    int getXp();
    int getLevel();
    List <Equipment> getEquipment();
    void addEquipment(Equipment ... equipment);
    void setStrength(int strength);
    void setHealth(int health);
    void setMana(int mana);
    void setDexterity(int dexterity);
    void setIntelligence(int intelligence);
    void setXp(int xp);
    void setLevel(int level);

}

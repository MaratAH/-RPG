import java.util.Random;

public abstract class Creature {
    public String name;
    public int health;
    public int gold;
    public int dexterity;
    public int experience;
    public int strength;

    public Creature(String name, int health, int gold, int dexterity, int experience, int strength) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.experience = experience;
        this.strength = strength;
    }

    /* Если наша ловкость, умноженная на 3, больше, чем случайное значение (от 0 до 100),
    то мы атакуем в размере нашей силы, если нет, то возвращаем 0, что приравнивается к промаху.*/
    public int attack() {
        if (dexterity * 3 > getRandomInt()) {
            return strength;
        } else if (dexterity * 3 < getRandomInt() && dexterity > getRandomInt() / 3) {
            return strength * 2;
        } else return 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getFullStatus() {
        return String.format("%s - здоровье:%d, золото:%d, ловкость:%d, опыт:%d, сила:%d", name, health, gold, dexterity, experience, strength);
    }

    public String getStatus() {
        return String.format("%s - здоровье:%d", name, health);
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else return false;
    }

    public int getRandomInt() {
        return new Random().nextInt(101);
    }
}

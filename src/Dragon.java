public class Dragon extends Creature{
    public Dragon(String name, int health, int gold, int dexterity, int experience, int strength) {
        super(name, health, gold, dexterity, experience, strength);
    }

    @Override
    public int attack() {
        if (dexterity * 3 > getRandomInt()) {
            return strength*2;
        } else return 0;
    }
}

public class Player extends Creature {
    static Player player = new Player(GameField.nameOfTheHero(), 100, 10, 10, 0, 10);
    private final String[] level = {"Новичок", "Продвинутый", "Опытный", "Мастер", "Супергерой"};

    public Player(String name, int health, int gold, int dexterity, int experience, int strength) {
        super(name, health, gold, dexterity, experience, strength);
    }

    public String getLevelName() {
        if (0 <= experience && experience < 20) {
            return level[0];
        } else if (20 <= experience && experience < 46) {
            return level[1];
        } else if (46 <= experience && experience < 71) {
            return level[2];
        } else if (71 <= experience && experience < 96) {
            return level[3];
        } else {
            return level[4];
        }
    }

    public void increase() {
        switch (getLevelName()) {
            case "продвинутый", "опытный", "мастер", "супергерой" -> {
                dexterity += 10;
                strength += 10;
            }
        }
    }

    @Override
    public String getFullStatus() {
        GameField.stars();
        System.out.println("\n Ваш статус и параметры:");
        return String.format("%s %s здоровье:%d, золото:%d, ловкость:%d, опыт:%d, сила:%d", getLevelName(), name, health, gold, dexterity, experience, strength);
    }
}

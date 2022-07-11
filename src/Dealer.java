public class Dealer {

    public static void trade() {
        switch (GameField.userInput("Торговец: Здравствуйте " + Player.player.name + ". Чего Вам угодно? " +
                "\n 1 - зелье (11 золотых), 2 - меч (15 золотых), 3 - копье (13 золотых), 4 - выход", 4)) {
            case 1:
                if (Player.player.gold < 11) {
                    System.out.println("Торговец: Извините, но у Вас не хватает золота." +
                            "\n Вы покидаете лавку.");
                    GameField.choiceOfLocation();
                } else {
                    System.out.println("Торговец: Пожалуйста, надеюсь это Вас исцелит.");
                    Player.player.health += 20;
                    Player.player.gold -= 11;
                    System.out.println(Player.player.getFullStatus());
                    GameField.stars();
                    System.out.println();
                    GameField.choiceOfLocation();
                }
                break;
            case 2:
                if (Player.player.gold < 15) {
                    System.out.println("Торговец: Извините, но у Вас не хватает золота");
                    GameField.choiceOfLocation();
                } else {
                    System.out.println("Торговец: Пожалуйста, у меча хороший баланс.");
                    Player.player.dexterity += 5;
                    Player.player.strength += 8;
                    Player.player.gold -= 15;
                    System.out.println(Player.player.getFullStatus());
                    GameField.stars();
                    System.out.println();
                    GameField.choiceOfLocation();
                }
                break;
            case 3:
                if (Player.player.gold < 13) {
                    System.out.println("Торговец: Извините, но у Вас не хватает золота");
                    GameField.choiceOfLocation();
                } else {
                    System.out.println("Торговец: Пожалуйста, копье поможет Вам разить врага.");
                    Player.player.dexterity += 8;
                    Player.player.strength += 4;
                    Player.player.gold -= 13;
                    System.out.println(Player.player.getFullStatus());
                    GameField.stars();
                    System.out.println();
                    GameField.choiceOfLocation();
                }
                break;
            case 4:
                GameField.choiceOfLocation();
        }
    }
}

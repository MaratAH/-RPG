import java.util.Random;

public class DarkForest {
    private static boolean isAcceptDuel;
    private static Creature monster;

    // определили последовательность появления монстров (кто будет монстр, скелет или гоблин?)
    public static Creature getMonster() {

            if (new Random().nextInt(11) % 2 == 0 && Player.player.experience < 100) {
                System.out.println("вы встретили скелета по прозвищу Костяшка. Он подходит, брякая костями!");
                monster = new Skeleton("Костяшка", 30, 20, 10, 0, 10);
            } else if (new Random().nextInt(11) % 2 != 0 && Player.player.experience < 100) {
                System.out.println("Вы встретили гоблина, его зовут Громила. Он рычит!");
                monster = new Goblin("Громила", 40, 30, 5, 0, 15);
            } else if (Player.player.experience > 100) {
                System.out.println("Вы встретили дракона, оперативный псевдоним - Костерок");
                monster = new Dragon("Костерок", 50, 100, 25, 0, 15);
            }
        return monster;
    }

    // Предоставляем выбор ползователю учавствовать в поединке или нет
    public static boolean isAcceptDuel() {
        switch (GameField.userInput("Принять бой? 1 - Да, 2 - Нет", 2)) {
            case 1 -> isAcceptDuel = true;
            case 2 -> {
                isAcceptDuel = false;
                System.out.println("Вы трусливо ретировались и ваши следы затерялись где-то в песках истории :) ");
                GameField.stars();
                System.out.println();
                GameField.choiceOfLocation();
            }
        }
        return isAcceptDuel;
    }

    // Бой нужно реализовать в отдельном потоке.
    public static void duel() {
        System.out.println("На дороге в темном лесу ...");
        getMonster();
        Runnable runnable = () -> {
            if (isAcceptDuel()) {
                System.out.println();
                try {
                    System.out.println(monster.name + ": Какой сегодня удачный денек! Щелкает челюстями и нападает");
                    while (Player.player.isAlive() && monster.isAlive()) {
                        Player.player.health -= monster.attack();
                        System.out.println(Player.player.getStatus());
                        monster.health -= Player.player.attack();
                        System.out.println(monster.getStatus());
                    }
                    if (Player.player.isAlive() && !monster.isAlive()) {
                        Player.player.gold += monster.gold;
                        Player.player.experience += 30;
                        Player.player.increase();
                        GameField.stars();
                        System.out.println("\n Вы победили!");
                        System.out.println(Player.player.getFullStatus());
                        GameField.choiceOfLocation();
                    } else {
                        GameField.stars();
                        System.out.println("\n К сожалению Вам не удалось одолеть : " + monster.name + ". Пусть Вам повезет в следующий раз.");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("Противник, лишь только завидев Вас, просто исчез в неизвестном направлении :)..." +
                            "\n и Вы вернулись обратно.");
                    GameField.choiceOfLocation();
                }
            }
        };
        //Запускаем поток
        Thread thread = new Thread(runnable);
        thread.start();
    }
}


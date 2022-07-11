import java.util.Scanner;

public class GameField {
    // строка с названием игры
    public static final String title = "Маленькое приключение - большой шаг в будущее!";
    // строковая переменная с именем героя которое будет определено пользователем с клавиатуры
    public static String name;
    //создали статический сканер
    public static Scanner consoleIn = new Scanner(System.in);
    // целочисленная переменная с помощью которой определяется пользовательский ввод команды
    public static int action;

    // оформление в виде линии из звездочек
    public static void stars() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
    }

    // метод выводящий в консоль оформленное звездочками название игры
    public static void title() {
        stars();
        System.out.print("\n" + "  " + title + "\n");
        stars();
        System.out.println();
    }

    //проверка имени персонажа введенного пользователем
    // игра спрашивает у пользователя - как зовут нашего героя?
    public static String nameOfTheHero() {
        System.out.println("Введите имя Вашего персонажа - ");
        name = new Scanner(System.in).nextLine();
        switch (userInput("Имя Вашего персонажа " + name + "? 1 - Да, 2 - Нет.", 2)) {
            case 1 -> {
                System.out.println("В добрый путь " + name + "!");
                System.out.println();
            }
            case 2 -> {
                System.out.println();
                nameOfTheHero();
            }
        }
        return name;
    }

    // формируем правильный пользовательский ввод с клавиатуры при ответе на запросы игры
    public static int userInput(String offer, int userChoices) {
        //offer - это строка с прозьбой выбрать из предложенных вариантов # "Введите 1 2 или 3"
        do {
            System.out.println("\n" + offer);
            //пользователь может ввести что угодно, поэтому нужно подстраховаться
            try {
                // любой ввод пользователя переделываем в целое число
                    action = Integer.parseInt(consoleIn.next());
            } catch (Exception e) {
                action = -1;
                System.out.println("Введите пожалуйста один из указанных вариантов");
            }
            // цикл продолжается пока пользователь не введет то что указано, а указано будет,
            // что вводить надо цыфры, userChoices - это количество вариантов для выбора пользователя
        } while (action < 1 || action > userChoices);
        return action;
    }

    // метод для выбора места куда пойдет герой
    public static void choiceOfLocation() {
        switch (userInput("Вы в городе. Куда вы хотите пойти? 1 - к торговцу, 2 - в темный лес, 3 - выйти из игры", 3)) {
            case 1 -> Dealer.trade();
            case 2 -> DarkForest.duel();
            case 3 -> {
                System.out.println();
                System.out.println("Вы закончили игру. Досвидания.");
                System.exit(0);
            }
        }
    }
    public static void startGame(){
        title();
        System.out.println(Player.player.getFullStatus());
        choiceOfLocation();
    }
}

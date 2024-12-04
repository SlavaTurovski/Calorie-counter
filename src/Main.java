import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println("-> Добро пожаловать в счетчик калорий! <-");

        while (true) {
            printMenu();
            int actionNumber = scanner.nextInt();

            switch (actionNumber) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();  // ввести количество шагов за определённый день
                    break;
                case 2:
                    stepTracker.changeStepGoal();   // изменить цель по количеству шагов в день
                    break;
                case 3:
                    stepTracker.printStatistic();    // напечатать статистику за определённый месяц
                    break;
                case 4:
                    System.out.println("До скорых встреч!");
                    return;    // выход из приложения
                default:
                    System.out.println("Введена неверная команда!");
            }
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("Введите номер команды: ");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Вывести статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
        System.out.println();
    }
}
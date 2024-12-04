import java.util.Scanner;

class StepTracker {

    MonthData monthData = new MonthData();

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца: 1 - Январь | 2 - Февраль | 3 - Март | 4 - Апрель | 5 - Май | " +
                "6 - Июнь | 7 - Июль | 8 - Август | 9 - Сентябрь | 10 - Октябрь | 11 - Ноябрь | 12 - Декабрь");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {    // проверка данных
            System.out.println("Введен не правильный номер месяца!");
            return;
        } else {
            System.out.println("Введите день: от 1 до 30");
        }

        int day = scanner.nextInt();

        if (day < 1 || day > 30) {     // проверка данных
            System.out.println("Введено некорректное число месяца!");
            return;
        } else {
            System.out.println("Введите количество шагов: ");
        }

        int steps = scanner.nextInt();

        if (steps < 0) {     // проверка данных на ввод отрицательного числа
            System.out.println("Введите положительно число!");
            return;
        } else {
            System.out.println("Число шагов " + steps + " сохранено за " + day + " день " + month + " месяца");
        }

        monthToData[month - 1].days[day - 1] = steps;
    }

    void changeStepGoal() {    // меняем значение цели шагов за месяц
        System.out.println("Ваша текущая цель шагов в день: " + goalByStepsPerDay + " шагов!");
        System.out.print("Введите новую цель шагов в день: ");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay <= 0) {     // проверка данных на ввод отрицательного числа
            System.out.println("Введите положительно число!");
        } else {
            goalByStepsPerDay = newGoalByStepsPerDay;    //если все ОК, то сохраняем новое значение
            System.out.println("Вы изменили цель шагов в день на " + goalByStepsPerDay + " шагов!");
        }
    }

    int getDistance() {    // находим сколько км прошли за месяц
        return Converter.convertStepsToKm(monthData.getSumStepsFromMonth());
    }

    int getKilocalories() {    // находим сколько Килокалорий сожгли
        return Converter.convertStepsToKiloCalories(monthData.getSumStepsFromMonth());
    }

    void printStatistic() {
        System.out.println("Введите номер месяца: 1 - Январь | 2 - Февраль | 3 - Март | 4 - Апрель | 5 - Май | " +
                "6 - Июнь | 7 - Июль | 8 - Август | 9 - Сентябрь | 10 - Октябрь | 11 - Ноябрь | 12 - Декабрь");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {    // проверка на корректный ввод номера месяца
            System.out.println("Введен не правильный номер месяца!");
        } else {
            System.out.println("Общая статистика по дням месяца: " + month);
            monthData.printTotalSteps();    // вывод общей статистики по дням
            System.out.println();    // просто отступ
            System.out.println("*** Общее количество шагов за месяц: " + monthData.getSumStepsFromMonth());
            // вывод суммы шагов за месяц

            System.out.println("*** Максимальное пройденное количество шагов за месяц: " + monthData.getMaxSteps());
            // вывод максимального пройденного количества шагов за месяц

            System.out.println("*** Среднее количество шагов: " + monthData.getMidSteps());
            // вывод среднего пройденного количества шагов за месяц

            System.out.println("*** Пройденная дистанция (в км): " + getDistance());
            // вывод пройденной за месяц дистанции в километрах

            System.out.println("*** Количество сожжённых килокалорий: " + getKilocalories());
            // вывод количества сожжённых килокалорий за месяц

            System.out.println("*** Лучшая серия: " + monthData.getBestSeries(goalByStepsPerDay));   // вывод лучшей серии
        }
    }
}

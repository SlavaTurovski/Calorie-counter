class MonthData {

    //сделал класс более функциональным

    static int[] days = new int[30];    // наша константа для данного класса поэтому static

    void printTotalSteps() {    // выводим из массива все записи о пройденных шагах по дням месяца
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + "-й день: " + days[i]);
        }
    }

    int getSumStepsFromMonth() {    // находим сумму шагов за месяц

        int sumSteps = 0;

        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;    // возвращаем результат суммы шагов
    }

    int getMaxSteps() {   // находим максимальное число шагов

        int maxSteps = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;    // возвращаем результат макс числа шагов
    }

    int getMidSteps() {    // находим среднее число шагов в месяц
        return getSumStepsFromMonth() / days.length;
    }

    int getBestSeries(int goalByStepsPerDay) {    //находим лучшую серию шагов
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {    //перебор и сравнение с целью шагов в день
            if (days[i] >= goalByStepsPerDay) {
                currentSeries = currentSeries + 1;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
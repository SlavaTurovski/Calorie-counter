class Converter {

    // Нам незачем создавать новый объект, т.к. нет необходимости изменять его поля и для нас эти данные как
    // константы, поэтому мы используем модификатор static в методах convertStepsToKm и convertStepsToKiloCalories.

    static int convertStepsToKm(int steps) {
        int stepLength = 75;    // длина шага в см
        return steps * stepLength/100/1000;    // возвращаем результат и переводим сразу в км
    }

    static int convertStepsToKiloCalories (int steps){
        int sizeKiloCaloriesPerSteps = 50;    // за 1 шаг тратится 50 кал
        return steps * sizeKiloCaloriesPerSteps/1000;    // возвращаем результат и переводим сразу в килокалории
    }

}

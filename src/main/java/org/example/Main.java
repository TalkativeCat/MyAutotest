package org.example;

public class Main {
    public static void main(String[] args) {
        int[] array = {58000, -2, 0, 51, 4839, 77, -22};
        int[] result = testMetod(array);
        System.out.println("Первое максимальное число: " + result[0]);
        System.out.println("Второе максимальное число: " + result[1]);
    }
    // Проще возвращать в данном методе массив из чисел и далее проводить над ним операции в main
    public static int[] testMetod(int[] array) {

        // Проверим, что в массиве не меньше одного числа, иначе реализация метода не имеет смысла
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать минимум два числа");
        }

        // Используем при инициализации переменных минимальные значения, допустимые для int
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Применим для перебора массива лаконичную конструкцию forEach
        for (int number : array) {

            // Если текущее число num больше, чем first, это означает, что мы нашли новое наибольшее число
            if (number > first) {

                // Старое наибольшее число из first перемещаем в second, first обновлям значением из number
                second = first;
                first = number;
            }

            // Если текущее число number не больше first, но больше second, это означает, что мы нашли новое второе наибольшее число
            else if (number > second) {
                second = number;
            }
        }

        // Возвращаем массив из двух чисел
        return new int[]{first, second};
    }
}
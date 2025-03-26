package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int totalNumbers = 10000; // количество случайных чисел для генерации
        int[] randomNumbers = generateRandomArray(totalNumbers); // генерация массива случайных целых чисел

        // выводим сгенерированные числа
        System.out.println("Сгенерированные случайные числа:");
        printArray(randomNumbers); // вызов метода для вывода массива

        int maxSquareSum = findMaxSquareSum(randomNumbers); // находим максимальную сумму квадратов двух элементов
        System.out.println("Максимальная сумма квадратов: " + maxSquareSum);
    }

    // метод для генерации массива случайных целых чисел
    private static int[] generateRandomArray(int count) {
        if (count <= 0) {
            logger.severe("Количество чисел для генерации должно быть положительным.");
            throw new IllegalArgumentException("Количество чисел для генерации должно быть положительным.");
        }

        Random rand = new Random();
        int[] numbersArray = new int[count]; // массив для хранения сгенерированных чисел

        for (int index = 0; index < count; index++) {
            // генерация случайных чисел в диапазоне от -100 до 100
            numbersArray[index] = rand.nextInt(201) - 100;
            logger.log(Level.FINE, "Сгенерировано число: " + numbersArray[index]);
        }
        logger.log(Level.INFO, "Массив случайных чисел сгенерирован успешно.");
        return numbersArray;
    }

    // метод для вывода массива
    private static void printArray(int[] array) {
        if (array == null) {
            logger.severe("Массив не может быть null.");
            throw new IllegalArgumentException("Массив не может быть null.");
        }

        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
            // переход на новую строку после каждых 20 чисел
            if ((index + 1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // добавление пустой строки для разделения
        logger.log(Level.INFO, "Массив выведен успешно.");
    }

    // метод для нахождения максимальной суммы квадратов двух элементов
    public static int findMaxSquareSum(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            logger.severe("Массив должен содержать как минимум два элемента.");
            throw new IllegalArgumentException("Массив должен содержать как минимум два элемента.");
        }

        Arrays.sort(numbers); // сортируем массив

        // находим два наибольших элемента
        int largest = numbers[numbers.length - 1];
        int secondLargest = numbers[numbers.length - 2];

        // вычисляем сумму квадратов этих двух элементов
        int maxSquareSum = (largest * largest) + (secondLargest * secondLargest);
        logger.log(Level.INFO, "Максимальная сумма квадратов: " + maxSquareSum);
        return maxSquareSum;
    }
}

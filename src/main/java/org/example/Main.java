package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Получаем текущие дату и время
        String currentDateTime = TaskA.getCurrentDateTime();

        // Выводим информацию о разработчике и времени получения задания
        System.out.println("/**");
        System.out.println("Разработчик: Иванов Данил");
        System.out.println("Дата получения задания: " + currentDateTime);
        System.out.println("Дата и время сдачи задания: " + currentDateTime);
        System.out.println("*/");

        // Вводим количество чисел с консоли
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        // Массив строк для хранения чисел
        String[] numbers = new String[n];

        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next(); // Вводим числа как строки
        }

        // Вызов методов для обработки чисел
        TaskA.findShortestAndLongest(numbers);
        TaskA.sortByLength(numbers);
        TaskA.findByAverageLength(numbers);
        TaskA.findNumberWithMinUniqueDigits(numbers);
        TaskA.findNumbersWithOnlyEvenDigits(numbers);
        TaskA.findNumberWithIncreasingDigits(numbers);
        TaskA.findNumberWithUniqueDigits(numbers);
        TaskA.findPalindrome(numbers);

        // Для решения квадратного уравнения
        if (args.length == 3) {
            TaskA.solveQuadraticEquation(args);
        } else {
            System.out.println("Для решения квадратного уравнения нужно передать 3 параметра (a, b, c).");
        }
    }
}

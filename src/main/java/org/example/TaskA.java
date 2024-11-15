package org.example;
import java.util.*;
import java.text.SimpleDateFormat;

public class TaskA {
    // Метод для получения текущего времени
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public static void findShortestAndLongest(String[] numbers) {
        String shortest = numbers[0];
        String longest = numbers[0];

        for (String num : numbers) {
            if (num.length() < shortest.length()) {
                shortest = num;
            }
            if (num.length() > longest.length()) {
                longest = num;
            }
        }

        System.out.println("\nСамое короткое число: " + shortest + " (длина: " + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (длина: " + longest.length() + ")");
    }

    // 2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
    public static void sortByLength(String[] numbers) {
        Arrays.sort(numbers, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("\nЧисла в порядке возрастания длины:");
        for (String num : numbers) {
            System.out.print(num + " ");
        }

        Arrays.sort(numbers, (a, b) -> Integer.compare(b.length(), a.length()));
        System.out.println("\nЧисла в порядке убывания длины:");
        for (String num : numbers) {
            System.out.print(num + " ");
        }
    }

    // 3. Вывести те числа, длина которых меньше (больше) средней, а также длину.
    public static void findByAverageLength(String[] numbers) {
        int totalLength = 0;
        for (String num : numbers) {
            totalLength += num.length();
        }
        double averageLength = totalLength / (double) numbers.length;

        System.out.println("\nЧисла с длиной меньше средней:");
        for (String num : numbers) {
            if (num.length() < averageLength) {
                System.out.println(num + " (длина: " + num.length() + ")");
            }
        }

        System.out.println("\nЧисла с длиной больше средней:");
        for (String num : numbers) {
            if (num.length() > averageLength) {
                System.out.println(num + " (длина: " + num.length() + ")");
            }
        }
    }

    // 4. Найти число, в котором число различных цифр минимально.
    public static void findNumberWithMinUniqueDigits(String[] numbers) {
        String minUniqueDigitsNumber = numbers[0];
        int minUniqueDigitsCount = countUniqueDigits(minUniqueDigitsNumber);

        for (String num : numbers) {
            int uniqueCount = countUniqueDigits(num);
            if (uniqueCount < minUniqueDigitsCount) {
                minUniqueDigitsNumber = num;
                minUniqueDigitsCount = uniqueCount;
            }
        }

        System.out.println("\nЧисло с минимальным количеством различных цифр: " + minUniqueDigitsNumber);
    }

    // Подсчет уникальных цифр в числе
    public static int countUniqueDigits(String num) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : num.toCharArray()) {
            uniqueDigits.add(c);
        }
        return uniqueDigits.size();
    }

    // 5. Найти количество чисел, содержащих только четные цифры.
    public static void findNumbersWithOnlyEvenDigits(String[] numbers) {
        int countEvenDigitNumbers = 0;
        int countEvenOddEqualNumbers = 0;

        for (String num : numbers) {
            if (containsOnlyEvenDigits(num)) {
                countEvenDigitNumbers++;
                if (countEvenOddEqual(num)) {
                    countEvenOddEqualNumbers++;
                }
            }
        }

        System.out.println("\nКоличество чисел с только четными цифрами: " + countEvenDigitNumbers);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр: " + countEvenOddEqualNumbers);
    }

    // Проверка, состоит ли число только из четных цифр
    public static boolean containsOnlyEvenDigits(String num) {
        for (char c : num.toCharArray()) {
            if ("13579".contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    // Проверка, равное ли число четных и нечетных цифр
    public static boolean countEvenOddEqual(String num) {
        int evenCount = 0, oddCount = 0;
        for (char c : num.toCharArray()) {
            if ("02468".contains(String.valueOf(c))) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return evenCount == oddCount;
    }

    // 6. Найти число, цифры в котором идут в строгом порядке возрастания.
    public static void findNumberWithIncreasingDigits(String[] numbers) {
        for (String num : numbers) {
            if (isStrictlyIncreasing(num)) {
                System.out.println("\nЧисло с цифрами в строгом порядке возрастания: " + num);
                return;
            }
        }
        System.out.println("\nЧисло с цифрами в строгом порядке возрастания не найдено.");
    }

    // Проверка, идут ли цифры в строгом порядке возрастания
    public static boolean isStrictlyIncreasing(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) >= num.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // 7. Найти число, состоящее только из различных цифр.
    public static void findNumberWithUniqueDigits(String[] numbers) {
        for (String num : numbers) {
            if (hasUniqueDigits(num)) {
                System.out.println("\nЧисло с уникальными цифрами: " + num);
                return;
            }
        }
        System.out.println("\nЧисло с уникальными цифрами не найдено.");
    }

    // Проверка, состоит ли число только из уникальных цифр
    public static boolean hasUniqueDigits(String num) {
        Set<Character> digits = new HashSet<>();
        for (char c : num.toCharArray()) {
            digits.add(c);
        }
        return digits.size() == num.length();
    }

    // 8. Найти среди чисел число-палиндром.
    public static void findPalindrome(String[] numbers) {
        List<String> palindromes = new ArrayList<>();
        for (String num : numbers) {
            if (isPalindrome(num)) {
                palindromes.add(num);
            }
        }

        if (palindromes.size() > 1) {
            System.out.println("\nВторое палиндромное число: " + palindromes.get(1));
        } else {
            System.out.println("\nПалиндромов не найдено или найдено только одно.");
        }
    }

    // Проверка на палиндром
    public static boolean isPalindrome(String num) {
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 9. Найти корни квадратного уравнения.
    public static void solveQuadraticEquation(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("\nКорни уравнения: x1 = " + root1 + ", x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("\nЕдинственный корень уравнения: x = " + root);
        } else {
            System.out.println("\nКорней нет (дискриминант меньше нуля).");
        }
    }
}

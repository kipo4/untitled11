import java.util.Scanner;

import java.util.Scanner;

public class DecimalToBinaryConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задаем количество бит для мантиссы
        int mantissaBits = 8;

        // Запрос ввода числа от пользователя
        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        // Задаем бит знака (0 - положительное число)
        int signBit = (number >= 0) ? 0 : 1;

        // Подготавливаем строки для представления знака, порядка и мантиссы
        String signMantissa = "0.";
        String signExponent = Integer.toBinaryString(signBit);

        number = Math.abs(number);

        int integerPart = (int) number;
        double fractionalPart = number - integerPart;

        String binaryInteger = Integer.toBinaryString(integerPart);

        StringBuilder binaryFractional = new StringBuilder();
        for (int i = 0; i < mantissaBits; i++) {
            fractionalPart *= 2;
            binaryFractional.append((int) fractionalPart);
            fractionalPart -= (int) fractionalPart;
        }

        int exponent = binaryInteger.length() - 1;
        String binaryExponent = Integer.toBinaryString(exponent);

        System.out.println("Знак: " + signExponent);
        System.out.println("Порядок: " + binaryExponent);
        System.out.println("Мантисса: " + signMantissa + binaryInteger.substring(1) + binaryFractional);

        // Закрытие сканнера
        scanner.close();
    }
}

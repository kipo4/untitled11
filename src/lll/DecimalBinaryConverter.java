import java.util.Scanner;

public class DecimalBinaryConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1. Десятичная в двоичную");
        System.out.println("2. Двоичная в десятичную");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                decimalToBinary();
                break;
            case 2:
                binaryToDecimal();
                break;
            default:
                System.out.println("Неверный выбор.");
        }

        // Закрытие сканнера
        scanner.close();
    }

    private static void decimalToBinary() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите десятичное число: ");
        double decimalNumber = scanner.nextDouble();

        String binaryResult = convertDecimalToBinary(decimalNumber);
        System.out.println("Двоичное представление числа " + decimalNumber + ": " + binaryResult);

        // Закрытие сканнера
        scanner.close();
    }

    private static void binaryToDecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите двоичное число: ");
        String binaryNumber = scanner.next();

        double decimalResult = convertBinaryToDecimal(binaryNumber);
        if (!Double.isNaN(decimalResult)) {
            System.out.printf("Десятичное представление числа %s: %.5f%n", binaryNumber, decimalResult);
        } else {
            System.out.println("Некорректный формат двоичного числа.");
        }

        // Закрытие сканнера
        scanner.close();
    }

    private static String convertDecimalToBinary(double decimalNumber) {
        long intPart = (long) decimalNumber;
        double fractionalPart = decimalNumber - intPart;

        String binaryInteger = Long.toBinaryString(intPart);

        StringBuilder binaryFractional = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            fractionalPart *= 2;
            binaryFractional.append((int) fractionalPart);
            fractionalPart -= (int) fractionalPart;
        }

        return binaryInteger + "." + binaryFractional.toString();
    }

    private static double convertBinaryToDecimal(String binaryNumber) {
        String[] parts = binaryNumber.split("\\.");

        if (parts.length == 2) {
            String integerPart = parts[0];
            String fractionalPart = parts[1];

            long intPart = Long.parseLong(integerPart, 2);
            double fractionalPartValue = 0;

            for (int i = 0; i < fractionalPart.length(); i++) {
                fractionalPartValue += Integer.parseInt(String.valueOf(fractionalPart.charAt(i))) * Math.pow(2, -(i + 1));
            }

            return intPart + fractionalPartValue;
        } else {
            // Попытка преобразования целого двоичного числа
            return Long.parseLong(binaryNumber, 2);
        }
    }
}

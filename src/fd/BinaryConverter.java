import java.util.Scanner;

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите целое число (для выхода введите 'exit'): ");

            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println("Число " + num + " в двоичной форме: " + toBinaryString(num));
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Программа завершена.");
                    break;
                } else {
                    System.out.println("Ошибка! Введите корректное целое число.");
                }
            }
        }

        scanner.close();
    }

    // Метод для перевода целых чисел в двоичную форму
    public static String toBinaryString(int num) {
        return String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
    }
}
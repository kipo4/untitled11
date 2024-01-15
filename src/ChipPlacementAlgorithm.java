import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Microchip {
    int width;
    int height;

    public Microchip(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

public class ChipPlacementAlgorithm {

    public static List<int[]> placeMicrochips(List<Microchip> microchips, int boardWidth, int boardHeight) {
        // Сортировка микросхем по убыванию площади
        Collections.sort(microchips, Comparator.comparingInt(chip -> chip.width * chip.height));
        Collections.reverse(microchips);

        List<int[]> chipPositions = new ArrayList<>();
        chipPositions.add(new int[]{0, 0});

        // Размещение микросхем
        for (Microchip chip : microchips) {
            boolean placed = false;
            for (int[] position : chipPositions) {
                int x = position[0];
                int y = position[1];

                if (x + chip.width <= boardWidth && y + chip.height <= boardHeight) {
                    chipPositions.add(new int[]{x + chip.width, y});
                    placed = true;
                    break;
                } else if (x + chip.height <= boardWidth && y + chip.width <= boardHeight) {
                    chipPositions.add(new int[]{x + chip.height, y});
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                chipPositions.add(new int[]{0, chipPositions.get(chipPositions.size() - 1)[1] + Math.max(chip.height, chip.width)});
            }
        }

        return chipPositions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ширину печатной платы: ");
        int boardWidth = scanner.nextInt();

        System.out.print("Введите высоту печатной платы: ");
        int boardHeight = scanner.nextInt();

        System.out.print("Введите количество микросхем: ");
        int numMicrochips = scanner.nextInt();

        List<Microchip> microchips = new ArrayList<>();
        for (int i = 0; i < numMicrochips; i++) {
            System.out.print("Введите ширину микросхемы " + (i + 1) + ": ");
            int width = scanner.nextInt();

            System.out.print("Введите высоту микросхемы " + (i + 1) + ": ");
            int height = scanner.nextInt();

            microchips.add(new Microchip(width, height));
        }

        List<int[]> resultPositions = placeMicrochips(microchips, boardWidth, boardHeight);

        for (int i = 0; i < resultPositions.size() - 1; i++) {
            System.out.println("Микросхема " + (i + 1) + " размещена по координатам " + Arrays.toString(resultPositions.get(i)));
        }
    }
}
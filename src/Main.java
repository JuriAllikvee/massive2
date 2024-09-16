import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[][] temperature = new int[12][];

        for (int month = 0; month < 12; month++) {
            temperature[month] = new int[daysInMonth[month]];
            for (int day = 0; day < daysInMonth[month]; day++) {
                temperature[month][day] = random.nextInt(81) - 30;  // Температуры от -30 до +50
            }
        }

        System.out.println("Введите месяц (1-12): ");
        int month = scanner.nextInt() - 1;  // Месяц (0 = Январь)
        System.out.println("Введите день (1-" + daysInMonth[month] + "): ");
        int day = scanner.nextInt() - 1;  // День (индексация с 0)

        System.out.println("Температура на " + (month + 1) + "/" + (day + 1) + " : " + temperature[month][day] + "°C");

        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        int warmestDay = 0, warmestMonth = 0;
        int coldestDay = 0, coldestMonth = 0;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < temperature[i].length; j++) {
                if (temperature[i][j] > maxTemp) {
                    maxTemp = temperature[i][j];
                    warmestDay = j + 1;
                    warmestMonth = i + 1;
                }
                if (temperature[i][j] < minTemp) {
                    minTemp = temperature[i][j];
                    coldestDay = j + 1;
                    coldestMonth = i + 1;
                }
            }
        }

        System.out.println("Самая теплая погода была " + warmestDay + "/" + warmestMonth + ": " + maxTemp + "°C");
        System.out.println("Самая холодная погода была " + coldestDay + "/" + coldestMonth + ": " + minTemp + "°C");
        
        for (int i = 0; i < 12; i++) {
            int sum = 0;
            for (int j = 0; j < temperature[i].length; j++) {
                sum += temperature[i][j];
            }
            double averageTemp = sum / (double) temperature[i].length;
            System.out.printf("Средняя температура за месяц %d: %.2f°C%n", i + 1, averageTemp);
        }
    }
}

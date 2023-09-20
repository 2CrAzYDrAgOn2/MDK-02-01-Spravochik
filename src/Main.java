import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Запуск программы...");
        ArrayList<Zadacha> zadachas = new ArrayList<>();
        ArrayList<Ispolnitel> ispolnitels = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите 1, чтобы посмотреть все задачи.");
            System.out.println("Введите 2, чтобы посмотреть всех исполнителей.");
            System.out.println("Введите 3, чтобы посмотреть задачу под номером.");
            System.out.println("Введите 4, чтобы посмотреть исполнителя под номером.");
            System.out.println("Введите 5, чтобы добавить задачу.");
            System.out.println("Введите 6, чтобы добавить исполнителя.");
            System.out.println("Введите 7, чтобы привязать задачу к исполнителю.");
            System.out.println("Введите 8, чтобы изменить статус задачи.");
            System.out.println("Введите 9, чтобы удалить исполнителя.");
            System.out.println("Введите 10, чтобы выйти из программы.");
            String statement = scanner.next();

            switch (statement) {
                case "1":
                    int count = 0;
                    for (Zadacha place : zadachas) {
                        count++;
                        System.out.println("\nНомер задачи: " + count);
                        place.Vivod();
                    }
                    System.out.println("Всего задач: " + count);
                    break;
                case "2":
                    int countI = 0;
                    for (Ispolnitel place : ispolnitels) {
                        countI++;
                        System.out.println("\nНомер исполнителя: " + countI);
                        place.Vivod();
                    }
                    System.out.println("Всего исполнителей: " + countI);
                    break;
                case "3":
                    System.out.println("Введите номер задачи для просмотра: ");
                    int index = scanner.nextInt();
                    if (index >= 1 && index <= zadachas.size()) {
                        Zadacha element = zadachas.get(index - 1);
                        element.Vivod();
                    } else {
                        System.out.println("Недопустимый номер задачи.");
                    }
                    break;
                case "4":
                    System.out.println("Введите номер исполнителя для просмотра: ");
                    int indexP = scanner.nextInt();
                    if (indexP >= 1 && indexP <= ispolnitels.size()) {
                        Ispolnitel element = ispolnitels.get(indexP - 1);
                        element.Vivod();
                    } else {
                        System.out.println("Недопустимый номер исполнителя.");
                    }
                    break;
                case "5":
                    String name;
                    System.out.println("Введите название задачи: ");
                    name = scanner.next();
                    zadachas.add(new Zadacha(name));
                    System.out.println("Задача добавлена.");
                    break;
                case "6":
                    String nameI;
                    System.out.println("Введите имя исполнителя: ");
                    nameI = scanner.next();
                    ispolnitels.add(new Ispolnitel(nameI));
                    System.out.println("Исполнитель добавлен.");
                    break;
                case "7":
                    System.out.println("Введите номер задачи: ");
                    int zadachaIndex = scanner.nextInt();
                    System.out.println("Введите номер исполнителя: ");
                    int ispolnitelIndex = scanner.nextInt();

                    if (zadachaIndex >= 1 && zadachaIndex <= zadachas.size() && ispolnitelIndex >= 1 && ispolnitelIndex <= ispolnitels.size()) {
                        Zadacha zadacha = zadachas.get(zadachaIndex - 1);
                        Ispolnitel ispolnitel = ispolnitels.get(ispolnitelIndex - 1);
                        zadacha.setIspolnitel(ispolnitel);
                        System.out.println("Исполнитель привязан к задаче.");
                    } else {
                        System.out.println("Недопустимый номер задачи или исполнителя.");
                    }
                    break;
                case "8":
                    System.out.println("Введите номер задачи для изменения её статуса: ");
                    int statusIndex = scanner.nextInt();
                    if (statusIndex >= 1 && statusIndex <= zadachas.size()) {
                        Zadacha zadacha = zadachas.get(statusIndex - 1);
                        zadacha.setStatus();
                        System.out.println("Статус задачи изменен.");
                    } else {
                        System.out.println("Недопустимый номер задачи.");
                    }
                    break;
                case "9":
                    System.out.println("Введите номер исполнителя для удаления: ");
                    int deleteIndexI = scanner.nextInt();
                    if (deleteIndexI >= 1 && deleteIndexI <= ispolnitels.size()) {
                        ispolnitels.remove(deleteIndexI - 1);
                        System.out.println("Исполнитель удален.");
                    } else {
                        System.out.println("Недопустимый номер исполнителя.");
                    }
                    break;
                case "10":
                    System.out.println("Выход из программы...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильный ввод. Пожалуйста, выберите один из вариантов (1-10).");
                    break;
            }
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Список операций:\n1. Добавить покупки\n2. Показать покупки\n3. Удалить покупки\n4. Поиск покупки");

        while (true) {
            System.out.println("Выберите номер операции: ");
            int number = scanner.nextInt();

            if (number == 1) {
                addProduct(list, scanner1);
            }
            if (number == 2) {
                printList(list);
            }
            if (number == 3) {
                remProduct(list, scanner1);
            }
            if (number == 4) {
                searchProduct(list, scanner1);
            }
        }
    }

    public static void printList(List<String> list) {
        int i = 1;
        for (String s : list) {
            System.out.println(i + ". " + s);
            i++;
        }
    }

    private static void addProduct(List<String> list, Scanner scanner1) {
        System.out.println("Какую покупку хотите добавить?");
        String line = scanner1.nextLine();
        list.add(line);
        System.out.println("Итого в списке покупок: " + list.size());
    }

    private static void remProduct(List<String> list, Scanner scanner1) {
        printList(list);
        System.out.println("Какую покупку хотите удалить? Введите название или номер:");
        String line = scanner1.nextLine();


        try {
            int opNum = Integer.parseInt(line) - 1;
            list.remove(opNum);
            int a = 1;
            printList(list);
        } catch (NumberFormatException e) {
            list.remove(line);
            printList(list);
        }
    }

    private static void searchProduct(List<String> list, Scanner scanner1) {
        System.out.println("Введите текст для поиска:");
        String line = scanner1.nextLine();
        String queryLower = line.toLowerCase();

        for (int i = 0; i < list.size(); i++) {
            String itLower = list.get(i);
            String itemLower = itLower.toLowerCase();
            if (itemLower.contains(queryLower)) {
                i++;
                System.out.println(i + ". " + itLower);
            } else {
                System.out.println("Нет товара с похожим названием!");
            }
        }
    }
}

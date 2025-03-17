import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamShop {
    public static void main(String[] args) {
        List<Shop> shops = new ArrayList<>();
        shops.add(new Shop("Удачный", 200.48, 1048.68));
        shops.add(new Shop("Прилесный", 308.97, 1509.32));
        shops.add(new Shop("Счастливый", 60.54, 800.62));
        shops.add(new Shop("У дома", 180.90, 1200.05));
        shops.add(new Shop("Всё для вас", 290.12, 1512.08));
        shops.add(new Shop("Русь", 3526.54, 2000.00));

        System.out.println("\nПосчитаем общий доход всех магазинов: ");
        Double sumIncome = shops.stream()
                .mapToDouble(Shop::getIncome)
                .sum();
        System.out.println(sumIncome + " млн. руб.");

        System.out.println("\nПосчитаем количество всех магазинов: ");
        int countShop = shops.size();
        System.out.println(countShop + " шт.");

        System.out.println("\nПосчитаем средний доход на каждый магазин: ");
        double averageIncome = shops.stream()
                .mapToDouble(Shop::getIncome)
                .average()
                .orElseThrow();
        System.out.println(averageIncome + " млн. руб.");

        System.out.println("\nОтсортируем магазины по доходности от большего к меньшему:");
        shops.stream()
                .sorted(Comparator.comparingDouble(Shop::getIncome).reversed())
                .forEach(System.out::println);

        System.out.println("\nОтсортируем магазины по соотношению дохода на 1м2 площади магазина от большего к меньшему:");
        shops.stream()
                .sorted(Comparator.comparingDouble(o -> 0 - (double) o.getIncome() / o.getArea()))
                .forEach(System.out::println);

        System.out.println("\nТоп-2 лучших магазина по доходности:");
        shops.stream()
                .sorted(Comparator.comparingDouble(Shop::getIncome).reversed())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("\nТоп-2 худших магазина по доходности:");
        shops.stream()
                .sorted(Comparator.comparingDouble(Shop::getIncome))
                .limit(2)
                .forEach(System.out::println);

        System.out.println("\nВыведем список магазинов, в которых соотношение дохода на 1м2 больше 1000 рублей:");
        shops.stream()
                .filter(o -> o.getIncome() / o.getArea() > 1) //так как у нас доход Х млн. руб. (сокращен на 1000)
                .forEach(System.out::println);
    }
}

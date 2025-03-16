import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamShop {
    public static void main(String[] args) {
        List<Shop> shops = new ArrayList<>();
        shops.add(new Shop("Удачный", 200, 1000));
        shops.add(new Shop("Прилесный", 300, 1500));
        shops.add(new Shop("Счастливый", 60, 800));
        shops.add(new Shop("У дома", 180, 1200));
        shops.add(new Shop("Всё для вас", 290, 1500));
        shops.add(new Shop("Русь", 4000, 2000));

        System.out.println("\nПосчитаем общий доход всех магазинов: ");
        long sumIncome = shops.stream()
                .mapToInt(Shop::getIncome)
                .sum();
        System.out.println(sumIncome + " млн.руб");

        System.out.println("\nПосчитаем количество всех магазинов: ");
        long countShop = shops.size();
        System.out.println(countShop + " шт.");

        System.out.println("\nПосчитаем средний доход на каждый магазин: ");
        double averageIncome = shops.stream()
                .mapToInt(Shop::getIncome)
                .average()
                .orElseThrow();
        System.out.println(averageIncome + " млн.руб");

        System.out.println("\nОтсортируем магазины по доходности от большего к меньшему:");
        shops.stream()
                .sorted(((o1, o2) -> o2.getIncome() - o1.getIncome()))
                .forEach(System.out::println);

        System.out.println("\nОтсортируем магазины по соотношению дохода на 1м2 площади магазина от большего к меньшему:");
        shops.stream()
                .sorted(Comparator.comparingDouble(o -> 0 - (double) o.getIncome() / o.getArea()))
                .forEach(System.out::println);

        System.out.println("\nТоп-2 лучших магазина по доходности:");
        shops.stream()
                .sorted((o1, o2) -> o2.getIncome() - o1.getIncome())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("\nТоп-2 худших магазина по доходности:");
        shops.stream()
                .sorted(Comparator.comparingInt(Shop::getIncome))
                .limit(2)
                .forEach(System.out::println);

        System.out.println("\nВыведем список магазинов, в которых соотношение дохода на 1м2 больше 1000 рублей:");
        shops.stream()
                .filter(o -> o.getIncome() / o.getArea() > 1)
                .forEach(System.out::println);
    }
}

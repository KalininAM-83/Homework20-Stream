import java.util.Objects;

public class Shop {
    private String Name;
    private Double Income;
    private Double area;

    public Shop(String Name, Double Income, Double area) {
        this.Name = Name;
        this.Income = Income;
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getIncome() {
        return Income;
    }

    public void setIncome(Double income) {
        Income = income;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(Name, shop.Name) && Objects.equals(Income, shop.Income) && Objects.equals(area, shop.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Income, area);
    }

    @Override
    public String toString() {
        return "Наименование магазина: " + Name +
                "; Доход - " + Income + " млн. руб.; " +
                "площадь - " + area + " м2";
    }
}

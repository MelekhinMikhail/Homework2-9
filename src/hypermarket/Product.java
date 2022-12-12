package hypermarket;

import java.util.Objects;

public class Product {
    private String name;
    private double weightInKg;
    private double costPerKg;

    public Product(String name, double weightInKg, double cost) {
        if (name == null || name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("Название продукта должно быть обязательно!");
        else this.name = name;
        if (weightInKg <= 0) throw new IllegalArgumentException("Вес продукта не может быть отрицательным или равен нулю");
        else this.weightInKg = weightInKg;
        if (cost < 0) throw new IllegalArgumentException("Стоимость не может быть отрицательной");
        else this.costPerKg = cost;
    }

    public String getName() {
        return name;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public double getCostPerKg() {
        return costPerKg;
    }

    public void setCount(double weightInKg) {
        if (weightInKg <= 0) throw new IllegalArgumentException("Вес продукта не может быть отрицательным или равен нулю");
        else this.weightInKg = weightInKg;
    }

    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("Стоимость не может быть отрицательной");
        else this.costPerKg = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getName()+" вес: "+getWeightInKg()+"кг  Цена за кг: "+getCostPerKg()+" руб.     === "+(getWeightInKg()*getCostPerKg())+" руб.";
    }
}

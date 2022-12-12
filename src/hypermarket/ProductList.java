package hypermarket;

import java.util.*;

public class ProductList {
    private String name;
    private Set<Product> list;

    public ProductList(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("Название списка должно быть обязательно!");
        else this.name = name;
        list = new HashSet<>();
    }

    public void addProduct(String name, double weightInKg, double costPerKg) {
        Product product = new Product(name, weightInKg, costPerKg);
        list.add(product);
    }

    public void deleteProduct(String string) {
        for (Product a : list) {
            if (a.getName().equalsIgnoreCase(string)) list.remove(a);
        }
    }

    public void printProductList() {
        System.out.println("Список покупок "+getName()+":");
        if (list.size() == 0) System.out.println("Список пуст");
        else {
            for (Product a : list) {
                if (a == null) continue;
                System.out.println(a);
            }
            System.out.println("ИТОГО: "+totalSum()+" руб.");
        }
        System.out.println();
    }

    public double totalSum() {
        double sum = 0;
        for (Product a : list) {
            if (a == null) continue;
            sum += a.getWeightInKg() * a.getCostPerKg();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductList list1 = (ProductList) o;
        return Objects.equals(name, list1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Список покупок "+getName()+" содержит "+getList().size()+" наименований с общей стоимостью " +
                totalSum()+" руб.";
    }
}

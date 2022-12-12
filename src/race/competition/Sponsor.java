package race.competition;

import race.transport.Transport;

public class Sponsor {
    private String name;
    private double sumOfSponsoring;

    public Sponsor(String name, double sumOfSponsoring) {
        this.name = (name == null || name.isBlank() || name.isEmpty()) ? "default" : name;
        this.sumOfSponsoring = (sumOfSponsoring < 0) ? 0 : sumOfSponsoring;
    }

    public void sponsoring(Transport transport) {
        System.out.println("Спонсор "+getName()+" спонсирует транспорт "+transport);
        transport.addSponsor(this);
    }

    public String getName() {
        return name;
    }

    public double getSumOfSponsoring() {
        return sumOfSponsoring;
    }

    public void setSumOfSponsoring(double sumOfSponsoring) {
        if (sumOfSponsoring >= 0) this.sumOfSponsoring = sumOfSponsoring;
        else throw new IllegalArgumentException("Сумма не может быть отрицательной");
    }

    @Override
    public String toString() {
        return "Спонсор "+getName()+" "+getSumOfSponsoring()+" руб.";
    }
}

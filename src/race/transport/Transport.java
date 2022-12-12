package race.transport;

import race.competition.Driver;
import race.competition.Mechanic;
import race.competition.Sponsor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class Transport {
    private String brand;
    private String model;
    private double engineVolume;
    private double bestLapTime;
    private int maxSpeed;
    private Driver currentDriver;
    private Set<Sponsor> sponsors;
    private boolean inCondition = true;
    private ArrayList<Mechanic> mechanicList;

    public Transport(String brand, String model, double engineVolume) {
        this.brand = (brand == null || brand.isEmpty() || brand.isBlank()) ? "default" : brand;
        this.model = (model == null || model.isEmpty() || model.isBlank()) ? "default" : model;
        this.engineVolume = (engineVolume <= 0) ? 1.5 : engineVolume;
        this.sponsors = new HashSet<>();
        mechanicList = new ArrayList<>(4);
    }

    public void addSponsor(Sponsor sponsor) {
        if (sponsor != null) sponsors.add(sponsor);
    }

    public void deleteSponsor(Sponsor sponsor) {
        if (sponsor != null) sponsors.remove(sponsor);
    }

    public void addMechanic(Mechanic mechanic) {
        if (mechanic != null) mechanicList.add(mechanic);
    }

    public void deleteMechanic(Mechanic mechanic) {
        if (mechanic != null) mechanicList.remove(mechanic);
    }

    public double totalSumOfSponsoring() {
        double sum = 0;
        for (Sponsor a : sponsors) {
            if (a != null) sum += a.getSumOfSponsoring();
        }
        return sum;
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void printType();

    public void printSponsors() {
        if (sponsors.size() == 0) System.out.println("У "+this+" нет спонсоров");
        else {
            System.out.println(this + " спонсируют: ");
            for (Sponsor a : sponsors) {
                System.out.println(a);
            }
            System.out.println("Общая сумма спонсирования: "+totalSumOfSponsoring()+" руб.");
            System.out.println();
        }
    }

    public void printMechanics() {
        if (mechanicList.size() ==0) System.out.println("У "+this+" нет механиков");
        else {
            System.out.println(this+" наблюдается у следующих механиков:");
            for (Mechanic a : mechanicList) {
                System.out.println(a);
            }
            System.out.println();
        }
    }

    public abstract boolean getDiagnosed() throws CantGetDiagnosed;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public double getBestLapTime() {
        return bestLapTime;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public abstract String getTypeOfTransport();

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public ArrayList<Mechanic> getMechanicList() {
        return mechanicList;
    }

    public Driver getCurrentDriver() {
        return currentDriver;
    }

    public boolean isInCondition() {
        return inCondition;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume > 0) this.engineVolume = engineVolume;
    }

    public void setBestLapTime(double bestLapTime) {
        if (bestLapTime > 0) this.bestLapTime = bestLapTime;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) this.maxSpeed = maxSpeed;
    }

    public void setCurrentDriver(Driver currentDriver) {
        this.currentDriver = currentDriver;
    }

    public void changeInCondition() {
        this.inCondition = !this.inCondition;
    }
}

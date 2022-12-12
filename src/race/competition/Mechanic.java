package race.competition;

import race.transport.Bus;
import race.transport.Car;
import race.transport.Transport;
import race.transport.Truck;

import java.util.LinkedList;
import java.util.Queue;

public class Mechanic {
    public enum Profile {
        CARS("Машины"), BUSES("Автобусы"), TRUCKS("Грузовики"), ANY("Любые");
        private String name;

        Profile(String profile) {
            this.name = profile;
        }

        public static Profile getProfileByString(String string) {
            for (Profile a : Profile.values()) {
                if (a.getName().equalsIgnoreCase(string)) return a;
            }
            return null;
        }
        public String getName() {
            return name;
        }
    }

    private String name;
    private String company;
    private Profile profile;
    private Queue<Transport> queueOfCars;

    public Mechanic(String name, String company, String profile) {
        this.name = name;
        this.company = company;
        if (Profile.getProfileByString(profile) == null) this.profile = Profile.valueOf(profile.toUpperCase());
        else this.profile = Profile.getProfileByString(profile);
        queueOfCars = new LinkedList<>();
    }

    public void performMaintenance() {
        Transport transport = queueOfCars.poll();
        if (transport != null) {
            System.out.println("Механик " + getName() + " из компании " + getCompany() + " начал чинить " + transport);
            System.out.println("Механик " + getName() + " из компании " + getCompany() + " закончил чинить " + transport);
            transport.changeInCondition();
            performMaintenance();
        } else System.out.println("Очередь пуста");
    }

    public void checkCarCondition(Transport transport) {
        if (transport != null) {
            if ((profile.getName().equalsIgnoreCase("Машины") && transport instanceof Car) || (profile.getName().equalsIgnoreCase("Грузовики") && transport instanceof Truck) || (profile.getName().equalsIgnoreCase("Автобусы") && transport instanceof Bus) || (profile.getName().equalsIgnoreCase("Любые"))) {
                if (queueOfCars.contains(transport)) System.out.println(transport+" уже в очереди у механика "+getName());
                else if (!transport.isInCondition()) {
                    queueOfCars.offer(transport);
                    transport.addMechanic(this);
                    System.out.println(transport + " неисправен, механик " + getName() + " займется этим транспортом");
                } else System.out.println(transport+" исправен, в ремонте не нуждается");
            } else System.out.println("Профиль механика "+getName()+" не подходит для "+transport);
        }
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Queue<Transport> getQueueOfCars() {
        return queueOfCars;
    }

    @Override
    public String toString() {
        return "Механик "+getName()+" из компании "+getCompany()+" профиль "+getProfile().getName();
    }
}

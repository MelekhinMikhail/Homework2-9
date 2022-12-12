package race.competition;

import race.transport.*;

import java.util.Arrays;

public class Driver<T extends Transport & Competing> {
    private String fullName;
    private String[] licenses;
    private int experience;
    private Transport currentTransport;
    private boolean inMoving = false;

    public Driver(String fullName, int experience) {
        this.fullName = (fullName == null || fullName.isEmpty() || fullName.isBlank()) ? "default" : fullName;
        this.experience = (experience < 0) ? 0 : experience;
        this.licenses = new String[0];
    }

    public void addLicense(String license) {
        if (licenses.length == 0 || !Arrays.asList(licenses).contains(license)) {
            if (license.equalsIgnoreCase("B") || license.equalsIgnoreCase("C") || license.equalsIgnoreCase("D")) {
                licenses = Arrays.copyOf(licenses, licenses.length + 1);
                licenses[licenses.length - 1] = license.toUpperCase();
            } else throw new IllegalArgumentException("Лицензии категории "+license.toUpperCase()+" не существует");
        }
    }

    public void deleteLicense(String license) {
        if (licenses.length == 0) System.out.println("У водителя нет лицензий");
        else {
            String[] array = new String[licenses.length - 1];
            for (int i=0; i < licenses.length; i++) {
                if (licenses[i].equalsIgnoreCase(license)) licenses[i] = null;
            }
            int a = 0;
            for (int j=0; j < licenses.length; j++) {
                if (licenses[j] != null) {
                    array[a] = licenses[j];
                    a++;
                }
            }
            licenses = Arrays.copyOf(array, array.length);
        }
    }

    public void setCurrentTransport(T transport) {
        if (transport.getClass() == Car.class && Arrays.asList(licenses).contains("B")) {
            currentTransport = transport;
            transport.setCurrentDriver(this);
        } else if (transport.getClass() == Truck.class && Arrays.asList(licenses).contains("C")) {
            currentTransport = transport;
            transport.setCurrentDriver(this);
        } else if (transport.getClass() == Bus.class && Arrays.asList(licenses).contains("D")) {
            currentTransport = transport;
            transport.setCurrentDriver(this);
        } else throw new RuntimeException("У водителя "+getFullName()+" нет лицензии на данный транспорт");
    }

    public void startDriving() {
        if (currentTransport == null) System.out.println("У водителя "+getFullName()+" нет транспорта");
        else if (inMoving) System.out.println("Водитель "+getFullName()+" уже в движении");
        else {
            System.out.println("Водиель "+getFullName()+" завел "+currentTransport);
            currentTransport.startMoving();
            inMoving = true;
        }
    }

    public void stopDriving() {
        if (currentTransport == null) System.out.println("У водителя "+getFullName()+" нет транспорта");
        else if (!inMoving) System.out.println("Водитель "+getFullName()+" не в движении");
        else {
            System.out.println("Водиель "+getFullName()+" остановился и заглушил "+currentTransport);
            currentTransport.stopMoving();
            inMoving = false;
        }
    }

    public void refillTransport(){
        if (currentTransport == null) System.out.println("У водителя "+getFullName()+" нет транспорта");
        else if (inMoving) System.out.println("Машину нужно остановить, чтобы заправить");
        else {
            System.out.println("Водиель "+getFullName()+" заправил "+currentTransport);
        }
    }


    public String getFullName() {
        return fullName;
    }

    public int getExperience() {
        return experience;
    }

    public String[] getLicenses() {
        return licenses;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void setExperience(int experience) {
        if (experience >= 0) this.experience = experience;
    }

    @Override
    public String toString() {
        return "Водитель "+getFullName()+" со стажем "+getExperience()+" лет имеет категории: "+String.join(" ", licenses)
                +((currentTransport == null) ? "" : " учавствует в соревновании на "+currentTransport);
    }
}

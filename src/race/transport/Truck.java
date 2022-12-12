package race.transport;

public class Truck extends Transport implements Competing {

    public enum LoadType {N1, N2, N3}

    private LoadType loadType;

    public Truck(String brand, String model, double engineVolume, String loadType) {
        super(brand, model, engineVolume);
        this.loadType = LoadType.valueOf(loadType.toUpperCase());
    }

    @Override
    public void startMoving() {
        System.out.println("Грузовик "+super.getBrand()+" "+super.getModel()+" начал движение");
    }

    @Override
    public void stopMoving() {
        System.out.println("Грузовик "+super.getBrand()+" "+super.getModel()+" пректратил движение");
    }

    @Override
    public void printType() {
        if (loadType != null) {
            System.out.println(this);
        } else System.out.println("Данных по транспортному средству недостаточно");
    }

    @Override
    public boolean getDiagnosed() {
        return true;
    }

    @Override
    public void pitStop() {
        System.out.println("Грузовик "+super.getBrand()+" "+super.getModel()+" сделал остановку");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время за круг: "+super.getBestLapTime());
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость: "+super.getMaxSpeed()+" км/ч");
    }


    @Override
    public String toString() {
        return "Грузовик "+super.getBrand()+" "+super.getModel()+" объем двигателя "+super.getEngineVolume()+" л. " +
                "тип грузоподъемности "+getLoadType();
    }

    public LoadType getLoadType() {
        return loadType;
    }

    public String getTypeOfTransport() {
        return "Грузовик";
    }
}

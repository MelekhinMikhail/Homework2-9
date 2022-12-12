package race.transport;

public class Bus extends Transport implements Competing {

    public enum TypeOfCapacity {
        ESPECIALLY_SMALL("Особо малая"), SMALL("Малая"), MEDIUM("Средняя"), LARGE("Большая"), ESPECIALLY_LARGE("Особо большая");
        private String typeOfCapacity;

        TypeOfCapacity(String typeOfCapacity) {
            this.typeOfCapacity = typeOfCapacity;
        }

        public static TypeOfCapacity getTypeOfCapacityByString(String string) {
            for (TypeOfCapacity a : TypeOfCapacity.values()) {
                if (a.getTypeOfCapacity().equalsIgnoreCase(string)) return a;
            }
            return null;
        }

        public String getTypeOfCapacity() {
            return typeOfCapacity;
        }
    }

    private TypeOfCapacity typeOfCapacity;

    public Bus(String brand, String model, double engineVolume, String typeOfCapacity) {
        super(brand, model, engineVolume);
        if (TypeOfCapacity.getTypeOfCapacityByString(typeOfCapacity) == null) this.typeOfCapacity = TypeOfCapacity.valueOf(typeOfCapacity.replace(' ', '_').toUpperCase());
        else this.typeOfCapacity = TypeOfCapacity.getTypeOfCapacityByString(typeOfCapacity);
    }

    @Override
    public void startMoving() {
        System.out.println("Автобус "+super.getBrand()+" "+super.getModel()+" начал движение");
    }

    @Override
    public void stopMoving() {
        System.out.println("Автобус "+super.getBrand()+" "+super.getModel()+" прекратил движение");
    }

    @Override
    public void printType() {
        if (typeOfCapacity != null) {
            System.out.println(this);
        } else System.out.println("Данных по транспортному средству недостаточно");
    }

    @Override
    public boolean getDiagnosed() throws CantGetDiagnosed {
        throw new CantGetDiagnosed(this);
    }

    @Override
    public void pitStop() {
        System.out.println("Автобус "+super.getBrand()+" "+super.getModel()+" сделал останувку");
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
        return "Автобус "+super.getBrand()+" "+super.getModel()+" объем двигателя "+super.getEngineVolume()+" л. " +
                "Вместимость "+getTypeOfCapacity().getTypeOfCapacity();
    }

    public TypeOfCapacity getTypeOfCapacity() {
        return typeOfCapacity;
    }

    public String getTypeOfTransport() {
        return "Автобус";
    }
}

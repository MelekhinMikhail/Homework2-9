package race.transport;

public class Car extends Transport implements Competing {
    public enum BodyType {
        SEDAN ("Седан"), HATCHBACK("Хетчбэк"), COUPE("Купэ"), UNIVERSAL("Универсал"), SUV("Внедорожник"), CROSSOVER("Кроссовер"), PICKUP("Пикап"), VAN("Фургон"), MINIVAN("Минивэн");
        private String bodyType;
        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public static BodyType getBodyTypeByString(String string) {
            for (BodyType a : BodyType.values()) {
                if (a.getBodyType().equalsIgnoreCase(string)) return a;
            }
            return null;
        }

        public String getBodyType() {
            return bodyType;
        }
    }

    private BodyType bodyType;

    public Car(String brand, String model, double engineVolume, String bodyType) {
        super(brand, model, engineVolume);
        if (BodyType.getBodyTypeByString(bodyType) == null) this.bodyType = BodyType.valueOf(bodyType.toUpperCase());
        else this.bodyType = BodyType.getBodyTypeByString(bodyType);
    }


    @Override
    public void startMoving() {
        System.out.println("Автомобиль "+super.getBrand()+" "+super.getModel()+" начал движение");
    }

    @Override
    public void stopMoving() {
        System.out.println("Автомобиль "+super.getBrand()+" "+super.getModel()+" прекратил движение");
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(this);
        } else System.out.println("Данных по транспортному средству недостаточно");
    }

    @Override
    public boolean getDiagnosed() {
        return false;
    }

    @Override
    public void pitStop() {
        System.out.println("Автомобиль "+super.getBrand()+" "+super.getModel()+" сделал остановку");
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
        return "Автомобиль "+super.getBrand()+" "+super.getModel()+" объем двигателя "+super.getEngineVolume()+" л. " +
                "тип кузова "+getBodyType().getBodyType();
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getTypeOfTransport() {
        return "Автомобиль";
    }
}

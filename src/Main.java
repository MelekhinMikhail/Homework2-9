import hypermarket.ProductList;
import passport.Passport;
import passport.PassportHub;
import race.competition.*;
import hypermarket.Hypermarket;
import race.transport.*;
import java.lang.Math.*;

import java.util.*;


public class Main {
    public static void main(String[] args) {
//        Car audi = new Car("Audi", "A8", 2.5, "купэ");
//        Car bmw = new Car("BMW", "M2 Competition", 3.0, "van");
//        Car mercedes = new Car("Mercedes-Benz", "SLS AMG", 6.2, "minivan");
//        Car ferrari = new Car("Ferrari", "250 TR", 6.6, "universal");
//
//        Truck man = new Truck("MAN", "TGS 6x6", 11.2, "n1");
//        Truck iveco = new Truck("Iveco", "Turbostar 190.48", 12.1, "n2");
//        Truck daf = new Truck("DAF", "MNS-390", 10.8, "n3");
//        Truck scania = new Truck("Scania", "RK-907", 11.7, "n2");
//
//        Bus ankai = new Bus("Ankai", "S-308", 8.1, "especially small");
//        Bus baw = new Bus("BAW", "JS-778", 7.2, "small");
//        Bus foton = new Bus("Foton", "HR 558", 8.6, "Особо большая");
//        Bus higer = new Bus("Higer", "FVN-367", 7.8, "средняя");
//
//        Driver robbyn =new  Driver("Афанасьев Робин Евгеньевич", 5);
//        robbyn.addLicense("b");
//        robbyn.setCurrentTransport(bmw);
//        robbyn.startDriving();
//        robbyn.stopDriving();
//        robbyn.refillTransport();
//        System.out.println(ankai);
//        System.out.println(baw);
//        System.out.println(foton);
//        System.out.println(higer);

//        try {
//            System.out.println(Data.check("abcd1_23", "qwerty123", "qwerty123"));
//        } catch (WrongLoginException e) {
//            throw new RuntimeException(e);
//        } catch (WrongPasswordException e) {
//            throw new RuntimeException(e);
//        }
//
//        checkDiagnosed(audi, ankai, iveco);

//        Competition competition = new Competition("Гранпри в Монако");
//        competition.addParticipant(baw);
//        competition.addParticipant(mercedes);
//        competition.addParticipant(iveco);
//        competition.addParticipant(ferrari);
//
//        Mechanic petrov = new Mechanic("Алексей Петров", "Чиню быстро", "машины");
//        Mechanic ivanov = new Mechanic("Николай Иванов", "Лучше всех", "грузовики");
//        Mechanic sidorov = new Mechanic("Иван Сидоров", "Шиномонтаж на Профсоюзной", "автобусы");
//        Mechanic fyodorov = new Mechanic("Владимир Федоров", "Тех обслуживание номер 1", "любые");
//
//        Sponsor gazprom = new Sponsor("Газпром", 200_000);
//        Sponsor tatneft = new Sponsor("Татнефть", 150_000);
//        Sponsor lukoil = new Sponsor("Лукойл", 180_000);
//        Sponsor sberbank = new Sponsor("Сбарбанк", 300_000);
//
//        mercedes.addSponsor(gazprom);
//        mercedes.addSponsor(lukoil);
//        ferrari.addSponsor(sberbank);
//        iveco.addSponsor(tatneft);
//        System.out.println(mercedes.totalSumOfSponsoring());
//
//        baw.changeInCondition();
//        petrov.checkCarCondition(baw);
//        sidorov.checkCarCondition(baw);
//        sidorov.checkCarCondition(baw);
//        sidorov.performMaintenance();
//        System.out.println(baw.isInCondition());
//
//        mercedes.printSponsors();
//        mercedes.changeInCondition();
//        petrov.checkCarCondition(mercedes);
//        mercedes.printMechanics();
//
//        ServiceStation service = new ServiceStation("№1");
//        service.addTransport(mercedes);
//        service.addTransport(bmw);
//        service.addTransport(ferrari);
//        service.printQueue();
//        service.performMaintenance();
//        service.printQueue();
//
//        Hypermarket ashan = new Hypermarket();
//        ashan.addConsumer("Валерий");
//        ashan.addConsumer("Аркадий");
//        ashan.addConsumer("Леонид");
//        ashan.addConsumer("Валентина");
//        ashan.addConsumer("Оксана");
//        ashan.addConsumer("Дмитрий");
//        ashan.addConsumer("Олег");
//        ashan.addConsumer("Семён");
//        ashan.addConsumer("Дарья");
//        ashan.addConsumer("Мария");
//        ashan.addConsumer("Глеб");
//        ashan.addConsumer("Иван");
//        ashan.addConsumer("Даниил");
//        ashan.addConsumer("Антон");
//        ashan.addConsumer("Татьяна");
//        ashan.addConsumer("Артём");
//        ashan.printBoxOffices();

        ProductList list = new ProductList("на день Рождения");
        list.addProduct("Банан", 1, 67);
        list.addProduct("Колбаса", 0.5, 500);
        list.addProduct("Хлеб", 0.4, 200);
        list.addProduct("Картофель", 3, 40);
        list.addProduct("Торт", 0.7, 1000);
//        list.addProduct("Колбаса", 0.6, 700);
        list.printProductList();

        ProductList list1 = new ProductList("на Новый год");
        list1.addProduct("Яблоки", 2, 70);
        list1.addProduct("Помидоры", 1, 120);
        list1.addProduct("Хлеб", 0.4, 200);
        list1.addProduct("Картофель", 3, 40);
        list1.addProduct("Торт", 0.7, 1000);
        list1.printProductList();

        ProductList list2 = new ProductList("на день Рождения");
        list2.addProduct("Молоко", 1, 80);
        list2.addProduct("Колбаса", 0.5, 500);
        list2.addProduct("Хлеб", 0.4, 200);
        list2.addProduct("Картофель", 3, 40);
        list2.addProduct("Торт", 0.7, 1000);
        list2.printProductList();

        Set<ProductList> listSet = new HashSet<>();
        listSet.add(list);
        listSet.add(list1);
        listSet.add(list2);
        System.out.println(listSet);

//        Создайте множество целых чисел. Заполните множество 20 случайными числами в диапазоне от 0 до 1000.
//        Пройдитесь по всем элементам множества и удалите из него все нечетные значения. Выведите оставшиеся элементы в консоль.
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<21; i++) {
            set.add(i);
        }
        System.out.println(set);
        set.removeIf(x -> x%2 == 1);
        System.out.println(set);

        task3_2();


        Passport passport1 = new Passport("1234567", "Иван", "Иванов", "Иванович", "13.03.1987");
        Passport passport2 = new Passport("7654321", "Олег", "Фёдоров", "13.03.1991");
        Passport passport3 = new Passport("1234567", "Вячеслав", "Иванов", "Иванович", "28.09.1997");
        PassportHub hub = new PassportHub();
        hub.addPassport(passport1);
        hub.addPassport(passport2);
        hub.printPassportHub();
        System.out.println();
        hub.addPassport(passport3);
        hub.printPassportHub();
        System.out.println();
        System.out.println(hub.getPassportByNumber("7654321"));



    }


    public static void task3_2() {
        List<String> tasks = new LinkedList<>();
        for (int i=2; i<10; i++) {
            for (int j=2; j<10; j++) {
                if (tasks.contains(j+"*"+i)) continue;
                tasks.add(i+"*"+j);
            }
        }
        int a;
        ArrayList<String> arrayList = new ArrayList<>(15);
        for (int h=0; h<15; h++) {
            a = (int) (Math.random()*tasks.size());
            if (arrayList.contains(tasks.get(a))) {
                while (arrayList.contains(tasks.get(a))) {
                    a = (int) (Math.random()*tasks.size());
                }
                arrayList.add(tasks.get(a));
            } else arrayList.add(tasks.get(a));
        }
        for (String s : arrayList) {
            System.out.println(s);
        }
    }


    public static void checkDiagnosed(Transport... transports) {
        try {
            for (Transport a : transports) {
                if (!a.getDiagnosed()) throw new RuntimeException(a.getTypeOfTransport()+" "+a.getBrand()+" "+a.getModel()+" не прошел диагностику");
            }
        } catch (CantGetDiagnosed e) {
            System.out.println(e.getTransport()+" в диагностике не требуется.");
        }
    }
}
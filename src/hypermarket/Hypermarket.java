package hypermarket;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Hypermarket {
    private Queue<String> boxOffice1;
    private Queue<String> boxOffice2;
    private Queue<String> boxOffice3;
    private LinkedList<Queue<String>> boxOffices;

    public Hypermarket() {
        boxOffice1 = new ArrayBlockingQueue<>(5);
        boxOffice2 = new ArrayBlockingQueue<>(5);
        boxOffice3 = new ArrayBlockingQueue<>(5);
        boxOffices = new LinkedList<>();
        boxOffices.add(boxOffice1);
        boxOffices.add(boxOffice2);
        boxOffices.add(boxOffice3);
    }

    public void addConsumer(String string) {
        if (string.isEmpty() || string.isBlank()) throw new IllegalArgumentException();
        if (boxOffices.get(0).size() == 5 && boxOffices.get(1).size() == 5 && boxOffices.get(2).size() == 5) System.out.println("Кассы переполнены, нужно позвать Галю!");
        else if (boxOffices.get(0).size() <= boxOffices.get(1).size() && boxOffices.get(0).size() <= boxOffices.get(2).size()) {
            boxOffices.get(0).add(string);
        } else if (boxOffices.get(1).size() <= boxOffices.get(0).size() && boxOffices.get(1).size() <= boxOffices.get(2).size()) {
            boxOffices.get(1).add(string);
        } else if (boxOffices.get(2).size() <= boxOffices.get(1).size() && boxOffices.get(2).size() <= boxOffices.get(0).size()) {
            boxOffices.get(2).add(string);
        }
    }

    public void deleteConsumer() {
        if (boxOffices.get(0).size() == 0 && boxOffices.get(1).size() == 0 && boxOffices.get(2).size() == 0) System.out.println("Кассы пустые");
        else if (boxOffices.get(0).size() >= boxOffices.get(1).size() && boxOffices.get(0).size() >= boxOffices.get(2).size()) {
            boxOffices.get(0).remove();
        } else if (boxOffices.get(1).size() >= boxOffices.get(0).size() && boxOffices.get(1).size() >= boxOffices.get(2).size()) {
            boxOffices.get(1).remove();
        } else if (boxOffices.get(2).size() >= boxOffices.get(1).size() && boxOffices.get(2).size() >= boxOffices.get(0).size()) {
            boxOffices.get(2).remove();
        }
    }

    public void printBoxOffices() {
        System.out.println("Загруженность касс на данный момент: ");
        for (Queue<String> a : boxOffices) {
            System.out.println((boxOffices.indexOf(a)+1)+"-я касса:");
            System.out.println("Всего "+a.size()+" человек:");
            for (String s : a) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public Queue<String> getBoxOffice1() {
        return boxOffice1;
    }

    public Queue<String> getBoxOffice2() {
        return boxOffice2;
    }

    public Queue<String> getBoxOffice3() {
        return boxOffice3;
    }
}

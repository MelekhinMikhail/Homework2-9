package race.competition;

import race.transport.Competing;
import race.transport.Transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Transport & Competing> {
    private String name;
    private Queue<T> queue;

    public ServiceStation(String name) {
        this.name = name;
        queue = new LinkedList<>();
    }

    public void addTransport(T transport) {
        if (transport != null) queue.offer(transport);
    }

    public void performMaintenance() {
        T transport = queue.poll();
        if (transport != null) {
            if (transport.isInCondition()) System.out.println(transport+" исправен, в ремонте не нуждается");
            else System.out.println(transport+" неисправен, нуждается в ремонте");
            performMaintenance();
        }
    }

    public String getName() {
        return name;
    }

    public Queue<T> getQueue() {
        return queue;
    }

    public void printQueue() {
        for (T a : queue) {
            System.out.println(a);
        }
        System.out.println();
    }
}

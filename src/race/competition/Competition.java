package race.competition;

import race.transport.Transport;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Competition {
    private String name;
    private Set<Transport> participants;

    public Competition(String name) {
        this.name = (name.isEmpty() || name.isBlank()) ? "default" : name;
        this.participants = new HashSet<>();
    }

    public void addParticipant(Transport transport) {
        if (transport != null) participants.add(transport);
    }

    public void deleteParticipant(Transport transport) {
        if (transport != null) participants.remove(transport);
    }

    public String getName() {
        return name;
    }

    public Set<Transport> getParticipants() {
        return participants;
    }
}

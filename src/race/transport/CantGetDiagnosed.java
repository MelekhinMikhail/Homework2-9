package race.transport;

public class CantGetDiagnosed extends Exception{
    private Transport transport;

    public CantGetDiagnosed() {
    }

    public CantGetDiagnosed(String message) {
        super(message);
    }

    public CantGetDiagnosed(Transport transport) {
        this.transport = transport;
    }

    public Transport getTransport() {
        return transport;
    }
}

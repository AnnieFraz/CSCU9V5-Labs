package Lab3;

public class Gate extends Thread {
    Counter counter;
    int gatePosition;

    public Gate(Counter counter, int gatePosition) {
        this.counter = counter;
        this.gatePosition = gatePosition;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            counter.accessFile(gatePosition);
        }

    }
}

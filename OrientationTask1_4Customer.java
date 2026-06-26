public class Customer {

    private static int nextId = 1;

    private int id;
    private long arrivalTime;

    public Customer() {
        id = nextId++;
        arrivalTime = System.nanoTime();
    }

    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}

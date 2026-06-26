import java.util.LinkedList;
import java.util.Random;

public class ServicePoint {

    private LinkedList<Customer> queue = new LinkedList<>();
    private Random random = new Random();

    public void addToQueue(Customer customer) {
        queue.addLast(customer);
        System.out.println("Customer " + customer.getId() + " joined the queue.");
    }

    public Customer removeFromQueue() {
        return queue.removeFirst();
    }

    public void serve() {

        while (!queue.isEmpty()) {

            Customer customer = removeFromQueue();

            long serviceStart = System.nanoTime();

            int serviceTime = random.nextInt(3000) + 1000;

            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long serviceEnd = System.nanoTime();

            double waitingTime =
                    (serviceStart - customer.getArrivalTime()) / 1_000_000.0;

            double serviceDuration =
                    (serviceEnd - serviceStart) / 1_000_000.0;

            double responseTime =
                    waitingTime + serviceDuration;

            System.out.println("--------------------------------");
            System.out.println("Customer ID: " + customer.getId());
            System.out.printf("Waiting Time: %.2f ms%n", waitingTime);
            System.out.printf("Service Time: %.2f ms%n", serviceDuration);
            System.out.printf("Response Time: %.2f ms%n", responseTime);
        }
    }
}

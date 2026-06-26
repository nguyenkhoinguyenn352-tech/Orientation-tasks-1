import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Queue Customer");
            System.out.println("2. Dequeue Customer");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    Customer customer = new Customer();
                    queue.addLast(customer);

                    System.out.println("Customer "
                            + customer.getId()
                            + " joined the queue.");

                    break;

                case 2:

                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {

                        Customer served = queue.removeFirst();

                        long waitingTime =
                                (System.nanoTime()
                                        - served.getArrivalTime())
                                        / 1_000_000;

                        System.out.println("Customer "
                                + served.getId()
                                + " left the queue.");

                        System.out.println("Waiting time: "
                                + waitingTime
                                + " ms");
                    }

                    break;

                case 3:

                    System.out.println("Program ended.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}

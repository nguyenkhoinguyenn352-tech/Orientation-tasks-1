public class CustomerGenerator {

    public static void generateCustomers(ServicePoint servicePoint,
                                         int numberOfCustomers) {

        for (int i = 0; i < numberOfCustomers; i++) {

            Customer customer = new Customer();

            servicePoint.addToQueue(customer);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

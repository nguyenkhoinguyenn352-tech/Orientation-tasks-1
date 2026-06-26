public class Main {

    public static void main(String[] args) {

        ServicePoint servicePoint = new ServicePoint();

        CustomerGenerator.generateCustomers(servicePoint, 5);

        System.out.println("\nStarting service...\n");

        servicePoint.serve();
    }
}

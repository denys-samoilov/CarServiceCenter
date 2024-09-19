import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList <Customer> customerArrayList = new ArrayList<Customer>();
        Customer customer = new Customer("Ivan", "ivan@gmail.com", "qwerty123", "0956259302", "opel");
        customer = new Customer("Denys", "den@gmail.com", "qwer", "+1111", "Opel");

        customerArrayList.add(customer);

        ArrayList <Order> orderArrayList = new ArrayList<Order>();

        Order order = new Order();
        order.setCustomer(customer);
        orderArrayList.add(order);
        Customer c = orderArrayList.get(0).getCustomer();
        System.out.println(c.getName() + "\n" + c.getCar());
    }
}
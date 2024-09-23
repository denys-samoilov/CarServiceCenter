import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList <Customer> customerArrayList = new ArrayList <Customer>();
        ArrayList <Order> orderArrayList = new ArrayList<Order>();

        Mechanic mechanic = new Mechanic();

        RegisterUser(customerArrayList);

        MakeOrder(orderArrayList, customerArrayList.getLast(), mechanic);


        System.out.println(orderArrayList.get(0).getOrderID());

        System.out.println(orderArrayList.get(0).getDescription());


//        Order order = new Order();
//        order.setCustomer(customer);
//        orderArrayList.add(order);
//        Customer c = orderArrayList.get(0).getCustomer();
//        System.out.println("\n" + c.getName() + "\n" + c.getCar());
    }

    public static void RegisterUser(ArrayList<Customer> list)
    {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();

        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        System.out.print("Введіть номер телефону: +38");
        String phone = "+38" + scanner.nextLine();

        System.out.print("Введіть назву свого автомобіля: ");
        String car = scanner.nextLine();

        Customer customer = new Customer(name, login, password, phone, car);

        list.add(customer);
    }

    public static void MakeOrder(ArrayList<Order> list, Customer customer, Mechanic mechanic)
    {

        Scanner scanner = new Scanner(System.in);

        int id = list.size();

        System.out.print("Введіть опис замовлення: ");
        String description = scanner.nextLine();

        Order order = new Order(id, customer, mechanic, description);

        list.add(order);

    }
}
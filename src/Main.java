import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {


        Scanner scanner = new Scanner(System.in);

        int loggedID = -1;

        ArrayList <Customer> customerArrayList = new ArrayList <Customer>();
        ArrayList <Order> orderArrayList = new ArrayList<Order>();
        ArrayList<Mechanic> mechanicArrayList = new ArrayList<Mechanic>();

        Mechanic mechanic = new Mechanic("Сергій", "mechanic123", "qwerty123", "+380952278423");
        mechanicArrayList.add(mechanic);

        for(int k = 1; k!=0;)
        {
            System.out.println("1 - зареєструватись \n2 - увійти \n3 - зробити замовлення \n0 - вийти");
            k = scanner.nextInt();
            switch (k)
            {
                case 1: {
                    RegisterUser(customerArrayList); break;
                }

                case 2: {
                    loggedID = LoginUser(customerArrayList); break;
                }

                case 3: {
                    MakeOrder(orderArrayList, customerArrayList.get(loggedID), mechanicArrayList, loggedID);
                }
            }
        }
    }

    public static void RegisterUser(ArrayList<Customer> customerArrayList)
    {
        Scanner scanner = new Scanner(System.in);

        int id = customerArrayList.size();

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

        Customer customer = new Customer(id, name, login, password, phone, car);

        for(int i = 0; i < customerArrayList.size(); i++)
        {
            String arrayListLogin = customerArrayList.get(i).getLogin();
            if(arrayListLogin.equals(login))
            {
                System.out.println("Користувач з даним логіном вже існоує");
                return;
            }
        }

        customerArrayList.add(customer);
    }

    public static void MakeOrder(ArrayList<Order> orderArrayList, Customer customer, ArrayList<Mechanic> mechanicArrayList, int loggedID)
    {

        if(loggedID == -1)
        {
            System.out.println("Увійдіть в обліковий запис.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        int id = orderArrayList.size();

        System.out.print("Введіть опис замовлення: ");
        String description = scanner.nextLine();

        System.out.println("Введіть індекс механіка до якого ви хочете звернутись: ");

        for(int i = 0; i< mechanicArrayList.size(); i++)
        {
            System.out.println(i + " -> " + mechanicArrayList.get(i).getName());
        }

        int mechanicIndex = scanner.nextInt();

        Order order = new Order(id, customer, mechanicArrayList.get(mechanicIndex), description);

        orderArrayList.add(order);

        OrderOutput(id, orderArrayList);
    }

    public  static void OrderOutput(int id, ArrayList<Order> orderArrayList)
    {
        Customer customer = orderArrayList.get(id).getCustomer();
        Mechanic mechanic = orderArrayList.get(id).getMechanic();
        String description = orderArrayList.get(id).getDescription();
        LocalDate date = orderArrayList.get(id).getDate();
        boolean isConfirmed = orderArrayList.get(id).isConfirmed();
        float price = orderArrayList.get(id).getPrice();

        System.out.println("ID замовлення: " + id);
        System.out.println("Логін замовника: " + customer.getLogin());
        System.out.println("Ім'я замовника: " + customer.getName());
        System.out.println("Номер телефону замовника: " + customer.getPhoneNumber());
        System.out.println("Машина замовника: " + customer.getCar());
        System.out.println("Ім'я механіка: " + mechanic.getName());
        System.out.println("Номер телефону механіка: " + mechanic.getPhoneNumber());
        System.out.println("Опис замовлення: " + description);
        System.out.println("Дата замовлення: " + date);
        System.out.println("Чи підтверджено замовлення: " + isConfirmed);
        System.out.println("Ціна замовлення: " + price + "\n");



    }

    public static int LoginUser(ArrayList<Customer> userArrayList)
    {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Логін: ");
        String inputLogin = scanner.nextLine();

        System.out.print("Пароль: ");
        String inputPassword = scanner.nextLine();

        int arrayListId;
        String arrayListLogin;
        String arrayListPassword;
        for(int i = 0; i<userArrayList.size(); i++)
        {
            arrayListId = userArrayList.get(i).getId();
            arrayListLogin = userArrayList.get(i).getLogin();
            arrayListPassword = userArrayList.get(i).getPassword();
            if(arrayListLogin.equals(inputLogin) && arrayListPassword.equals(inputPassword))
            {
                System.out.println("Вітаємо, " + userArrayList.get(i).getName());
                return arrayListId;
            }
        }

        System.out.println("Дані введено невірно, або користувача не зареєстровано");
        return -1;
    }
}
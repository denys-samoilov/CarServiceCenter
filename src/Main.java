import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int loggedID = -1;


        ArrayList<User> userArrayList = new ArrayList<User>();
        ArrayList <Customer> customerArrayList = new ArrayList <Customer>();
        ArrayList <Order> orderArrayList = new ArrayList<Order>();
        ArrayList<Mechanic> mechanicArrayList = new ArrayList<Mechanic>();

        Mechanic mechanic = new Mechanic(0,"Сергій", "mechanic123", "qwerty123", "+380952278423");
        mechanicArrayList.add(mechanic);
        userArrayList.add(mechanic);

        while(true)
        {
            int k;
            System.out.println("1 - зареєструватись \n2 - увійти \n3 - зробити замовлення \n0 - вийти");

            k = scanner.nextInt();
            switch (k)
            {
                case 1: {
                    RegisterUser(userArrayList, customerArrayList); break;
                }

                case 2: {
                    loggedID = LoginUser(customerArrayList);
                    break;
                }

                case 3: {
                    Customer currentCustomer = null;

                    if(loggedID!=-1)
                    {
                        for(int i = 0; i<customerArrayList.size();i++)
                        {
                            if(customerArrayList.get(i).getId() == loggedID)
                                currentCustomer = customerArrayList.get(i);
                        }
                    }

                    if(currentCustomer == null)
                    {
                        System.out.println("Увійдіть в обліковий запис.");
                    }
                    else MakeOrder(orderArrayList, currentCustomer, mechanicArrayList);

                    break;
                }

                case 0: {System.out.println("Виходимо..."); return;}

                default: {System.out.println("Введіть коректне значення");}
            }
        }
    }

    public static void RegisterUser(ArrayList<User> userArrayList, ArrayList<Customer> customerArrayList)
    {
        Scanner scanner = new Scanner(System.in);

        int id = userArrayList.size();

        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();

        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        System.out.print("Введіть номер телефону: +38");
        String phone = "+38" + scanner.nextLine();


        System.out.println("Введіть індекс бренду свого автомобіля: ");
        for(int i = 0; i<Car.Brand.values().length;i++)
        {
            System.out.println(i+1 + " " + Car.Brand.values()[i]);
        }
        int carBrandId = scanner.nextInt()-1;
        scanner.nextLine();
        System.out.print("Введіть серію автомобіля: ");
        String carSeries = scanner.nextLine();

        System.out.print("Введіть рік автомобіля: ");
        int carYear = scanner.nextInt();

        Car car = new Car(Car.Brand.values()[carBrandId], carSeries, carYear);


        Customer customer = new Customer(id, name, login, password, phone, car);

        for(int i = 0; i < userArrayList.size(); i++)
        {
            String arrayListLogin = userArrayList.get(i).getLogin();
            if(arrayListLogin.equals(login))
            {
                System.out.println("Користувач з даним логіном вже існоує");
                return;
            }
        }
        userArrayList.add(customer);
        customerArrayList.add(customer);

        System.out.print("Вітаємо, " + name + "! \nВаш автомобіль:" + car.getBrand() + " " + car.getSeries() + " " + car.getYear() + "\n\n");

    }

    public static void MakeOrder(ArrayList<Order> orderArrayList, Customer customer, ArrayList<Mechanic> mechanicArrayList)
    {
        Scanner scanner = new Scanner(System.in);

        int id = orderArrayList.size();

        System.out.print("Введіть опис замовлення: ");
        String description = scanner.nextLine();

        System.out.println("Введіть індекс механіка до якого ви хочете звернутись: ");

        for(int i = 0; i< mechanicArrayList.size(); i++)
        {
            System.out.println(i+1 + " -> " + mechanicArrayList.get(i).getName());
        }

        int mechanicIndex = scanner.nextInt()-1;

        Order order = new Order(id, customer, mechanicArrayList.get(mechanicIndex), description);

        orderArrayList.add(order);

        OrderOutput(id, orderArrayList);
    }

    public  static void OrderOutput(int id, ArrayList<Order> orderArrayList)
    {
        System.out.println(orderArrayList.get(id));
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
                System.out.println("Вітаємо, " + userArrayList.get(i).getName() + "! Ваш ID: " + arrayListId);
                return arrayListId;
            }
        }

        System.out.println("Дані введено невірно, або користувача не зареєстровано");
        return -1;
    }
}
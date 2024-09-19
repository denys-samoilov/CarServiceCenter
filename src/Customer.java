public class Customer extends User{

    public Customer(String name, String login, String password, String phoneNumber, String car)
    {
        this.setName(name);
        this.setLogin(login);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.car = car;
    }

    private String car;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}

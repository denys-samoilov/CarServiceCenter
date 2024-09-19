import java.time.LocalDate;

public class Order {
    private int orderID;
    private Customer customer;
    private Mechanic mechanic;
    private String description;
    private LocalDate date;
    private boolean isConfirmed = false;
    private float price = 0;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setBoolean(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}

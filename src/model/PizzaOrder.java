package model;

public class PizzaOrder {
    private int id;
    private String customerName;
    private String mobileNumber;
    private String pizzaSize;
    private int numberOfToppings;
    private double totalBill;

    public PizzaOrder(int id, String customerName, String mobileNumber, String pizzaSize, int numberOfToppings, double totalBill) {
        this.id = id;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.pizzaSize = pizzaSize;
        this.numberOfToppings = numberOfToppings;
        this.totalBill = totalBill;
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getMobileNumber() { return mobileNumber; }
    public String getPizzaSize() { return pizzaSize; }
    public int getNumberOfToppings() { return numberOfToppings; }
    public double getTotalBill() { return totalBill; }
}



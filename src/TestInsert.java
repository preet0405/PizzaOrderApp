import model.PizzaOrder;
import dao.PizzaOrderDAO;

public class TestInsert {
    public static void main(String[] args) {
        PizzaOrder order = new PizzaOrder("Test User", "9000000000", "L", 2, 17.25);
        PizzaOrderDAO.saveOrder(order);
    }
}


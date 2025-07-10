package util;

public class BillCalculator {
    public static double calculateTotal(String size, boolean cheese, boolean pepperoni, boolean mushrooms) {
        double total = 0;
        switch (size) {
            case "Small": total += 5; break;
            case "Medium": total += 7; break;
            case "Large": total += 9; break;
        }
        if (cheese) total += 1;
        if (pepperoni) total += 1.5;
        if (mushrooms) total += 1.2;
        return total;
    }
}
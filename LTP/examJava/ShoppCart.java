import java.util.*;

public class ShoppCart<T> {
    protected ArrayList<T> items;
    private double total;

    public ShoppCart() { items = new ArrayList<T>(); }
    
    public double getTotal() { return total; }

    public void updateAmount(double qt) { total = total + qt; }    
}
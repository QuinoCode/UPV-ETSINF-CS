
public abstract class Article implements Comparable<Article> {
    private String id;
    private double priceCost;
    private double tax;
    private int category;    
    
    public Article(String s, double t) { id = s; tax = t; }
    
    public String getId() { return id; }
    public double getPriceCost() { return priceCost; }
    public double getTax() { return tax; }
    public int getCategory() { return category; }
    
    public void setCategory(int c) { category = c; }
    public void setPriceCost(double c) { priceCost = c; }    
    abstract double getPriceBT();
    public double getPriceAT() {
        return this.getPriceBT() * (1 + tax);
    }
    public  int compareTo(Article a)
    {
        return this.category - a.category;
    }
}
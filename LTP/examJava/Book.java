
public class Book extends Article implements Comparable<Article> {
    private String title;
 
    public Book(String n, double p, int cat, String t) {
        super(n, 0.04);
        setPriceCost(p);
        setCategory(1);
        title = t;
    }

    public String getTitle() { return title; }    
    public double getPriceBT()
    {
        return super.getPriceCost() * 1.1;
    }
    public int compareTo(Article a) 
    {
        if (!(a instanceof Book)) return super.compareTo(a);
        Book b = (Book) a;
        if (this.title == b.title) return 0;
        else return -1; //Creo que es como funciona el metodo compareTo de Strings pero no lo sé
    }
}

public class Stationer extends Article implements Comparable<Article> {
    private String name;
    
    public Stationer(String n, double p, int cat, String nm) {
        super(n, 0.21);
        setPriceCost(p);
        setCategory(2);
        name = nm;
    }

    public String getName() { return name; }    
    public double getPriceBT()
    {
        return super.getPriceCost() * 1.15;
    }
    public int compareTo(Article a) 
    {
        if (!(a instanceof Stationer)) return super.compareTo(a);
        Stationer s = (Stationer) a;
        if (this.name == s.name) return 0;
        else return -1;//Mismo comentario que he puesto en la clase book con respecto a este tema
    }
}
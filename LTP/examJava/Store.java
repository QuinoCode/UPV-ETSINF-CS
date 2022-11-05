import java.util.*;

public class Store implements Comparable<Article> {
    private ArrayList<Article> store;
    private double cash;

    public Store() {
        store = new ArrayList<Article>();
        cash = 100.0;
    }
    
    public double getCash() { return cash; }

    public void updateCash(double d) { cash = cash - d; }
    
    public void addArticle(Article a) {        
        store.add(a);
        updateCash(a.getPriceCost());
    }
    
    public boolean sellArticle(Article a) {
        updateCash(0 - a.getPriceAT());
        return store.remove(a);
    }  
    public int getEqualSamples(Article a)
    {
        int contador = 0;
        Article b;
        for(int i = 0; i < store.size(); i++)
        {
            b = (Article) store.get(i);
            if (Article.b.compareTo(a) = 0) contador++;
        }
        return contador;
    }
    public int compareTo(Article a)
    {
        
    }
}
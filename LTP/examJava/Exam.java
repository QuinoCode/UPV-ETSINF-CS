
public class Exam {
    public static void main(String[] args) {
        Book b1 = new Book("book1", 6.5, 1, "Holes");
        Book b2 = new Book("book2", 5, 1, "Coraline");
        Book b3 = new Book("book2", 7, 1, "Coraline");
        Stationer p1 = new Stationer("pen1", 1, 3, "BluePen");
        Stationer p2 = new Stationer("pen2", 1.5, 3, "RedPen");
        Stationer e1 = new Stationer("eraser", 0.5, 3, "Eraser");
        Stationer s1 = new Stationer("scisors", 2.5, 3, "Scisors");
        
        Store shop = new Store();
        System.out.println("Our cash is " + shop.getCash());
        
        shop.addArticle(b1);
        shop.addArticle(b2);
        shop.addArticle(e1);
        shop.addArticle(b3);
        System.out.println("We have "+ shop.getEqualSamples(b2) + " samples of "+b2.getId());
        System.out.println("Our cash is " + shop.getCash());
        shop.sellArticle(b2);
        System.out.println("Our cash is " + shop.getCash());
        shop.addArticle(p1);
        shop.sellArticle(b1);
        System.out.println("We have "+ shop.getEqualSamples(b1) + " samples of "+b1.getId());
        shop.sellArticle(p1);
        shop.addArticle(p2);
        shop.addArticle(e1);
        shop.addArticle(s1);
        shop.sellArticle(s1);
        shop.sellArticle(b2);
        
        int r1 = b2.compareTo(b3);
        if (r1 == 0) 
            System.out.println("Articles " + b2.getId() + " and " + b3.getId() + " are equal.");
        else 
            System.out.println("Articles " + b2.getId() + " and " + b3.getId() + " are different.");
        System.out.println(r1);
        
        r1 = b1.compareTo(b3);
        if (r1 == 0) 
            System.out.println("Articles " + b1.getId() + " and " + b3.getId() + " are equal.");
        else 
            System.out.println("Articles " + b1.getId() + " and " + b3.getId() + " are different.");
        System.out.println(r1);
        
        ArticleShoppCart cart = new ArticleShoppCart<Article>();    
    }
}
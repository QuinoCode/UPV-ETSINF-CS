package practica1;
/**
 * class FiguresGroupUse.
 * 
 * @author LTP/Quino
 * @version 2022-23
 * Básicamente es para ir modificando este código para probar las distintas implementaciones que hacemos en las otras clases
 */
public class FiguresGroupUse {
    public static void main(String[] args) {
        FiguresGroup g = new FiguresGroup();
        FiguresGroup f = new FiguresGroup();
        FiguresGroup d = new FiguresGroup();
        FiguresGroup v = new FiguresGroup();
        f.add(new Circle(10, 5, 3.5));
        f.add(new Square(10, 5, 6.5));
        f.add(new Triangle(10, 5, 6.5, 32, 2, 3));
        f.add(new Rectangle(10,5, 6.5, 32));
        g.add(new Circle(10, 5, 3.5));
        g.add(new Square(10, 5, 6.5));
        g.add(new Rectangle(10,5, 6.5, 32));
        g.add(new Triangle(10, 5, 6.5, 32, 2, 3));
        d.add(new Square(10,10,1));
        d.add(new Rectangle(10,10,2,3));
        
        System.out.println(f);
        System.out.println(g.equals(f));
        System.out.println(d.area());
        System.out.println(d.greatestFigure());
    }
}
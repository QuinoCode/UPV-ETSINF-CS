package practica3;
import java.util.*;
/**
 * class FiguresGroupUse.
 * 
 * @author LTP 
 * @version 2020-21
 */
public class FiguresGroupUse {
    public static void main(String[] args) {
        FiguresGroup g = new FiguresGroup();
        g.add(new Circle(1.0, 6.0, 6.0));
        g.add(new Rectangle(2.0, 5.0, 10.0, 12.0));
        g.add(new Triangle(3.0, 4.0, 10.0, 2.0, 3.0, 3.0));
        g.add(new Rectangle(2.0, 5.0, 10.0, 12.0));
        System.out.println(g.orderedList());
        Rectangle a = new Rectangle(2.0, 5.0, 10.0, 112.5);
        Rectangle b = new Rectangle(2.0, 5.0, 10.0, 11.0);
        System.out.println(a.compareToRange(b));
        g.print('.');
    }
    public static void testComparableRange() { //Piden un test para comprobar el metodo compareToRange
        List<Rectangle> l = new LinkedList<Rectangle>(); //Se puede usar o esta o la de debajo (para almacenar todos los rectángulos)
        // List<Rectangle> l = new ArrayList<Rectangle>();
        Random r = new Random(); //Para poder usar la clase java.util.Random() hay que instanciarla

        for (int i = 0; i < 100; i++) {//Con este bucle metemos 100 rectángulos de lados aleatorios en una LinkedList

            if (r.nextInt(2) == 0) {//Una de cada 3 veces (nextInt(2) solo puede valer 0,1,2) se crea un rectángulo
                                        //las otras dos veces se genera un cuadrado 
                double a = r.nextDouble() * 10; //Gracias a java.util.Random() asignamos un double aleatorio al lado 'a'
                double b = r.nextDouble() * 10;//Asignamos un double aleatorio al lado 'b' 
                                                //nextDouble() asigna un double entre 0 y 1, este valor lo multiplicamos 
                                                // por 10 porque queremos rectángulos más grandes
                l.add(new Rectangle(1, 1, a, b));//Se añade el rectángulo de lados aleatorios a la LinkedList
            }
            else {
                double a = r.nextDouble() * 10;
                l.add(new Square(1, 1, a));//Añadimos el cuadrado a la LinkedList 'l'
            }
        }
        for (int i = 0; i < 100; i++) {
            Rectangle fi = (Rectangle) l.get(i); //En cada iteración cogemos el rectángulo que esté en la posición 'i'
                                                // de la linkedList 'l'
            for (int j = i + 1; j < 100; j++) {//Comparamos ese rectángulo con todas los rectángulos siguientes a él

                Rectangle fj = (Rectangle) l.get(j);
                if (fi.compareToRange(fj) == 0) {//Si las figuras son iguales según el método compareToRange entonces
                                                //se printea que figuras son y sus respectivas áreas
                    System.out.print("Figuras iguales: "
                        + fi.getClass().getName() + " " +  i 
                        + " y " + fj.getClass().getName() + " " +  j
                        + "\n Areas: " + fi.area()
                        + ", " + fj.area() + "\n\n");
                }
            }
        }        
    }
}
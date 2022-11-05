package practica3;
import java.util.*;
/**
 * class Figure.
 * 
 * @author LTP 
 * @version 2020-21
 */

public abstract class Figure implements Comparable<Figure> {
    private double x;
    private double y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y;
    }
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
    public int compareTo(Figure f) //Necesario implementar el metodo compareTo ya que se ha implementado Comparable
    {
        return (int)(this.area() - f.area());//Sigue lo impuesto por Comparable sobre como ha de funcionar
    }
    public abstract double area(); //Método area de cada figura, se obliga a la implementación
    public abstract double perimeter();//Método perímetro de cada figura, se obliga a su implementación en las subclases
    
}
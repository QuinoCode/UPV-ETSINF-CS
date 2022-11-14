package practica1;
/**
 * class Figure.
 * 
 * @author LTP/Quino
 * @version 2022-23
 */

public abstract class Figure {
    private double x;
    private double y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y; // Devuelve true si la figura 'this' y la que se pasa como argumento están ubicadas en la misma posición.
    }
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
    public abstract double area(); //Método area de cada figura, se obliga a la implementación en las clases que hereden de esta
    public abstract double perimeter();//Método perímetro de cada figura, se obliga a su implementación en las subclases
}
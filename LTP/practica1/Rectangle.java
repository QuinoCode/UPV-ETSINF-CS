package practica1;
/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Figure
{
    private double base;
    private double height;
    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double x, double y, double b, double h)
    {
        super(x,y);
        base = b;
        height = h;
    }
    public String toString() {
        return "Rectangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
    public boolean equals(Object o)
    {
        if (!(o instanceof Rectangle)) return false;
        Rectangle r = (Rectangle) o;
        //Para poder sobreescribir el metodo son necesarias ambas líneas, la primera para asegurarnos de que 
        //el casting no proporcionará errores, puesto que si el objeto O no es un rectángulo entonces devolvemos false
        //la segunda es para convertir 'o' en un rectángulo y poder así emplear sus atributos y métodos.
        return super.equals(r) && this.base == r.base && this.height == r.height;
    }
    public double area() 
    {
        return base * height;
    }
     public double perimeter()
    {
        return 2 * (base + height);
    }
}

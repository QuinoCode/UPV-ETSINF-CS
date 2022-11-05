package practica3;
/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Rectangle
{
    private double side;
    /**
     * Constructor for objects of class Square
     */
    public Square(double x, double y, double s)
    {
        super(x,y,s,s); //Necesario dar valor a todos los atributos que se heredan de la superclase
        side = s;
    }
    public String toString() {
        return "Square:\n\t" +
            super.toString() +
            "\n\tSide: " + side + "\n";
    }
    public boolean equals(Object o)
    {
        if (!(o instanceof Square)) return false;
        Square r = (Square) o;
        //Para poder sobreescribir el metodo son necesarias ambas líneas, la primera para asegurarnos de que 
        //el casting no proporcionará errores, puesto que si el objeto O no es un rectángulo entonces devolvemos false
        //la segunda es para convertir 'o' en un rectángulo y poder así emplear sus atributos y métodos.
        return super.equals(r) && this.side == r.side;
    }
    public double area() 
    {
        return super.area();
    }
     public double perimeter()
    {
        return 4 * side;
    }
}

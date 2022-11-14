package practica3;
/**
 * class Triangle.
 * 
 * @author LTP
 * @version 2020-21
 */

public class Triangle extends Figure {
    private double base; 
    private double height;
    private double ladoIzq;
    private double ladoDer;

    public Triangle(double x, double y, double b, double h, double lIz, double lDr) {
        super(x, y);
        base = b;
        height = h;
        ladoIzq = lIz;
        ladoDer = lDr;
    }

    public String toString() {
        return "Triangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height + "\n";
    }
    public boolean equals(Object o)
    {
        if (!(o instanceof Triangle)) return false;
        Triangle t = (Triangle) o;
        //Para poder sobreescribir el metodo son necesarias ambas líneas, la primera para asegurarnos de que 
        //el casting no proporcionará errores, puesto que si el objeto O no es un triángulo entonces devolvemos false
        //la segunda es para convertir 'o' en un triángulo y poder así emplear sus atributos y métodos.
        return super.equals(t) && this.base == t.base && this.height == t.height;
        //Con el método de la superclase devuelve si la posición es la misma y luego comprueba que 
        // tanto base como altura son las mismas
    }
    public double area() 
    {
        return (base*height) / 2;
    }
     public double perimeter()
    {
        return ladoIzq + ladoDer + base;
    }
}
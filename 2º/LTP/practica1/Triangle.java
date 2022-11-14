package practica1;
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
        //Esto son más argumentos de los que pide inicialmente, es la solución al último ejercicio del boletín que nos pide implementar el método perímetro en todas las figuras 
        //nos encontramos que no podemos hacerlo en triángulo ya que no tenemos 2 de los 3 lados y nos pide una solución teórica, la más correcta es enriquecer la clase con nuevos argumentos 
        //para poder así calcular el perímetro acordemente, no hacía falta ponerlo pero lo he puesto por dejar constancia de la solución.
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
            "\n\tHeight: " + height;
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
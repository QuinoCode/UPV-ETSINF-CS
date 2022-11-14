package practica1;
/**
 * class Circle.
 * 
 * @author LTP/Quino
 * @version 2022-23
 */

public class Circle extends Figure {
    private double radius;

    public Circle(double x, double y, double r) {
        super(x, y);
        radius = r;
    }

    public String toString() {
        return "Circle:\n\t" +
            super.toString() +
            "\n\tRadius: " + radius;
    }
    public boolean equals (Object o) 
    {
        if (!(o instanceof Circle)) return false;
        Circle c = (Circle) o;
        //Para poder sobreescribir el metodo son necesarias ambas líneas, la primera para asegurarnos de que 
        //el casting no proporcionará errores, puesto que si el objeto 'O' no es un circulo entonces devolvemos false y no trabajamos sobre un falso círculo
        //la segunda es para convertir 'o' en un circulo y poder así emplear sus atributos y métodos.
        return super.equals(c) && this.radius == c.radius;//super.equals(c) usa el método de la superclase (de la que se hereda), que está explicado en ella. Lo que resta para comprobar
                                                          //que un círculo es igual a otro es comprobar el radio de ambos.
    }
    public double area() 
    {
        return Math.PI * radius * radius; //Fórmula del área de un círculo
    }
    public double perimeter()
    {
        return 2 * Math.PI * radius; //Fórmula del perímetro de un círculo
    }
}
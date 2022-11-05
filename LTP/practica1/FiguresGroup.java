package practica1;
/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresGroup {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { figuresList[numF++] = f; }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s; //Printea figuras mientras todavía haya en el array 'figuresList[]', las acompaña de un salto de línea con '\n' para facilitar la claridad.
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;//Comprueba que la figura pasada como argumento 'f' se encuentra en el array this.figuresList[], cada figura emplea su propio método 'equals' 
                    // por lo que no funcionará si no está debidamente sobrecargado.
    }

    private boolean included(FiguresGroup g) {
        for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false; //Si alguna figura del FiguresGroup pasado como argumento no se encuentra en en this.figuresList[] se devuelve false
        }
        return true; //Efectivamente el FiguresGroup pasado como argumento está incluido en this.figuresList[]
    }
    public boolean equals(Object o)
    {
        if(!(o instanceof FiguresGroup)) return false;
        FiguresGroup fG = (FiguresGroup) o;
        //Para poder sobreescribir el metodo son necesarias ambas líneas, la primera para asegurarnos de que 
        //el casting no proporcionará errores, puesto que si el objeto 'o' no es un FiguresGroup entonces
        //devolvemos falsela segunda es para convertir 'o' en un FiguresGroup y poder así emplear sus
        //atributos y métodos.
        return this.numF == fG.numF && included(fG);
        //Si no tienen el mismo tamaño es imposible que sean iguales, por lo que si this incluye a fG(todas las figuras de fG estan en this) y tienen el mismo tamaño, son iguales.
        //return included(fG) && fG.included(this);      Solución planteada por el pdf, no se me ocurrió en su momento xd, pero si, si ambos se incluyen es que son iguales,
                                                        //si uno es más grande que el otro ya no es incuido por él, por lo que efectivamente, lo son, esta me cuesta más de entender intuitivamente.
    }
    public double area()
    {
        double result = 0;
        for (int i = 0; i < (numF); i++) 
        {
            result = result + figuresList[i].area();
        }
        return result;
    }
    public Figure greatestFigure()
    {
        if (!(numF>0)) return null; //Si no hay figuras no se puede devolver ninguna
        double greatestArea = 0; //Para conocer cual es él área más grande y poder comparar contra ella
        int indexGA = 0; //Como se ha de devolver una figura este índice guarda la figura con área más grande
        for (int i = 0; i < numF; i++) 
        {
            if (figuresList[i].area() > greatestArea)
            {
                indexGA = i;    
                greatestArea = figuresList[i].area();
            }
        }
        return figuresList[indexGA];
    }
}
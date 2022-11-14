package practica3;
import java.util.*;
/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresGroup implements Printable {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { figuresList[numF++] = f; }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {
        for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false;
        }
        return true;
    }
    public boolean equals(Object o)
    {
        if(!(o instanceof FiguresGroup)) return false;
        FiguresGroup fG = (FiguresGroup) o;
        return this.numF == fG.numF && included(fG);
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
        if (!(numF>0)) return null; 
        double greatestArea = 0; 
        int indexGA = 0; 
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
    public List<Figure> orderedList()
    {
        List<Figure> list = new ArrayList<Figure>();
        if (numF > 0) list.add(figuresList[0]); //Se rellena la ArrayList con 1 elemento para poder pivotar con él
        for (int i = 1; i < numF; i++) //Recorre el array "figuresList"
        {
            int j = list.size() - 1;//Devuelve el puntero 'j' al final de la ArrayList 'list'
            while (j >= 0 && figuresList[i].compareTo(list.get(j)) < 0)//Mientras que j no apunte al primer elemento y la figura de figuresList[i] tenga menos área que
                                                                    //donde apunta el puntero j de la ArrayList 'list' se reduce en uno j 
                                                                    //(para que apunte a una posición anterior, pues queremos ordenar de menor area a mayor)
            {
                j--;
            }
            list.add(j+1, figuresList[i]);//Se añade la figura en la posición siguiente a 'j' que es donde apunta a una figura con area mayor que figuresList[i]
        }
        return list;//Devuelve la ArrayList ordenada en función del área de las figuras, de  menos a más
    }
    public void print(char c) 
    {
        for (int i = 0; i < numF; i++)
        {
            if(figuresList[i] instanceof Printable)//Si la figura que esté en la posición 'i' de figuresList implementa
                                                    // la interfaz Printable entonces significa que puede printerase
            {
                ((Printable)figuresList[i]).print(c); //por tanto la printeamos, aunque para ello necesitamos poder usar print
                                                        //y nos aseguramos de que podemos usarlo aplicando un cast a Printable
            }
        }
    }
}
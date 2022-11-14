package practica3;
/**
 * Write a description of interface ComparableRange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface ComparableRange<Figure> extends Comparable<Figure>
{
    int compareToRange(Figure f);//Método que deberán incorporar todas las figuras que implementen esta interfaz
}

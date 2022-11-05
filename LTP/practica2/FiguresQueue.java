package practica2;

import practica1.Figure;
import practica1.Circle;

import practica2.librerias.implementaciones.QueueAL;

/**
 * class FiguresQueue.
 * 
 * @author LTP/Quino
 * @version 2022-23
 */

public class FiguresQueue<T extends Figure> extends QueueAL<T> { 
     
    public double area()
    {
        double resultado = 0;
        
        
        while (!this.isEmpty()) 
        {
            resultado = resultado + this.dequeue().area();
            //No sé si este método borra todo lo de 'this', yo creo que sí xd pero bueno, ahi está el área la calcula
            //si a alguien se le ocurre otra cosa que me diga argo.
        }
        return resultado;
    }
}
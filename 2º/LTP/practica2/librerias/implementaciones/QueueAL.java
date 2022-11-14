package practica2.librerias.implementaciones;

import practica2.librerias.modelos.Queue;
import java.util.ArrayList;

/**
 * class QueueAL<T>
 * It is the implementation of a Queue<T> 
 * using a generic ArrayList.
 * Si no viene en el PDF recomiendo buscar la documentación del ArrayList para hacer esta práctica
 * @author LTP/Quino 
 * @version 2022-23
 * @param <T>
 */

public class QueueAL<T> implements Queue<T> {

    ArrayList<T> theArray;
    
    /** The object constructor */
    public QueueAL() {
        theArray = new ArrayList<T>();  
    } 

    /** It returns the content of the queue 
     *  according to the following format:
     *   <- item0 <- item1 <- item2 <- ... <- itemN 
     *  where N = size() - 1
     *  and each item is concatenated 
     *  according to the format defined in its type
     *  @return the content of the queue 
     */
    public String toString() {
        String s = "";
        for ( T e : theArray ) { 
            s += " <- " + e; 
        }
        /** An alternative loop */
        // for (int k = 0; k < size(); k++) {
        //     s += " <- " + theArray.get(k);
        // }
        return s;
    }
  
    // Implementation of the operations defined 
    // in the Queue<T> interface

    // Methods that change the queue' state
    /** Inserts the element at the end of the queue
     *  @param e element to be inserted 
     */  
    public void enqueue(T e) {
        // TO COMPLETE ...
        theArray.add(e);
    } 
  
    /** Queries and extracts the first element,
     *  only if the queue is not empty 
     *  @return the first element
     */
    public T dequeue() {
        // TO COMPLETE / CHANGE ...
        return theArray.remove(0); 
    } 
  
    // Methods that query the queue' state
    /** Queries the number of elements of the queue
     *  @return the number of elements
     */
    public int size() {
        // TO COMPLETE / CHANGE ...
        return theArray.size();
    } 
  
    /** Queries the first element, in order of insertion,
     *  only if the queue is not empty 
     *  @return the first element
     */
    public T first() {
        // TO COMPLETE / CHANGE ... 
        if (theArray.isEmpty()) return null;
        
        return theArray.get(0);
    } 
  
    /** Verifies if the queue is empty
     *  @return true iif the queue is empty
     */
    public boolean isEmpty() {
        // TO COMPLETE / CHANGE ... 
        return !(theArray.size() > 0); // Si el tamaño de theArray es mayor que 0 es que no esta vacío
    } 
}
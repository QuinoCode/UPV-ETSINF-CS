import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Terrain3 implements Terrain {
Viewer v;
ReentrantLock lock = new ReentrantLock();
Condition[][] terrainLocked;

public  Terrain3 (int t, int ants, int movs, String msg) {
    v=new Viewer(t,ants,movs,msg);
    terrainLocked = new Condition[t][t];
    
    for (int contadorFilas = 0; contadorFilas < t; contadorFilas++)
    {
        for (int contadorColumnas = 0; contadorColumnas < t; contadorColumnas++)
        {
            terrainLocked[contadorFilas][contadorColumnas] = lock.newCondition();
        }
    }
}
public void     hi      (int a) 
{
    lock.lock();
    try 
    {
        v.hi(a);    
    } finally {lock.unlock();}
}
public void     bye     (int a)
{
    lock.lock();
    try {
        Pos actualPosition = v.getPos(a);
        terrainLocked[actualPosition.x][actualPosition.y].signalAll();
        v.bye(a);    
    }finally {lock.unlock();}
}
public void move (int a) throws InterruptedException 
{
    lock.lock();
    try {
        Pos actualPosition = v.getPos(a);
        v.turn(a); Pos dest=v.dest(a); 
        while (v.occupied(dest)) 
        {
          if (!terrainLocked[dest.x][dest.y].await(300, TimeUnit.MILLISECONDS)) { v.chgDir(a); dest = v.dest(a);}// Hay que añadir la dirección extra
          
        }
        v.go(a); terrainLocked[actualPosition.x][actualPosition.y].signalAll();
    } finally {lock.unlock();}
}
}


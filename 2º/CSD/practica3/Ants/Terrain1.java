import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.ReentrantLock;

public class Terrain1 implements Terrain {
    Viewer v;
    ReentrantLock lock ;
    Condition general;

    public  Terrain1 (int t, int ants, int movs, String msg) {
        v=new Viewer(t,ants,movs,msg);
        lock =  new ReentrantLock();
         general = lock.newCondition();
    
    }

    public void hi (int a) 
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
        general.signalAll();
        v.bye(a);    
        }finally {lock.unlock();}
    }
    public void move (int a) throws InterruptedException 
    {
        lock.lock();
        try {
            v.turn(a); Pos dest=v.dest(a); 
            while (v.occupied(dest)) {general.await(); v.retry(a);}
            v.go(a); general.signalAll();
        } finally {lock.unlock();}
    }
}


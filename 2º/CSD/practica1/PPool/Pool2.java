// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor

    int maxKidsForInstructor;
    int noMoreKidsThanThisNumber = 0;
    int kidsSwimming = 0;
    int instructorsSwimming = 0;
    public void init(int ki, int cap)           
    {
        maxKidsForInstructor = ki;
    }

    public synchronized void kidSwims() throws InterruptedException
    {
        while (kidsSwimming == noMoreKidsThanThisNumber)  wait();
        kidsSwimming++;
        
        log.swimming();
    }
    
    public synchronized void kidRests()      
    {
        kidsSwimming--;
        notifyAll();
        log.resting(); 
    }

    public synchronized void instructorSwims()   
    {
        instructorsSwimming++;
        noMoreKidsThanThisNumber = maxKidsForInstructor * instructorsSwimming;
        notifyAll();
        log.swimming();
    }

    public synchronized void instructorRests() throws InterruptedException  
    {
        while(kidsSwimming > noMoreKidsThanThisNumber - maxKidsForInstructor) wait();
        instructorsSwimming--;
        noMoreKidsThanThisNumber = maxKidsForInstructor * instructorsSwimming;
        log.resting();
    }

}

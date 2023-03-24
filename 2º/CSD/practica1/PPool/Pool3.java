// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    int maxKidsForInstructor;
    int maxCapacity;
    int currentSwimmers = 0;
    int noMoreKidsThanThisNumber = 0;
    int kidsSwimming = 0;
    int instructorsSwimming = 0;
    public void init(int ki, int cap)           
    {
        maxKidsForInstructor = ki;
        maxCapacity = cap;
    }

    public synchronized void kidSwims() throws InterruptedException
    {
        while (kidsSwimming == noMoreKidsThanThisNumber || currentSwimmers == maxCapacity)  wait();
        kidsSwimming++;
        currentSwimmers++;
        
        log.swimming();
    }
    
    public synchronized void kidRests()      
    {
        kidsSwimming--;
        currentSwimmers--;
        notifyAll();
        log.resting(); 
    }

    public synchronized void instructorSwims() throws InterruptedException
    {
        while (currentSwimmers == maxCapacity) wait();
        instructorsSwimming++;
        currentSwimmers++;
        noMoreKidsThanThisNumber = maxKidsForInstructor * instructorsSwimming;
        notifyAll();
        log.swimming();
    }

    public synchronized void instructorRests() throws InterruptedException  
    {
        while(kidsSwimming > noMoreKidsThanThisNumber - maxKidsForInstructor) wait();
        instructorsSwimming--;
        currentSwimmers--;
        noMoreKidsThanThisNumber = maxKidsForInstructor * instructorsSwimming;
        log.resting();
    }

}

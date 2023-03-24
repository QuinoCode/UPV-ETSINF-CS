// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool { //kids cannot enter if there are instructors waiting to exit
    boolean instructorWaitingToRest = false;
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
        while (kidsSwimming == noMoreKidsThanThisNumber || currentSwimmers == maxCapacity ||
         instructorWaitingToRest)  wait();
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
        instructorWaitingToRest = true;
        while(kidsSwimming > noMoreKidsThanThisNumber - maxKidsForInstructor) wait();
        instructorsSwimming--;
        currentSwimmers--;
        noMoreKidsThanThisNumber = maxKidsForInstructor * instructorsSwimming;
        instructorWaitingToRest = false;
        log.resting();
    }

}

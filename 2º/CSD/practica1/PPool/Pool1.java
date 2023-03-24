// CSD feb 2015 Juansa Sendra
public class Pool1 extends Pool {   //no kids alone
    int kidsSwimming = 0;
    int instructorsSwimming = 0;
    public void init(int ki, int cap)           {}
    public synchronized void kidSwims() throws InterruptedException {
      while (instructorsSwimming == 0) 
      {
        log.waitingToSwim(); // Para visualizar la posición del nadador
        wait();
      }
      kidsSwimming++;
      
      log.swimming();
      }
    public synchronized void kidRests()
    {
      kidsSwimming--;
      if (kidsSwimming == 0) notifyAll();
      log.resting();
    }
    public synchronized void instructorSwims()   
    {
      instructorsSwimming++;
      if (instructorsSwimming >= 1) notifyAll();
      log.swimming();
    }
    public synchronized void instructorRests()  throws InterruptedException
    {
      while (!(kidsSwimming == 0))
      {
          log.waitingToRest();
          wait();
      }
      instructorsSwimming--;
      log.resting(); 
      }
}

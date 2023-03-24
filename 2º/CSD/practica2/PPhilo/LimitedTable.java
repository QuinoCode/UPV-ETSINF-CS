// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    private final int capacity = 4;
    private int currentDinners = 0;
    private boolean spaceAvailable = true;
    public LimitedTable(StateManager state) {super(state);}
    public synchronized void enter(int id) throws InterruptedException 
    {
        while (!spaceAvailable) { state.wenter(id); wait();}
        state.enter(id);
        currentDinners++;
        spaceAvailable = currentDinners < capacity;
    }
    public synchronized void exit(int id)  
    {
        state.exit(id);
        currentDinners--;
        spaceAvailable = true;

    }
}

import java.util.*;

public class Workshop<T> {
    private final Deque<T> storedCars = new ArrayDeque<>();
    private int maxCars;
    public Workshop(int maxCars){
        this.maxCars = maxCars;
    }

    boolean isLoadable(){ return getStoredCars().size() != getMaxCars(); }

    public void loadCar(T t){
        if(isLoadable()){
            getStoredCars().push(t);
            ((Vehicle) t).setIsDrivable(false);
        }
    }

    public void unloadCar(){
        T t = getStoredCars().pop();
        ((Vehicle) t).setIsDrivable(true);
    }


    Deque<T> getStoredCars(){
        return storedCars;
    }

    int getMaxCars(){
        return maxCars;
    }

}

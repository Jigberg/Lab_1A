import java.awt.*;
import java.util.*;

/**
 * @author Lukas, Emil, Martin.
 * A class for truck Scania
 */

public class Car_Transport extends Truck {
    private final int maxCars = 4;
    private final Deque<Vehicle> transportingCars = new ArrayDeque<>();

    public Car_Transport() {
        super(4, 100, Color.GRAY, "Scania");
    }

    /**
     * The ramp is up when 1
     */
    @Override
    void raiseRamp(int angle){
        if (getCurrentSpeed() == 0){
            setRampAngle(1);
            setIsDrivable(true);
        }else{
            System.out.println("Can't raise ramp while moving");
        }
    }

    /**
     * The ramp is down when 0
     */
    @Override
    void lowerRamp(int angle) {
        if (getCurrentSpeed() == 0) {
            setRampAngle(0);
            setIsDrivable(false);
        } else {
            System.out.println("Can't lower ramp while moving");
        }
    }

    /**
     * checks if the loading car is in range.
     * @param vehicle car that is being loaded.
     * @return true if in range.
     */
    boolean isRightPosition(Vehicle vehicle){
        switch (getDirection()) {
            case NORTH: if (vehicle.getyPos() < getyPos() && (getyPos()- vehicle.getyPos() < 3) && Math.abs(getxPos() - vehicle.getxPos()) < 0.001 ){ return true;}
            case EAST: if (vehicle.getxPos() < getxPos() && (getxPos()- vehicle.getxPos() < 3) && Math.abs(getyPos() - vehicle.getyPos()) < 0.001 ){ return true;}
            case SOUTH : if (vehicle.getyPos() > getyPos() && (getyPos()- vehicle.getyPos() < -3) && Math.abs(getxPos() - vehicle.getxPos()) > -0.001 ){ return true;}
            case WEST : if (vehicle.getxPos() > getxPos() && (getyPos()- vehicle.getyPos() < -3) && Math.abs(getyPos() - vehicle.getyPos()) < 0.001 ){ return true;}
            default :
            System.out.print("not right position");
            return false;
        }
    }

    /**
     * Checks if car can be loaded onto Car_Transport.
     * @param vehicle car that is being loaded.
     * @return true if car is loadable.
     */
    public boolean isLoadable(Vehicle vehicle){
        if (getDirection() != vehicle.getDirection()){ return false; }
        if (vehicle instanceof Truck){ return false; }
        if (getRampAngle() != 0){ return false; }
        if (getTransportingCars().size() == getMaxCars()){ return false; }
        if (vehicle.getCurrentSpeed() != 0 || getCurrentSpeed() != 0){ return false; }
        if (!isRightPosition(vehicle)){ return false; }
        return true;
    }

    /**
     * Loads car onto Car_Transport.
     * @param vehicle car that is being loaded.
     */
    public void loadCar(Vehicle vehicle){
        if (isLoadable(vehicle)) {
            getTransportingCars().push(vehicle);
            vehicle.setIsDrivable(false);
        } else {
            System.out.println("Can't load car");
        }
    }

    /**
     * Unloads car and assigns it the position and direction of the Car_Transport.
     */
    public void unloadCar(){
            Vehicle vehicle = getTransportingCars().pop();
        if (getCurrentSpeed() == 0 && getTransportingCars().size() != 0 && getRampAngle() == 0) {
            getTransportingCars().remove(vehicle);
            vehicle.setIsDrivable(true);
        } else {
            System.out.println("Can't unload car");
        }
    }

    /**
     * Moves the car depending on direction. Also moves cars on transport.
     */
    @Override
    public void move() {
        if(getIsDrivable()) {
            switch (getDirection()) {
                case NORTH -> setyPos(getyPos() + getCurrentSpeed());
                case EAST -> setxPos(getxPos() + getCurrentSpeed());
                case SOUTH -> setyPos(getyPos() - getCurrentSpeed());
                case WEST -> setxPos(getxPos() - getCurrentSpeed());
                default -> System.out.print("non valid direction!");
            }
        }
        for(Vehicle vehicle : getTransportingCars()){
            vehicle.setxPos(getxPos());
            vehicle.setyPos(getyPos());
        }
    }

//    void getIsDrivable(){

//    }

    /**
     * Turns the car left. Also moves cars in transport.
     */
    @Override
    public void turnLeft() {
        Collections.rotate(getDirectionList(), 1);
        for(Vehicle vehicle : getTransportingCars()){
            vehicle.setDirection(getDirection());
        }
    }

    /**
     * Turns the car right. Also moves cars in transport.
     */
    @Override
    public void turnRight() {
        Collections.rotate(getDirectionList(), -1);
        for(Vehicle vehicle : getTransportingCars()){
            vehicle.setDirection(getDirection());
        }
    }

    int getMaxCars() {
        return maxCars;
    }

   Deque<Vehicle> getTransportingCars(){
        return transportingCars;
    }



}

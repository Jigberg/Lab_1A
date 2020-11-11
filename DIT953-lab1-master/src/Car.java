import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public abstract class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private double xPos; // The car X position
    private double yPos; // The car Y position
    private final List<Direction> directionList = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    /**
     * Constructor for the class Car.
     * Stops the car.
     * @param nrDoors number of doors.
     * @param enginePower engine power of the car.
     * @param color color of the car.
     * @param modelName the cars model name.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Moves the car depending on direction.
     */
    public void move() {
        switch (getDirection()) {
            case NORTH -> setyPos(getyPos() + getCurrentSpeed());
            case EAST -> setxPos(getxPos() + getCurrentSpeed());
            case SOUTH -> setyPos(getyPos() - getCurrentSpeed());
            case WEST -> setxPos(getxPos() - getCurrentSpeed());
            default -> System.out.print("non valid direction!");
        }
    }

    /**
     * Turns the car left.
     */
    public void turnLeft() {
        Collections.rotate(getDirectionList(), 1);
    }

    /**
     * Turns the car right.
     */
    public void turnRight() {
        Collections.rotate(getDirectionList(), -1);
    }

    /**
     * Stops the car engine.
     */
    void stopEngine() {
        setCurrentSpeed(0);
    }

    /**
     * Starts the car engine.
     */
    void startEngine() {
        setCurrentSpeed(0.1);
    }

    /**
     *
     * @return a calculated speedFactor.
     */
    abstract  double speedFactor();

    /**
     * Increments the speed a specified amount.
     * @param amount to increment the speed.
     */
    abstract void incrementSpeed(double amount);

    /**
     * Decrements the speed a specified amount.
     * @param amount to decrement the speed.
     */
    abstract void decrementSpeed(double amount);

    /**
     * Increments the speed a specified amount.
     * @param amount to multiply the speedfactor with.
     */

    // TODO fix this method according to lab pm
    void gas(double amount) {
        if (amount >= 0 && amount <= 1.0){
            incrementSpeed(amount);
        }
        else{
            System.out.println("Not valid amount.");
        }
    }

    /**
     * Decrements the speed a specified amount.
     * @param amount to multiply the speedfactor with.
     */

    // TODO fix this method according to lab pm
    void brake(double amount) {
        if (amount >= 0 && amount <= 1.0){
            decrementSpeed(amount);
        }
        else{
            System.out.println("Not valid amount.");
        }
    }
    // ----------- getters and setters -----------

    int getNrDoors() { return nrDoors; }

    double getEnginePower() {
        return enginePower;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    Color getColor() {
        return color;
    }

    String getModelName() {
        return modelName;
    }

    /**
     * Decrements the speed a specified amount.
     * Checks if current speed is in interval [0, enginePower]
     * @param currentSpeed The speed that the car already has.
     */
    void setCurrentSpeed(double currentSpeed) {
        if(currentSpeed >= 0 && currentSpeed <= getEnginePower()){
            this.currentSpeed = currentSpeed;
        }
        else if(currentSpeed < 0){
            this.currentSpeed = 0;
        }
        else{
            this.currentSpeed = getEnginePower();
        }

    }

    List<Direction> getDirectionList() {
        return directionList;
    }

    Direction getDirection() {
        return getDirectionList().get(0); }

    public double getxPos() { return xPos; }

    public double getyPos() { return yPos; }

    public void setxPos(double xPos) { this.xPos = xPos; }

    public void setyPos(double yPos) { this.yPos = yPos; }

    void setColor(Color color) { setColor(color); }
}

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Volvo240
 */

public class Volvo240 extends Vehicle {
    private final static double trimFactor = 1.25;

    /**
     * Constructor for class.
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

     boolean isDrivable(){
        return true;
    }
    /**
     * Calculates the speedfactor.
     * Uses trimFactor.
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Increments the cars speed.
     * @param amount to multiply the speedfactor with.
     */
    @Override
    void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrements the cars speed.
     * @param amount to multiply the speedfactor with.
     */
    @Override
    void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }

}

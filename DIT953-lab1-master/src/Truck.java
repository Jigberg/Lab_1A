import java.awt.*;

public abstract class Truck extends Vehicle {
    private int rampAngle;

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.rampAngle = 0;
    }


    /**
     * Checks when the truck is able to move.
     * @return If the truck can move.
     */
    @Override
    public boolean getIsDrivable(){
        return getRampAngle() == 0;
    }

    /**
     * Calculates the speedfactor.
     * @return returns a speedFactor.
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Increments the speed.
     * @param amount to multiply the speedFactor with.
     */
    @Override
    void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + amount*speedFactor());
    }

    /**
     * Decrements the speed.
     * @param amount to multiply the speedFactor with.
     */
    @Override
    void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - amount*speedFactor());
    }

    /**
     * Moves the truck if platform has not been lowered or raised.
     */
    @Override
    public void move(){
        if(getIsDrivable()){
            super.move();
        }
        System.out.println("Can't move while platform is tilted");
    }

    /**
     * Raises platform.
     * @param angle to raise platform.
     */
    abstract void raiseRamp(int angle);

    /**
     * Lowers platform.
     * @param angle to lower platform.
     */
    abstract void lowerRamp(int angle);

    int getRampAngle(){
        return rampAngle;
    }

    void setRampAngle(int platformAngle) {
        this.rampAngle = platformAngle;
    }
}

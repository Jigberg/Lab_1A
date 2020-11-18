import java.awt.*;

/**
 * @author Lukas, Emil, Martin.
 * A class for truck Scania
 */

public class Scania extends Truck {

    public Scania() {
        super(4, 100, Color.GRAY, "Scania");
    }

    /**
     * Lowers platform.
     * @param angle to lower platform.
     */
    @Override
    void lowerRamp(int angle) {
        if (getCurrentSpeed() == 0) {
            setRampAngle(Math.max(getRampAngle() - angle, 0));
        } else {
            System.out.println("Can't lower ramp while moving");
        }
    }

    /**
     * Raises platform.
     * @param angle to raise platform.
     */
    @Override
    void raiseRamp(int angle){
        if (getCurrentSpeed() == 0){
            setRampAngle(Math.min(getRampAngle() + angle, 70));
        }else{
            System.out.println("Can't raise ramp while moving");
        }
    }
}


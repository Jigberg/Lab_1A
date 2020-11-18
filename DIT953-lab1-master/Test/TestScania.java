import org.junit.Test;


import static org.junit.Assert.*;

public class TestScania {

    /**
     * The car doesn't move while there is an angle.
     */
    @Test
    public void testMoveAngle(){
        Scania scania = new Scania();
        scania.startEngine();
        scania.setRampAngle(20);
        scania.move();
        assertEquals(scania.getyPos(), 0.0, 0.001);
    }

    /**
     * Moves the car, when the angle is 0.
     */
    @Test
    public void testMove(){
        Scania scania = new Scania();
        scania.startEngine();
        scania.setRampAngle(0);
        scania.move();
        assertEquals(scania.getyPos(), 0.1, 0.001);
    }

    /**
     * Don't raise the platform while moving.
     */
    @Test
    public void testMoveRaiseRamp(){
        Scania scania = new Scania();
        scania.startEngine();
        scania.move();
        scania.raiseRamp(20);
        assertEquals(scania.getRampAngle(), 0);
    }

    /**
     * Asserts angle can't be negative.
     */
    @Test
    public void testLowerRampBelowZero(){
        Scania scania = new Scania();
        scania.lowerRamp(20);
        assertEquals(scania.getRampAngle(), 0);
    }

    /**
     * Tests if the platform raises.
     */
    @Test
    public void testRaisePlatform(){
        Scania scania = new Scania();
        scania.raiseRamp(20);
        assertEquals(scania.getRampAngle(), 20);
    }


    /**
     * Don't lower the platform while moving.
     */
    @Test
    public void testLowerRamp(){
        Scania scania = new Scania();
        scania.setRampAngle(30);
        scania.lowerRamp(20);
        assertEquals(scania.getRampAngle(), 10);
    }

}

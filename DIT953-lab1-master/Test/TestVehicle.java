import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TestVehicle {

    @Test
    public void testMove(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.move();
        assertEquals(v.getyPos(), 0.1, 0.001);
    }

    @Test
    public void testTurnLeft() {
        Volvo240 v = new Volvo240();
        v.turnLeft();
        assertSame("Test",v.getDirection(), Direction.WEST);
    }

    @Test
    public void testTurnRight(){
        Volvo240 v = new Volvo240();
        v.turnRight();
        assertSame(v.getDirection(), Direction.EAST);
    }

    @Test
    public void testStopEngine(){
        Volvo240 v = new Volvo240();
        v.stopEngine();
        assertEquals(v.getCurrentSpeed(), 0, 0.001);
    }

    @Test
    public void testStartEngine(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        assertEquals(v.getCurrentSpeed(), 0.1, 0.001);
    }

    @Test
    public void testGas(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.gas(0.5);
        assertEquals(v.getCurrentSpeed(), 0.725, 0.001);
    }

    @Test
    public void testBrake(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.setCurrentSpeed(5.0);
        v.brake(0.5);
        assertEquals(v.getCurrentSpeed(), 4.375, 0.001);
    }

    @Test
    public void testSetCurrentSpeedMax(){
        Volvo240 v = new Volvo240();
        v.setCurrentSpeed(105);
        assertEquals(v.getCurrentSpeed(), 100, 0.001);
    }

    @Test
    public void testSetCurrentSpeedMin(){
        Volvo240 v = new Volvo240();
        v.setCurrentSpeed(-5);
        assertEquals(v.getCurrentSpeed(), 0, 0.001);
    }

    @Test
    public void testGasInterval(){
        Volvo240 v = new Volvo240();
        v.setCurrentSpeed(50.0);
        v.gas(-5);
        assertEquals(v.getCurrentSpeed(), 50.0, 0.001);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSaab95 {
    @Test
    public void testSetTurboOn (){
        Saab95 s = new Saab95();
        s.setTurboOn();
        assertEquals(s.speedFactor(), 1.625, 0.001);
    }

    @Test
    public void testSetTurboOff(){
        Saab95 s = new Saab95();
        s.setTurboOn();
        s.setTurboOff();
        assertEquals(s.speedFactor(), 1.25, 0.001);
    }

    @Test
    public void testSpeedFactor(){
        Saab95 s = new Saab95();
        assertEquals(s.speedFactor(), 1.25, 0.001);
    }

    @Test
    public void testIncrementSpeed(){
        Saab95 s = new Saab95();
        s.startEngine();
        s.incrementSpeed(0.2);
        assertEquals(s.getCurrentSpeed(), 0.35, 0.001);
    }

    @Test
    public void testDecrementSpeed(){
        Saab95 s = new Saab95();
        s.startEngine();
        s.setCurrentSpeed(50.0);
        s.decrementSpeed(2);
        assertEquals(s.getCurrentSpeed(), 47.5, 0.001);
    }

    @Test
    public void testGas(){
        Saab95 s = new Saab95();
        s.startEngine();
        s.gas(0.2);
        assertEquals(s.getCurrentSpeed(), 0.35, 0.001);

    }

    @Test
    public void testBrake(){
        Saab95 s = new Saab95();
        s.startEngine();
        s.brake(2);
        assertNotEquals(s.getCurrentSpeed(), -2.4, 0.001);
    }
}


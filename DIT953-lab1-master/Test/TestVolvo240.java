import org.junit.Test;
import static org.junit.Assert.*;

public class TestVolvo240 {

    @Test
    public void testSpeedFactor(){
        Volvo240 v = new Volvo240();
        assertEquals(v.speedFactor(), v.getEnginePower() * 0.01 * v.speedFactor(),0.001);
    }

    @Test
    public void testGas(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.gas(0.2);
        assertEquals(v.getCurrentSpeed(),0.35, 0.001);
    }

    @Test
    public void testBrake(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.brake(1);
        assertEquals(v.getCurrentSpeed(), 0, 0.001);
    }

}

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCar_Transport {
    /**
     * Tests if a car can be loaded while being in the right position.
     */
    @Test
    public void TestisLoadable(){
        Volvo240 volvo = new Volvo240();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        assertEquals(ct.isLoadable(volvo), true);
    }

    /**
     * Tests if a car can not be loaded while being in the right position but moving.
     */
    @Test
    public void TestisLoadable_Moving(){
        Volvo240 volvo = new Volvo240();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        volvo.setCurrentSpeed(1.0);
        assertEquals(ct.isLoadable(volvo), false);
    }

    /**
     * Tests if a car can not be loaded while NOT being in the right position.
     */
    @Test
    public void TestisLoadable_TooFarAway(){
        Volvo240 volvo = new Volvo240();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-4);
        assertEquals(ct.isLoadable(volvo), false);
    }

    /**
     * Tests if a car can not be loaded while being in the right position, but the ramp is up.
     */
    @Test
    public void TestisLoadable_RampUp() {
        Volvo240 volvo = new Volvo240();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        ct.setRampAngle(1);
        assertEquals(ct.isLoadable(volvo), false);
    }

    /**
     * Tests if a car can not be loaded while being in the right position, but there is already the max amount of cars.
     */
    @Test
    public void TestisLoadable_MaxAmountCars() {
        Volvo240 volvo = new Volvo240();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        ct.getTransportingCars().add(volvo);
        ct.getTransportingCars().add(volvo);
        ct.getTransportingCars().add(volvo);
        ct.getTransportingCars().add(volvo);
        assertEquals(ct.isLoadable(volvo), false);
    }

    /**
     * Tests if a CAR TRANSPORT can not be loaded while being in the right position.
     */
    @Test
    public void TestisLoadable_CarTransport() {
        Car_Transport ct = new Car_Transport();
        Car_Transport ct1 = new Car_Transport();
        ct1.setxPos(0);
        ct1.setyPos(-1);
        assertEquals(ct.isLoadable(ct1), false);
    }

    /**
     * Tests if a CAR TRANSPORT can not be loaded while being in the right position.
     */
    @Test
    public void TestisLoadable_Scania() {
        Car_Transport ct = new Car_Transport();
        Scania s = new Scania();
        s.setxPos(0);
        s.setyPos(-1);
        assertEquals(ct.isLoadable(s), false);
    }

    /**
     * Tests if a car can not moved while ramp is down.
     */
    @Test
    public void TestMoveRampDown() {
        Car_Transport ct = new Car_Transport();
        ct.setRampAngle(0);
        ct.move();
        assertEquals(ct.getyPos(), 0, 0.0001);
    }

    @Test
    public void TestLoadCar(){
        Car_Transport ct = new Car_Transport();
        Volvo240 volvo = new Volvo240();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        ct.loadCar(volvo);
        assertEquals(ct.getTransportingCars().size(), 1);
    }

    @Test
    public void TestUnloadCar() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        saab.setxPos(0);
        saab.setyPos(-1);
        ct.loadCar(volvo);
        ct.loadCar(saab);
        ct.turnLeft();
        ct.unloadCar();
        assertEquals(saab.getDirection(), ct.getDirection());
    }

    @Test
    public void TestMoveCarInTransport() {
        Volvo240 volvo = new Volvo240();
        Car_Transport ct = new Car_Transport();
        volvo.setxPos(0);
        volvo.setyPos(-1);
        ct.loadCar(volvo);
        ct.move();
        assertEquals(volvo.getyPos(), ct.getyPos(), 0.001);
    }

}

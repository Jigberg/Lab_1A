import org.junit.Test;

import static org.junit.Assert.*;

public class TestWorkshop {
    /**
     * Tests if a volvo workshop accepts loading a volvo.
     */
    @Test
    public void TestWorkshopVolvo240Load(){
        Workshop<Volvo240> wV = new Workshop<>(3);
        Volvo240 v = new Volvo240();
        wV.loadCar(v);
        assertEquals(wV.getStoredCars().pop(), v);
    }

    /**
     * Tests if a volvo workshop doesn't accept loading a saab.
     * Line is commented to avoid compile time error.
     */
    @Test
    public void TestWorkshopVolvo240LoadWrongType(){
        Workshop<Volvo240> wV = new Workshop<>(3);
        Saab95 s = new Saab95();
        //wV.loadCar(s);
        assertEquals(wV.getStoredCars().size(), 0);
    }

    /**
     * Tests if car on transport becomes undrivable when on car transport.
     */
    @Test
    public void TestWorkshopVolvo240Unload(){
        Workshop<Volvo240> wV = new Workshop<>(3);
        Volvo240 v = new Volvo240();
        Volvo240 v1 = new Volvo240();
        wV.loadCar(v);
        wV.loadCar(v1);
        assertEquals(v1.getIsDrivable(), false);
    }

    /**
     * Tests if car becomes drivable when unloaded from car transport.
     */
    @Test
    public void TestWorkshopVolvo240Unload1(){
        Workshop<Volvo240> wV = new Workshop<>(3);
        Volvo240 v = new Volvo240();
        Volvo240 v1 = new Volvo240();
        wV.loadCar(v);
        wV.loadCar(v1);
        wV.unloadCar();
        assertEquals(v1.getIsDrivable(), true);
    }

    /**
     * Tests to load more cars than capacity
     */
    @Test
    public void TestWorkshopFull(){
        Workshop<Saab95> wS = new Workshop<>(2);
        Saab95 s = new Saab95();
        Saab95 s1 = new Saab95();
        Saab95 s2 = new Saab95();
        wS.loadCar(s);
        wS.loadCar(s1);
        wS.loadCar(s2);
        assertEquals(wS.getStoredCars().size(), 2);

    }

    /**
     * Tests to load different types of vehicles when using a general workshop
     */
    @Test
    public void TestWorkshopGeneral(){
        Workshop<Vehicle> wC = new Workshop<>(3);
        Saab95 s = new Saab95();
        Volvo240 v = new Volvo240();
        Scania scania = new Scania();
        wC.loadCar(s);
        wC.loadCar(v);
        wC.loadCar(scania);
        assertEquals(wC.getStoredCars().size(), 3);

    }
}

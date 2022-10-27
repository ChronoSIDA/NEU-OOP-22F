import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.input.GestureEvent;

import static org.junit.Assert.*;

public class GearTest {

    private Gear gear1;
    private Gear gear2;
    private Gear gear3;
    private Gear gear4;
    private Gear gear5;

    @Before
    public void setUp() throws Exception {
        gear1 = new HeadGear("Abyssal", "Mask",35);
        gear2 = new HandGear("Infinity", "Edge",70);
        gear3 = new HandGear("Black", "Cleaver",40);
        gear4 = new Footwear("Plated", "Steelcaps",10,60);
        gear5 = new Footwear("Berserker", "Greaves",40,20);
    }
    @Test(expected=IllegalArgumentException.class)
    public void inValidAttackOrDefenseConstruct(){
        gear1 = new HeadGear("Abyssal", "Mask",-123);
        gear2 = new HandGear("Abyssal", "Mask",-100);
        gear4 = new Footwear("Plated", "Steelcaps",-10,-20);
        gear5 = new Footwear("Plated", "Steelcaps",10,-20);
    }



    @Test(expected=IllegalArgumentException.class)
    public void inValidStringConstruct(){
        gear1 = new HeadGear("Abyssal adc", "Mask",-123);
        gear2 = new HandGear("Abyssal", "Mask efdas",-100);
    }
    @Test(expected=IllegalArgumentException.class)
    public void inValidCombineConstruct(){
        gear1.combine(gear2);
        gear2.combine(gear4);
        gear3.combine(gear1);
        gear4.combine(gear3);
        gear5.combine(gear1);
    }

    @Test
    public void getType() {
        Assert.assertEquals(GEAR_TYPE.HEAD_GEAR, gear1.getType());
        Assert.assertEquals(GEAR_TYPE.HAND_GEAR, gear2.getType());
        Assert.assertEquals(GEAR_TYPE.HAND_GEAR, gear3.getType());
        Assert.assertEquals(GEAR_TYPE.FOOTWEAR, gear4.getType());
        Assert.assertEquals(GEAR_TYPE.FOOTWEAR, gear5.getType());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Abyssal, Mask", gear1.getName());
        Assert.assertEquals("Infinity, Edge", gear2.getName());
        Assert.assertEquals("Black, Cleaver", gear3.getName());
        Assert.assertEquals("Plated, Steelcaps", gear4.getName());
        Assert.assertEquals("Berserker, Greaves", gear5.getName());
    }

    @Test
    public void getAdjective() {
        Assert.assertEquals("Abyssal", gear1.getAdjective());
        Assert.assertEquals("Infinity", gear2.getAdjective());
        Assert.assertEquals("Black", gear3.getAdjective());
        Assert.assertEquals("Plated", gear4.getAdjective());
        Assert.assertEquals("Berserker", gear5.getAdjective());
    }

    @Test
    public void getNoun() {
        Assert.assertEquals("Mask", gear1.getNoun());
        Assert.assertEquals("Edge", gear2.getNoun());
        Assert.assertEquals("Cleaver", gear3.getNoun());
        Assert.assertEquals("Steelcaps", gear4.getNoun());
        Assert.assertEquals("Greaves", gear5.getNoun());
    }

    @Test
    public void combine() {
        Gear newGear1 = gear2.combine(gear3);
        Assert.assertEquals("Black, Infinity Edge", newGear1.getName());
        Assert.assertEquals(110, newGear1.getAttackStrength());
        Assert.assertEquals(0, newGear1.getDefenseStrength());
        Gear newGear2 = gear4.combine(gear5);
        Assert.assertEquals("Berserker, Plated Steelcaps", newGear2.getName());
        Assert.assertEquals(50, newGear2.getAttackStrength());
        Assert.assertEquals(80, newGear2.getDefenseStrength());
    }

    @Test
    public void getAttackStrength() {
        Assert.assertEquals(0, gear1.getAttackStrength());
        Assert.assertEquals(70, gear2.getAttackStrength());
        Assert.assertEquals(40, gear3.getAttackStrength());
        Assert.assertEquals(10, gear4.getAttackStrength());
        Assert.assertEquals(40, gear5.getAttackStrength());
    }

    @Test
    public void getDefenseStrength() {
        Assert.assertEquals(35, gear1.getDefenseStrength());
        Assert.assertEquals(0, gear2.getDefenseStrength());
        Assert.assertEquals(0, gear3.getDefenseStrength());
        Assert.assertEquals(60, gear4.getDefenseStrength());
        Assert.assertEquals(20, gear5.getDefenseStrength());
    }
}
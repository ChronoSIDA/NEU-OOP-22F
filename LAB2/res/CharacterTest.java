import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
    private Character chara1;
    private Character chara2;
    private Character chara3;

    private HeadGear headGear;

    private HandGear handGear;

    private HandGear handGear;
    private Footwear footGear;
    private Footwear footGear;


    @Test(expected=IllegalArgumentException.class)
    public void inValidAttackOrDefenseConstruct(){
        chara1 = new CharacterImpl(-1, 10, "chara1");
        chara2 = new CharacterImpl(9, -2, "chara2");
        chara3 = new CharacterImpl(-3, -4, "chara3");
    }

    @Before
    public void setUp() throws Exception {
        ch1 = new CharacterImpl(10, 5,"ch1");
        ch2 = new CharacterImpl(19, 10,"ch2");
        ch3 = new CharacterImpl(10, 5,"ch3");
        gear1 = new HeadGear("Abyssal", "Mask",35);
        gear2 = new HandGear("Infinity", "Edge",70);
        gear3 = new HandGear("Black", "Cleaver",40);
        gear4 = new Footwear("Plated", "Cleaver",10,60);
        gear5 = new Footwear("Berserker", "Greaves",10,20);
        ch1.setGear(gear1);
        ch1.setGear(gear2);
        ch1.setGear(gear3);
        ch1.setGear(gear4);
        ch1.setGear(gear5);
        ch2.setGear(gear1);
        ch2.setGear(gear2);
        ch2.setGear(gear3);
        ch2.setGear(gear4);
        ch2.setGear(gear5);
        ch3.setGear(gear1);
        ch3.setGear(gear2);
        ch3.setGear(gear3);
        ch3.setGear(gear4);
        ch3.setGear(gear5);

    }

    @Test
    public void setGear() {

        assertEquals("[Type: HEAD_GEAR name='Abyssal, Mask', attackStrength=0, defenseStrength=35]",ch1.getHeadGearList().toString());
        assertEquals("[Type: FOOTWEAR name='Plated, Cleaver', attackStrength=10, defenseStrength=60, Type: FOOTWEAR name='Berserker, Greaves', attackStrength=10, defenseStrength=20]",ch1.getFootWearList().toString());
        assertEquals("[Type: HAND_GEAR name='Infinity, Edge', attackStrength=70, defenseStrength=0, Type: HAND_GEAR name='Black, Cleaver', attackStrength=40, defenseStrength=0]",ch1.getHandGearList().toString());
        assertEquals("[Type: HEAD_GEAR name='Abyssal, Mask', attackStrength=0, defenseStrength=35]",ch2.getHeadGearList().toString());
        assertEquals("[Type: FOOTWEAR name='Plated, Cleaver', attackStrength=10, defenseStrength=60, Type: FOOTWEAR name='Berserker, Greaves', attackStrength=10, defenseStrength=20]",ch2.getFootWearList().toString());
        assertEquals("[Type: HAND_GEAR name='Infinity, Edge', attackStrength=70, defenseStrength=0, Type: HAND_GEAR name='Black, Cleaver', attackStrength=40, defenseStrength=0]",ch2.getHandGearList().toString());
        assertEquals("[Type: HEAD_GEAR name='Abyssal, Mask', attackStrength=0, defenseStrength=35]",ch3.getHeadGearList().toString());
        assertEquals("[Type: FOOTWEAR name='Plated, Cleaver', attackStrength=10, defenseStrength=60, Type: FOOTWEAR name='Berserker, Greaves', attackStrength=10, defenseStrength=20]",ch3.getFootWearList().toString());
        assertEquals("[Type: HAND_GEAR name='Infinity, Edge', attackStrength=70, defenseStrength=0, Type: HAND_GEAR name='Black, Cleaver', attackStrength=40, defenseStrength=0]",ch3.getHandGearList().toString());
    }




    @Test
    public void getAttackPoint() {
        Assert.assertEquals(120,ch1.getDefensePoint());

        Assert.assertEquals(149, ch2.getAttackPoint());
        Assert.assertEquals(140, ch3.getAttackPoint());

    }

    @Test
    public void getDefensePoint() {
        Assert.assertEquals(120, ch1.getDefensePoint());
        Assert.assertEquals(125, ch2.getDefensePoint());
        Assert.assertEquals(120, ch3.getDefensePoint());

    }

    @Test
    public void getName() {
        Assert.assertEquals("ch1",ch1.getName());
        Assert.assertEquals("ch2",ch2.getName());
        Assert.assertEquals("ch3",ch3.getName());

    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, ch1.compareTo(ch2));
        Assert.assertEquals(1, ch2.compareTo(ch1));
        Assert.assertEquals(0, ch1.compareTo(ch3));
    }

    @Test
    public void assignNewGear() {

    }
}
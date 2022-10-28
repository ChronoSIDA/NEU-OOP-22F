import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class GearTest {

    private Gear headGear1;
    private Gear handGear1;
    private Gear handGear2;
    private Gear footWear1;
    private Gear footWear2;

    @Before
    public void setUp() throws Exception {
        headGear1 = new HeadGear("Burning Righteousness", "Helm", 34);
        handGear1 = new HandGear("Thunderfury","Sword", 72);
        handGear2 = new HandGear("Warglaive of Azzinoth", "Sword", 42);
        footWear1 = new FootWear("The Sentinel's Eternal Refuge Demon Hunter", "Boot", 8, 10);
        footWear2 = new FootWear("The Neverending Path", "Boot", 9, 9);
    }
    @Test
    public void invalidAttackOrDefenseGearTest(){
        System.out.println("Given gear with -34 defense: ");
        try {
            headGear1 = new HeadGear("Burning Righteousness", "Helm", -34);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
        System.out.println("Given gear with -9 attack: ");
        try {
            handGear1 = new HandGear("Thunderfury","Sword", -72);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        System.out.println("Given gear with -42 attack: ");
        try {
            handGear2 = new HandGear("Warglaive of Azzinoth", "Sword", -42);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        System.out.println("Given gear with -8 attack: ");
        try {
            footWear1 = new FootWear("The Sentinel's Eternal Refuge Demon Hunter", "Boot", -8, 10);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        System.out.println("Given gear with -9 attack: ");
        try {
            footWear2 = new FootWear("The Neverending Path", "Boot", -9, 9);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
        System.out.println("Passed all invalid attack or defense values for gear types");
    }



    @Test
    public void inValidStringConstruct(){
        System.out.println("Given gear with name of 'Sword, Boot, Hand': ");
        try {
            handGear1 = new HandGear("Thunderfury","Sword, Boot, Hand", -72);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
        System.out.println("Passed invalid gear name (noun).");
    }
    @Test
    public void inValidCombineConstruct(){
        System.out.println("Tried to combine head gear with a hand gear:");
        try {
            headGear1.combineGear(handGear1);
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
        System.out.println("Passed invalid gear combine type.");
    }

    @Test
    public void getName() {
        Assert.assertEquals("Thunderfury, Sword", handGear1.getGearName());
        System.out.println("Passed get gear noun.");
    }

    @Test
    public void getAdjective() {
        Assert.assertEquals("Burning Righteousness", headGear1.getGearAdjective());
        System.out.println("Passed get gear adjective.");
    }

    @Test
    public void getNoun() {
        Assert.assertEquals("Sword", handGear1.getGearNoun());
        System.out.println("Passed get gear Noun.");
    }

    @Test
    public void getCombineValues() {
        Gear newGear1 = handGear1.combineGear(handGear2);
        Assert.assertEquals("Thunderfury Warglaive of Azzinoth, Sword", newGear1.getGearName());
        Assert.assertEquals(114, newGear1.getGearAttackPoints());
        Assert.assertEquals(0, newGear1.getGearDefensePoints());
        Gear newGear2 = footWear1.combineGear(footWear2);
        Assert.assertEquals("The Sentinel's Eternal Refuge Demon Hunter The Neverending Path, Boot", newGear2.getGearName());
        Assert.assertEquals(17, newGear2.getGearAttackPoints());
        Assert.assertEquals(19, newGear2.getGearDefensePoints());

        System.out.println("Passed all combined gear values.");
    }

    @Test
    public void getAttackStrength() {
        Assert.assertEquals(0, headGear1.getGearAttackPoints());
        Assert.assertEquals(72, handGear1.getGearAttackPoints());
        Assert.assertEquals(42, handGear2.getGearAttackPoints());
        Assert.assertEquals(8, footWear1.getGearAttackPoints());
        Assert.assertEquals(9, footWear2.getGearAttackPoints());

        System.out.println("Passed five gears attack points.");
    }

    @Test
    public void getDefenseStrength() {
        Assert.assertEquals(34, headGear1.getGearDefensePoints());
        Assert.assertEquals(0, handGear1.getGearDefensePoints());
        Assert.assertEquals(0, handGear2.getGearDefensePoints());
        Assert.assertEquals(10, footWear1.getGearDefensePoints());
        Assert.assertEquals(9, footWear2.getGearDefensePoints());

        System.out.println("Passed five gears defense points.");
    }
}
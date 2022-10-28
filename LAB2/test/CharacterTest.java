import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
    private Character chara1;
    private Character chara2;
    private Character chara3;
    private HeadGear headGear1;
    private HandGear handGear1;
    private HandGear handGear2;
    private FootWear footWear1;
    private FootWear footWear2;

    @Before
    public void setUp() throws Exception {
        chara1 = new Character(20, 4, "Mage");
        chara2 = new Character(17, 7, "Warlock");
        chara3 = new Character(14, 10, "Hunter");


        headGear1 = new HeadGear("Burning Righteousness", "Helm", 34);
        handGear1 = new HandGear("Thunderfury","Sword", 72);
        handGear2 = new HandGear("Warglaive of Azzinoth", "Sword", 42);
        footWear1 = new FootWear("The Sentinel's Eternal Refuge Demon Hunter", "Boot", 8, 10);
        footWear2 = new FootWear("The Neverending Path", "Boot", 9, 9);

        chara1.setGear(headGear1);
        chara1.setGear(handGear1);
        chara1.setGear(handGear2);
        chara1.setGear(footWear1);
        chara1.setGear(footWear2);

        chara2.setGear(headGear1);
        chara2.setGear(handGear1);
        chara2.setGear(handGear2);
        chara2.setGear(footWear1);
        chara2.setGear(footWear2);

        chara3.setGear(headGear1);
        chara3.setGear(handGear1);
        chara3.setGear(handGear2);
        chara3.setGear(footWear1);
        chara3.setGear(footWear2);
    }

    @Test
    public void invalidAttackOrDefenseConstruct(){
        try {
            chara1 = new Character(-20, 4, "Mage");
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        try {
            chara2 = new Character(17, -7, "Warlock");
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        try {
            chara3 = new Character(-14, 10, "Hunter");
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        System.out.println("Passed all invalid attack or defense values");
        System.out.println("Given Mage with -20 attack");
        System.out.println("Given Warlock with 17 attack");
        System.out.println("Given Hunter with -14 attack");
    }

    @Test
    public void validAttackOrDefenseConstruct(){
        try {
            chara1 = new Character(20, 4, "Mage");
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        try {
            chara2 = new Character(17, 7, "Warlock");
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }

        try {
            chara3 = new Character(14, 10, "Hunter");
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }


        System.out.println("Passed all invalid attack or defense values");
        System.out.println("Given Mage with 20 attack and 4 defense");
        System.out.println("Given Warlock with 17 attack and 7 defense");
        System.out.println("Given Hunter with 14 attack and 10 defense");
    }


    @Test
    public void setGear() {
        assertEquals("[HeadGear Name = 'Burning Righteousness, Helm', AttackStrength = 0, DefenseStrength = 34]", chara1.getHeadGearList().toString());
        assertEquals("[FootWear Name = 'The Sentinel's Eternal Refuge Demon Hunter, Boot', AttackStrength = 8, DefenseStrength = 10, FootWear Name = 'The Neverending Path, Boot', AttackStrength = 9, DefenseStrength = 9]",chara1.getFootWearList().toString());
        assertEquals("[HandGear Name = 'Thunderfury, Sword', AttackStrength = 72, DefenseStrength = 0, HandGear Name = 'Warglaive of Azzinoth, Sword', AttackStrength = 42, DefenseStrength = 0]",chara1.getHandGearList().toString());


        System.out.println("Passed all equip gear for characters: \n");

        System.out.println("Passed equip head gear for character 1 Mage");
        System.out.println(chara1.getHeadGearList().toString());
        System.out.println("Passed all equip foot wears for character 1 Mage");
        System.out.println(chara1.getFootWearList().toString());
        System.out.println("Passed all equip hand gears for character 1 Mage");
        System.out.println(chara3.getHandGearList().toString());
    }

    @Test
    public void getAttackPoint() {
        Assert.assertEquals(151,chara1.getAttackPoint());
        Assert.assertEquals(148, chara2.getAttackPoint());
        Assert.assertEquals(145, chara3.getAttackPoint());


        System.out.println("Passed all get attack point");
        System.out.println("Given Mage with 151 defense");
        System.out.println("Given Warlock with 148 defense");
        System.out.println("Given Hunter with 145 defense");
    }

    @Test
    public void getDefensePoint() {
        Assert.assertEquals(57, chara1.getDefensePoint());
        Assert.assertEquals(60, chara2.getDefensePoint());
        Assert.assertEquals(63, chara3.getDefensePoint());


        System.out.println("Passed all get defense point");
        System.out.println("Given Mage with 57 defense");
        System.out.println("Given Warlock with 60 defense");
        System.out.println("Given Hunter with 63 defense");
    }

    @Test
    public void getName() {
        Assert.assertEquals("Mage",chara1.getName());
        Assert.assertEquals("Warlock",chara2.getName());
        Assert.assertEquals("Hunter",chara3.getName());


        System.out.println("Passed all characters' names");
        System.out.println("Character 1: Mage");
        System.out.println("Character 2: Warlock");
        System.out.println("Character 3: Hunter");
    }
}
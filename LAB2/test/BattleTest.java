import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleTest {

    private Battle battle1;
    private Battle battle2;
    private Battle battle3;

    private Battle battle4;

    private Character chara1;
    private Character chara2;
    private Character chara3;
    private Character chara4;


    private HeadGear headGear1;
    private HeadGear headGear2;

    private HandGear handGear1;
    private HandGear handGear2;
    private HandGear handGear3;
    private HandGear handGear4;

    private FootWear footWear1;
    private FootWear footWear2;
    private FootWear footWear3;
    private FootWear footWear4;

    @Before
    public void setUp() throws Exception {
        chara1 = new Character(10, 5, "chara1");
        chara2 = new Character(19, 10, "chara2");
        chara3 = new Character(10, 5, "chara3");
        chara4 = new Character(10, 5, "chara4");

        headGear1 = new HeadGear("Burning Righteousness", "Helm", 35);
        handGear1 = new HandGear("Thunderfury, Blessed Blade of the Windseeker", "Sword", 70);
        handGear2 = new HandGear("Warglaive of Azzinoth", "Sword", 40);
        footWear1 = new FootWear("The Sentinel's Eternal Refuge Demon Hunter", "Boot", 10, 60);
        footWear2 = new FootWear("The Neverending Path", "Boot", 10, 20);

        headGear2 = new HeadGear("The Horseman's Horrific", "Hood", 36);
        handGear3 = new HandGear("Shadowmourne", "Aex", 71);
        handGear4 = new HandGear("Thori'dal, the Stars' Fury", "Bow", 41);
        footWear3 = new FootWear("The Neverending Path", "Boot", 11, 61);
        footWear4 = new FootWear("Slippers of the Unruly Fairies", "Boot", 11, 21);

        battle1 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
        battle2 = new Battle(chara2, chara3, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear2, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
        battle3 = new Battle(chara3, chara4, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
        battle4 = new Battle(chara4, chara1, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inValidGearListSizeConstruct() {
        battle1 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(new Gear[]{headGear1, headGear2})));
        battle2 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3})));
        battle3 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
    }

    @Test
    public void start() {
        battle1.start();
        Assert.assertEquals(1, chara1.calculateDamage(chara2));
        Assert.assertEquals(143 ,chara1.getAttackPoint());
        Assert.assertEquals(150 ,chara2.getAttackPoint());
        Assert.assertEquals(162, chara1.getDefensePoint());
        Assert.assertEquals(86, chara2.getDefensePoint());

        battle2.start();
        Assert.assertEquals(-1, chara2.calculateDamage(chara3));
        Assert.assertEquals(276 ,chara2.getAttackPoint());
        Assert.assertEquals(281 ,chara3.getAttackPoint());
        Assert.assertEquals(319, chara2.getDefensePoint());
        Assert.assertEquals(162, chara3.getDefensePoint());


        battle3.start();
        Assert.assertEquals(0, chara3.calculateDamage(chara4));
        Assert.assertEquals(10 ,chara3.getAttackPoint());
        Assert.assertEquals(10 ,chara4.getAttackPoint());
        Assert.assertEquals(180, chara3.getDefensePoint());
        Assert.assertEquals(180, chara4.getDefensePoint());


        battle4.start();
        Assert.assertEquals(0, chara4.calculateDamage(chara1));
        Assert.assertEquals(10 ,chara4.getAttackPoint());
        Assert.assertEquals(10 ,chara1.getAttackPoint());
        Assert.assertEquals(180, chara4.getDefensePoint());
        Assert.assertEquals(180, chara1.getDefensePoint());
    }
}
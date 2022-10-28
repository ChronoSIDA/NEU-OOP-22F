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

    private Character testChar1;
    private Character testChar2;
    private Battle testBattle;

    @Before
    public void setUp() throws Exception {
        chara1 = new Character(20, 4, "Mage");
        chara2 = new Character(17, 7, "Warlock");
        chara3 = new Character(14, 10, "Hunter");
        chara4 = new Character(6, 19, "Paladin");

        headGear1 = new HeadGear("Burning Righteousness", "Helm", 34);
        handGear1 = new HandGear("Thunderfury","Sword", 72);
        handGear2 = new HandGear("Warglaive of Azzinoth", "Sword", 42);
        footWear1 = new FootWear("The Sentinel's Eternal Refuge Demon Hunter", "Boot", 8, 10);
        footWear2 = new FootWear("The Neverending Path", "Boot", 9, 9);



        headGear2 = new HeadGear("The Horseman's Horrific", "Hood", 36);
        handGear3 = new HandGear("Shadowmourne", "Aex", 58);
        handGear4 = new HandGear("Thori'dal", "Bow", 60);
        footWear3 = new FootWear("The Neverending Path", "Boot", 3, 15);
        footWear4 = new FootWear("Slippers of the Unruly Fairies", "Boot", 16, 4);

        battle1 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
                new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
        battle2 = new Battle(chara2, chara3, new ArrayList<>(Arrays.asList(
                new Gear[]{headGear2, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
        battle3 = new Battle(chara3, chara4, new ArrayList<>(Arrays.asList(
                new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
        battle4 = new Battle(chara4, chara1, new ArrayList<>(Arrays.asList(
                new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3, footWear4})));
    }

    @Test
    public void invalidGearListSizeConstruct() {
        System.out.println("Given only two gear slots: ");
        ArrayList list = new ArrayList<>(Arrays.asList(new Gear[]{headGear1, headGear2}));

        try {
            battle1 = new Battle(chara1, chara2, list);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        System.out.println("Given only eight gear slots:");
        try {
            battle2 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
                new Gear[]{headGear1, headGear2, handGear1, handGear2, handGear3, handGear4, footWear1, footWear2, footWear3})));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        System.out.println("Given only one gear slot:");
        try {
            battle3 = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
                new Gear[]{headGear1})));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void start() {
        System.out.println("==================================================");
        System.out.println("Battle started between the Mage and the Warlock: ");
        battle1.start();
        Assert.assertEquals(77, chara1.calculateDamage(chara2));
        Assert.assertEquals(174, chara1.getAttackPoint());
        Assert.assertEquals(131, chara2.getAttackPoint());
        Assert.assertEquals(54, chara1.getDefensePoint());
        Assert.assertEquals(65, chara2.getDefensePoint());


        System.out.println("\n");
        System.out.println("==================================================");
        System.out.println("Battle started between the Warlock and the Hunter: ");
        battle2.start();
        Assert.assertEquals(13, chara2.calculateDamage(chara3));
        Assert.assertEquals(285, chara2.getAttackPoint());
        Assert.assertEquals(128, chara3.getAttackPoint());
        Assert.assertEquals(115, chara2.getDefensePoint());
        Assert.assertEquals(70, chara3.getDefensePoint());


        System.out.println("\n");
        System.out.println("==================================================");
        System.out.println("Battle started between the Hunter and the Paladin: ");
        battle3.start();
        Assert.assertEquals(0, chara3.calculateDamage(chara4));
        Assert.assertEquals(282, chara3.getAttackPoint());
        Assert.assertEquals(120, chara4.getAttackPoint());
        Assert.assertEquals(120, chara3.getDefensePoint());
        Assert.assertEquals(77, chara4.getDefensePoint());



        System.out.println("\n");
        System.out.println("==================================================");
        System.out.println("Battle started between the Paladin and the Mage: ");
        battle4.start();
        Assert.assertEquals(161, chara4.calculateDamage(chara1));
        Assert.assertEquals(274, chara4.getAttackPoint());
        Assert.assertEquals(288, chara1.getAttackPoint());
        Assert.assertEquals(127, chara4.getDefensePoint());
        Assert.assertEquals(112, chara1.getDefensePoint());
    }

    @Test
    public void getCalculatedBasicDamage(){

        Assert.assertEquals(13, chara1.calculateDamage(chara2));
        Assert.assertEquals(7, chara2.calculateDamage(chara3));
        Assert.assertEquals(-4, chara3.calculateDamage(chara4));
        Assert.assertEquals(1, chara4.calculateDamage(chara1));

        System.out.println("Passed all basic damage calculating between two characters:");
        System.out.println("Character 1 to Character 2: 13");
        System.out.println("Character 2 to Character 3: 7");
        System.out.println("Character 3 to Character 4: -4");
        System.out.println("Character 4 to Character 1: 1");
    }

    @Test
    public void getAttackAndDefenseBasicPoints(){
        System.out.println("Passed all get attack and defense basic points for two characters:");
        System.out.println("Character 1 (20, 4) to Character 2 (17, 7) ");
        Assert.assertEquals(20, chara1.getAttackPoint());
        Assert.assertEquals(17, chara2.getAttackPoint());
        Assert.assertEquals(4, chara1.getDefensePoint());
        Assert.assertEquals(7, chara2.getDefensePoint());

        System.out.println("Character 2 (17, 7) to Character 3 (14, 10)");
        Assert.assertEquals(17, chara2.getAttackPoint());
        Assert.assertEquals(14, chara3.getAttackPoint());
        Assert.assertEquals(7, chara2.getDefensePoint());
        Assert.assertEquals(10, chara3.getDefensePoint());

        System.out.println("Character 3 (14, 10) to Character 4 (6, 19)");
        Assert.assertEquals(14, chara3.getAttackPoint());
        Assert.assertEquals(6, chara4.getAttackPoint());
        Assert.assertEquals(10, chara3.getDefensePoint());
        Assert.assertEquals(19, chara4.getDefensePoint());

        System.out.println("Character 4 (6, 19) to Character 1 (20, 4)");
        Assert.assertEquals(6, chara4.getAttackPoint());
        Assert.assertEquals(20, chara1.getAttackPoint());
        Assert.assertEquals(19, chara4.getDefensePoint());
        Assert.assertEquals(4, chara1.getDefensePoint());
    }
    @Test
    public void testGetGearList(){
        System.out.println("Test all the gear list of all the gears in the battle setup: ");
        for(Gear gear: battle1.getGearList()){
            System.out.println(gear);
        }
    }

    @Test
    public void tieBattleTest(){
        System.out.println("Battle started between the Mage and the Warlock: ");

        testChar1 = new Character(20, 20, "Mage");
        testChar2 = new Character(20, 20, "Warlock");

        testBattle = new Battle(chara1, chara2, new ArrayList<>(Arrays.asList(
            new Gear[]{headGear1, headGear1, handGear1, handGear1, handGear1, handGear1, footWear1, footWear1, footWear1, footWear1})));


        testBattle.start();
    }
}



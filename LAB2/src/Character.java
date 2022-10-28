import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Character implements CharacterInterface{

    private int attackPoint;
    private int defensePoint;
    private  String name = null;
    private  ArrayList<Gear> headGear = null;
    private static int HEAD_CAP = 1;
    private final static int HAND_CAP = 2;
    private final static int FOOT_CAP = 2;
    private  ArrayList<Gear> handGear = null;
    private  ArrayList<Gear> footGear = null;


    public Character(int attackPoint, int defensePoint, String name) {
        if (attackPoint < 0) throw new IllegalArgumentException("Attack point cannot be negative.");
        if (defensePoint < 0) throw new IllegalArgumentException("Defense point cannot be negative.");
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.name = name;

        headGear = new ArrayList<Gear>(HEAD_CAP);
        handGear = new ArrayList<Gear>(HAND_CAP);
        footGear = new ArrayList<Gear>(FOOT_CAP);
    }


    @Override
    public int calculateDamage(Character c) {
        return -(this.getDefensePoint() - c.getAttackPoint());
    }


    @Override
    public void setGear(Gear newGear) {
        if (newGear == null){
            return;
        }
        if (newGear instanceof HeadGear) {
            defensePoint += newGear.getGearDefensePoints();
            if (headGear.size() == Character.HEAD_CAP) {
                Gear tmp1 = this.headGear.get(Character.HEAD_CAP - 1);
                Gear tmp2 = tmp1.combineGear(newGear);
                headGear.set(Character.HEAD_CAP - 1, tmp2);
            } else {
                headGear.add(newGear);
            }
        } else if (newGear instanceof HandGear) {
            attackPoint += newGear.getGearAttackPoints();
            if (this.handGear.size() == Character.HAND_CAP) {

                handGear.set(Character.HAND_CAP - 1, this.handGear.get(Character.HAND_CAP - 1).combineGear(newGear));
            } else {
                handGear.add(newGear);
            }
        } else {
            attackPoint += newGear.getGearAttackPoints();
            defensePoint += newGear.getGearDefensePoints();
            if (this.footGear.size() == Character.FOOT_CAP) {

                footGear.set(Character.FOOT_CAP - 1, this.footGear.get(Character.FOOT_CAP - 1).combineGear(newGear));
            } else {
                footGear.add(newGear);
            }
        }
    }






    @Override
    public ArrayList<Gear> getHeadGearList() {
        return headGear;
    }

    @Override
    public ArrayList<Gear> getHandGearList() {
        return handGear;
    }

    @Override
    public ArrayList<Gear> getFootWearList() {
        return footGear;
    }

    @Override
    public int getAttackPoint() {
        return attackPoint;
    }

    @Override
    public int getDefensePoint() {
        return defensePoint;
    }

    @Override
    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                "AttackPoint = " + attackPoint +
                ", DefensePoint = " + defensePoint +
                ", HeadGear=" + headGear +
                ", HandGear=" + handGear +
                ", FootGear=" + footGear;
    }


}

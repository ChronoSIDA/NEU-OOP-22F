import java.util.ArrayList;

public interface CharacterInterface {


    //calculate the damage caused by the other character
    int calculateDamage(Character c);
    void setGear(Gear newGear);
    ArrayList<Gear> getHeadGearList();
    ArrayList<Gear> getHandGearList();
    ArrayList<Gear> getFootWearList();

    int getAttackPoint();
    int getDefensePoint();
    String getName();
//    void assignNewGear(ArrayList<Gear> gearList);

}

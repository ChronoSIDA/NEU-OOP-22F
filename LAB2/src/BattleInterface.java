import java.util.ArrayList;

public interface BattleInterface {
    void start();
    void assignGear(ArrayList<Gear> gearList, Character player);
    ArrayList<Gear> getGearList();



}

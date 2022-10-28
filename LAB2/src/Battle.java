import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Battle implements BattleInterface{
    private Character player1;
    private Character player2;
    private ArrayList<Gear> gearList;

    public Battle(Character ch1, Character ch2, ArrayList<Gear> gearList) {
        if (gearList.size() != 10) throw new IllegalArgumentException("The size of the Gear List should be fixed 10.");
        this.player1 = ch1;
        this.player2 = ch2;
        this.gearList = gearList;
        Collections.sort(gearList, new Comparator<Gear>() {
            @Override
            public int compare(Gear o1, Gear o2) {

                if(o1.getGearAttackPoints() > o2.getGearAttackPoints()){
                    return -1;
                }else if(o1.getGearAttackPoints() < o2.getGearAttackPoints()){
                    return 1;
                }else{
                    return -Integer.compare(o1.getGearDefensePoints(),o2.getGearDefensePoints());
                }


            }
        });
    }

    @Override
    public void assignGear(ArrayList<Gear> gearList, Character player){

        for (int i = 0; i < gearList.size(); i++) {
            Gear tmp = gearList.get(i);

            if (tmp instanceof HeadGear){
                if (player.getHeadGearList().size() < 1){
                    player.setGear(tmp);
                    gearList.remove(i);
                    return;
                }
            } else if (tmp instanceof FootWear) {
                if (player.getFootWearList().size() < 2){
                    player.setGear(tmp);
                    gearList.remove(i);
                    return;
                }
            }
            else{
                if( player.getHandGearList().size() < 2){
                    player.setGear(tmp);
                    gearList.remove(i);
                    return;
                }
            }
        }
        //If all slots on the character is full, nothing can be equipped after the loop, so we just add the fist element in the list.
        Gear gear = gearList.get(0);
        player.setGear(gear);
        gearList.remove(0);

    }

    @Override
    public ArrayList<Gear> getGearList() {
        return this.gearList;
    }

    @Override
    public void start() {
        while (gearList.size() != 0){
            assignGear(gearList, this.player1);
            assignGear(gearList, this.player2);
            System.out.println(player1);
            System.out.println(player2);

        }
        if(player1.calculateDamage(player2) < player2.calculateDamage(player1)){
            System.out.println(player1.getName() + " Wins the battle!");
        }else if (player1.calculateDamage(player2) > player2.calculateDamage(player1)){
            System.out.println(player2.getName() + " Wins the battle!");
        }else{
            System.out.println("\nThere is a tie between two characters.");
        }

    }
}

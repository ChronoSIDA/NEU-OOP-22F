import java.util.ArrayList;

public class BirdsOfPrey extends AbstractBirds {

    public BirdsOfPrey(String birdName, BIRDTYPE birdType, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird){
        super(birdName, birdType,  extinct, numWings, preferredFood, waterBird);
         characteristics = new ArrayList<>();
        characteristics.add("Sharp, Hooked Beak with Visible Nostrils.");

        if(birdType != BIRDTYPE.HAWKS && birdType != BIRDTYPE.EAGLES && birdType != BIRDTYPE.OSPREY){
            throw new IllegalArgumentException("Birds of prey include Hawks, Eagles, and Osprey");
        }
    }

    @Override
    public CLASSIFICATIONS getBirdsClass() {
        return CLASSIFICATIONS.BIRDS_OF_PREY;
    }

    @Override
    public String toString(){
        String desc;
        String extinct;
        if (isExtinct()){
            extinct = "Yes ";
        } else {
            extinct = "No ";
        }
        desc = "Bird Name:" + this.birdName + " Bird Type: " + this.birdType + "\n" +
                " Characteristics: " + this.characteristics + "\n" +///////////////////
                " Extinction: " + extinct + "Number of Wings: " + "\n" +
                " Preferred Food: " + this.preferredFood + "\n";

        return desc;
    }
}

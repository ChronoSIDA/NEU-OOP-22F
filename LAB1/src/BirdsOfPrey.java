import java.util.ArrayList;

public class BirdsOfPrey extends AbstractBirds {

    public BirdsOfPrey(String birdName, BIRDTYPE birdType, ArrayList<String> characteristics, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird, ArrayList<WATERBODY> waterBody){
        super(birdName, birdType, characteristics, extinct, numWings, preferredFood, waterBird, waterBody);
        ArrayList<String> chara = new ArrayList<>();
        chara.add("Sharp, Hooked Beak with Visible Nostrils.");

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
                " Characteristics: " + this.characteristics + "\n" +
                " Extinction: " + extinct + "Number of Wings: " + "\n" +
                " Preferred Food: " + this.preferredFood + "\n";

        return desc;
    }
}

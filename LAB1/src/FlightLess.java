import java.util.ArrayList;

public class FlightLess extends AbstractBirds {

    public FlightLess(String birdName, BIRDTYPE birdType, ArrayList<String> characteristics, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird, ArrayList<WATERBODY> waterBody) {
        super(birdName, birdType, characteristics, extinct, numWings, preferredFood, waterBird, waterBody);
        ArrayList<String> chara = new ArrayList<>();
        chara.add("Flightless Birds live on the ground and have no (or undeveloped) wings.");

        if(birdType != BIRDTYPE.EMUS && birdType != BIRDTYPE.KIWIS && birdType != BIRDTYPE.MOAS){
            throw new IllegalArgumentException("Flightless birds include emus, kiwis, and moas.");
        }
    }

    @Override
    public CLASSIFICATIONS getBirdsClass() {
        return CLASSIFICATIONS.FLIGHTLESS;
    }

    @Override
    public String toString() {
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





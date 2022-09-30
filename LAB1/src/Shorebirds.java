import java.util.ArrayList;

public class Shorebirds extends AbstractBirds{
    private boolean waterBird;
    private ArrayList<WATERBODY> waterBody;

    public Shorebirds(String birdName, BIRDTYPE birdType, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird) {
        super(birdName, birdType, extinct, numWings, preferredFood, waterBird);
        ArrayList<String> chara = new ArrayList<>();
        chara.add("Shorebirds live near water sources including wetlands, freshwater and saltwater shorelands, or ocean.");

        for(WATERBODY water: waterBody){
            if (water != WATERBODY.WETLANDS && water != WATERBODY.OCEAN &&
                    water != WATERBODY.FRESHWATER_SHORELANDS && water != WATERBODY.SALTWATER_SHORELANDS){
                throw new IllegalArgumentException("Shorebirds be in either wetlands, freshwater and saltwater shorelands, or ocean");
            }
        }

        if(birdType != BIRDTYPE.GREAT_AUK || birdType != BIRDTYPE.HORNED_PUFFIN || birdType != BIRDTYPE.AFRICAN_JACANA){
            throw new IllegalArgumentException("Shorebirds include Great Auk, Horned puffin, and African Jacana.");
        }
    }

    @Override
    public CLASSIFICATIONS getBirdsClass() {
        return CLASSIFICATIONS.SHOREBIRDS;
    }

    @Override
    public String toString() {
        String desc;
        String extinct, waterBird;
        if (isExtinct()){
            extinct = "Yes ";
        } else {
            extinct = "No ";
        }

        if(isWaterBird()){
            waterBird = "Yes";
        } else {
            waterBird = "No";
        }

        desc = "Bird Name:" + this.birdName + " Bird Type: " + this.birdType + "\n" +
                " Characteristics: " + this.characteristics + "\n" +
                " Extinction: " + extinct + " Water Bird: " + waterBird + "\n" +
                " Number of Wings: " + "\n" +
                " Preferred Food: " + this.preferredFood + "\n";

        return desc;
    }
}

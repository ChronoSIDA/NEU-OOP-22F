import java.util.ArrayList;

public class Pigeons extends AbstractBirds{

    public Pigeons(String birdName, BIRDTYPE birdType, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird) {
        super(birdName, birdType, extinct, numWings, preferredFood, waterBird);
        characteristics = new ArrayList<>();
        characteristics.add("Pigeons feeding their young 'bird milk' very similar to the milk of mammals ");

        if(birdType != BIRDTYPE.PIGEONS || birdType != BIRDTYPE.DOVES || birdType != BIRDTYPE.EXTINCT_PIGEONS){
            throw new IllegalArgumentException("The bird type has to either pigeons, doves, or extincted pigeons");
        }
    }

    @Override
    public CLASSIFICATIONS getBirdsClass() {
        return CLASSIFICATIONS.PIGEONS;
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

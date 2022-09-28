import java.util.ArrayList;

public class Owls extends AbstractBirds{

    public Owls(String birdName, BIRDTYPE birdType, ArrayList<String> characteristics, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird, ArrayList<WATERBODY> waterBody) {
        super(birdName, birdType, characteristics, extinct, numWings, preferredFood, waterBird, waterBody);
        ArrayList<String> chara = new ArrayList<>();
        chara.add("Owls are distinguished by the facial disks that frame the eyes and bill. ");

        if(birdType != BIRDTYPE.OWLS){
            throw new IllegalArgumentException("The bird type has to be Owls");
        }
    }

    @Override
    public CLASSIFICATIONS getBirdsClass() {
        return CLASSIFICATIONS.OWLS;
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
        desc = "Bird Name:" + super.getBirdName() + " Bird Type: " + getBirdType() + "\n" +
                " Characteristics: " + super.getCharacteristics() + "\n" +
                " Extinction: " + extinct + "Number of Wings: " + "\n" +
                " Preferred Food: " + getPreferredFood() + "\n";

        return desc;
    }
}

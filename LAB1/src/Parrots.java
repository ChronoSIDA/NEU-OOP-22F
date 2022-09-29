import java.util.ArrayList;
import java.util.List;

public class Parrots extends AbstractBirds{
    private int numOfWords;
    private String favoritePhrase;

    public Parrots(String birdName, BIRDTYPE birdType, int numOfWords, String favoritePhrase, ArrayList<String> characteristics, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird, ArrayList<WATERBODY> waterBody) {
        super(birdName, birdType, characteristics, extinct, numWings, preferredFood, waterBird, waterBody);
        ArrayList<String> chara = new ArrayList<>();
        chara.add("Short, curved beak and are known for their intelligence and ability to mimic sounds.");

        if ( 0 > numOfWords ||  numOfWords > 100) {
            throw new IllegalArgumentException("Pet parrots can learn a vocabulary  of up to 100 words. ");
        }
        this.numOfWords = numOfWords;
        this.favoritePhrase = favoritePhrase;
        if(birdType != BIRDTYPE.ROSE_RING_PARAKEET && birdType != BIRDTYPE.GRAY_PARROT && birdType != BIRDTYPE.SULFUR_CRESTED_COCKATOO){
            throw new IllegalArgumentException("Parrots include Rose-Ring Parakeet, Gray Parrot, and Sulfur-crested cockatoo.");
        }
    }

    public int getNumberOfWord(){
        return this.numOfWords;
    }

    public String getFavoritePhrase(){
        return this.favoritePhrase;
    }

    @Override
    public CLASSIFICATIONS getBirdsClass() {
        return CLASSIFICATIONS.PARROTS;
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
        desc = "Bird Name:" +  this.birdName + " Bird Type: " + this.birdType + "\n" +
                " Characteristics: " + this.characteristics + "\n" +
                " Extinction: " + extinct + "Number of Wings: " + "\n" +
                " Preferred Food: " + this.preferredFood + "\n" +
                " Number of Words: " + this.numOfWords + " Favorite Phrase: " + this.favoritePhrase + "\n";

        return desc;
    }
}

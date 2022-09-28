import java.util.ArrayList;

public abstract class AbstractBirds implements Birds{
    private String birdName;

    private BIRDTYPE birdType;

    private ArrayList<String> characteristics;

    private boolean extinct;

    private int numWings;

    private ArrayList<FEED> preferredFood;

    private ArrayList<WATERBODY> waterBody;

    public AbstractBirds(String birdName, BIRDTYPE birdType, ArrayList<String> characteristics, boolean extinct, int numWings, ArrayList<FEED> preferredFood, ArrayList<WATERBODY> waterBody){
        if (preferredFood.size() < 2 || preferredFood.size() > 4){
            throw new IllegalArgumentException("Birds' preferred food should in range of 2 to 4 items");
        }

        if (numWings < 0){
            throw new IllegalArgumentException("Number of wings cannot be smaller than 0.");
        } else if (numWings > 6) {
            throw new IllegalArgumentException("Birds don't have that many wings.");
        }

        this.birdName = birdName;
        this.birdType = birdType;
        this.characteristics = characteristics;
        this.extinct = extinct;
        this.numWings = numWings;
        this.preferredFood = preferredFood;

        if (waterBody == null){
            this.waterBody = null;
        } else {
            this.waterBody = waterBody;
        }
    }

    public String getBirdName() {
        return birdName;
    }

    public BIRDTYPE getBirdType() {
        return birdType;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public boolean isExtinct() {
        return extinct;
    }

    public int getNumWings() {
        return numWings;
    }

    public ArrayList<FEED> getPreferredFood() {
        return preferredFood;
    }

    public ArrayList<WATERBODY> getWaterBody() {
        return waterBody;
    }

    public abstract CLASSIFICATIONS getBirdsClass();
}

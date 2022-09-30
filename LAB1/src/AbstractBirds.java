import java.util.ArrayList;

public abstract class AbstractBirds implements Birds{
    protected String birdName;

    protected BIRDTYPE birdType;

    protected ArrayList<String> characteristics;

    protected boolean extinct;

    protected int numWings;

    protected ArrayList<FEED> preferredFood;

    protected boolean waterBird;
    protected CLASSIFICATIONS classifications = CLASSIFICATIONS.PIGEONS;

    public AbstractBirds(String birdName, BIRDTYPE birdType, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird){
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
        this.extinct = extinct;
        this.numWings = numWings;
        this.preferredFood = preferredFood;

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

    public abstract CLASSIFICATIONS getBirdsClass();

    public boolean isWaterBird(){return waterBird; }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public void setBirdType(BIRDTYPE birdType) {
        this.birdType = birdType;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    public void setExtinct(boolean extinct) {
        this.extinct = extinct;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    public void setPreferredFood(ArrayList<FEED> preferredFood) {
        this.preferredFood = preferredFood;
    }

    public void setWaterBird(boolean waterBird) {
        this.waterBird = waterBird;
    }
}

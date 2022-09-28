import java.util.ArrayList;

public class Waterfowl extends AbstractWaterBirds{
    public Waterfowl(String name, BIRDTYPE type, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food, ArrayList<WATER> bodyOfWater) {
        super(name, type, chara, extinct, wingNum, food, bodyOfWater);
        for(WATER water: bodyOfWater){
            if (water != WATER.FRESH && water != WATER.SALT){
                throw new IllegalArgumentException("The waterfowl's water source must be fresh or salt.");
            }
        }
        this.characteristic.add("live near water sources (fresh or salt)");
        if (type != BIRDTYPE.DUCKS && type != BIRDTYPE.SWANS && type != BIRDTYPE.GEESE) {
            throw new IllegalArgumentException("This type of bird is not waterfowls");

        }
    }


    @Override
    public CLASSIFICATION getBirdsCategory() {
        return CLASSIFICATION.WATERFOWL;
    }

    @Override
    public String toString() {
        return "Name: " + super.name + " Classification: " +
                this.getBirdsCategory() + " Type: " + super.getType() + "\n" + " Extinction Status: " +
                super.extinct + " Number of Wings: " + super.wingNumber + "\n" +
                " Characteristics: " + super.characteristic + "\n" +
                " Food it eats: " + super.getPreferFood() + "\n" +
                " Water source it lives near by: " + this.getWaterLiveBy();
    }
}

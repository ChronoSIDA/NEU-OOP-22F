import java.util.ArrayList;

public class ShoreBirds extends AbstractWaterBirds{
    public ShoreBirds(String name,BIRDTYPE type, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food, ArrayList<WATER> bodyOfWater) {
        super(name, type, chara, extinct, wingNum, food, bodyOfWater);

        for(WATER water: bodyOfWater){
            if (water != WATER.FRESHWATER_SHORELANDS && water != WATER.OCEAN &&
                    water != WATER.SALTWATER_SHORELANDS && water != WATER.WETLANDS){
                throw new IllegalArgumentException("The ShoreBirds' water sources " +
                        "must be FRESHWATER_SHORELANDS or SALTWATER_SHORELANDS or WETLANDS or OCEAN");
            }
        }
        if (type != BIRDTYPE.GREATAUK && type != BIRDTYPE.CRESTEDAUKLET && type != BIRDTYPE.HORNEDPUFFIN && type != BIRDTYPE.AFRICANJACANA) {
            throw new IllegalArgumentException("This type of bird is not Shore birds");

        }
        super.characteristic.add("live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean");
    }

    @Override
    public CLASSIFICATION getBirdsCategory() {
        return CLASSIFICATION.SHOREBIRDS;
    }



    @Override
    public String toString() {
        return  "Name: " + super.name + " Classification: " +
                this.getBirdsCategory() + " Type: " + super.getType() + "\n" + " Extinction Status: " +
                super.extinct + " Number of Wings: " + super.wingNumber + "\n" +
                " Characteristics: " + super.characteristic + "\n" +
                " Food it eats: " + super.getPreferFood() + "\n" +
                " Water source it lives near by: " + this.getWaterLiveBy();
    }
}

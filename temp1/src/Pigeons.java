import java.util.ArrayList;

public class Pigeons extends AbstractBirds{

    public Pigeons(String name, BIRDTYPE type, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food) {
        super(name, type, chara, extinct, wingNum, food);
        this.characteristic.add("feeding their young bird milk");
        if (type != BIRDTYPE.PASSENGERPIGEON && type != BIRDTYPE.PIGEON ) {
            throw new IllegalArgumentException("This type of bird is not BirdsOfPrey");
        }
    }

    @Override
    public CLASSIFICATION getBirdsCategory() {
        return CLASSIFICATION.PIGEONS;
    }

    @Override
    public String toString() {
        return "Name: " + super.name + " Classification: " +
                this.getBirdsCategory() + " Type: " + super.getType() + "\n" + " Extinction Status: " +
                super.extinct + " Number of Wings: " + super.wingNumber + "\n" +
                " Characteristics: " + super.characteristic + "\n" +
                " Food it eats: " + super.getPreferFood();
    }
}

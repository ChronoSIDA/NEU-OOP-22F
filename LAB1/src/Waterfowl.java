import java.util.ArrayList;

public class Waterfowl extends AbstractBirds{
  private boolean waterBird;
  private ArrayList<WATERBODY> waterBody;

  public Waterfowl(String birdName, BIRDTYPE birdType, ArrayList<String> characteristics, boolean extinct, int numWings, ArrayList<FEED> preferredFood, boolean waterBird) {
    super(birdName, birdType, characteristics, extinct, numWings, preferredFood, waterBird);
    ArrayList<String> chara = new ArrayList<>();
    chara.add("Waterfowls live near water sources.");

    for(WATERBODY water: waterBody){
      if (water != WATERBODY.FRESH && water != WATERBODY.SALT){
        throw new IllegalArgumentException("Waterfowls be in either fresh or salt water sources");
      }
    }

    if(birdType != BIRDTYPE.DUCKS || birdType != BIRDTYPE.SWANS || birdType != BIRDTYPE.GEESE){
      throw new IllegalArgumentException("Waterfowls include ducks, swans, and geese.");
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

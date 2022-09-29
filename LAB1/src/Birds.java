import java.util.ArrayList;

public interface Birds {
    // Get the type of the bird
    BIRDTYPE getBirdType();
    String getBirdName();
    // Get defining characteristic
    ArrayList<String> getCharacteristics();
    // Get defining extinct
    boolean isExtinct();
    // Get the number of wings
    int getNumWings();
    // 2-4 items bird prefer to eat
    ArrayList<FEED> getPreferredFood();
    CLASSIFICATIONS getBirdsClass();
    boolean isWaterBird();
}

import java.util.HashMap;

public class Conservatories implements Conservatory{
  //map location to corresponding aviaries
  private HashMap<Location, Aviary> Location_Aviary;

  //map the food to its quantity
  private HashMap<FEED, Integer> Food_Quantity;
  public Conservatories(){
    for (FEED food: FEED.values()){
      Food_Quantity.put(food, 0);//initialize the Food quentity
    }
    Location_Aviary = new HashMap<>();
    Food_Quantity = new HashMap<>();
  }

  @Override
  public void addBird(Birds birds) {

  }

  @Override
  public void calculateFood() {

  }

  @Override
  public Location getAviary(Birds birds) {
    return null;
  }

  @Override
  public void printSign(Aviary aviary) {

  }

  @Override
  public void printMap() {

  }

  @Override
  public void printIndex() {

  }
}

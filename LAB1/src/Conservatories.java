import java.util.ArrayList;
import java.util.HashMap;

public class Conservatories implements Conservatory{
  //map location to corresponding aviaries
  //private HashMap<Location, Aviary> Location_Aviary;

  //map the food to its quantity
  private HashMap<FEED, Integer> Food_Quantity;


  //Store the list of aviaries in the conservatory
  private ArrayList<Aviary> aviaryArrayList;

  //Store the info of Bird to its aviaries
  private HashMap<Birds, Aviary> Bird_Aviary;


  public Conservatories(){
    for (FEED food: FEED.values()){
      Food_Quantity.put(food, 0);//initialize the Food quantity
    }
    //Location_Aviary = new HashMap<>();
    Food_Quantity = new HashMap<>();
    aviaryArrayList = new ArrayList<>();
    for(Location location: Location.values()){//start from the enum Location, initialize the 20 aviaries
      Aviary aviary = new Aviaries(location);
      aviaryArrayList.add(aviary);//initialize with enum in the Location;
     // Location_Aviary.put(location, aviary);//initialize the Location-Aviary map;

    }
  }

  @Override
  public void addBird(Birds birds) {
    if (birds.isExtinct()) {//this bird is already extinct, so we can not assign it to our conservatory.
      throw new RuntimeException("the bird has been extinct");
    }
    //Before adding a new bird, check the type of the bird, and make sure
    // Flightless birds, birds of prey, and waterfowl should not be mixed with other bird types.

    int flag = 0;//used for testing whether we have found out an aviary for this bird
    //if after the for loop, it's still zero, then there are no aviary for this bird and vice versa

    for (Aviary aviary : aviaryArrayList) {
      if (aviary.getSize() == 0) {//it's empty, so we can directly put the bird in
        aviary.addBird(birds);
        Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
        flag = 1;
        break;
      } else if(aviary.getSize() < 5){//the aviary is not full
        //not empty, and we need to check if the bird in the aviary is BirdsOfPrey
        if (birds instanceof BirdsOfPrey) {// the bird is BirdsOfPrey, and it should group with birdsOfprey
          //First traverse the list, if the birdlist in the aviary is empty, then we
          //can direct add the bird, if not empty, then we should check the bird in the
          // birdlist and make sure they are BirdsOfPrey
          if (aviary.getBird() instanceof BirdsOfPrey) {
            aviary.addBird(birds);
            Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
            flag = 1;
            break;
          }

        }
        if (birds instanceof FlightLess) {
          if (aviary.getBird() instanceof FlightLess) {
            aviary.addBird(birds);
            Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
            flag = 1;
            break;
          }
        }
        if (birds.isWaterBird()) {
          if (aviary.getBird().isWaterBird()) {
            aviary.addBird(birds);
            Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
            flag = 1;
            break;
          }
        }
      }
    }
    if (flag == 0) {
      //flag ==0 means the bird is not assigned to any aviaries
      throw new RuntimeException("No aviary is available for this bird");
    }

    for(FEED feed: birds.getPreferredFood()){
      Food_Quantity.put(feed, Food_Quantity.get(feed) + 1);//Since we add a new bird, increase the quantity of its favorite food
    }
  }


  @Override
  public void calculateFood() {
    System.out.println("Quantity of Food");
    System.out.println("Food-----Quantity");
    for (FEED feed: Food_Quantity.keySet()){
      System.out.println(feed + "-----" + Food_Quantity.get(feed));
    }

  }

  @Override
  public String getAviary(Birds birds) {
    return "The bird is in the aviary of " + Bird_Aviary.get(birds).getLocation();
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

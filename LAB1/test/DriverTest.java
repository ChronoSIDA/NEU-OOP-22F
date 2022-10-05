import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {
    private Conservatories conservatoryOne;

    private Conservatories conservatoryTwo;



    private Feed[] feedList;
    private Pigeons pigeon1;
    private FlightLess flightLess;
    private Pigeons pigeon2;
    private Pigeons pigeon3;
    
    // test birds
    private BirdsOfPrey eagle;
    private FlightLess moas;
    private Owls owl;
    private Parrots parrot;
    private Pigeons pigeon;
    private Shorebirds hornedPuffin;
    private Waterfowl goose;



    @Before
    public void setUp() throws Exception {
        conservatoryOne = new Conservatories();
        conservatoryTwo = new Conservatories();


        feedList = new Feed[]{Feed.FISH,  Feed.BERRIES,
                Feed.SEEDS, Feed.FRUIT, Feed.INSECTS, Feed.BIRDS,
                Feed.EGGS, Feed.SMALL_MAMMALS, Feed.FISH, Feed.BUDS,
                Feed.LARVAE, Feed.AQUATIC_INVERTEBRATES,
                Feed.NUTS, Feed.VEGETATION};
        ArrayList<Feed> foods = new ArrayList<>();
        foods.add(feedList[1]);
        foods.add(feedList[2]);

//        pigeon1 = new Pigeons("d", Birdtype.EXTINCT_PIGEONS, false, 2, foods);

        // Test IllegalArgumentException on extinction
        pigeon1 = new Pigeons("Real Pigeon", Birdtype.PIGEONS, false, 2, foods);

        flightLess = new FlightLess("KiwisKK",Birdtype.KIWIS, false, 0, foods);
        pigeon2 = new Pigeons("Pigeon Alive", Birdtype.PIGEONS, false, 2, foods);
        pigeon3 = new Pigeons("The Only Dove", Birdtype.DOVES, false, 2, foods);

        // Test extinction

        conservatoryOne.addBird(pigeon1);
        conservatoryOne.addBird(flightLess);
        conservatoryOne.addBird(pigeon2);
        conservatoryOne.addBird(pigeon3);



        feedList = new Feed[]{Feed.FISH,  Feed.BERRIES,
                Feed.SEEDS, Feed.FRUIT, Feed.INSECTS, Feed.BIRDS,
                Feed.EGGS, Feed.SMALL_MAMMALS, Feed.FISH, Feed.BUDS,
                Feed.LARVAE, Feed.AQUATIC_INVERTEBRATES,
                Feed.NUTS, Feed.VEGETATION};

        ArrayList<Feed> foodEagle = new ArrayList<>();
        foodEagle.add(Feed.FISH);
        foodEagle.add(Feed.BIRDS);
        foodEagle.add(Feed.EGGS);
        foodEagle.add(Feed.INSECTS);

        ArrayList<Feed> foodMoas = new ArrayList<>();
        foodMoas.add(Feed.EGGS);
        foodMoas.add(Feed.BIRDS);
        foodMoas.add(Feed.INSECTS);

        ArrayList<Feed> foodOwl = new ArrayList<>();
        foodOwl.add(Feed.LARVAE);
        foodOwl.add(Feed.VEGETATION);
        foodOwl.add(Feed.INSECTS);

        ArrayList<Feed> foodParrot = new ArrayList<>();
        foodParrot.add(Feed.AQUATIC_INVERTEBRATES);
        foodParrot.add(Feed.VEGETATION);
        foodParrot.add(Feed.LARVAE);
        foodParrot.add(Feed.BUDS);

        ArrayList<Feed> foodPigeon = new ArrayList<>();
        foodPigeon.add(Feed.LARVAE);
        foodPigeon.add(Feed.VEGETATION);
        foodPigeon.add(Feed.SMALL_MAMMALS);
        foodPigeon.add(Feed.INSECTS);

        ArrayList<Feed> foodShoreBird = new ArrayList<>();
        foodShoreBird.add(Feed.SEEDS);
        foodShoreBird.add(Feed.VEGETATION);
        foodShoreBird.add(Feed.INSECTS);

        ArrayList<Feed> foodGoose = new ArrayList<>();
        foodGoose.add(Feed.NUTS);
        foodGoose.add(Feed.SEEDS);
        foodGoose.add(Feed.FRUIT);


        eagle = new BirdsOfPrey("American Eagle", Birdtype.EAGLES,false, 2, foodEagle);
        moas = new FlightLess("China Moas",Birdtype.MOAS,false, 2, foodMoas);
        owl = new Owls("Owlllllllls", Birdtype.OWLS, false, 2, foodOwl);
        parrot = new Parrots("Im Rose One", Birdtype.ROSE_RING_PARAKEET, 10,"Hello",false, 2, foodParrot);
        parrot = new Parrots("Im Rose Two", Birdtype.ROSE_RING_PARAKEET, 10,"World",false, 2, foodParrot);

        pigeon = new Pigeons("Pigeon the killer", Birdtype.PIGEONS, false,2, foodPigeon);
        hornedPuffin = new Shorebirds("Auk the Hulk",Birdtype.GREAT_AUK, false,2, foodShoreBird,new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.WETLANDS})));
        goose = new Waterfowl("Goosebumps",Birdtype.GEESE, false,2, foodGoose,new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.SALT})));


        conservatoryOne.addBird(eagle);
        conservatoryOne.addBird(moas);
        conservatoryOne.addBird(owl);
        conservatoryOne.addBird(parrot);
        conservatoryOne.addBird(pigeon);
        conservatoryOne.addBird(hornedPuffin);
        conservatoryOne.addBird(goose);
    }




    @Test
    public void getFoodQuantity() {
        conservatoryOne.calculateFood();
    }

    @Test
    public void testGetAviaryOfBird(){
        Assert.assertEquals(Location.L3, conservatoryOne.getAviary(eagle));
        Assert.assertEquals(Location.L2, conservatoryOne.getAviary(moas));
        Assert.assertEquals(Location.L1, conservatoryOne.getAviary(owl));
        Assert.assertEquals(Location.L1, conservatoryOne.getAviary(parrot));
        Assert.assertEquals(Location.L4, conservatoryOne.getAviary(pigeon));
        Assert.assertEquals(Location.L4, conservatoryOne.getAviary(hornedPuffin));
        Assert.assertEquals(Location.L5, conservatoryOne.getAviary(goose));
    }

    @Test
    public void printSignOfAviary() {
        ArrayList<Aviary> aviaryListOne = conservatoryOne.getAviaryList();
        for (Aviary aviary: aviaryListOne) {
            conservatoryOne.printSign(aviary);
        }
        ArrayList<Aviary> aviaryListTwo = conservatoryTwo.getAviaryList();
        for (Aviary aviary: aviaryListTwo) {
            conservatoryOne.printSign(aviary);
        }
    }
    @Test
    public void printMap() {
        conservatoryOne.printMap();
    }

    @Test
    public void printBirdIndex() {
        conservatoryOne.printIndex();
    }
    @Test
    public void addExtinctBird() {
        // Test IllegalArgumentException
        ArrayList<Feed> foods = new ArrayList<>();
        foods.add(Feed.SMALL_MAMMALS);
        foods.add(Feed.FISH);

        Birds extinctBird = new Pigeons("Pigeon the killer",Birdtype.EXTINCT_PIGEONS, true,2, foods);

        conservatoryTwo.addBird(extinctBird);
        Assert.assertEquals(new ArrayList<Aviary>(), conservatoryTwo.getAviaryList());

    }
    @Test
    public void addTwentyMoreBird(){
        for(int i = 0; i < 5; i++){

            ArrayList<Feed> foods = new ArrayList<>();
            foods.add(Feed.SMALL_MAMMALS);
            foods.add(Feed.FISH);

            conservatoryTwo.addBird(new Pigeons("b", Birdtype.PIGEONS,false,2, foods));
        }
    }

    @Test
    public void checkNumOfWings(){
        ArrayList<Feed> foods = new ArrayList<>();
        foods.add(Feed.SMALL_MAMMALS);
        foods.add(Feed.FISH);

        Birds manyWingsBird = new Pigeons("Pigeon the killer",Birdtype.EXTINCT_PIGEONS, true,100, foods);

        conservatoryTwo.addBird(manyWingsBird);
        Assert.assertEquals(new ArrayList<Aviary>(), conservatoryTwo.getAviaryList());
    }
}
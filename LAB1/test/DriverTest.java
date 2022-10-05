import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {
    private Conservatories d1;

    private Conservatories d2;



    private Feed[] foodsList;
    private Pigeons p1;
    private FlightLess p2;
    private Pigeons p3;
    private Pigeons p4;
    private BirdsOfPrey hawk;
    private FlightLess emus;
    private Owls owl;

    private Parrots parrot;
    private Pigeons pigeon;
    private Shorebirds greatauk;
    private Waterfowl duck;
    private Parrots extinctParrot;



    @Before
    public void setUp() throws Exception {
        d1 = new Conservatories();
        d2 = new Conservatories();


        foodsList = new Feed[]{Feed.FISH,  Feed.BERRIES,
                Feed.SEEDS, Feed.FRUIT, Feed.INSECTS, Feed.BIRDS,
                Feed.EGGS, Feed.SMALL_MAMMALS, Feed.FISH, Feed.BUDS,
                Feed.LARVAE, Feed.AQUATIC_INVERTEBRATES,
                Feed.NUTS, Feed.VEGETATION};
        ArrayList<Feed> foods = new ArrayList<>();
        foods.add(foodsList[1]);
        foods.add(foodsList[2]);
        p1 = new Pigeons("d", Birdtype.EXTINCT_PIGEONS, true, 2, foods);
        p2 = new FlightLess("c",Birdtype.KIWIS, false, 0, foods);
        p3 = new Pigeons("d", Birdtype.EXTINCT_PIGEONS, true, 2, foods);
        p4 = new Pigeons("d", Birdtype.EXTINCT_PIGEONS, true, 2, foods);
        d1.addBird(p1);
        d1.addBird(p2);
        d1.addBird(p3);
        d1.addBird(p4);
        ArrayList<Feed> foodHawk = new ArrayList<>();
        foodHawk.add(foodsList[0]);
        foodHawk.add(foodsList[5]);
        ArrayList<Feed> foodEmus = new ArrayList<>();
        foodEmus.add(foodsList[0]);
        foodEmus.add(foodsList[1]);
        ArrayList<Feed> foodOwl = new ArrayList<>();
        foodOwl.add(foodsList[1]);
        foodOwl.add(foodsList[4]);
        foodOwl.add(foodsList[13]);

        ArrayList<Feed> foodParrot = new ArrayList<>();
        foodParrot.add(foodsList[2]);
        foodParrot.add(foodsList[6]);
        ArrayList<Feed> foodPigeon = new ArrayList<>();
        foodPigeon.add(foodsList[7]);
        foodPigeon.add(foodsList[5]);
        ArrayList<Feed> foodShoreBird = new ArrayList<>();
        foodShoreBird.add(foodsList[8]);
        foodShoreBird.add(foodsList[9]);
        ArrayList<Feed> foodDuck = new ArrayList<>();
        foodDuck.add(foodsList[10]);
        foodDuck.add(foodsList[11]);


        hawk = new BirdsOfPrey("hk", Birdtype.HAWKS,false, 2, foodHawk);
        emus = new FlightLess("emus1",Birdtype.EMUS,false, 2, foodEmus);
        owl = new Owls("ow", Birdtype.OWLS, false, 2, foodOwl);
        parrot = new Parrots("prt", Birdtype.ROSE_RING_PARAKEET, 10,"Hello",false, 2, foodParrot);
        parrot = new Parrots("prt", Birdtype.ROSE_RING_PARAKEET, 10,"World",true, 2, foodParrot);
        pigeon = new Pigeons("b",Birdtype.EXTINCT_PIGEONS, true,2, foodPigeon);
        greatauk = new Shorebirds("grtauk",Birdtype.GREAT_AUK, false,2, foodShoreBird,new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.WETLANDS})));
        duck = new Waterfowl("dc",Birdtype.DUCKS, false,2, foodDuck,new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.SALT})));
        d1.addBird(hawk);
        d1.addBird(emus);
        d1.addBird(owl);
        d1.addBird(parrot);

        d1.addBird(pigeon);
        d1.addBird(greatauk);
        d1.addBird(duck);


    }




    @Test
    public void getFoodQuantity() {
        d1.calculateFood();
        }

    @Test
    public void testGetAviaryOfBird(){

            //d1.printMap();
            //System.out.println(d1.getBirdDictionary());
            //System.out.println(d1.getAviaryOfBird(p1));
//        d1.printBirdIndex();

    Assert.assertEquals(Location.L3, d1.getAviary(hawk));
        Assert.assertEquals(Location.L2, d1.getAviary(emus));
        Assert.assertEquals(Location.L1, d1.getAviary(owl));
        Assert.assertEquals(Location.L1, d1.getAviary(parrot));
        Assert.assertEquals(Location.L4, d1.getAviary(pigeon));
        Assert.assertEquals(Location.L4, d1.getAviary(greatauk));
        Assert.assertEquals(Location.L5, d1.getAviary(duck));

    }

    @Test
    public void printSignOfAviary() {
        ArrayList<Aviary> aviaryList = d1.getAviaryList();
        for (Aviary aviary: aviaryList) {
            d1.printSign(aviary);
        }
    }
    @Test
    public void printMap() {
        d1.printMap();
    }

    @Test
    public void printBirdIndex() {
        d1.printIndex();
    }

    @Test
    public void getSignOfAviary() {
        //d1.getSignOfAviary();
    }
    @Test
    public void addExtinctBird() {
        d2.addBird(extinctParrot);
        Assert.assertEquals(new ArrayList<Aviary>(), d2.getAviaryList());

    }
    @Test (expected = IllegalStateException.class)
    public void addTwentyMoreBird(){
        for(int i=0;i< 101;i++){

            ArrayList<Feed> foods = new ArrayList<>();
            foods.add(Feed.SMALL_MAMMALS);
            foods.add(Feed.FISH);

            d2.addBird(new Pigeons("b",Birdtype.EXTINCT_PIGEONS,false,2, foods));

        }
    }
}
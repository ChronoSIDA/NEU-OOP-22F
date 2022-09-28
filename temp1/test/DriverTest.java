import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {
    private Conservatories d1;

    private Conservatories d2;



    private FOODS[] foodsList;
    private Pigeons p1;
    private FlightLessBirds p2;
    private Pigeons p3;
    private Pigeons p4;
    private BirdsOfPrey hawk;
    private FlightLessBirds emus;
    private Owls owl;

    private Parrots parrot;
    private Pigeons pigeon;
    private ShoreBirds greatauk;
    private Waterfowl duck;
    private Parrots extinctParrot;



    @Before
    public void setUp() throws Exception {
        d1 = new Conservatories();
        d2 = new Conservatories();


        foodsList = new FOODS[]{FOODS.FISH,  FOODS.BERRIES,
            FOODS.SEEDS, FOODS.FRUIT, FOODS.INSECTS, FOODS.OTHERBIRDS,
            FOODS.EGGS, FOODS.SMALLMAMMALS, FOODS.FISH, FOODS.BUDS,
            FOODS.LARVAE, FOODS.AQUATICINVERTEBRATES,
            FOODS.NUTS, FOODS.VEGETATION};
        ArrayList<FOODS> foods = new ArrayList<>();
        foods.add(foodsList[1]);
        foods.add(foodsList[2]);
        p1 = new Pigeons("d",BIRDTYPE.PASSENGERPIGEON, new ArrayList<String>(),false,2, foods);
        p2 = new FlightLessBirds("c",BIRDTYPE.KIWIS, new ArrayList<String>(),false,foods);
        p3 = new Pigeons("b",BIRDTYPE.PASSENGERPIGEON, new ArrayList<String>(),false,2, foods);
        p4 = new Pigeons("g",BIRDTYPE.PASSENGERPIGEON, new ArrayList<String>(),false,2, foods);
        d1.addBirds(p1);
        d1.addBirds(p2);
        d1.addBirds(p3);
        d1.addBirds(p4);
        ArrayList<FOODS> foodHawk = new ArrayList<>();
        foodHawk.add(foodsList[0]);
        foodHawk.add(foodsList[5]);
        ArrayList<FOODS> foodEmus = new ArrayList<>();
        foodEmus.add(foodsList[0]);
        foodEmus.add(foodsList[1]);
        ArrayList<FOODS> foodOwl = new ArrayList<>();
        foodOwl.add(foodsList[1]);
        foodOwl.add(foodsList[4]);
        foodOwl.add(foodsList[13]);

        ArrayList<FOODS> foodParrot = new ArrayList<>();
        foodParrot.add(foodsList[2]);
        foodParrot.add(foodsList[6]);
        ArrayList<FOODS> foodPigeon = new ArrayList<>();
        foodPigeon.add(foodsList[7]);
        foodPigeon.add(foodsList[5]);
        ArrayList<FOODS> foodShoreBird = new ArrayList<>();
        foodShoreBird.add(foodsList[8]);
        foodShoreBird.add(foodsList[9]);
        ArrayList<FOODS> foodDuck = new ArrayList<>();
        foodDuck.add(foodsList[10]);
        foodDuck.add(foodsList[11]);


        hawk = new BirdsOfPrey("hk",BIRDTYPE.HAWKS, new ArrayList<String>(),false, 2, foodHawk);
        emus = new FlightLessBirds("emus1",BIRDTYPE.EMUS, new ArrayList<String>(),false,foodEmus);
        owl = new Owls("ow",BIRDTYPE.OWLS, new ArrayList<String>(),false, 2, foodOwl);
        parrot = new Parrots("prt",BIRDTYPE.ROSERINGPARAKEET,"Hello",10,new ArrayList<String>(),false, 2, foodParrot);
        extinctParrot = new Parrots("prt",BIRDTYPE.ROSERINGPARAKEET,"Hello",10,new ArrayList<String>(),true, 2, foodParrot);
        pigeon = new Pigeons("b",BIRDTYPE.PASSENGERPIGEON, new ArrayList<String>(),false,2, foodPigeon);
        greatauk = new ShoreBirds("grtauk",BIRDTYPE.GREATAUK, new ArrayList<String>(),false,2, foodShoreBird,new ArrayList<WATER>(
            List.of(new WATER[]{WATER.WETLANDS})));
        duck = new Waterfowl("dc",BIRDTYPE.DUCKS, new ArrayList<String>(),false,2, foodDuck,new ArrayList<WATER>(
            List.of(new WATER[]{WATER.SALT})));
        d1.addBirds(hawk);
        d1.addBirds(emus);
        d1.addBirds(owl);
        d1.addBirds(parrot);

        d1.addBirds(pigeon);
        d1.addBirds(greatauk);
        d1.addBirds(duck);


    }




    @Test
    public void getFoodQuantity() {
        d1.printFoodQuantityList();
        }

    @Test
    public void testGetAviaryOfBird(){

            //d1.printMap();
            //System.out.println(d1.getBirdDictionary());
            //System.out.println(d1.getAviaryOfBird(p1));
//        d1.printBirdIndex();

    Assert.assertEquals(LOCATION.LOCATION3,d1.getAviaryOfBird(hawk));
        Assert.assertEquals(LOCATION.LOCATION2,d1.getAviaryOfBird(emus));
        Assert.assertEquals(LOCATION.LOCATION1, d1.getAviaryOfBird(owl));
        Assert.assertEquals(LOCATION.LOCATION1,d1.getAviaryOfBird(parrot));
        Assert.assertEquals(LOCATION.LOCATION4,d1.getAviaryOfBird(pigeon));
        Assert.assertEquals(LOCATION.LOCATION4,d1.getAviaryOfBird(greatauk));
        Assert.assertEquals(LOCATION.LOCATION5,d1.getAviaryOfBird(duck));

    }

    @Test
    public void printSignOfAviary() {
        ArrayList<Aviary> aviaryList = d1.getAviaryList();
        for (Aviary aviary: aviaryList) {
            d1.printSignOfAviary(aviary);
        }
    }
    @Test
    public void printMap() {
        d1.printMap();
    }

    @Test
    public void printBirdIndex() {
        d1.printBirdIndex();
    }

    @Test
    public void getSignOfAviary() {
        //d1.getSignOfAviary();
    }
    @Test
    public void addExtinctBird() {
        d2.addBirds(extinctParrot);
        Assert.assertEquals(new ArrayList<Aviary>(), d2.getAviaryList());

    }
    @Test (expected = IllegalStateException.class)
    public void addTwentyMoreBird(){
    for(int i=0;i< 101;i++){
    d2.addBirds(new Pigeons("b",BIRDTYPE.PASSENGERPIGEON,new ArrayList<String>(),false,2,new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.SMALLMAMMALS,FOODS.FISH}))));

    }

    }}
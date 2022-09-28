import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BirdTestList {
    private ArrayList<Bird> birds;
    private HashMap<Bird, ArrayList<String>> expectedChara;
    private HashMap<Bird, Boolean> expectedExtinct;
    private HashMap<Bird, Integer> expectedWings;
    private HashMap<Bird, ArrayList<FOODS>> expectedFoods;
    private HashMap<Bird, ArrayList<WATER>> expectedWaters;
    private HashMap<Bird, BIRDTYPE> expectedType;

    private String[] characterList;
    private FOODS[] foodsList;

    private WATER[] watersListShore;
    private WATER[] watersListWaterfowl;

    private BIRDTYPE[] typeList;

    /**
    @Before
    public void setUp() {
        birds = new ArrayList<>();

        expectedExtinct = new HashMap<>();
        expectedWings = new HashMap<>();
        expectedChara = new HashMap<>();
        expectedFoods = new HashMap<>();
        expectedWaters = new HashMap<>();
        expectedType = new HashMap<Bird, BIRDTYPE>();


        typeList = new BIRDTYPE[]{"type1", "type2", "type3","type4","type5","type6","type7","type8", "type9"};
        characterList = new String[]{"enormous", "very heavy", "small", "light", "black"};
        foodsList = new FOODS[]{FOODS.FISH, FOODS.BERRIES,
                FOODS.SEEDS, FOODS.FRUIT, FOODS.INSECTS, FOODS.OTHERBIRDS,
                FOODS.EGGS, FOODS.SMALLMAMMALS, FOODS.FISH, FOODS.BUDS,
                FOODS.LARVAE, FOODS.AQUATICINVERTEBRATES,
                FOODS.NUTS, FOODS.VEGETATION};

        watersListShore = new WATER[]{WATER.WETLANDS, WATER.FRESHWATER_SHORELANDS, WATER.SALTWATER_SHORELANDS, WATER.OCEAN};
        watersListWaterfowl = new WATER[]{WATER.SALT, WATER.FRESH};
        Random random = new Random();


        // flightless birds
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();
            int randomIndex = random.nextInt(characterList.length);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);

            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();
            // randomly set the size of the foods
            int randFoodNumber = random.nextInt(2, 4);

            for (int j = 0; j < randFoodNumber; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length);
                foods.add(foodsList[randomIndexFood]);
            }

            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();

            // generate all expected value for type

            int typeIndex = random.nextInt(typeList.length) ;

            BIRDTYPE type = typeList[typeIndex];


            FlightLessBirds flightLessBirds = new FlightLessBirds(type, chara,
                    extinct, foods);

            expectedType.put(flightLessBirds, type);
            birds.add(flightLessBirds);
            chara.add("live on ground");
            expectedExtinct.put(flightLessBirds, extinct);
            expectedChara.put(flightLessBirds, chara);
            expectedFoods.put(flightLessBirds, foods);
            expectedWings.put(flightLessBirds, 0);
        }

        // creating the object of Owls
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();
            int randomIndex = random.nextInt(characterList.length);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);

            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();

            // randomly set the size of the food
            int randFoodNumber = random.nextInt(2, 5);

            for (int j = 0; j < randFoodNumber; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length);
                foods.add(foodsList[randomIndexFood]);
            }

            // generate random wing numbers
            int wingNumber = random.nextInt(2, 11);

            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();

            int typeIndex = random.nextInt(typeList.length);

            BIRDTYPE type = typeList[typeIndex];



            Owls owlsBirds = new Owls(type, chara, extinct, wingNumber, foods);

            birds.add(owlsBirds);
            chara.add("facial disks");

            expectedType.put(owlsBirds, type);
            expectedExtinct.put(owlsBirds, extinct);
            expectedChara.put(owlsBirds, chara);
            expectedFoods.put(owlsBirds, foods);
            expectedWings.put(owlsBirds, wingNumber);
        }

        // Pigeons
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();

            int randomIndex = random.nextInt(characterList.length);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);

            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();

            // randomly set the size of the food
            int randFoodNumber = random.nextInt(2, 5);

            for (int j = 0; j < randFoodNumber; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length);
                foods.add(foodsList[randomIndexFood]);
            }

            // generate random wing numbers
            int wingNumber = random.nextInt(2, 11);

            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();


            int typeIndex = random.nextInt(typeList.length);

            BIRDTYPE type = typeList[typeIndex];

            Pigeons pigeons = new Pigeons(type, chara, extinct, wingNumber, foods);

            expectedType.put(pigeons, type);
            birds.add(pigeons);
            chara.add("feeding their young bird milk");
            expectedExtinct.put(pigeons, extinct);
            expectedChara.put(pigeons, chara);
            expectedFoods.put(pigeons, foods);
            expectedWings.put(pigeons, wingNumber);
        }


        // WaterFowl
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();

            int randomIndex = random.nextInt(characterList.length);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);

            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();

            // randomly set the size of the food
            int randFoodNumber = random.nextInt(2, 5);

            for (int j = 0; j < randFoodNumber; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length);
                foods.add(foodsList[randomIndexFood]);
            }

            ArrayList<WATER> waters = new ArrayList<>();

            int randomIndexWater = random.nextInt(watersListWaterfowl.length);
            waters.add(watersListWaterfowl[randomIndexWater]);


            // generate random wing numbers
            int wingNumber = random.nextInt(2, 11);

            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();

            int typeIndex = random.nextInt(typeList.length);

            BIRDTYPE type = typeList[typeIndex];

            Waterfowl waterfowl = new Waterfowl(type, chara, extinct, wingNumber, foods, waters);

            expectedType.put(waterfowl, type);
            birds.add(waterfowl);
            chara.add("live near water sources (fresh or salt)");
            expectedExtinct.put(waterfowl, extinct);
            expectedChara.put(waterfowl, chara);
            expectedFoods.put(waterfowl, foods);
            expectedWings.put(waterfowl, wingNumber);
            expectedWaters.put(waterfowl, waters);
        }
        // shore birds
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();
            int randomIndex = random.nextInt(characterList.length);
            ArrayList<WATER> waters = new ArrayList<>();
            int randomIndexWater = random.nextInt(watersListShore.length);
            waters.add(watersListShore[randomIndexWater]);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);
            int wing = random.nextInt(2, 11);

            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();
            // randomly set the size of the foods
            int randFoodNumber = random.nextInt(2, 5);

            for (int j = 0; j < randFoodNumber; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length);
                foods.add(foodsList[randomIndexFood]);
            }


            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();
            //

            int typeIndex = random.nextInt(typeList.length);

            BIRDTYPE type = typeList[typeIndex];


            ShoreBirds shoreBirds = new ShoreBirds(type, chara, extinct, wing, foods, waters);


            expectedType.put(shoreBirds, type);
            birds.add(shoreBirds);
            chara.add("live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean");
            expectedExtinct.put(shoreBirds, extinct);
            expectedChara.put(shoreBirds, chara);
            expectedFoods.put(shoreBirds, foods);
            expectedWings.put(shoreBirds, wing);
            expectedWaters.put(shoreBirds, waters);

        }
        // bird of prey
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();
            int randomIndex = random.nextInt(characterList.length);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);
            int wing = random.nextInt(2,11);


            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();
            // randomly set the size of the foods
            int randFoodNumber = random.nextInt(2, 4);


            int typeIndex = random.nextInt(typeList.length);

            BIRDTYPE type = typeList[typeIndex];



            for (int j = 0; j < randFoodNumber ; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length);
                foods.add(foodsList[randomIndexFood]);
            }

            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();
            // add type
            BirdsOfPrey birdsOfPrey = new BirdsOfPrey(type, chara, extinct, wing, foods);


            expectedType.put(birdsOfPrey, type);

            birds.add(birdsOfPrey);
            chara.add("sharp, hooked beaks with visible nostrils");
            expectedExtinct.put(birdsOfPrey, extinct);
            expectedChara.put(birdsOfPrey, chara);
            expectedFoods.put(birdsOfPrey, foods);
            expectedWings.put(birdsOfPrey, wing);
        }

    }
    @Test
    public void testGetType(){
        for (Bird bird : birds) {
            Assert.assertEquals(expectedType.get(bird), bird.getType());
        }
        System.out.println("test getType Pass!");
    }



    @Test
    public void testGetCategory() {
        for (Bird bird : birds) {
            if (bird instanceof FlightLessBirds) {
                Assert.assertEquals("FlightLess Birds", bird.getBirdsCategory());
            }
            else if (bird instanceof Owls){
                Assert.assertEquals("Owls", bird.getBirdsCategory());
            }

            else if (bird instanceof Pigeons){
                Assert.assertEquals("Pigeons", bird.getBirdsCategory());
            }
            else if (bird instanceof Waterfowl){
                Assert.assertEquals("Waterfowl", bird.getBirdsCategory());
            }

            else if (bird instanceof ShoreBirds){
                Assert.assertEquals("Shore Birds", bird.getBirdsCategory());
            }

        }

        System.out.println("test getType Pass!");
    }

    @Test
    public void testGetCharacteristic() {
        for (Bird bird : birds) {
            Assert.assertEquals(expectedChara.get(bird), bird.getCharacteristic());
        }
        System.out.println("test getCharacteristic Pass!");
    }

    @Test
    public void testGetExtinct() {

        for (Bird bird : birds) {
            if (bird instanceof FlightLessBirds) {
                Assert.assertEquals(expectedExtinct.get(bird), bird.getExtinct());
            }
        }
        System.out.println("TestGetExtinct Pass!");
    }

    @Test
    public void testGetFoods() {

        for (Bird bird : birds) {
            Assert.assertEquals(expectedFoods.get(bird), bird.getPreferFood());
        }
        System.out.println("Test cases Pass!");
    }


    @Test
    public void testWinNums() {
        for (Bird bird : birds) {
            Assert.assertEquals(expectedWings.get(bird), (Integer) bird.getWingNum());
        }
        System.out.println("Test getWingNum Pass!");
    }

    @Test
    public void testGetWaterLiveBy(){
        for (Bird bird: birds){
            if (bird instanceof Waterfowl){
                Assert.assertEquals(expectedWaters.get(bird), ((Waterfowl) bird).getWaterLiveBy());
            }

            else if( bird instanceof  ShoreBirds){
                Assert.assertEquals(expectedWaters.get(bird), ((ShoreBirds) bird).getWaterLiveBy());
            }
        }

        System.out.println("Test getWaterNearBy Pass!");

    }


    @Test(expected = IllegalArgumentException.class)
    public void inValidWingsInput(){
        Bird bird = new BirdsOfPrey("bird", new ArrayList<>(), false, -1,
                new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.NUTS})));
        Bird bird2 = new Pigeons("bird", new ArrayList<>(), false, -2,
                new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.NUTS})));
        Bird bird3 = new Owls("bird", new ArrayList<>(), false, -3,
                new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.NUTS})));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inValidFoodsInput(){
        Bird bird = new BirdsOfPrey("bird", new ArrayList<>(), false, 2,
                new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH})));
        Bird bird2 = new Pigeons("bird", new ArrayList<>(), false, 2,
                new ArrayList<FOODS>());
        Bird bird3 = new Owls("bird" ,new ArrayList<>(), false, -3,
                new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.NUTS, FOODS.NUTS, FOODS.BERRIES, FOODS.FRUIT})));
    }


    @Test(expected = IllegalArgumentException.class)
    public void inValidWaterLiveByInput(){
        Bird bird = new Waterfowl("bird",new ArrayList<>(), false, 2,
                new ArrayList<>(List.of(new FOODS[]{FOODS.FISH, FOODS.NUTS})), new ArrayList<>(List.of(new WATER[]{WATER.OCEAN})));
        Bird bird2 = new ShoreBirds("bird",new ArrayList<>(), false, 2,
                new ArrayList<>(List.of(new FOODS[]{FOODS.FISH, FOODS.NUTS})), new ArrayList<>(List.of(new WATER[]{WATER.SALT})));
    }



    @Test(expected = IllegalArgumentException.class)
    public void inValidVocabularyInput(){
        Bird bird = new Parrots("bird", "Hello", -2 ,new ArrayList<>(),
                false, 2, new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.FRUIT})));
        Bird bird2 = new Parrots("bird", "Hello", 101 ,new ArrayList<>(),
                false, 2, new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.FRUIT})));
        Bird bird = new Parrots("bird", BIRDTYPE.HAWKS, "" ,1,
        new ArrayList<String>(), false,2, new ArrayList<FOODS>(List.of(new FOODS[]{FOODS.FISH, FOODS.FRUIT})));

    }
    **/

}

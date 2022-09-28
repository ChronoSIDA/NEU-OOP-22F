import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParrotsTest {
    private ArrayList<Bird> birds;
    private HashMap<Bird, ArrayList<String>> expectedChara;
    private HashMap<Bird, Boolean> expectedExtinct;
    private HashMap<Bird, Integer> expectedWings;
    private HashMap<Bird, ArrayList<FOODS>> expectedFoods;


    private HashMap<Bird, BIRDTYPE> expectedType;
    private HashMap<Bird, String> expectedName;
    private HashMap<Bird, String> expectedSaying;
    private String[] characterList;
    private FOODS[] foodsList;
    private String[] favoriteSayingList;
    private int vocabulary;
    private HashMap<Bird, Integer> expectedVocab;

    private String[] nameList;

    private BIRDTYPE[] typeList;


    @Before
    public void setUp() throws Exception {
        birds = new ArrayList<>();

        expectedExtinct = new HashMap<>();
        expectedWings = new HashMap<>();
        expectedChara = new HashMap<>();
        expectedFoods = new HashMap<>();
        expectedSaying = new HashMap<>();
        expectedVocab = new HashMap<>();
        expectedType = new HashMap<>();
        expectedName = new HashMap<>();

        nameList = new String[]{"type1", "type2", "type3","type4","type5","type6","type7","type8", "type9"};
        characterList = new String[]{"enormous", "very heavy", "small", "light", "black"};
        foodsList = new FOODS[]{FOODS.FISH,  FOODS.BERRIES,
            FOODS.SEEDS, FOODS.FRUIT, FOODS.INSECTS, FOODS.OTHERBIRDS,
            FOODS.EGGS, FOODS.SMALLMAMMALS, FOODS.FISH, FOODS.BUDS,
            FOODS.LARVAE, FOODS.AQUATICINVERTEBRATES,
            FOODS.NUTS, FOODS.VEGETATION};

        typeList = new BIRDTYPE[]{BIRDTYPE.ROSERINGPARAKEET, BIRDTYPE.GRAYPARROT, BIRDTYPE.SULFURCRESTEDCOCKATOO};
        favoriteSayingList = new String[]{"2 sum", "binary search", "leetcode", "accepted", "run time error"};


        Random random = new Random();


        // flightless birds
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();
            int randomIndex = random.nextInt(characterList.length - 1);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);
            int wing = random.nextInt(2,11);
            int typeIdx = random.nextInt(typeList.length - 1);



            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<FOODS> foods = new ArrayList<>();
            // randomly set the size of the foods
            int randFoodNumber = random.nextInt(2, 4);

            // generate the random type
            int typeIndex = random.nextInt() * nameList.length;
            int nameIdx = random.nextInt(nameList.length - 1);
            String name = nameList[nameIdx];

            for (int j = 0; j < randFoodNumber ; j++) {
                // randomly get the foods from the food list
                int randomIndexFood = random.nextInt(foodsList.length - 1);
                foods.add(foodsList[randomIndexFood]);
            }
            String favoriteSaying = favoriteSayingList[ random.nextInt(favoriteSayingList.length)];

            // generate all expected value and put it in the hashmap
            boolean extinct = random.nextBoolean();
            //
            int vocabulary = random.nextInt(0,100);

            BIRDTYPE type = this.typeList[typeIdx];
            Parrots parrot = new Parrots(name,type, favoriteSaying, vocabulary, chara, extinct, wing, foods);

            expectedType.put(parrot, type);
            birds.add(parrot);
            chara.add("sharp, hooked beaks with visible nostrils");
            expectedExtinct.put(parrot, extinct);
            expectedChara.put(parrot, chara);
            expectedFoods.put(parrot, foods);
            expectedWings.put(parrot, wing);
            expectedSaying.put(parrot, favoriteSaying);
            expectedVocab.put(parrot, vocabulary);
            expectedName.put(parrot, name);
        }
    }

    @Test
    public void testGetCategory() {
        for (Bird bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(CLASSIFICATION.PARROTS, bird.getBirdsCategory());
            }
        }
    }

    @Test
    public void testGetType() {
        for (Bird bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(expectedType.get(bird), bird.getType());
            }
        }
    }

    @Test
    public void testGetNumberOfWord() {
        for (Bird bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(expectedVocab.get(bird), (Integer) ((Parrots) bird).getNumberOfWord());
            }

        }

    }

    @Test
    public void testGetFavoriteSaying() {
        for (Bird bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(expectedSaying.get(bird), ((Parrots) bird).getFavoriteSaying());
            }

        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void inValiBirdType(){

    }
}
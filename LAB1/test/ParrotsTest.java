import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParrotsTest {
    private ArrayList<Birds> birds;
    private HashMap<Birds, ArrayList<String>> expectedChara;
    private HashMap<Birds, Boolean> expectedExtinct;
    private HashMap<Birds, Integer> expectedWings;
    private HashMap<Birds, ArrayList<Feed>> expectedFoods;


    private HashMap<Birds, Birdtype> expectedType;
    private HashMap<Birds, String> expectedName;
    private HashMap<Birds, String> expectedSaying;
    private String[] characterList;
    private Feed[] foodsList;
    private String[] favoriteSayingList;
    private int vocabulary;
    private HashMap<Birds, Integer> expectedVocab;

    private String[] nameList;

    private Birdtype[] typeList;


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
        foodsList = new Feed[]{Feed.FISH,  Feed.BERRIES,
                Feed.SEEDS, Feed.FRUIT, Feed.INSECTS, Feed.BIRDS,
                Feed.EGGS, Feed.SMALL_MAMMALS, Feed.FISH, Feed.BUDS,
                Feed.LARVAE, Feed.AQUATIC_INVERTEBRATES,
                Feed.NUTS, Feed.VEGETATION};

        typeList = new Birdtype[]{Birdtype.ROSE_RING_PARAKEET, Birdtype.GRAY_PARROT, Birdtype.SULFUR_CRESTED_COCKATOO};
        favoriteSayingList = new String[]{"2 sum", "binary search", "leetcode", "accepted", "run time error"};


        Random random = new Random();


        // flightless birds
        for (int i = 0; i < 10; i++) {
            // randomly get the characteristics and foods
            ArrayList<String> chara = new ArrayList<>();
            int randomIndex = random.nextInt(characterList.length - 1);

            // add the randomly generated characteristic to the chara which is a param list putted into the constructor latter
            chara.add(characterList[randomIndex]);
            int wing = random.nextInt(0,6);
            int typeIdx = random.nextInt(typeList.length - 1);



            // the same idea for foods, but here the list of foods' size must be 2 - 4
            ArrayList<Feed> foods = new ArrayList<>();
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

            Birdtype type = this.typeList[typeIdx];
            Parrots parrot = new Parrots(name,type, vocabulary,  favoriteSaying, extinct, wing, foods);

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
        for (Birds bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(Classification.PARROTS, bird.getBirdsClass());
            }
        }
    }

    @Test
    public void testGetType() {
        for (Birds bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(expectedType.get(bird), bird.getBirdType());
            }
        }
    }

    @Test
    public void testGetNumberOfWord() {
        for (Birds bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(expectedVocab.get(bird), (Integer) ((Parrots) bird).getNumberOfWord());
            }

        }

    }

    @Test
    public void testGetFavoriteSaying() {
        for (Birds bird : birds) {
            if (bird instanceof Parrots) {
                Assert.assertEquals(expectedSaying.get(bird), ((Parrots) bird).getFavoritePhrase());
            }

        }
    }
}
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<Birds> {
    @Override
    public int compare(Birds b1, Birds b2) {
        return b1.getBirdName().compareTo(b2.getBirdName());
    }
}

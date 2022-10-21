package questions;

public interface Question extends Comparable{
    String getText();

    String answer(String string);

    int getOrder();

    QuestionType getType();
}

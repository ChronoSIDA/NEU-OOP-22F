package questions;

public class TrueFalse implements Question{
    private String text;
    private String answer;
    private int order;

    public TrueFalse(String text, String answer) {
        this.text = text;
        this.answer = answer;
        this.order = 1;
    }
    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public QuestionType getType() {
        return QuestionType.TRUE_FALSE;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String answer(String text) {
        if (text == answer){
            return "Correct";
        }
        return "Incorrect";
    }

    @Override
    public int compareTo(Object o) {
        Question question = (Question) o;
        if(question.getType() == QuestionType.TRUE_FALSE) {
            if(this.text.compareTo(question.getText()) > 0){
                return 1;
            } else if (this.text.compareTo(question.getText()) < 0 ){
                return -1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}

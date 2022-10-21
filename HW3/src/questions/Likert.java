package questions;

public class Likert implements Question{
    private String text;
    private int order;

    public Likert(String text){
        this.text = text;
        this.order = 4;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public QuestionType getType() {
        return QuestionType.LIKERT;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String answer(String likertText) {
        int likertNum = Integer.parseInt(likertText);
        if (likertNum < 1 || likertNum > 5){
            return "Incorrect";
        } else{
            return "Correct";
        }
    }


    @Override
    public int compareTo(Object o) {
        Question question = (Question) o;
        if(question.getType() == QuestionType.LIKERT) {
            if(this.text.compareTo(question.getText()) > 0){
                return 1;
            } else if (this.text.compareTo(question.getText()) < 0 ){
                return -1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }
}

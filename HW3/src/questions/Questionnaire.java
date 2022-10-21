package questions;

import java.util.List;

public class Questionnaire implements Question{
    private List<Question> questionList;
    private Question question;
    private int order;



    public Questionnaire(Question q, List questionList) {
        this.question = q;
        this.questionList = questionList;
        System.out.println(this.questionList);
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public QuestionType getType() {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String answer(String text) {
        return text;
    }

    @Override
    public int compareTo(Object o) {
        int order = this.question.getOrder();
        if(o instanceof Question){
            Question question = (Question) o;
            if (order > question.getOrder()){
                return 1;
            } else if (order < question.getOrder()){
                return -1;
            } else {
                return 0;
            }
        } else {
            throw new IllegalArgumentException("Wrong order questions");
        }
    }
}

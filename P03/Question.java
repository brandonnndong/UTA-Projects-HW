 public class Question{
    public Question(String question, String[] answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    /*  private static int nextQuestionNumber = 1;
    public boolean checkAnswer(int answer){

    }*/
    @Override
    public String toString(){
        return questionNumber + question + "\n" + answers + "\n\n" + "Your answer? ";
    }

    private final int questionNumber;
    private String question;
    private String[] answers;
    private int rightAnswer;

 }


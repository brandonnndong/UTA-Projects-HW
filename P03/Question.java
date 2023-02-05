 class Question{
    private int nextQuestionNumber;
    private final int questionNumnber;
    private String question;
    private String[] answers;
    private int rightAnswers;

    public Question(String question, String[] answers, int rightAnswers){
        this.question = question;
        this.answers = answers;
        this.rightAnswers = rightAnswers;
    }

    public boolean checkAnswer(int answer){

    }
    @Override
    public String toString(){
        return questionNumber + question + "\n" + answers + "\n" + "Your answer? ";
    }


 }

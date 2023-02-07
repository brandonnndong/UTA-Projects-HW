public class Question{
    public Question(String question, String answers, int rightAnswer){
        Question.question = question;
        this.answers = answers;
    }
        

    public static Question[] question(){
        Question[] question = new Question[2];
        question[0] = new Question("1. What is 4 x 4?", "1) 16\n2) 24\n3) 36\n4) 84", 1);
        question[0] = new Question("2. When did Great Britain burn down the White House?", "1) 2016\n2) 1924\n3) 1936\n4) 1812", 4);
        return question;
    }

    /*public boolean checkAnswer(int answer){

    }*/
    @Override
    public String toString(){
        return question + "\n" + answers + "\n\n" + "Your answer? ";
    }


    static String question;
    String answers;

 }


package full_credit;
public class Quizzer{
    public static void main(String[] args){
        Quiz quiz = new Quiz();
        try{
            quiz.takeQuiz();

    }catch(IllegalArgumentException e){
        System.err.println("Invalid input");
    }
}
} 

public class Quizzer{
    public static void main(String[] args){
    try{
    Quiz quiz = new Quiz();
    quiz.takeQuiz();

    }catch(IllegalArgumentException e){
        System.err.println("Invalid input");
    }
}
} 

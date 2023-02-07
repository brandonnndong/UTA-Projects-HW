public class Quizzer{
    public static void main(String[] args){
    try{

    Quiz.takeQuiz();

    }catch(IllegalArgumentException e){
        System.err.println("Invalid input");
    }
}
} 

import java.util.Scanner;

public class Quiz{
	public Quiz(){
		Quiz.loadQuiz();
	}
	private static void loadQuiz(){
		Question.question();
		Quiz.takeQuiz();
	}
	
	public static void takeQuiz(Question [] questions){
		int score = 0;
		try (Scanner proposedAnswer = new Scanner(System.in)) {
			for(int i = 0; i < questions.length; i++){
				System.out.println(Question.question());
				String answers =  proposedAnswer.nextLine();
				if(answers.equals(questions[i].answers)){
					score++;
				}
			}
		} 
			System.out.println("Your grade is: " + score);
	}
    public static void takeQuiz() {
    }
 	
 }

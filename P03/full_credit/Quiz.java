package full_credit;
import java.util.Scanner;

class Quiz{
	public Quiz(){
		loadQuiz();
	}
	private static void loadQuiz(){
		Question.question();
		Quiz quiz = new Quiz();
		quiz.takeQuiz();
	}
	
	public void takeQuiz(){
		int score = 0;
		try (Scanner proposedAnswer = new Scanner(System.in)) {
			for(int i = 0; i < 2; i++){
				int givenAnswer = proposedAnswer.nextInt(); proposedAnswer.nextLine();
				if(givenAnswer == 1){
					score++;
				}
			}
		}
			System.out.println("Your grade is: " + score);
		} 
	}
    
 	
 

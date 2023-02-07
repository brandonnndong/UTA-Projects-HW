import java.util.Scanner;

public class Quiz{
	public Quiz(){
		Quiz.loadQuiz();
	}
	private static void loadQuiz(){
		String Question1 = "What is 4 x 4" + "A. 16\nB. 34\nC. 24\nD. 64";
		String Question2 = "What is 4 x 4" + "A. 16\nB. 34\nC. 24\nD. 64";
		question [] questions  = {
			new question(Question1, "A"),
			new question(Question2, "D")};
		takeQuiz(questions);
	}
	
	public static void takeQuiz(Question [] questions){
		int score = 0;
		Scanner proposedAnswer = new Scanner(System.in); 
			for(int i = 0; i < questions.length; i++){
				System.out.println(questions[i].question);
				String answers =  proposedAnswer.nextLine();
				if(answers.equals(questions[i].answers)){
					score++;
				}
			}
		

		System.out.println("Your grade is: " + score);
	}
    public void takeQuiz() {
    }
 	
 }

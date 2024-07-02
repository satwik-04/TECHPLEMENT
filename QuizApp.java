package quiz;

import java.util.Scanner;

public class QuizApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizGenerator quizGenerator = new QuizGenerator();
        QuizTaker quizTaker = new QuizTaker();

        while (true) {
            System.out.println("1. Create Quiz");
            System.out.println("2. Add Question to Quiz");
            System.out.println("3. Take Quiz");
            System.out.println("4. List All Quizzes");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter quiz topic: ");
                    String topic = sc.nextLine();
                    System.out.print("Enter maximum number of questions: ");
                    int maxQuestions = sc.nextInt();
                    sc.nextLine();
                    quizGenerator.createQuiz(topic, maxQuestions);
                    break;
                case 2:
                    System.out.print("Enter quiz topic: ");
                    topic = sc.nextLine();
                    if (quizGenerator.getQuizzes().containsKey(topic)) {
                        System.out.print("Enter question: ");
                        String questionText = sc.nextLine();
                        System.out.print("Enter number of options: ");
                        int numOptions = sc.nextInt();
                        sc.nextLine(); 
                        String[] options = new String[numOptions];
                        for (int i = 0; i < numOptions; i++) {
                            System.out.print("Enter option " + (i + 1) + ": ");
                            options[i] = sc.nextLine();
                        }
                        System.out.print("Enter correct answer (1-" + numOptions + "): ");
                        int correctAnswer = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        quizGenerator.addQuestionToQuiz(topic, questionText, options, correctAnswer);
                    } else {
                        System.out.println("Quiz does not exist for topic: " + topic);
                    }
                    break;
                case 3:
                    System.out.print("Enter quiz topic: ");
                    topic = sc.nextLine();
                    Quiz quiz = quizGenerator.getQuiz(topic);
                    if (quiz != null) {
                        quizTaker.takeQuiz(quiz);
                    } else {
                        System.out.println("Quiz does not exist for topic: " + topic);
                    }
                    break;
                case 4:
                    System.out.println("Available quizzes:");
                    for (String quizTopic : quizGenerator.getQuizzes().keySet()) {
                        System.out.println("- " + quizTopic);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

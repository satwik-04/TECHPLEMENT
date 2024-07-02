package quiz;

import java.util.Scanner;

public class QuizTaker {
    public static void takeQuiz(Quiz quiz) {
        Scanner sc = new Scanner(System.in);
        Question[] questions = quiz.getQuestions();
        int score = 0;

        for (int i = 0; i < quiz.getcount(); i++) {
            Question question = questions[i];
            System.out.println(question.questionText);
            for (int j = 0; j < question.options.length; j++) {
                System.out.println((j + 1) + ". " + question.options[j]);
            }
            System.out.print("Your answer: ");
            int answer = sc.nextInt();
            if (answer == question.correctAnswer) {
                score++;
            }
        }

        System.out.println("You scored: " + score + "/" + quiz.getcount());
    }
}
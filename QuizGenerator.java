package quiz;

import java.util.HashMap;
import java.util.Map;

public class QuizGenerator {
    private Map<String, Quiz> quizzes;

    public QuizGenerator() {
        quizzes = new HashMap<>();
    }

    public void createQuiz(String topic, int maxQuestions) {
        if (!quizzes.containsKey(topic)) {
            quizzes.put(topic, new Quiz(topic, maxQuestions));
            System.out.println("Quiz created for topic: " + topic);
        } else {
            System.out.println("Quiz already exists for topic: " + topic);
        }
    }

    public void addQuestionToQuiz(String topic, String questionText, String[] options, int correctAnswer) {
        if (quizzes.containsKey(topic)) {
            Quiz quiz = quizzes.get(topic);
            quiz.addQuestion(new Question(questionText, options, correctAnswer));
            System.out.println("Question added to quiz: " + topic);
        } else {
            System.out.println("Quiz does not exist for topic: " + topic);
        }
    }

    public Quiz getQuiz(String topic) {
        return quizzes.get(topic);
    }

    public Map<String, Quiz> getQuizzes() {
        return quizzes;
    }
}

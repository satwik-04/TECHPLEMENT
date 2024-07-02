package quiz;

public  class Quiz {
    String topic;
    Question[] questions;
    int count;

    public Quiz(String topic, int maxQuestions) {
        this.topic = topic;
        this.questions = new Question[maxQuestions];
        this.count = 0;
    }

    public void addQuestion(Question question) {
        if (count < questions.length) {
            questions[count++] = question;
        } else {
            System.out.println("Quiz is full. Cannot add more questions.");
        }
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getcount() {
        return count;
    }

    public String getTopic() {
        return topic;
    }
}
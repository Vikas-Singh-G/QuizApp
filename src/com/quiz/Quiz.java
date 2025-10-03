package com.quiz;

import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score = 0;
    private Scanner scanner = new Scanner(System.in);

    public Quiz() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
            "What are Java loops?",
            List.of("1. Conditional statements", "2. Repetitive execution blocks", "3. Data structures", "4. None of the above"),
            2
        ));

        questions.add(new Question(
            "What is an enhanced for-loop?",
            List.of("1. A loop for integers", "2. Loop used for collections/arrays", "3. Deprecated loop", "4. None"),
            2
        ));

        questions.add(new Question(
            "How is a switch-case different from if-else?",
            List.of("1. Faster and cleaner", "2. Slower", "3. Replaces while loop", "4. None"),
            1
        ));
    }

    public void startQuiz() {
        System.out.println("🎓 Welcome to the Java Quiz! 🎓\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.getQuestion());

            for (int j = 0; j < q.getOptions().size(); j++) {
                System.out.println(q.getOptions().get(j));
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            if (answer == q.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println(" Wrong. Correct answer was: " + q.getCorrectOption() + "\n");
            }
        }

        showResult();
    }

    private void showResult() {
        System.out.println(" Quiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println(" Excellent work!");
        } else if (score >= questions.size() / 2) {
            System.out.println(" Good job! Keep practicing.");
        } else {
            System.out.println(" Review your Java basics and try again.");
        }
    }
}

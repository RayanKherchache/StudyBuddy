package StudyBuddy;
import java.util.Scanner;

public class Question implements StudyItem {
    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question(String q, String[] opts, char correct) {
        questionText = q;
        options = opts;
        correctAnswer = Character.toUpperCase(correct);
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (String opt : options) {
            System.out.println(opt);
        }
    }

    /**
     * Affiche la question et lit la réponse.
     * Retourne :
     *   - true si bonne réponse
     *   - false si mauvaise réponse
     *   - null si l'utilisateur a quitté
     */
    public Boolean interact() {
        display();
        Scanner sc = new Scanner(System.in);

        System.out.print("Your answer (A/B/C/D or -1 to quit): ");

        long start = System.currentTimeMillis();
        String input = sc.nextLine();
        long elapsed = System.currentTimeMillis() - start;

        if (input.equals("-1")) {
            return null; // signaler qu'on a quitté
        }

        if (elapsed > 8000) {
            System.out.println("⏱ Time's up!");
            return false;
        }

        char answer = Character.toUpperCase(input.charAt(0));
        if (answer == correctAnswer) {
            System.out.println("✅ Correct!");
            return true;
        } else {
            System.out.println("❌ Incorrect. Correct answer: " + correctAnswer);
            return false;
        }
    }
}

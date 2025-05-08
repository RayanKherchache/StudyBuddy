package StudyBuddy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudyBuddy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🎉 BANNIÈRE STYLED
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║         📚 Welcome to StudyBuddy      ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("Your personal Java quiz & flashcard app!\n");

        // 🌟 MENU LOOP
        while (true) {
            System.out.println("🔹 Please select a mode:");
            System.out.println("   1️⃣  Quiz Mode");
            System.out.println("   2️⃣  Flashcard Mode");
            System.out.println("   3️⃣  Quit");
            System.out.print("👉 Your choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    launchQuiz();
                    break;
                case "2":
                    launchFlashcards();
                    break;
                case "3":
                    System.out.println("\n👋 Thanks for using StudyBuddy. Good luck in your studies!");
                    return;
                default:
                    System.out.println("❌ Invalid input. Please enter 1, 2, or 3.\n");
            }

            System.out.println("─────────────────────────────────────\n");
        }
    }

    // 🎯 Quiz logic
    public static void launchQuiz() {
        try {
            ArrayList<Question> questions = FileLoader.loadQuestions("Data/questions.txt");
            Collections.shuffle(questions);

            int score = 0;
            int asked = 0;

            System.out.println("\n⏳ You have 8 seconds to answer each question. Are you ready?");

            for (Question q : questions) {
                Boolean result = q.interact();

                if (result == null) {
                    System.out.println("\n👋 You exited the quiz early.");
                    System.out.println("📊 Your score was " + score + " / " + asked);
                    return;
                }

                if (result) score++;
                asked++;
            }

            System.out.println("\n✅ Quiz completed!");
            System.out.println("📊 Your final score: " + score + " / " + questions.size());

        } catch (Exception e) {
            System.out.println("❌ Error loading quiz questions: " + e.getMessage());
        }
    }

    // 📘 Flashcard logic
    public static void launchFlashcards() {
        try {
            ArrayList<Flashcard> flashcards = FileLoader.loadFlashcards("Data/flashcards.txt");
            for (Flashcard f : flashcards) {
                f.interact();
            }
        } catch (Exception e) {
            System.out.println("❌ Error loading flashcards: " + e.getMessage());
        }
    }
}

package StudyBuddy;
import java.util.Scanner;

public class Flashcard implements StudyItem {
    private String front;
    private String back;

    public Flashcard(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public void display() {
        System.out.println("\n🧠 " + front);
    }

    public Boolean interact() {
        display();
        Scanner sc = new Scanner(System.in);

        System.out.print("(Press Enter to show the answer)");
        long start = System.currentTimeMillis();
        sc.nextLine();
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("💡 Answer: " + back);
        System.out.printf("⏱ It took you %.2f seconds to reveal the answer.%n", elapsed / 1000.0);
        return null;
    }
}

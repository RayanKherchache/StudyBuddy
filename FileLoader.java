package StudyBuddy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileLoader {

    public static ArrayList<Question> loadQuestions(String filename) throws Exception {
        ArrayList<Question> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 6) {
                String[] opts = { parts[1], parts[2], parts[3], parts[4] };
                list.add(new Question(parts[0], opts, parts[5].charAt(0)));
            }
        }
        br.close();
        return list;
    }

    public static ArrayList<Flashcard> loadFlashcards(String filename) throws Exception {
        ArrayList<Flashcard> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 2)
                list.add(new Flashcard(parts[0], parts[1]));
        }
        br.close();
        return list;
    }
}

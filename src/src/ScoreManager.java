package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreManager {
    private static final String SCORES_FILE = "scores.txt";
    private List<Score> highScores;

    public ScoreManager() {
        highScores = loadScores();
    }

    public void addScore(String playerName, int score) {
        Score newScore = new Score(playerName, score);
        highScores.add(newScore);


        Collections.sort(highScores, new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                return Integer.compare(s2.getScore(), s1.getScore());
            }
        });


        if (highScores.size() > 10) {
            highScores = highScores.subList(0, 10);
        }

        saveScores();
    }

    public List<Score> getHighScores() {
        return new ArrayList<>(highScores);
    }

    private List<Score> loadScores() {
        List<Score> scores = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SCORES_FILE))) {
            scores = (List<Score>) ois.readObject();
        } catch (FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scores;
    }

    private void saveScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SCORES_FILE))) {
            oos.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
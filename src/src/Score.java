package src;

import java.io.Serializable;

public class Score implements Serializable {
    private String playerName;
    private int currentScore;
    private long timestamp;

    public Score(String playerName) {
        this.playerName = playerName;
        this.currentScore = 0;
        this.timestamp = System.currentTimeMillis();
    }

    public Score(String playerName, int score) {
        this.playerName = playerName;
        this.currentScore = score;
        this.timestamp = System.currentTimeMillis();
    }

    public void increaseScore() {
        currentScore++;
    }

    public void resetScore() {
        currentScore = 0;
    }

    public int getScore() {
        return currentScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void increaseScore(int points) {
        currentScore += points;
    }

    @Override
    public String toString() {
        return playerName + ": " + currentScore;
    }
}

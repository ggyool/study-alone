package score_example;

import subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord extends Subject {
    private final List<Integer> scores = new ArrayList<>();

    public void addScore(int score) {
        scores.add(score);
        notifyObservers();
    }

    public List<Integer> getScores() {
        return scores;
    }
}

package score_example;

import subject.Observer;

import java.util.Collections;
import java.util.List;

public class MinMaxView implements Observer {
    private final ScoreRecord scoreRecord;

    public MinMaxView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        displayMinMax(scores);
    }

    private void displayMinMax(List<Integer> scores) {
        int min = Collections.min(scores);
        int max = Collections.max(scores);
        System.out.println("최소값:" + min + " 최대값:" + max);
    }
}

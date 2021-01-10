package score_example;

import subject.Observer;

import java.util.List;

public class DataSheetView implements Observer {
    private final ScoreRecord scoreRecord;
    private final int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        displayScores(scores);
    }

    private void displayScores(List<Integer> scores) {
        for (int i = 0; i < viewCount && i < scores.size(); i++) {
            System.out.print(scores.get(i) + " ");
        }
        System.out.println();
    }
}

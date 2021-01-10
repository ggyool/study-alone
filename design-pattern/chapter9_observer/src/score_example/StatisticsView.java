package score_example;

import subject.Observer;

import java.util.List;

public class StatisticsView implements Observer {
    private final ScoreRecord scoreRecord;

    public StatisticsView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        displayStatistics(scores);
    }

    private void displayStatistics(List<Integer> scores) {
        int sum = scores.stream()
                .reduce(0, Integer::sum);
        double average = (double) sum / scores.size();

        System.out.println("합계:" + sum + " 평균:" + average);
    }
}

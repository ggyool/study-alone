package score_example;

public class Main {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attach(dataSheetView5);
        scoreRecord.attach(minMaxView);

        for (int i = 1; i <= 5 ; i++) {
            int score = i * 10;
            scoreRecord.addScore(score);
        }

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();
        scoreRecord.detach(dataSheetView5);

        StatisticsView statisticsView = new StatisticsView(scoreRecord);
        scoreRecord.attach(statisticsView);

        for (int i = 6; i <= 10 ; i++) {
            int score = i * 10;
            scoreRecord.addScore(score);
        }
    }
}

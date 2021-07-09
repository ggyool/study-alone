package modernjavainaction.practice;

import java.util.Arrays;

public enum Grade {
    A(95),
    B(90),
    C(80),
    D(70),
    F(0);

    private final int minScore;

    Grade(final int minScore) {
        this.minScore = minScore;
    }

    public boolean isSatisfied(final int score) {
        return score >= this.minScore;
    }

    public static Grade getGradeByScore(final int score) {
        return Arrays.stream(values())
                .filter(grade -> grade.isSatisfied(score))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("음수"));
    }
}

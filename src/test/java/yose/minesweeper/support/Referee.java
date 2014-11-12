package yose.minesweeper.support;

public class Referee {

    private Athlete athlete;

    public Referee judging(Athlete athlete) {
        this.athlete = athlete;
        return this;
    }

    public void expectsToSeeTheMinesweeperTitle() {
        athlete.page.displaysTheCorrectTitle();
    }

    public void expectsToSeeTheGrid() {
        athlete.page.displaysTheCorrectGrid();
    }
}

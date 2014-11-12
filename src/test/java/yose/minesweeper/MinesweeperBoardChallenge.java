package yose.minesweeper;

import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YosePlayer;
import yose.minesweeper.support.Referee;
import yose.minesweeper.support.Athlete;

public class MinesweeperBoardChallenge {

    private Athlete athlete;
    private Referee referee;

    @Before
    public void startPerformance() throws Exception {
        athlete = new Athlete(new YosePlayer(new GsonBuilder().setPrettyPrinting().create()));
        referee = new Referee().judging(athlete);
        athlete.startPerformance();
    }

    @After
    public void leaveStage() throws Exception {
        athlete.leaveStage();
    }

    @Test
    public void displaysExpectedTitle() {
        athlete.performsTitleMovement();
        referee.expectsToSeeTheMinesweeperTitle();
    }

    @Test
    public void displaysTheExpectedGrid() {
        athlete.performsGridMovement();
        referee.expectsToSeeTheGrid();
    }
}

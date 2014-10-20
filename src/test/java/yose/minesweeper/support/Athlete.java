package yose.minesweeper.support;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import com.vtence.molecule.WebServer;
import org.openqa.selenium.firefox.FirefoxDriver;
import yose.YosePlayer;
import yose.minesweeper.support.MinesweeperPage;

public class Athlete {

    public static final int PORT = 9999;
    private final WebServer server;
    private final YosePlayer yosePlayer;
    public final AsyncWebDriver browser;

    public MinesweeperPage page;

    public Athlete(YosePlayer yosePlayer) {
        this.yosePlayer = yosePlayer;
        this.server = WebServer.create(PORT);
        this.browser = new AsyncWebDriver(new UnsynchronizedProber(), new FirefoxDriver());

    }

    public void startPerformance() throws Exception {
        yosePlayer.start(server);
    }

    public void leaveStage() throws Exception {
        server.stop();
        browser.quit();
    }

    public String baseUrl() {
        return "http://localhost:" + PORT;
    }

    public void performsTitleMovement() {
        navigateToMinesweeperPage();
    }

    public void performsGridMovement() {
        navigateToMinesweeperPage();
    }

    protected void navigateToMinesweeperPage() {
        browser.navigate().to(baseUrl() + "/minesweeper");
        page = new MinesweeperPage(browser);
    }
}

package yose.minesweeper.support;

import com.objogate.wl.web.AsyncWebDriver;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.equalTo;

public class MinesweeperPage {

    private AsyncWebDriver browser;

    public MinesweeperPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public void displaysTheCorrectTitle() {
        browser.element(By.id("title")).assertText(equalTo("Minesweeper"));
    }

    public void displaysTheCorrectGrid() {
        browser.element(By.id("cell-1x1")).assertExists();
    }
}

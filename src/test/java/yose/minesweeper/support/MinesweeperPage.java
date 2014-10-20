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
        browser.assertTitle(equalTo("Minesweeper"));
    }

    public void displaysTheCorrectGrid() {
        browser.element(By.id("cell-1x1")).assertExists();
        browser.element(By.id("cell-8x8")).assertExists();
        browser.element(By.id("cell-2x3")).assertExists();
    }
}

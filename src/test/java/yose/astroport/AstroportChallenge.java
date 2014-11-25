package yose.astroport;

import com.google.gson.GsonBuilder;
import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import com.vtence.molecule.WebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import yose.YosePlayer;

import java.io.IOException;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class AstroportChallenge {

    public static final int PORT = 9999;
    private WebServer server;
    private YosePlayer yosePlayer;
    private AsyncWebDriver browser;

    @Before
    public void start() throws IOException {
        yosePlayer = new YosePlayer( new GsonBuilder().setPrettyPrinting().create() );
        server = WebServer.create( PORT );
        yosePlayer.start( server );
        browser = new AsyncWebDriver( new UnsynchronizedProber(), new PhantomJSDriver() );
    }

    @After
    public void stop() throws IOException {
        server.stop();
        browser.quit();
    }

    @Test
    public void displaysAstroportName() {
        browser.navigate().to( baseUrl() + "/astroport" );

        browser.element( By.id( "astroport-name" ) ).assertExists();
        browser.element( By.id( "astroport-name" ) ).assertText( not( isEmptyString() ) );
    }

    public String baseUrl() {
        return "http://localhost:" + PORT;
    }
}

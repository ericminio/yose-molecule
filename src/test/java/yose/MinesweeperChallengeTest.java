package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.support.HttpRequest;
import com.vtence.molecule.support.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;

public class MinesweeperChallengeTest {

    int PORT = 9999;
    WebServer server = WebServer.create(PORT);

    HttpRequest request = new HttpRequest(PORT);
    HttpResponse response;

    Yose yose = new Yose(new Gson());

    @Before
    public void startGame() throws Exception {
        yose.start(server);
    }

    @After
    public void stopGame() throws Exception {
        server.stop();
    }

    @Test
    public void passesTheBoardChallenge() throws IOException {
        response = request.get("/minesweeper");
        response.assertOK();
        response.assertHasContentType("text/html");
        response.assertHasContent(containsString("<title>Minesweeper</title>"));
    }
}

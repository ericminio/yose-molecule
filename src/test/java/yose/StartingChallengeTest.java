package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.support.HttpRequest;
import com.vtence.molecule.support.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;

public class StartingChallengeTest {

    YosePlayer yosePlayer = new YosePlayer(new Gson());
    WebServer server = WebServer.create(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yosePlayer.start(server);
    }

    @After
    public void stopGame() throws Exception {
        server.stop();
    }

    @Test
    public void passesHelloChallenge() throws IOException {
        response = request.get("/");
        response.assertOK();
        response.assertHasContent(containsString("Hello Yose"));
    }

    @Test
    public void passesPingChallenge() throws IOException {
        response = request.get("/ping");
        response.assertOK();
        response.assertHasContentType("application/json");
        response.assertHasContent("{\"alive\":true}");
    }
}
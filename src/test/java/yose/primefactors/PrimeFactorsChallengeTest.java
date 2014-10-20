package yose.primefactors;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.support.HttpRequest;
import com.vtence.molecule.support.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YosePlayer;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class PrimeFactorsChallengeTest {

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
    public void passesPowerOfTwoChallenge() throws IOException {
        response = request.get("/primeFactors?number=8");
        response.assertOK();
        response.assertHasContentType("application/json");
        response.assertHasContent(equalTo("{\"number\":8,\"decomposition\":[2,2,2]}"));
    }
}

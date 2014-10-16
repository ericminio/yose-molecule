package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.support.HttpRequest;
import com.vtence.molecule.support.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class PrimeFactorsChallengeTest {

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
    public void passesPowerOfTwoChallenge() throws IOException {
        response = request.get("/primeFactors?number=8");
        response.assertOK();
        response.assertHasContentType("application/json");
        response.assertHasContent("{\"number\":8}");
        response.assertHasContent("{\"decomposition\":[2,2,2]}");
    }
}

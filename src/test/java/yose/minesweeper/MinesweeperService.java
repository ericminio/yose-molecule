package yose.minesweeper;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.support.HttpRequest;
import com.vtence.molecule.support.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YosePlayer;

import java.io.IOException;

public class MinesweeperService {

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
    public void isOnline() throws IOException {
        response = request.get("/minesweeper");
        response.assertOK();
    }

    @Test
    public void respondsWithHtml() throws IOException {
        response = request.get("/minesweeper");
        response.assertHasContentType("text/html");
    }
}

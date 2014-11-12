package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.support.HttpRequest;
import com.vtence.molecule.support.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YosePlayerTest {

    YosePlayer yosePlayer = new YosePlayer(new Gson());
    WebServer server = WebServer.create(9999);
    private String staticAssetsFolder = "src/test/data";

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yosePlayer.serveStaticAssetsInFolder(staticAssetsFolder);
        yosePlayer.start(server);
    }

    @After
    public void stopGame() throws Exception {
        server.stop();
    }

    @Test
    public void canServeJs() throws IOException {
        new File(staticAssetsFolder + "/js").mkdir();
        createFileWithGivenContent(new File(staticAssetsFolder + "/js/js-file"), "this is a js file");
        response = request.get("/js/js-file");

        response.assertOK();
        response.assertHasContent("this is a js file");
    }

    @Test
    public void canServeCss() throws IOException {
        new File(staticAssetsFolder + "/css").mkdir();
        createFileWithGivenContent(new File(staticAssetsFolder + "/css/css-file"), "this is a css file");
        response = request.get("/css/css-file");

        response.assertOK();
        response.assertHasContent("this is a css file");
    }

    @Test
    public void servesStaticContentInWebappFolder() {
        assertThat(new YosePlayer(null).staticAssetsPath, equalTo("src/main/webapp/"));
    }

    protected void createFileWithGivenContent(File file, String content) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}

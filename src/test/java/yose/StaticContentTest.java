package yose;

import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import com.vtence.molecule.http.HttpStatus;
import com.vtence.molecule.middlewares.FileServer;
import com.vtence.molecule.middlewares.StaticAssets;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StaticContentTest {

    @Test
    public void canServeJs() throws Exception {
        StaticAssets middleware = new StaticAssets(new FileServer(new File("webapp")), "/js");
        Request request = new Request().path("/css/any.js");
        Response response = new Response();
        middleware.handle(request, response);

        assertThat(response.statusCode(), equalTo(HttpStatus.OK.code));
    }
}

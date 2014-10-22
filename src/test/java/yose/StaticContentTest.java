package yose;

import com.vtence.molecule.middlewares.FileServer;
import com.vtence.molecule.middlewares.StaticAssets;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StaticContentTest {

    @Test
    public void canServeJs() {
        StaticAssets middleware = new StaticAssets(new FileServer(new File("webapp")), "/js");

        //assertThat(middleware.canServe(request), equalTo(true));
    }
}

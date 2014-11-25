package yose;

import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Astroport {

    public void page(Request request, Response response) {
        try {
            List<String> lines = Files.readAllLines( Paths.get( "src/main/webapp/views/astroport.html" ), StandardCharsets.UTF_8 );
            response.contentType("text/html").body(lines.stream().collect( Collectors.joining( "\n" )));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

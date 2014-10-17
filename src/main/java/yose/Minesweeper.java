package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Minesweeper {

    private Gson gson;

    public Minesweeper(Gson gson) {
        this.gson = gson;
    }

    public void page(Request request, Response response) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/webapp/views/minesweeper.html"));
            response.contentType("text/html").body(lines.stream().collect(Collectors.joining("\n")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

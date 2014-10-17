package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

public class Minesweeper {

    private Gson gson;

    public Minesweeper(Gson gson) {
        this.gson = gson;
    }

    public void page(Request request, Response response) {
        response.contentType("text/html");
    }
}

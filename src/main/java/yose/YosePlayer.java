package yose;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.middlewares.FileServer;
import com.vtence.molecule.middlewares.StaticAssets;

import java.io.File;
import java.io.IOException;

public class YosePlayer {
    private final Gson gson;

    public YosePlayer(Gson gson) {
        this.gson = gson;
    }

    public void start(WebServer server) throws IOException {
        server.add(new StaticAssets(new FileServer(new File("src/main/webapp/")), "/js"))
              .start(new Routes(gson));
    }

    private static final int PORT = 0;

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    public static void main(String[] args) throws IOException {
        WebServer server = WebServer.create(port(args));
        YosePlayer yosePlayer = new YosePlayer(new GsonBuilder().setPrettyPrinting().create());
        yosePlayer.start(server);
        System.out.println("Access at: " + server.uri());
    }
}
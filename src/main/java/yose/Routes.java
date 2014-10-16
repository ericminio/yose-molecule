package yose;

import com.google.gson.Gson;
import com.vtence.molecule.routing.DynamicRoutes;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class Routes extends DynamicRoutes {

    public Routes(Gson gson) {

        get("/ping").to((request, response) -> {
            response.contentType(JSON).body(gson.toJson(new Pong()));
        });

        get("/primeFactors").to((request, response) -> {
            response.contentType(JSON).body(gson.toJson(new PowerOfTwo(Integer.parseInt(request.parameter("number")))));
        });

        get("/").to((request, response) -> response.body("Hello Yose"));
    }
}

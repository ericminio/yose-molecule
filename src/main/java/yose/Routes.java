package yose;

import com.google.gson.Gson;
import com.vtence.molecule.routing.DynamicRoutes;

public class Routes extends DynamicRoutes {

    public Routes(Gson gson) {

        get("/ping").to(new Ping(gson)::pong);

        get("/primeFactors").to(new Primes(gson)::list);

        get("/").to((request, response) -> response.body("Hello Yose"));
    }
}

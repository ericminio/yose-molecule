package yose;

import com.google.gson.Gson;
import com.vtence.molecule.routing.DynamicRoutes;

public class Routes extends DynamicRoutes {

    public Routes(Gson gson) {

        get("/").to((request, response) -> response.body("Hello Yose"));
        get("/ping").to(new Ping(gson)::pong);
        get("/primeFactors").to(new Primes(gson)::list);
        get("/minesweeper").to(new Minesweeper(gson)::page);
    }
}

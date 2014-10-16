package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import java.io.IOException;
import java.util.List;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class Primes {

    private Gson gson;

    public Primes(Gson gson) {
        this.gson = gson;
    }

    public void list(Request request, Response response) throws IOException {
        int number = Integer.parseInt(request.parameter("number"));

        response.contentType(JSON).body(gson.toJson(new Decomposition(number, PrimeFactors.of(number))));
    }

    public class Decomposition {

        private int number;
        private List<Integer> decomposition;

        public Decomposition(int number, List<Integer> factors) {

            this.number = number;
            this.decomposition = factors;
        }
    }
}

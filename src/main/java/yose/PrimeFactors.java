package yose;

import java.util.ArrayList;
import java.util.List;


public class PrimeFactors {

    public static List<Integer> of(int number) {
        List<Integer> factors = new ArrayList<>();

        int factor = 2;
        while(number >1) {
            factors.add(factor);
            number /= factor;
        }

        return factors;
    }
}

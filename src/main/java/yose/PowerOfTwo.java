package yose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerOfTwo {

    protected Integer number;
    protected final List<Integer> decomposition;

    public PowerOfTwo(Integer number) {
        this.number = number;
        List<Integer> factors = new ArrayList<Integer>();

        int factor = 2;
        while(number >1) {
            factors.add(factor);
            number /= factor;
        }

        this.decomposition = factors;
    }
}

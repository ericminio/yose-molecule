package yose;

import java.util.Arrays;
import java.util.List;

public class PowerOfTwo {

    private Integer number;
    private final List<Integer> decomposition;

    public PowerOfTwo(Integer number) {
        this.number = number;
        this.decomposition = Arrays.asList(2, 2, 2);
    }
}

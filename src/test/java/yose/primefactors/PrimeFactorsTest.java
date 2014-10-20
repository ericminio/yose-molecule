package yose.primefactors;

import org.junit.Test;
import yose.PrimeFactors;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrimeFactorsTest {

    @Test
    public void computesThePowerOfTwoDecompositionOfTheGivenNumber() {
        assertThat(PrimeFactors.of(4), equalTo(Arrays.asList(2, 2)));
    }
}

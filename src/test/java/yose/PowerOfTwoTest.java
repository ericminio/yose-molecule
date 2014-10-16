package yose;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PowerOfTwoTest {

    private PowerOfTwo service;

    @Before
    public void thisService() {
        service = new PowerOfTwo(4);
    }

    @Test
    public void keepsTheGivenNumber() {
        assertThat(service.number, equalTo(4));
    }

    @Test
    public void computesThePowerOfTwoDecompositionOfTheGivenNumber() {
        assertThat(service.decomposition, equalTo(Arrays.asList(2, 2)));
    }
}

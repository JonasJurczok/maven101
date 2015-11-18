package de.zalando.mentoring;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void testDummy() {
        assertThat("Oh noe, dummy test failed :(", true, is(false));
    }

}

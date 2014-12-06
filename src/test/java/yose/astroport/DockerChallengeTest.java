package yose.astroport;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testinfected.hamcrest.dom.DomMatchers.*;
import static yose.astroport.support.ViewRenderer.render;

public class DockerChallengeTest {

    Element view;

    @Before
    public void thisPage() {
        view = render( "astroport" ).asDom();
    }

    @Test
    public void hasAShipField() {
        assertThat( view, hasUniqueSelector( "input#ship" ) );
    }

    @Test
    public void hasADockButton() {
        assertThat( view, hasUniqueSelector( "button#dock" ) );
    }
}

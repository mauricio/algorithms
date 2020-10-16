package io.github.mauricio.search;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class GraphsTest {

    @Test
    public void testShortestPath() {
        var bridge = new Node("Golden gate bridge");
        var bus28 =  new Node("Bus 28", bridge);
        var bus5l = new Node("Bus 5l", bus28);
        var bus33to5l = new Node("Bus 33 to 5l", bus5l);
        var bus38l = new Node("Bus 38l", bus28);
        var bus33to38l = new Node("Bus 33 to 38l", bus38l);
        var bus44 = new Node("Bus 44", bus28);
        var twinPeaks = new Node("Twin Peaks", bus33to5l, bus33to38l, bus44 );

        var result = Graphs.shortestPath(twinPeaks, bridge);
        assertEquals(Arrays.asList(twinPeaks, bus44, bus28, bridge), result);
    }

}

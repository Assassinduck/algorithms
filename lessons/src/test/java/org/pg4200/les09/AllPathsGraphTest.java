package org.pg4200.les09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllPathsGraphTest {

    private AllPathsGraph<String> createGraph() {
        AllPathsGraph<String> graph = new AllPathsGraph<>();

        graph.addEdge("0","X");
        graph.addEdge("X","1");
        graph.addEdge("X","Y");
        graph.addEdge("1","2");
        graph.addEdge("2","Y");
        graph.addEdge("1","3");
        graph.addEdge("3","4");
        graph.addEdge("3","5");
        graph.addEdge("4","5");

        return graph;

    }


    @Test
    public void testgraphLenght(){

        AllPathsGraph<String> graph = createGraph();

        List<List<String>> paths =  graph.findAllPaths("X", "5");

        assertEquals(4, paths.size());

        assertEquals(5, paths.get(0).size());
        assertEquals(4, paths.get(1).size());
        assertEquals(7, paths.get(2).size());
        assertEquals(6, paths.get(3).size());
    }
}

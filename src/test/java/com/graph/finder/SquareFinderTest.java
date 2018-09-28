package com.graph.finder;

import com.graph.exception.InvalidInputException;
import com.graph.model.Graph;
import com.graph.model.Square;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SquareFinderTest {

    private SquareFinder squareFinder = new SquareFinder();

    //******* SQUARE NAME TO COLUMN AND ROW TESTS **************

    @Test
    public void squareNameToColumnRowExpectMapThatContainsBoth() throws InvalidInputException {
        //Act
        Map<String, Integer> result = squareFinder.squareNameToColumnRow("b3");

        //Assert
        assertTrue(result.containsKey("column"));
        assertTrue(result.containsKey("row"));
        assertEquals(1, result.get("column").intValue());
        assertEquals(2, result.get("row").intValue());
    }

    @Test(expected = InvalidInputException.class)
    public void squareNameToColumnRowThrowsExceptionOnWrongName() throws InvalidInputException {
        squareFinder.squareNameToColumnRow("b33a");
    }


    //******* GET SQUARE TESTS **************

    @Test
    public void getSquare() throws InvalidInputException {
        //Arrange
        Graph graph = new Graph();

        //Act
        Square square = squareFinder.getSquare("A3", graph);

        //Assert
        assertEquals("A3", square.getName());
        assertEquals(Square.Status.NOT_INITIALIZED, square.getStatus());

    }


}

package com.graph.finder;

import com.graph.exception.InvalidInputException;
import com.graph.model.Graph;
import com.graph.model.Square;

import java.util.List;
import java.util.Map;

import static com.graph.converter.Converter.squareNameToColumnRow;

public class SquareFinder {

    private SquareFinder() {
        throw new IllegalStateException();
    }

    public static Square getSquare(String name, Graph graph) throws InvalidInputException {
        Map<String, Integer> coordinates = squareNameToColumnRow(name);
        List<Square> columns = graph.getTableOfSquares().get(coordinates.get("row"));
        return columns.get(coordinates.get("column"));
    }
}

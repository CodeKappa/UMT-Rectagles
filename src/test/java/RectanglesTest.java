import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RectanglesTest
{
    @ParameterizedTest
    @DisplayName("Tests countRectangles")
    @CsvSource(delimiter = '|', value = {
            " 3 | (1,1), (1,3), (2,1), (2,3), (3,1), (3,3)",
            " 1 | (1,1), (1,3), (2,1), (3,1), (3,3)",
            " 1 | (1,1), (1,2), (2,1), (2,2)",
            " 9 | (0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)",
            "15 | (0, 0), (0, 1), (1, 1), (1, 0), (2, 1), (2, 0), (3, 1), (3, 0), (4, 0), (4, 1), (5, 1), (5, 0)",
            "21 | (0, 0), (0, 1), (1, 1), (1, 0), (2, 1), (2, 0), (3, 1), (3, 0), (4, 0), (4, 1), (5, 1), (5, 0), (0, 2), (1, 2), (2, 2)",
            "45 | (0, 0), (0, 1), (1, 1), (1, 0), (2, 1), (2, 0), (3, 1), (3, 0), (4, 0), (4, 1), (5, 1), (5, 0), (0, 2), (1, 2), (2, 2), (3, 2), (4, 2), (5, 2)",
            " 0 | (0, 0)",
            " 0 | nothing",
            " 0 | (0, 0), (0, 2), (1, 1), (2, 0), (2, 1), (3, 0), (4, 0)",
            " 1 | (-1,-1), (-1, 2), (2,-1), (+2,+2)",

    })
    void countRectangles(int expectedRectangles, String input)
    {
        Set<Point> points = Rectangles.parseData(input);
        assertEquals(expectedRectangles, Rectangles.countRectangles(points));
    }
}
package Assignments.A1Exceptions.Shapes;

import Assignments.A1Exceptions.InvalidShapeParameterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleExceptionTest {

    @Test
    void createRectangles () throws InvalidShapeParameterException {
        Rectangle goodRectangle = new Rectangle(1.0,1.0);
        assertNotNull(goodRectangle);


        assertThrows(InvalidShapeParameterException.class, () -> {
            Rectangle badWidthRectangle = new Rectangle(1.0, -1.0);
        });

        assertThrows(InvalidShapeParameterException.class, ()-> {
            Rectangle badLengthRectangle = new Rectangle(-1.0,1.0);
        });
    }

}
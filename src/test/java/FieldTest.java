import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldTest {
    Field field;
    @BeforeEach
    void setUp() {
        field = new Field(3, 1, true, 1, 2);
    }

    @Test
    void testColor() {
        assertEquals(field.getColor(), Color.BLUE);
    }

    @Test
    void testEnable() {
        assertTrue(field.isEnabled());
    }
}

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {
    Map map;

    @Test
    public void checkMapFor2() {
        map = new Map(2);

        assertEquals(map.getField(2, 10).getColor(), Color.GREEN);
        assertEquals(map.getField(2, 12).getColor(), Color.GREEN);
        assertEquals(map.getField(2, 14).getColor(), Color.GREEN);
        assertEquals(map.getField(14, 10).getColor(), Color.RED);
        assertEquals(map.getField(14, 12).getColor(), Color.RED);
        assertEquals(map.getField(14, 14).getColor(), Color.RED);
    }

    @Test
    public void checkMapFor3() {
        map = new Map(3);

        assertEquals(map.getField(1, 11).getColor(), Color.GREEN);
        assertEquals(map.getField(1, 13).getColor(), Color.GREEN);
        assertEquals(map.getField(11, 23).getColor(), Color.RED);
        assertEquals(map.getField(12, 22).getColor(), Color.RED);
        assertEquals(map.getField(11, 1).getColor(), Color.BLUE);
        assertEquals(map.getField(12, 2).getColor(), Color.BLUE);
    }

    @Test
    public void checkMapFor4() {
        map = new Map(4);

        assertEquals(map.getField(0, 12).getColor(), Color.GREEN);
        assertEquals(map.getField(4, 24).getColor(), Color.RED);
        assertEquals(map.getField(12, 24).getColor(), Color.LIGHT_GRAY);
        assertEquals(map.getField(16, 12).getColor(), Color.BLUE);
        assertEquals(map.getField(12, 0).getColor(), Color.MAGENTA);
        assertEquals(map.getField(4, 0).getColor(), Color.LIGHT_GRAY);
    }

    @Test
    public void checkMapFor6() {
        map = new Map(6);

        assertEquals(map.getField(0, 12).getColor(), Color.GREEN);
        assertEquals(map.getField(4, 24).getColor(), Color.RED);
        assertEquals(map.getField(12, 24).getColor(), Color.BLUE);
        assertEquals(map.getField(16, 12).getColor(), Color.MAGENTA);
        assertEquals(map.getField(12, 0).getColor(), Color.ORANGE);
        assertEquals(map.getField(4, 0).getColor(), Color.CYAN);
    }
}

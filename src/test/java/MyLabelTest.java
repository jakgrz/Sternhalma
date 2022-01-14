import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLabelTest {
    MyLabel myLabel;

    @BeforeEach
    void setUp() {
        myLabel = new MyLabel();
    }

    @Test
    void testText() {
        myLabel.setText("Deithwen Addan yn Carn aep Morvudd");
        assertEquals(myLabel.getText(), "Deithwen Addan yn Carn aep Morvudd");
    }
}

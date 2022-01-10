import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Field extends Ellipse2D.Float {
    private boolean enabled;
    private Color color;
    private int colorNumber;

    public Field(int colorNumber, boolean enabled, double x, double y) {
        this.enabled = enabled;
        if (enabled) {
            this.setColor(colorNumber);
            this.setColorNumber(colorNumber);
            this.setFrame(x,y,30,30);
        }
    }

    public void setColor(int color) {
        switch (color) {
            case 0:
                this.color = Color.LIGHT_GRAY;
                break;
            case 1:
                this.color = Color.GREEN;
                break;
            case 2:
                this.color = Color.RED;
                break;
            case 3:
                this.color = Color.BLUE;
                break;
            case 4:
                this.color = Color.MAGENTA;
                break;
            case 5:
                this.color = Color.ORANGE;
                break;
            case 6:
                this.color = Color.CYAN;
                break;
            default:
                this.color = Color.BLACK;
        }
    }

    public Color getColor()
    {
        return this.color;
    }

    public int getColorNumber() {
        return this.colorNumber;
    }

    public void setColorNumber(int colorNumber) {
        this.colorNumber = colorNumber;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}

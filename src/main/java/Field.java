import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Objects of this class are fields on the game board
 */
public class Field extends Ellipse2D.Float {

    private boolean enabled;
    private Color color;
    private int colorNumber;
    private int destinationColor;

    /**
     * Constructor that creates the field with given color at given coordinates
     * @param colorNumber is the color id of pawn on this field
     * @param destinationColor is the color of pawn that should end here
     * @param enabled indicates whether this field is displayable
     * @param x is first coordinate of the field on the board
     * @param y is second coordinate of the field on the board
     */
    public Field(int colorNumber, int destinationColor, boolean enabled, double x, double y) {
        this.enabled = enabled;
        if (enabled) {
            this.setColor(colorNumber);
            this.destinationColor = destinationColor;
            this.setColorNumber(colorNumber);
            this.setFrame(x,y,30,30);
        }
    }

    /**
     * This method sets color of this field
     * @param color is an integer that sets the color of the field
     */
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

    /**
     * This method returns the current color of this field
     * @return color of the field
     */
    public Color getColor()
    {
        return this.color;
    }

    /**
     * This method returns the current color id of this field
     * @return color id of the field
     */
    public int getColorNumber() {
        return this.colorNumber;
    }

    /**
     * This method returns the destination color id of this field
     * @return destination color id of the field
     */
    public int getDestinationColor() {
        return this.destinationColor;
    }

    /**
     * This method sets the current color id of this field
     * @param colorNumber is the color id of the field
     */
    public void setColorNumber(int colorNumber) {
        this.colorNumber = colorNumber;
    }

    /**
     * This method returns the state of this field (availible / not aviailble)
     * @return state of the field
     */
    public boolean isEnabled() {
        return this.enabled;
    }
}

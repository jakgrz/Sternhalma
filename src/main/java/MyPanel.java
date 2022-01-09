import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener {
    private Map map;
    private Field tempField;

    MyPanel(Map map) {
        this.setPreferredSize(new Dimension(720,480));
        this.map = map;
        addMouseListener(this);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setStroke(new BasicStroke(6));
        //g2d.drawRect(12,12,100,100);
        //g2d.drawOval(20,20,100,100);
        //g2d.setPaint(Color.orange);
        //g2d.fillOval(20,20,100,100);

        /*Field field = new Field(null,false,5 + 35 * 0, 5 + 35 * 0);
        Field field2 = new Field(null,false,5 + 35 * 1, 5 + 35 * 0);
        Field field3 = new Field(null,false,5 + 35 * 2, 5 + 35 * 0);
        g2d.setPaint(field.getColor());
        g2d.fill(field);
        g2d.fill(field2);
        g2d.fill(field3);*/

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                tempField = map.getField(i, j);
                if (tempField.isEnabled()) {
                    g2d.setPaint(tempField.getColor());
                    g2d.fill(tempField);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*map.getField(10,10).setColor(5);
        repaint();*/
        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                if (map.getField(i,j).getBounds2D().contains(e.getX(),e.getY())) {
                    map.getField(i,j).setColor(6);
                    repaint();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

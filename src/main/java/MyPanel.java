import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener {
    private Map map;
    private MyLabel label;
    private Field tempField;
    private int activePlayer;
    private int numberOfPlayers;
    private boolean move;
    private int active_x, active_y;

    MyPanel(Map map, int numberOfPlayers, MyLabel myLabel) {
        this.setPreferredSize(new Dimension(720,480));
        this.map = map;
        this.numberOfPlayers = numberOfPlayers;
        addMouseListener(this);
        this.activePlayer = (int) Math.floor(Math.random() * numberOfPlayers) + 1;
        this.move = false;
        this.label = myLabel;
        myLabel.setText("Zaczyna gracz numer: " + this.activePlayer);
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
                    //map.getField(i,j).setColor(this.activePlayer);
                    //map.getField(i,j).setColorNumber(activePlayer);

                    //anulujemy ruch
                    if (map.getField(i,j).getColorNumber() == 10  && move == true) {
                        map.getField(i,j).setColor(activePlayer);
                        map.getField(i,j).setColorNumber(activePlayer);
                        move = false;
                        activePlayer++;
                        if (activePlayer > numberOfPlayers) {
                            activePlayer = 1;
                        }
                        label.setText("Ruch gracza numer: " + this.activePlayer);
                    }

                    //wybieramy pionek do ruchu i zaznaczamy go
                    if (map.getField(i,j).getColorNumber() == this.activePlayer && move == false) {
                        map.getField(i,j).setColor(10);
                        map.getField(i,j).setColorNumber(10);
                        active_x = i;
                        active_y = j;
                        move = true;
                    }

                    //ruszamy pionkiem
                    if (map.getField(i,j).getColorNumber() == 0 && move == true && ((active_x == i && Math.abs(active_y - j) == 2) || (Math.abs(active_x - i) == 1 && Math.abs(active_y - j) == 1))) {
                        map.getField(i,j).setColor(activePlayer);
                        map.getField(i,j).setColorNumber(activePlayer);
                        map.getField(active_x,active_y).setColor(0);
                        map.getField(active_x,active_y).setColorNumber(0);
                        move = false;
                        activePlayer++;
                        if (activePlayer > numberOfPlayers) {
                            activePlayer = 1;
                        }
                        label.setText("Ruch gracza numer: " + this.activePlayer);
                    }

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

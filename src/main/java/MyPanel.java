import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class MyPanel extends JPanel implements MouseListener {
    private Map map;
    private Field passButton;
    private MyLabel label;
    private Field tempField;
    private int activePlayer;
    private boolean move;
    private boolean jump;
    private int active_x, active_y;
    private int previous_x, previous_y;
    private Vector<Integer> players;
    private int playerIndex;
    private boolean gameFinished;
    private boolean mustJump;
    private Client client;
    private boolean active;

    MyPanel(Map map, int numberOfPlayers, MyLabel myLabel, Client client, int seed) {
        this.setPreferredSize(new Dimension(720,480));
        this.map = map;
        this.passButton = new Field(0,0,true,0,0);
        addMouseListener(this);
        this.playerIndex = seed;
        this.move = false;
        this.label = myLabel;
        this.gameFinished = false;
        this.mustJump = false;
        this.previous_x = -1;
        this.previous_y = -1;
        this.client = client;
        this.active = (client.getID() == seed + 1);
        players = new Vector<>();
        for (int i = 1; i <= numberOfPlayers; ++i) {
            players.add(i);
        }
        this.activePlayer = players.elementAt(playerIndex);

        repaint();
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(passButton.getColor());
        g2d.fill(passButton);

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

    private boolean validMove(int x_0, int y_0, int x_1, int y_1, int x_2, int y_2) {
        //sprawdzam czy nie wychodze z pola docelowego
        if (map.getField(x_0,y_0).getDestinationColor() == activePlayer && map.getField(x_1,y_1).getDestinationColor() != activePlayer)
            return false;

        //sprawdzam czy wykonany jest normalny ruch bez skokow
        if ((x_0 == x_1 && Math.abs(y_0 - y_1) == 2) || (Math.abs(x_0 - x_1) == 1 && Math.abs(y_0 - y_1) == 1))
            return true;

        //sprawdzam czy wykonany jest skok w lewo
        if ((x_1 != x_2 || y_1 != y_2) && x_0 == x_1 && y_0 - y_1 == 4 && (map.getField(x_1, y_1 + 2).getColorNumber() >= 1 && map.getField(x_1, y_1 + 2).getColorNumber() <= 6)) {
            jump = true;
            return true;
        }
        //sprawdzam czy wykonany jest skok w prawo
        if ((x_1 != x_2 || y_1 != y_2) && x_0 == x_1 && y_1 - y_0 == 4 && (map.getField(x_1, y_1 - 2).getColorNumber() >= 1 && map.getField(x_1, y_1 - 2).getColorNumber() <= 6)) {
            jump = true;
            return true;
        }
        //sprawdzam czy wykonany jest skok w lewo-gora
        if ((x_1 != x_2 || y_1 != y_2) && x_0 - x_1 == 2 && y_0 - y_1 == 2 && (map.getField(x_1 + 1, y_1 + 1).getColorNumber() >= 1 && map.getField(x_1 + 1, y_1 + 1).getColorNumber() <= 6)) {
            jump = true;
            return true;
        }
        //sprawdzam czy wykonany jest skok w lewo-dol
        if ((x_1 != x_2 || y_1 != y_2) && x_1 - x_0 == 2 && y_0 - y_1 == 2 && (map.getField(x_1 - 1, y_1 + 1).getColorNumber() >= 1 && map.getField(x_1 - 1, y_1 + 1).getColorNumber() <= 6)) {
            jump = true;
            return true;
        }
        //sprawdzam czy wykonany jest skok w prawo-gora
        if ((x_1 != x_2 || y_1 != y_2) && x_0 - x_1 == 2 && y_1 - y_0 == 2 && (map.getField(x_1 + 1, y_1 - 1).getColorNumber() >= 1 && map.getField(x_1 + 1, y_1 - 1).getColorNumber() <= 6)) {
            jump = true;
            return true;
        }
        //sprawdzam czy wykonany jest skok w prawo-dol
        if ((x_1 != x_2 || y_1 != y_2) && x_1 - x_0 == 2 && y_1 - y_0 == 2 && (map.getField(x_1 - 1, y_1 - 1).getColorNumber() >= 1 && map.getField(x_1 - 1, y_1 - 1).getColorNumber() <= 6)) {
            jump = true;
            return true;
        }

        //zwracam falsz jesli zostal wykonany ruch nie spelniajacy powyzszych warunkow
        return false;
    }

    private boolean validJump(int x_0, int y_0, int x_1, int y_1, int x_2, int y_2) {
        //sprawdzam czy mozliwy jest skok w lewo
        if ((x_1 != x_2 || y_1 != y_2) && x_0 == x_1 && y_0 - y_1 == 4 && (map.getField(x_1, y_1 + 2).getColorNumber() >= 1 && map.getField(x_1, y_1 + 2).getColorNumber() <= 6) && map.getField(x_1, y_1).getColorNumber() == 0 && !(map.getField(x_0, y_0).getDestinationColor() == this.activePlayer && map.getField(x_1, y_1).getDestinationColor() != this.activePlayer)) {
            return true;
        }
        //sprawdzam czy mozliwy jest skok w prawo
        if ((x_1 != x_2 || y_1 != y_2) && x_0 == x_1 && y_1 - y_0 == 4 && (map.getField(x_1, y_1 - 2).getColorNumber() >= 1 && map.getField(x_1, y_1 - 2).getColorNumber() <= 6) && map.getField(x_1, y_1).getColorNumber() == 0 && !(map.getField(x_0, y_0).getDestinationColor() == this.activePlayer && map.getField(x_1, y_1).getDestinationColor() != this.activePlayer)) {
            return true;
        }
        //sprawdzam czy mozliwy jest skok w lewo-gora
        if ((x_1 != x_2 || y_1 != y_2) && x_0 - x_1 == 2 && y_0 - y_1 == 2 && (map.getField(x_1 + 1, y_1 + 1).getColorNumber() >= 1 && map.getField(x_1 + 1, y_1 + 1).getColorNumber() <= 6) && map.getField(x_1, y_1).getColorNumber() == 0 && !(map.getField(x_0, y_0).getDestinationColor() == this.activePlayer && map.getField(x_1, y_1).getDestinationColor() != this.activePlayer)) {
            return true;
        }
        //sprawdzam czy mozliwy jest skok w lewo-dol
        if ((x_1 != x_2 || y_1 != y_2) && x_1 - x_0 == 2 && y_0 - y_1 == 2 && (map.getField(x_1 - 1, y_1 + 1).getColorNumber() >= 1 && map.getField(x_1 - 1, y_1 + 1).getColorNumber() <= 6) && map.getField(x_1, y_1).getColorNumber() == 0 && !(map.getField(x_0, y_0).getDestinationColor() == this.activePlayer && map.getField(x_1, y_1).getDestinationColor() != this.activePlayer)) {
            return true;
        }
        //sprawdzam czy mozliwy jest skok w prawo-gora
        if ((x_1 != x_2 || y_1 != y_2) && x_0 - x_1 == 2 && y_1 - y_0 == 2 && (map.getField(x_1 + 1, y_1 - 1).getColorNumber() >= 1 && map.getField(x_1 + 1, y_1 - 1).getColorNumber() <= 6) && map.getField(x_1, y_1).getColorNumber() == 0 && !(map.getField(x_0, y_0).getDestinationColor() == this.activePlayer && map.getField(x_1, y_1).getDestinationColor() != this.activePlayer)) {
            return true;
        }
        //sprawdzam czy mozliwy jest skok w prawo-dol
        if ((x_1 != x_2 || y_1 != y_2) && x_1 - x_0 == 2 && y_1 - y_0 == 2 && (map.getField(x_1 - 1, y_1 - 1).getColorNumber() >= 1 && map.getField(x_1 - 1, y_1 - 1).getColorNumber() <= 6) && map.getField(x_1, y_1).getColorNumber() == 0 && !(map.getField(x_0, y_0).getDestinationColor() == this.activePlayer && map.getField(x_1, y_1).getDestinationColor() != this.activePlayer)) {
            return true;
        }

        return false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!gameFinished && active && client.getID() == activePlayer) {

            for (int i = 0; i < 17; ++i) {
                for (int j = 0; j < 25; ++j) {
                    if (map.getField(i,j).getBounds2D().contains(e.getX(),e.getY())) {
                        //wybieramy pionek do ruchu i zaznaczamy go
                        if (map.getField(i,j).getColorNumber() == this.activePlayer && move == false) {
                            map.getField(i,j).setColor(7);
                            map.getField(i,j).setColorNumber(7);
                            active_x = i;
                            active_y = j;
                            move = true;
                        }

                        //ruszamy pionkiem
                        if (map.getField(i,j).getColorNumber() == 0 && move == true && validMove(active_x, active_y, i, j, previous_x, previous_y)) {
                            if (jump) {
                                //sprawdzam czy po tym skoku beda dostepne inne skoki
                                //jesli tak to pionek zostaje aktywny
                                if (nextJump(i, j)) {
                                    map.getField(i,j).setColor(7);
                                    map.getField(i,j).setColorNumber(7);
                                    map.getField(active_x,active_y).setColor(0);
                                    map.getField(active_x,active_y).setColorNumber(0);
                                    previous_x = active_x;
                                    previous_y = active_y;
                                    active_x = i;
                                    active_y = j;
                                    mustJump = true;
                                }
                                //jesli nie to pionek przestaje byc aktywny
                                else {
                                    map.getField(i,j).setColor(activePlayer);
                                    map.getField(i,j).setColorNumber(activePlayer);
                                    map.getField(active_x,active_y).setColor(0);
                                    map.getField(active_x,active_y).setColorNumber(0);

                                    hasFinished(this.activePlayer);

                                    previous_x = -1;
                                    previous_y = -1;

                                    mustJump = false;
                                    move = false;
                                    playerIndex++;
                                    if (playerIndex >= players.size()) {
                                        playerIndex = 0;
                                    }
                                    activePlayer = players.elementAt(playerIndex);
                                }
                                jump = false;
                            }
                            //sprawdza czy nie jest konieczny skok (kolejny w sekwencji ruchow)
                            else if (!mustJump){
                                map.getField(i,j).setColor(activePlayer);
                                map.getField(i,j).setColorNumber(activePlayer);
                                map.getField(active_x,active_y).setColor(0);
                                map.getField(active_x,active_y).setColorNumber(0);

                                hasFinished(this.activePlayer);

                                move = false;
                                playerIndex++;
                                if (playerIndex >= players.size()) {
                                    playerIndex = 0;
                                }
                                activePlayer = players.elementAt(playerIndex);
                            }
                        }
                        //repaint();
                    }
                }
            }

            if (passButton.getBounds2D().contains(e.getX(),e.getY())) {
                passTurn();
            }

            client.post(toString());
        }
    }

    private void hasFinished(int x) {
        int counter = 0;

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                if (map.getField(i,j).isEnabled() && map.getField(i,j).getColorNumber() == x && map.getField(i,j).getDestinationColor() == x) {
                    ++counter;
                }
            }
        }
        if (counter == 10) {
            players.removeElement(x);
        }
        if (players.size() == 1) {
            label.setText("Gra zakonczona!");
            gameFinished = true;
        }
    }

    public void passTurn() {
        move = false;
        mustJump = false;

        if (map.getField(active_x, active_y).getColorNumber() == 7) {
            map.getField(active_x,active_y).setColorNumber(activePlayer);
            map.getField(active_x,active_y).setColor(activePlayer);
            //repaint();
        }

        previous_x = -1;
        previous_y = -1;

        playerIndex++;
        if (playerIndex >= players.size()) {
            playerIndex = 0;
        }
        activePlayer = players.elementAt(playerIndex);
    }

    private boolean nextJump(int x, int y) {
        //sprawdzam czy mozna skoczyc w lewo-gora
        if (x - 2 >= 0 && y - 2 >= 0 && validJump(x, y, x - 2, y - 2, active_x, active_y) && map.getField(x - 2, y - 2).isEnabled())
            return true;
        //sprawdzam czy mozna skoczyc w lewo
        if (y - 4 >= 0 && validJump(x, y, x, y - 4, active_x, active_y) && map.getField(x, y - 4).isEnabled())
            return true;
        //sprawdzam czy mozna skoczyc w lewo-dol
        if (x + 2 <= 16 && y - 2 >= 0 && validJump(x, y, x + 2, y - 2, active_x, active_y) && map.getField(x + 2, y - 2).isEnabled())
            return true;

        //sprawdzam czy mozna skoczyc w prawo-gora
        if (x - 2 >= 0 && y + 2 <= 24 && validJump(x, y, x - 2, y + 2, active_x, active_y) && map.getField(x - 2, y + 2).isEnabled())
            return true;
        //sprawdzam czy mozna skoczyc w prawo
        if (y + 4 <= 24 && validJump(x, y, x, y + 4, active_x, active_y) && map.getField(x, y + 4).isEnabled())
            return true;
        //sprawdzam czy mozna skoczyc w prawo-dol
        if (x + 2 <= 16 && y + 2 <= 24 && validJump(x, y, x + 2, y + 2, active_x, active_y) && map.getField(x + 2, y + 2).isEnabled())
            return true;

        return false;
    }

    public void setMap(String message, boolean active) {
        this.active = active;
        if (active)
            this.label.setText("Twoja tura!");
        else {
            this.label.setText("");
        }
        int temp;
        int counter = 1;

        activePlayer = Character.getNumericValue(message.charAt(0));
        playerIndex = players.indexOf(activePlayer);

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                temp = Character.getNumericValue(message.charAt(counter));
                map.getField(i ,j).setColorNumber(temp);
                map.getField(i ,j).setColor(temp);
                ++counter;
            }
        }
        repaint();
    }

    public String toString() {
        StringBuilder message = new StringBuilder();

        message.append(activePlayer);

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                message.append(map.getField(i, j).getColorNumber());
            }
        }
        System.out.println(move);
        System.out.println(message.toString());
        return message.toString();
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

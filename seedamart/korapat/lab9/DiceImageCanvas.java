package seedamart.korapat.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DiceImageCanvas extends JPanel {
    protected int diceNumber;
    protected Graphics2D g2d;
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square;
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;
    protected int circleRandom ;

    public DiceImageCanvas(int diceNumber) {
        this.diceNumber = diceNumber;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);
        createCircles();
    }

    protected void createCircles() {
        circleCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + squareHeight / 2 - circleHeight / 2, circleWidth, circleHeight);

        circleTopRight = new Ellipse2D.Double(startSquareX + squareWidth - circleWidth - margin,
                startSquareY + margin, circleWidth, circleHeight);

        circleBottomLeft = new Ellipse2D.Double(startSquareX + margin,
                startSquareY + squareHeight - circleHeight - margin, circleWidth, circleHeight);

        circleTopLeft = new Ellipse2D.Double(startSquareX + margin,
                startSquareY + margin, circleWidth, circleHeight);

        circleBottomRight = new Ellipse2D.Double(startSquareX + squareWidth - circleWidth - margin,
                startSquareY + squareHeight - circleHeight - margin, circleWidth, circleHeight);

        circleTopCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + margin, circleWidth, circleHeight);

        circleBottomCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + squareHeight - circleHeight - margin, circleWidth, circleHeight);
    }

    protected void drawDiceNumber() {
        g2d.setColor(Color.RED);
        diceNumber  = 1;
        diceNumber = 2 + (int) (Math.random() * ((6 - 2) + 1));

        switch (diceNumber) {
            case 1:
                g2d.fill(circleCenter);
                break;
            case 2:
                g2d.fill(circleTopLeft);
                g2d.fill(circleBottomRight);
                break;
            case 3:
                g2d.fill(circleTopLeft);
                g2d.fill(circleCenter);
                g2d.fill(circleBottomRight);
                break;
            case 4:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                break;
            case 5:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleCenter);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                break;
            case 6:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                g2d.fill(circleTopCenter);
                g2d.fill(circleBottomCenter);
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fill(square);
        drawDiceNumber();
    }
}

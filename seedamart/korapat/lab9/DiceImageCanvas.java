package seedamart.korapat.lab9;

/* 
 * DiceImageCanvas Class :
 * 
 * The program can also display dice representing each number, from two to six.
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 16 February 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DiceImageCanvas extends JPanel {
    // Member variables declaration
    protected int diceNumber; // Current dice number
    protected Graphics2D g2d; // Graphics context for drawing
    // Ellipse shapes representing dice dots
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square; // Square representing the dice face
    // Constants for sizes and positions
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;
    protected int circleRandom;

    public DiceImageCanvas(int diceNumber) {
        this.diceNumber = diceNumber;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);
        createCircles(); // Create ellipse shapes for dots
    }

    protected void createCircles() {
        // Create ellipse shapes at appropriate positions on the dice face
        circleCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + squareHeight / 2 - circleHeight / 2, circleWidth, circleHeight);

        // Create other ellipse shapes similarly for different dot positions
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

        // For now, generating a random dice number (1-6)
        diceNumber = 1;
        diceNumber = 2 + (int) (Math.random() * ((6 - 2) + 1));

        // Draw dots based on the current dice number
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
        super.paintComponent(g); // Call superclass method
        g2d = (Graphics2D) g; // Cast Graphics object to Graphics2D
        g2d.setColor(Color.WHITE); // Set background color
        g2d.fill(square); // Fill the square with background color
        drawDiceNumber(); // Draw dots on the dice face
    }
}

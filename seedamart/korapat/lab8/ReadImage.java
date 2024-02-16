package seedamart.korapat.lab8;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImage extends JPanel{
     private BufferedImage image;

    public ReadImage() {
        // Load the image from file
        try {
            image = ImageIO.read(new File("seedamart/korapat/lab8/images/Football.jpg")); // Update the file path with your image file path
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Draw the image at (0, 0) of the panel
            g.drawImage(image, 0, 0, this);
        }
    }
}

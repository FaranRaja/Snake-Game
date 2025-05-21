package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Banana extends Fruit {
    public Banana() {
        super();
        this.points = 2;

        try {

            File inputFile = new File("images/fruits.png");
            BufferedImage originalImage = ImageIO.read(inputFile);


            int columns = 38;
            int rows = 6;
            int fruitWidth = originalImage.getWidth() / columns;
            int fruitHeight = originalImage.getHeight() / rows;


            int x = fruitWidth * 7;
            int y = fruitHeight * 0;


            BufferedImage bananaImage = originalImage.getSubimage(x, y, fruitWidth, fruitHeight);



            this.image = new ImageIcon(bananaImage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
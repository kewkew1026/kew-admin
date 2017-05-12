package com.kew.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by qiudanping on 2017/5/10.
 */
public class ImageUtil {

    public static String wiriteImage(OutputStream os,Color backgroundColor,Color fontColor) throws IOException {

        BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Random r = new Random();
        Graphics g = image.getGraphics();
        Font font = new Font("Default", Font.ROMAN_BASELINE, 15);
        g.setFont(font);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, 60, 20);
        g.setColor(fontColor);
        int x = r.nextInt(9999);
        while (x < 1000) {
            x = r.nextInt(9999);
        }
        String number = String.valueOf(x);

        g.drawString(number, 10, 15);

        ImageIO.write(image, "jpeg", os);

        return number;
    }
}

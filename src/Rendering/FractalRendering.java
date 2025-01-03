package Rendering;

import GUI.MyPanel;
import Logic.ComplexNumber;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FractalRendering {

    public static int zoom = 200;
    static int zoomFactor = 4;
    public static boolean isJuliaFractal;
    public static ComplexNumber juliaComplex = new ComplexNumber(-0.77146, -0.10119);

    // middleX and middleY represent the offset needed to display the desired part of the fractal in the middle of the screen
    public static double middleX = 0;
    public static double middleY = 0;

    int inSetColor = Color.black.getRGB();

    // Loops through all pixels and renders them to the buffered image
    public void renderFractal(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                PixelRendering pg = new PixelRendering(x, y);
                pg.paintPixel(image);
            }
        }
    }

    public static void zoomIn(Point mouseLocation) {
        int width = MyPanel.width;
        int height = MyPanel.height;

        // Adjust middleX and middleY based on where the user clicked
        if ((width)/2 - mouseLocation.x > 0) {
            middleX += (width/2 - mouseLocation.x);
        } else {
            middleX -= Math.abs(width/2 - mouseLocation.x);
        }
        if ((height)/2 - mouseLocation.y > 0) {
            middleY += (height/2 - mouseLocation.y);
        } else {
            middleY -= Math.abs(height/2 - mouseLocation.y);
        }

        // Scale the middle point along with the fractal
        middleX *= zoomFactor;
        middleY *= zoomFactor;
        zoom *= zoomFactor;
    }
    public static void zoomOut() {
        // Scale the middle point along with the fractal
        middleX /= zoomFactor;
        middleY /= zoomFactor;
        zoom /= zoomFactor;
    }
}

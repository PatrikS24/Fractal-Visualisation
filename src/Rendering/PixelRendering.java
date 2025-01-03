package Rendering;

import Logic.Fractal;
import GUI.MyPanel;
import Logic.ComplexNumber;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelRendering extends FractalRendering{
    double x;
    double y;
    int iterations;
    ComplexNumber complexNumber;


    public PixelRendering(double screenX, double screenY) {
        x = screenX;
        y = screenY;
        // Every pixel is represented by a point on the complex plane
        // x and y are moved so that a pixel on the screen that is in the middle of the screen gets the coordinates 0,0 on the complex plane
        // middleX and middleY adjust the position of the point so that where you click is moved to the middle of the screen after zooming
        // Lastly the point is zoomed in according to the zoom variable
        complexNumber = new ComplexNumber((x - middleX - (MyPanel.width/2)) / zoom, (y * -1 + middleY + (MyPanel.height/2)) / zoom);
    }

    public void paintPixel(BufferedImage image) {
        if (FractalRendering.isJuliaFractal) {
            iterations = Fractal.isInJuliaFractal(complexNumber, juliaComplex, 400);
        } else {
            iterations = Fractal.isInMandelbrotFractal(complexNumber, 200);
        }
        if (iterations == -1) {
            image.setRGB((int)x, (int)y, inSetColor);
        } else {
            //int boundaryColor = new Color(0,0,0).getRGB();
            int color = Math.min(255, Math.max(0, iterations));
            /*
            if ( iterations % 2 == 0) {
                boundaryColor = Color.black.getRGB();
            } else {
                boundaryColor = Color.white.getRGB();
            }
            */
            int boundaryColor = new Color(255 - color,  255 - color, 255 - color).getRGB();
            image.setRGB((int)x, (int)y, boundaryColor);
        }
    }
}

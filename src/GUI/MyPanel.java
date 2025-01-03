package GUI;

import Mouse.MousePressedListener;
import Rendering.FractalRendering;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyPanel extends JPanel {

    MyFrame frame;
    BufferedImage image;
    FractalRendering fractalRenderer = new FractalRendering();
    JComboBox comboBox = new JComboBox(new String[] {"Mandelbrot set", "Julia set"});
    JTextField realTextField = new JTextField("-0.77146", 10);
    JTextField imaginaryTextField = new JTextField("-0.10119", 10);
    JLabel realLabel = new JLabel("Complex number:");
    JLabel imaginaryLabel = new JLabel(" + i");
    JButton applyButton = new JButton("Apply");
    ApplyButtonListener applyButtonListener = new ApplyButtonListener(realTextField, imaginaryTextField, this);

    static Dimension screenSize = new Dimension(1000, 600);
    public static int height = screenSize.height;
    public static int width = screenSize.width;

    public MyPanel(MyFrame inputFrame) {
        frame = inputFrame;
        this.setPreferredSize(screenSize);
        MousePressedListener mousePressedListener = new MousePressedListener(frame, this);
        this.addMouseListener(mousePressedListener);
        applyButton.addActionListener(applyButtonListener);

        this.add(comboBox);
        comboBox.addItemListener(new ComboBoxListener(comboBox, this));

        paintFractal();
    }
    // Is called when the fractal needs to be repainted
    public void paintFractal() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fractalRenderer.renderFractal(image);
    }

    protected void paintComponent(Graphics g) {
        // Only repaint the fractal if window size changes
        if (image == null || getWidth() != image.getWidth() || getHeight() != image.getHeight()) {
            width = getWidth();
            height = getHeight();
            paintFractal();
        }

        g.drawImage(image, 0,0 , null);
    }

    // Is called when the Julia set fractal is active so that the user can input a complex number
    public void createInputFields() {
        this.add(realLabel);
        this.add(realTextField);
        this.add(imaginaryLabel);
        this.add(imaginaryTextField);
        this.add(applyButton);
        this.revalidate();
    }

    // Is called when teh Julia set fractal is deselected
    public void deleteInputFields() {
        this.removeAll();
        this.add(comboBox);
        this.revalidate();
    }
}

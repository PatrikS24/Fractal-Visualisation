package GUI;

import Logic.ComplexNumber;
import Rendering.FractalRendering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyButtonListener implements ActionListener {

    JTextField realTextfield;
    JTextField imaginaryTextField;
    MyPanel panel;

    public ApplyButtonListener(JTextField real, JTextField imaginary, MyPanel inputPanel) {
        realTextfield = real;
        imaginaryTextField = imaginary;
        panel = inputPanel;
    }


    // When the user presses the apply button the julia fractal is updated
    @Override
    public void actionPerformed(ActionEvent e) {

        String real = realTextfield.getText();
        String imaginary = imaginaryTextField.getText();
        System.out.println(real);
        FractalRendering.juliaComplex = new ComplexNumber(Double.parseDouble(real), Double.parseDouble(imaginary));
        panel.paintFractal();
        panel.repaint();
    }
}

package GUI;

import Rendering.FractalRendering;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxListener implements ItemListener {

    JComboBox comboBox;
    MyPanel panel;

    public ComboBoxListener(JComboBox inputComboBox, MyPanel p) {
        super();
        comboBox = inputComboBox;
        panel = p;
    }

    // When the user changes fractal type the fractal gets updated and options for choosing julia set appears
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (comboBox.getSelectedItem().equals("Julia set")) {
                FractalRendering.isJuliaFractal = true;
                panel.createInputFields();
            } else {
                FractalRendering.isJuliaFractal = false;
                panel.deleteInputFields();
            }
            panel.paintFractal();
            panel.repaint();
        }
    }

}

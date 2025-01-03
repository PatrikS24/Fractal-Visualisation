package GUI;

import javax.swing.*;

public class MyFrame extends JFrame{

    MyPanel panel;

    public MyFrame() {
        panel = new MyPanel(this);
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Fractal Visualization");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

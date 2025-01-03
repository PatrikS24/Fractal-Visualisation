package Mouse;

import Rendering.FractalRendering;
import GUI.MyFrame;
import GUI.MyPanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePressedListener implements MouseListener {

    MyFrame frame;
    MyPanel panel;
    PointerLocation pl;

    public MousePressedListener(MyFrame inputFrame, MyPanel inputPanel) {
        frame = inputFrame;
        panel = inputPanel;
        pl = new PointerLocation(frame);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point relativeMouseLocation = pl.getRelativePoint();

        if (SwingUtilities.isLeftMouseButton(e)) {
            FractalRendering.zoomIn(relativeMouseLocation);
        } else if (SwingUtilities.isRightMouseButton(e)) {
            FractalRendering.zoomOut();
        }

        panel.paintFractal();
        panel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {



    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

package Mouse;

import GUI.MyFrame;
import java.awt.*;

public class PointerLocation {

    MyFrame frame;

    public PointerLocation(MyFrame inputFrame) {
        frame = inputFrame;
    }

    // Returns the position of the cursor relative to the users entire screen
    public Point getAbsolutePoint() {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        return pointerInfo.getLocation();
    }

    // Returns the cursors position relative to the frame
    public Point getRelativePoint() {
        Point absolutePoint = getAbsolutePoint();
        Point windowPoint = getWindowPoint();
        Point relativePoint = new Point(absolutePoint.x - windowPoint.x, absolutePoint.y - windowPoint.y - 30);
        return relativePoint;
    }

    // Returns the position of the frame relative to the entire screen
    public Point getWindowPoint() {
        return frame.getLocationOnScreen();
    }
}

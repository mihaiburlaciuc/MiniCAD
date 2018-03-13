package algorithms;

import main.*;
import main.Point;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class BresenhamsLine {
    private BresenhamsLine() { }

    public static void action(final Integer x1,
                              final Integer x2,
                              final Integer y1,
                              final Integer y2,
                              final BufferedImage img,
                              final Color color) {
        Integer x = x1;
        Integer y = y1;
        Integer deltaX = Math.abs(x2 - x);
        Integer deltaY = Math.abs(y2 - y1);
        Integer s1 = Math.round(Math.signum(x2 - x1));
        Integer s2 = Math.round(Math.signum(y2 - y1));
        boolean interchanged = false;

        if (deltaY > deltaX) {
            Integer tmp = deltaY;
            deltaY = deltaX;
            deltaX = tmp;
            interchanged = true;
        }

        Integer error = 2 * deltaY - deltaX;

        for (int i = 0; i <= deltaX; i++) {
            if (!ImageUtility.pointOutOfBounds(new Point(x, y), img)) {
                img.setRGB(x, y, color.getRGB());
            }

            while (error > 0) {
                if (interchanged) {
                    x += s1;
                } else {
                    y += s2;
                }

                error -= 2 * deltaX;
            }

            if (interchanged) {
                y += s2;
            } else {
                x += s1;
            }

            error += 2 * deltaY;
        }
    }
}

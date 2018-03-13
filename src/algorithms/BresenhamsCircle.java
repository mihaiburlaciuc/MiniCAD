package algorithms;

import main.ImageUtility;
import main.Point;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class BresenhamsCircle {
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int SIX = 6;
    private static final int TEN = 10;

    private BresenhamsCircle() { }

    private static void circleUtility(final Integer xCenter,
                                      final Integer yCenter,
                                      final Integer x,
                                      final Integer y,
                                      final Color color,
                                      final BufferedImage image) {
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter + x, yCenter + y), image)) {
            image.setRGB(xCenter + x, yCenter + y, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter - x, yCenter + y), image)) {
            image.setRGB(xCenter - x, yCenter + y, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter + x, yCenter - y), image)) {
            image.setRGB(xCenter + x, yCenter - y, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter - x, yCenter - y), image)) {
            image.setRGB(xCenter - x, yCenter - y, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter + y, yCenter + x), image)) {
            image.setRGB(xCenter + y, yCenter + x, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter - y, yCenter + x), image)) {
            image.setRGB(xCenter - y, yCenter + x, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter + y, yCenter - x), image)) {
            image.setRGB(xCenter + y, yCenter - x, color.getRGB());
        }
        if (!ImageUtility.pointOutOfBounds(new Point(xCenter - y, yCenter - x), image)) {
            image.setRGB(xCenter - y, yCenter - x, color.getRGB());
        }
    }
    public static void action(final Integer xCenter,
                              final Integer yCenter,
                              final Integer radius,
                              final BufferedImage image,
                              final Color color) {
        Integer x = ZERO;
        Integer y = radius;
        Integer d = THREE - TWO * radius;

        while (y >= x) {
            circleUtility(xCenter, yCenter, x, y, color, image);
            x++;

            if (d  > ZERO) {
                y--;
                d = d + FOUR * (x - y) + TEN;
            } else {
                d = d + FOUR * x + SIX;
            }

            circleUtility(xCenter, yCenter, x, y, color, image);
        }

    }
}

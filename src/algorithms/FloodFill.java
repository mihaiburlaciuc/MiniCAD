package algorithms;

import main.ImageUtility;
import main.Point;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public final class FloodFill {
    private FloodFill() { }

    public static void addToQueue(final Point point,
                                  final Color interiorColor,
                                  final Color outlineColor,
                                  final Queue queue,
                                  final BufferedImage image) {
        if (ImageUtility.pointOutOfBounds(point, image)) {
            return;
        }

        if (image.getRGB(point.getX(), point.getY()) != outlineColor.getRGB()
                && image.getRGB(point.getX(), point.getY()) != interiorColor.getRGB()) {
            image.setRGB(point.getX(), point.getY(), interiorColor.getRGB());
            queue.add(new Point(point.getX(), point.getY()));
        }
    }

    public static void action(final Point startPoint,
                              final Color interiorColor,
                              final Color outlineColor,
                              final BufferedImage image) {
        Queue<Point> queue = new LinkedList<>();
        // Oprim daca gasim marginea
        if (ImageUtility.pointOutOfBounds(startPoint, image)) {
            System.out.println(startPoint.getX() + " " + startPoint.getY());
            return;
        }
        if (outlineColor.getRGB() == image.getRGB(startPoint.getX(), startPoint.getY())) {
            return;
        }
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            Point tmp = queue.peek();
            queue.remove();
            image.setRGB(tmp.getX(), tmp.getY(), interiorColor.getRGB());

            addToQueue(new Point(tmp.getX() + 1, tmp.getY()),
                    interiorColor,
                    outlineColor,
                    queue,
                    image);
            addToQueue(new Point(tmp.getX(), tmp.getY() + 1),
                    interiorColor,
                    outlineColor,
                    queue,
                    image);
            addToQueue(new Point(tmp.getX(), tmp.getY() - 1),
                    interiorColor,
                    outlineColor,
                    queue,
                    image);
            addToQueue(new Point(tmp.getX() - 1, tmp.getY()),
                    interiorColor,
                    outlineColor,
                    queue,
                    image);
        }
    }
}

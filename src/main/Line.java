package main;

import java.awt.*;

public class Line extends Form {
    private Point start;
    private Point stop;

    Line(final int startX,
         final int startY,
         final int stopX,
         final int stopY,
         final Color outlineColor) {
        super(outlineColor);
        start = new Point(startX, startY);
        stop = new Point(stopX, stopY);
    }

    /**
     * getter punct de start.
     * @return
     */
    public Point getStart() {
        return start;
    }

    /**
     * getter punct de stop.
     * @return
     */
    public Point getStop() {
        return stop;
    }

    /**
     * Visitorul viziteaza acest element.
     * @param v
     */
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }

    /**
     * Nu are centru de greutate.
     * Linia nu va fi folosita de FloodFill.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        return null;
    }
}

package main;

import java.awt.*;

public class Triangle extends Form {
    private Point point1;
    private Point point2;
    private Point point3;
    private Color interiorColor;
    private static final int NUM_POINTS = 3;

    public Triangle(final Integer point1X,
                    final Integer point1Y,
                    final Integer point2X,
                    final Integer point2Y,
                    final Integer point3X,
                    final Integer point3Y,
                    final Color outlineColor,
                    final Color interiorColor) {
        super(outlineColor);
        point1 = new Point(point1X, point1Y);
        point2 = new Point(point2X, point2Y);
        point3 = new Point(point3X, point3Y);
        this.interiorColor = interiorColor;
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
     * returneaza centru de greutate.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        return new Point ((point1.getX() + point2.getX() + point3.getX()) / NUM_POINTS,
                (point1.getY() + point2.getY() + point3.getY()) / NUM_POINTS);
    }

    /**
     * getter primul punct dat.
     * @return
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * getter al doilea punct.
     * @return
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * getter al treilea punct.
     * @return
     */
    public Point getPoint3() {
        return point3;
    }

    /**
     * getter culoare de umplere.
     * @return
     */
    public Color getInteriorColor() {
        return interiorColor;
    }
}

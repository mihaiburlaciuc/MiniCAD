package main;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends Form {
    private int pointsNumber;
    private ArrayList<Point> points;
    private Color interiorColor;

    public Polygon(final int pointsNumber,
                   final ArrayList<Point> points,
                   final Color outlineColor,
                   final Color interiorColor) {
        super(outlineColor);
        this.pointsNumber = pointsNumber;
        this.points = points;
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
     * Returnam centrul de greutate al poligonului.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        Integer x = 0;
        Integer y = 0;

        for (Point p : points) {
            x += p.getX();
            y += p.getY();
        }

        return new Point(x / points.size(), y / points.size());
    }

    /**
     * Getter numar de puncte.
     * @return
     */
    public int getPointsNumber() {
        return pointsNumber;
    }

    /**
     * Getter Array de puncte.
     * @return
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Getter culoare de umplere.
     * @return
     */
    public Color getInteriorColor() {
        return interiorColor;
    }
}

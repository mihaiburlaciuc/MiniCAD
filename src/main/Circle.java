package main;

import java.awt.*;

public class Circle extends Form {
    private Point center;
    private Integer radius;
    private Color interiorColor;

    public Circle(final Integer centerX,
           final Integer centerY,
           final Integer radius,
           final Color outlineColor,
           final Color interiorColor) {
        super(outlineColor);
        center = new Point(centerX, centerY);
        this.interiorColor = interiorColor;
        this.radius = radius;
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
     * returneaza centrul de greutate.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        return center;
    }

    /**
     * getter centrul cercului.
     * @return
     */
    public Point getCenter() {
        return center;
    }

    /**
     * getter culoare de umplere.
     * @return
     */
    public Color getInteriorColor() {
        return interiorColor;
    }

    /**
     * getter raza.
     * @return
     */
    public Integer getRadius() {
        return radius;
    }
}

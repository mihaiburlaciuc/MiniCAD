package main;

import java.awt.*;

public class Rectangle extends Form {
    private Point leftTopCorner;
    private Integer length;
    private Integer height;
    private Color interiorColor;

    public Rectangle(final Integer leftTopCornerX,
                     final Integer leftTopCornerY,
                     final Integer height,
                     final Integer length,
                     final Color outlineColor,
                     final Color interiorColor) {
        super(outlineColor);
        leftTopCorner = new Point(leftTopCornerX, leftTopCornerY);
        this.length = length;
        this.height = height;
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
     * Returneaza centru de greutate al dreptunghiului.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        Integer x = leftTopCorner.getX() + length / 2;
        Integer y = leftTopCorner.getY() + height / 2;

        return new Point(x, y);
    }

    /**
     * Getter colt stanga sus.
     * @return
     */
    public Point getLeftTopCorner() {
        return leftTopCorner;
    }

    /**
     * Getter lungime.
     * @return
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Getter inaltime.
     * @return
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Getter culoare de umplere.
     * @return
     */
    public Color getInteriorColor() {
        return interiorColor;
    }
}

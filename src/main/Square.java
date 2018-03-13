package main;

import java.awt.*;

public class Square extends Form implements Visitable {
    private Point leftTopCorner;
    private Integer length;
    private Color interiorColor;

    public Square(final Integer leftTopCornerX,
                  final Integer leftTopCornerY,
                  final Integer length,
                  final Color outlineColor,
                  final Color interiorColor) {
        super(outlineColor);
        leftTopCorner = new Point(leftTopCornerX, leftTopCornerY);
        this.length = length;
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
     * Returneaza centru de greutate.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        Integer x = leftTopCorner.getX() + length / 2;
        Integer y = leftTopCorner.getY() + length / 2;

        return new Point(x, y);
    }

    /**
     * Returneaza Colt stanga sus.
     * @return
     */
    public Point getLeftTopCorner() {
        return leftTopCorner;
    }

    /**
     * Returneaza lungime.
     * @return
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Returneaza culoare interioara.
     * @return
     */
    public Color getInteriorColor() {
        return interiorColor;
    }
}

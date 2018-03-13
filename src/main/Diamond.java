package main;

import java.awt.*;

public class Diamond extends Form {
    private Point center;
    private int horizontalDiagonalLength;
    private int verticalDiagonalLength;
    private Color interiorColor;

    public Diamond(final int centerX,
                   final int centerY,
                   final int horizontalDiagonalLength,
                   final int verticalDiagonalLength,
                   final Color outlineColor,
                   final Color interiorColor) {
        super(outlineColor);
        center = new Point(centerX, centerY);
        this.horizontalDiagonalLength = horizontalDiagonalLength;
        this.verticalDiagonalLength = verticalDiagonalLength;
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
     * Returneaza cetrul de greutate.
     * @return
     */
    @Override
    Point getCenterOfGravity() {
        return center;
    }

    /**
     * Returneaza centrul rombului.
     * @return
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Getter lungime diagonala orizontala.
     * @return
     */
    public int getHorizontalDiagonalLength() {
        return horizontalDiagonalLength;
    }

    /**
     * getter lungime diagonala verticala.
     * @return
     */
    public int getVerticalDiagonalLength() {
        return verticalDiagonalLength;
    }

    /**
     * getter culoare de umplere.
     * @return
     */
    public Color getInteriorColor() {
        return interiorColor;
    }
}

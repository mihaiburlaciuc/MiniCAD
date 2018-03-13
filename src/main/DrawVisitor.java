package main;

import algorithms.BresenhamsCircle;
import algorithms.BresenhamsLine;
import algorithms.FloodFill;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawVisitor implements Visitor {
    private BufferedImage image;

    public DrawVisitor(final BufferedImage image) {
        this.image = image;
    }

    /**
     * Desenam linia folosind algoritmul lui Bresenham.
     * @param e
     */
    @Override
    public void visit(final Line e) {
        BresenhamsLine.action(e.getStart().getX(),
                e.getStop().getX(),
                e.getStart().getY(),
                e.getStop().getY(),
                image,
                e.getOutlineColor());
    }

    /**
     * Desenam patratul pornind de la coltul din stanga sus
     * si ne folosim de lungime pentru a afla restul coordonatelor.
     * Facem FloodFill pornind din centru de greutate.
     * @param e
     */
    @Override
    public void visit(final Square e) {
        System.out.println(e.getInteriorColor().toString());
        BresenhamsLine.action(e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getY(),
                e.getLeftTopCorner().getY() + e.getLength() - 1,
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getY() + e.getLength() - 1,
                e.getLeftTopCorner().getY() + e.getLength() - 1,
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getY(),
                e.getLeftTopCorner().getY(),
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getY() + e.getLength() - 1,
                e.getLeftTopCorner().getY(),
                image,
                e.getOutlineColor());
        if (ImageUtility.pointOutOfBounds(e.getCenterOfGravity(), image)) {
            FloodFill.action(new Point(e.getLeftTopCorner().getX() + 1,
                            e.getLeftTopCorner().getY() + 1),
                    e.getInteriorColor(),
                    e.getOutlineColor(),
                    image);
        } else {
            FloodFill.action(e.getCenterOfGravity(),
                    e.getInteriorColor(),
                    e.getOutlineColor(),
                    image);
        }

    }

    /**
     * Desenam dreptunghiul pornind din coltul stanga sus
     * si aflam restul coordonatelor folosindu-ne de
     * lungime si latime.
     * @param e
     */
    @Override
    public void visit(final Rectangle e) {
        BresenhamsLine.action(e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getY(),
                e.getLeftTopCorner().getY() + e.getHeight() - 1,
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getY() + e.getHeight() - 1,
                e.getLeftTopCorner().getY() + e.getHeight() - 1,
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getX() + e.getLength() - 1,
                e.getLeftTopCorner().getY(),
                e.getLeftTopCorner().getY(),
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getX(),
                e.getLeftTopCorner().getY() + e.getHeight() - 1,
                e.getLeftTopCorner().getY(),
                image,
                e.getOutlineColor());
        if (ImageUtility.pointOutOfBounds(e.getCenterOfGravity(), image)) {
            FloodFill.action(new Point(e.getLeftTopCorner().getX() + 1,
                            e.getLeftTopCorner().getY() + 1),
                    e.getInteriorColor(),
                    e.getOutlineColor(),
                    image);
        } else {
            FloodFill.action(e.getCenterOfGravity(),
                    e.getInteriorColor(),
                    e.getOutlineColor(),
                    image);
        }
    }

    /**
     * Desenam cercul folosind algoritmul Bresenham pentru cerc.
     * @param e
     */
    @Override
    public void visit(final Circle e) {
        BresenhamsCircle.action(e.getCenter().getX(),
                e.getCenter().getY(),
                e.getRadius(),
                image,
                e.getOutlineColor());
        FloodFill.action(e.getCenterOfGravity(),
                    e.getInteriorColor(),
                    e.getOutlineColor(),
                    image);
    }

    /**
     * Desenam triunghiul folosindu-ne de algoritmul
     * Bresenham pentru linie astfel:
     * P1->P2->P3->P1.
     * @param e
     */
    @Override
    public void visit(final Triangle e) {
        BresenhamsLine.action(e.getPoint1().getX(),
                e.getPoint2().getX(),
                e.getPoint1().getY(),
                e.getPoint2().getY(),
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getPoint2().getX(),
                e.getPoint3().getX(),
                e.getPoint2().getY(),
                e.getPoint3().getY(),
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getPoint3().getX(),
                e.getPoint1().getX(),
                e.getPoint3().getY(),
                e.getPoint1().getY(),
                image,
                e.getOutlineColor());
        FloodFill.action(e.getCenterOfGravity(),
                e.getInteriorColor(),
                e.getOutlineColor(),
                image);

    }

    /**
     * Desenam rombul folosindu-ne de centrul lui de greutate
     * si de cele doua diagonale pentru a afla coordonatele
     * punctelor.
     * @param e
     */
    @Override
    public void visit(final Diamond e) {
        BresenhamsLine.action(e.getCenter().getX(),
                e.getCenter().getX() - e.getHorizontalDiagonalLength() / 2,
                e.getCenter().getY() - e.getVerticalDiagonalLength() / 2,
                e.getCenter().getY(),
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getCenter().getX() - e.getHorizontalDiagonalLength() / 2,
                e.getCenter().getX(),
                e.getCenter().getY(),
                e.getCenter().getY() + e.getVerticalDiagonalLength() / 2,
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getCenter().getX(),
                e.getCenter().getX() + e.getHorizontalDiagonalLength() / 2,
                e.getCenter().getY() + e.getVerticalDiagonalLength() / 2,
                e.getCenter().getY(),
                image,
                e.getOutlineColor());
        BresenhamsLine.action(e.getCenter().getX() + e.getHorizontalDiagonalLength() / 2,
                e.getCenter().getX(),
                e.getCenter().getY(),
                e.getCenter().getY() - e.getVerticalDiagonalLength() / 2,
                image,
                e.getOutlineColor());
        FloodFill.action(e.getCenterOfGravity(),
                e.getInteriorColor(),
                e.getOutlineColor(),
                image);

    }

    /**
     * Pornim de la primul punct din poligon si trasam linii
     * pana cand ajungem la ultimul din lista.
     * @param e
     */
    @Override
    public void visit(final Polygon e) {
        ArrayList<Point> points = e.getPoints();
        for (int i = 0; i < e.getPointsNumber() - 1; i++) {
            BresenhamsLine.action(points.get(i).getX(),
                    points.get(i + 1).getX(),
                    points.get(i).getY(),
                    points.get(i + 1).getY(),
                    image,
                    e.getOutlineColor());
        }
        BresenhamsLine.action(points.get(e.getPointsNumber() - 1).getX(),
                points.get(0).getX(),
                points.get(e.getPointsNumber() - 1).getY(),
                points.get(0).getY(),
                image,
                e.getOutlineColor());
        FloodFill.action(e.getCenterOfGravity(),
                e.getInteriorColor(),
                e.getOutlineColor(),
                image);
    }
}

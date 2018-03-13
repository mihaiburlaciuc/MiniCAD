package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtility {
    private static final int ARG_ONE = 1;
    private static final int ARG_TWO = 2;
    private static final int ARG_THREE = 3;
    private static final int ARG_FOUR = 4;
    private static final int ARG_FIVE = 5;
    private static final int ARG_SIX = 6;
    private static final int HEX = 16;

    private ImageUtility() { }
    /**
     * Insereaza canvas-ul in imagine.
     * @param canvas
     * @param img
     */
    public static void drawCanvas(final Canvas canvas, final BufferedImage img) {
        for (int i = 0; i < canvas.getLength(); i++) {
            for (int j = 0; j < canvas.getHeight(); j++) {
                img.setRGB(i, j, canvas.getColor().getRGB());
            }
        }
    }

    /**
     * Seteaza culoarea in functie de string-ul RGB dat.
     * @param stringRGB
     * @param a
     * @return
     */
    public static Color setColor(final String stringRGB, final Integer a) {
        Integer r = Integer.parseInt(("" + stringRGB.charAt(ARG_ONE) + stringRGB.charAt(ARG_TWO)), HEX);
        Integer g = Integer.parseInt(("" + stringRGB.charAt(ARG_THREE)
                + stringRGB.charAt(ARG_FOUR)), HEX);
        Integer b = Integer.parseInt(("" + stringRGB.charAt(ARG_FIVE)
                + stringRGB.charAt(ARG_SIX)), HEX);
        Color tmp = new Color(r, g, b, a);

        return tmp;
    }

    /**
     * Verifica daca un punct se afla in cadrul imaginii.
     * @param point
     * @param image
     * @return
     */
    public static boolean pointOutOfBounds(final Point point, final BufferedImage image) {
        Integer imageHeight = image.getHeight();
        Integer imageWidth = image.getWidth();

        if (point.getX() < 0
                || point.getY() < 0
                || point.getX() >= imageWidth
                || point.getY() >= imageHeight) {
            return true;
        }

        return false;
    }
}

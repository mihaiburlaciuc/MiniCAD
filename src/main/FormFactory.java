package main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Singleton pattern.
 */
public final class FormFactory {
    private static FormFactory instance = new FormFactory();
    private static final int ARG_ONE = 1;
    private static final int ARG_TWO = 2;
    private static final int ARG_THREE = 3;
    private static final int ARG_FOUR = 4;
    private static final int ARG_FIVE = 5;
    private static final int ARG_SIX = 6;
    private static final int ARG_SEVEN = 7;
    private static final int ARG_EIGHT = 8;
    private static final int ARG_NINE = 9;
    private static final int ARG_TEN = 10;

    private FormFactory() { }

    public Form getForm(final String formInfo) {
        String[] arguments = formInfo.split(" ");
        if (arguments[0] == null) {
            return null;
        } else if (arguments[0].equals(FormTypes.LINE.toString())) {
            Color tmpColor = ImageUtility.setColor(arguments[ARG_FIVE],
                    Integer.parseInt(arguments[ARG_SIX]));
            return new Line(Integer.parseInt(arguments[ARG_ONE]),
                    Integer.parseInt(arguments[ARG_TWO]),
                    Integer.parseInt(arguments[ARG_THREE]),
                    Integer.parseInt(arguments[ARG_FOUR]),
                    tmpColor);
        } else if (arguments[0].equals(FormTypes.SQUARE.toString())) {
            Color outlineColor = ImageUtility.setColor(arguments[ARG_FOUR],
                    Integer.parseInt(arguments[ARG_FIVE]));
            Color interiorColor = ImageUtility.setColor(arguments[ARG_SIX],
                    Integer.parseInt(arguments[ARG_SEVEN]));
            return new Square(Integer.parseInt(arguments[ARG_ONE]),
                    Integer.parseInt(arguments[ARG_TWO]),
                    Integer.parseInt(arguments[ARG_THREE]),
                    outlineColor,
                    interiorColor);
        } else if (arguments[0].equals(FormTypes.RECTANGLE.toString())) {
            Color outlineColor = ImageUtility.setColor(arguments[ARG_FIVE],
                    Integer.parseInt(arguments[ARG_SIX]));
            Color interiorColor = ImageUtility.setColor(arguments[ARG_SEVEN],
                    Integer.parseInt(arguments[ARG_EIGHT]));
            return new Rectangle(Integer.parseInt(arguments[ARG_ONE]),
                    Integer.parseInt(arguments[ARG_TWO]),
                    Integer.parseInt(arguments[ARG_THREE]),
                    Integer.parseInt(arguments[ARG_FOUR]),
                    outlineColor,
                    interiorColor);
        } else if (arguments[0].equals(FormTypes.CIRCLE.toString())) {
            Color outlinerColor = ImageUtility.setColor(arguments[ARG_FOUR],
                    Integer.parseInt(arguments[ARG_FIVE]));
            Color interiorColor = ImageUtility.setColor(arguments[ARG_SIX],
                    Integer.parseInt(arguments[ARG_SEVEN]));
            return new Circle(Integer.parseInt(arguments[ARG_ONE]),
                    Integer.parseInt(arguments[ARG_TWO]),
                    Integer.parseInt(arguments[ARG_THREE]),
                    outlinerColor,
                    interiorColor);
        } else if (arguments[0].equals(FormTypes.TRIANGLE.toString())) {
            Color outlineColor = ImageUtility.setColor(arguments[ARG_SEVEN],
                    Integer.parseInt(arguments[ARG_EIGHT]));
            Color interiorColor = ImageUtility.setColor(arguments[ARG_NINE],
                    Integer.parseInt(arguments[ARG_TEN]));
            return new Triangle(Integer.parseInt(arguments[ARG_ONE]),
                    Integer.parseInt(arguments[ARG_TWO]),
                    Integer.parseInt(arguments[ARG_THREE]),
                    Integer.parseInt(arguments[ARG_FOUR]),
                    Integer.parseInt(arguments[ARG_FIVE]),
                    Integer.parseInt(arguments[ARG_SIX]),
                    outlineColor,
                    interiorColor);
        } else if (arguments[0].equals(FormTypes.DIAMOND.toString())) {
            Color outlineColor = ImageUtility.setColor(arguments[ARG_FIVE],
                    Integer.parseInt(arguments[ARG_SIX]));
            Color interiorColor = ImageUtility.setColor(arguments[ARG_SEVEN],
                    Integer.parseInt(arguments[ARG_EIGHT]));
            return new Diamond(Integer.parseInt(arguments[ARG_ONE]),
                    Integer.parseInt(arguments[ARG_TWO]),
                    Integer.parseInt(arguments[ARG_THREE]),
                    Integer.parseInt(arguments[ARG_FOUR]),
                    outlineColor,
                    interiorColor);
        } else if (arguments[0].equals(FormTypes.POLYGON.toString())) {
            ArrayList<Point> list = new ArrayList<>();

            Integer numberOfPoints = Integer.parseInt(arguments[ARG_ONE]);

            for (int i = 2; i <= numberOfPoints * 2 + 1; i += 2) {
                Point tmpPoint = new Point(Integer.parseInt(arguments[i]),
                        Integer.parseInt(arguments[i + 1]));
                list.add(tmpPoint);
            }


            Color outlineColor = ImageUtility.setColor(arguments[2 * numberOfPoints + ARG_TWO],
                    Integer.parseInt(arguments[2 * numberOfPoints + ARG_THREE]));
            Color interiorColor = ImageUtility.setColor(arguments[2 * numberOfPoints + ARG_FOUR],
                    Integer.parseInt(arguments[2 * numberOfPoints + ARG_FIVE]));

            return new Polygon(numberOfPoints,
                    list,
                    outlineColor,
                    interiorColor);
        }
        return null;
    }

    public static FormFactory getInstance(){
        return instance;
    }
}

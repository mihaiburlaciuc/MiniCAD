package main;

import java.awt.*;

public class Canvas {
    private Integer height;
    private Integer length;
    private Color color;

    public Canvas(final Integer height,
                  final Integer length,
                  final Color color) {
        this.height = height;
        this.length = length;
        this.color = color;
    }

    /**
     * getter inaltime.
     * @return
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * getter lungime.
     * @return
     */
    public Integer getLength() {
        return length;
    }

    /**
     * getter culoare.
     * @return
     */
    public Color getColor() {
        return color;
    }
}

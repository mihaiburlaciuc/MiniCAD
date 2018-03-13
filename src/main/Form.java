package main;

import java.awt.*;

public abstract class Form implements Visitable {
    private Color outlineColor;

    public Form(final Color outlineColor) {
        this.outlineColor = outlineColor;
    }

    /**
     * Salvam culoare de contur.
     * @return
     */
    public Color getOutlineColor() {
        return outlineColor;
    }

    abstract Point getCenterOfGravity();
}

package com.slamur.lib.javafx;

import javafx.scene.Node;

import java.awt.*;
import java.util.Locale;

public class InterfaceUtils {

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static void setBackgroundColor(Node node, Color backgroundColor, double alpha) {
        String cssColorString = String.format(
                Locale.US, "rgba(%d, %d, %d, %.1f)",
                backgroundColor.getRed(),
                backgroundColor.getGreen(),
                backgroundColor.getBlue(),
                alpha
        );

        node.setStyle("-fx-background-color: " + cssColorString);
    }
}

package raf.draft.dsw.controller.actions;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class AbstractRoomAction extends AbstractAction {
    @Getter
    protected boolean isCurrentAction;

    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            ImageIcon originalIcon = new ImageIcon(imageURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Adjust width and height as needed
            icon = new ImageIcon(scaledImage);
        } else {
            System.err.println("Resource not found: " + fileName);
        }

        return icon;
    }
}

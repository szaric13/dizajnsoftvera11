package raf.draft.dsw.gui.swing.tree.view;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.implementation.Building;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.ProjectExplorer;
import raf.draft.dsw.model.implementation.Room;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class DraftTreeCellRenderer extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);
        URL imageURL = null;

        if (((DraftTreeItem)value).getDraftNode() instanceof ProjectExplorer) {
            imageURL = getClass().getResource("/images/pe.gif");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Project) {
            imageURL = getClass().getResource("/images/tproject.gif");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Building) {
            imageURL = getClass().getResource("/images/building.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Room) {
            imageURL = getClass().getResource("/images/bed.png");
        }

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        Image scaledImage = ((ImageIcon) icon).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        setIcon(icon);

        return this;
    }
}

package raf.draft.dsw.controller.actions;

import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.view.MainFrame;
import raf.draft.dsw.gui.swing.tree.DraftTreeImplementation;
import raf.draft.dsw.model.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractRoomAction{
    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/tproject.gif"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    public void actionPerformed(ActionEvent arg0) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_SELECTED);
            return;
        }
        if (selected.getDraftNode() instanceof ProjectExplorer) {
            isCurrentAction = true;
            MainFrame.getInstance().getDraftTree().addChild(selected);
            isCurrentAction = false;
        }
        else {
            /*DraftTreeItem rootNode = MainFrame.getInstance().getDraftTree().();
            if (rootNode == null || !(rootNode.getDraftNode() instanceof ProjectExplorer)) {
                // If no ProjectExplorer exists, create a new root ProjectExplorer
                ProjectExplorer newProjectExplorer = new ProjectExplorer();
                MainFrame.getInstance().getDraftTree().setRoot(new DraftTreeItem(newProjectExplorer));
            } else {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_SELECTED);
            }*/
        }

    }
}

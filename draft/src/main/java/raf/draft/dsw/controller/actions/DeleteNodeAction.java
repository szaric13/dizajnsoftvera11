package raf.draft.dsw.controller.actions;

import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.controller.logger.MessageType;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.view.MainFrame;
import raf.draft.dsw.model.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteNodeAction extends AbstractRoomAction{

    public DeleteNodeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete Node");
        putValue(SHORT_DESCRIPTION, "Delete Node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator()
                    .generateMessage(ErrorType.NODE_NOT_SELECTED);
            return;
        }
        if (selected.getDraftNode() instanceof ProjectExplorer) {
            ApplicationFramework.getInstance().getMessageGenerator()
                    .generateMessage(ErrorType.NODE_CANNOT_BE_DELETED);
            return;
        }
        MainFrame.getInstance().getDraftTree().removeChild(selected);
        //MainFrame.getFrames().clone();
    }
}

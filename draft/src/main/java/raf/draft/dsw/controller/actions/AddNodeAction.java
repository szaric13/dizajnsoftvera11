package raf.draft.dsw.controller.actions;

import com.sun.tools.javac.Main;
import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.controller.logger.MessageType;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.view.MainFrame;
import raf.draft.dsw.model.implementation.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddNodeAction extends AbstractRoomAction {

    public AddNodeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/bed.png"));
        putValue(NAME, "New node");
        putValue(SHORT_DESCRIPTION, "New node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator()
                    .generateMessage(ErrorType.NODE_NOT_SELECTED);
            return;
        }

        if(selected.getDraftNode() instanceof Room) {
            ApplicationFramework.getInstance().getMessageGenerator().
                    generateMessage(ErrorType.NODE_CANNOT_HAVE_CHILDREN);
            return;
        }

        MainFrame.getInstance().getDraftTree().addChild(selected);
    }
}

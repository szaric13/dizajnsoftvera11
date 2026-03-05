package raf.draft.dsw.gui.swing.tree.view;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.tree.controller.DraftTreeCellEditor;
import raf.draft.dsw.gui.swing.tree.controller.DraftTreeSelectionListener;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DraftTreeView extends JTree implements MouseListener {

    public DraftTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        DraftTreeCellRenderer draftTreeCellRenderer = new DraftTreeCellRenderer();
        addTreeSelectionListener(new DraftTreeSelectionListener());
        setCellEditor(new DraftTreeCellEditor(this, draftTreeCellRenderer));
        setCellRenderer(draftTreeCellRenderer);
        setEditable(true);
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getClickCount()==2){
            DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

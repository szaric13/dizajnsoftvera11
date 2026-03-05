package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class DraftTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        DraftTreeItem itemSelected = (DraftTreeItem) path.getLastPathComponent();

        if (itemSelected != null && itemSelected.getDraftNode() != null) {
            System.out.println("Selected node: " + itemSelected.getDraftNode().getName());
        } else {
            System.err.println("Warning: Selected item or DraftNode is null.");
        }

        System.out.println("getPath: " + e.getPath());
    }
}


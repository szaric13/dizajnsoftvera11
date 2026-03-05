package raf.draft.dsw.gui.swing.tree;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.controller.logger.MessageGenerator;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.Building;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.ProjectExplorer;
import raf.draft.dsw.model.implementation.Room;
import raf.draft.dsw.nodefactory.FactoryProduction;
import raf.draft.dsw.nodefactory.NodeCreatorFactory;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.Random;

@Getter
@Setter
public class DraftTreeImplementation implements DraftTree {

    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;
    private DraftTreeItem root;


    @Override
    public DraftTreeView generateTree(ProjectExplorer projectExplorer) {
        DraftTreeItem root = new DraftTreeItem(projectExplorer);
        this.root = root;
        treeModel = new DefaultTreeModel(root);
        treeView = new DraftTreeView(treeModel);
        return treeView;
    }
    private DraftNode createChild(DraftNodeComposite parent) {
        NodeCreatorFactory nodeFactory = FactoryProduction.getFactory(parent);
        return nodeFactory.getNode(parent);

    }


    @Override
    public void addChild(DraftTreeItem parent) {
        if (!(parent.getDraftNode() instanceof DraftNodeComposite))
            return;

        DraftNode child = createChild((DraftNodeComposite) parent.getDraftNode());
        parent.add(new DraftTreeItem(child));
        ((DraftNodeComposite) parent.getDraftNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void removeChild(DraftTreeItem child) {
        if (child.getDraftNode() instanceof ProjectExplorer) {
            MessageGenerator msgGen = MessageGenerator.getInstance();
            msgGen.generateMessage(ErrorType.PROJECTEXPLORER_CANNOT_BE_DELETED);
            return;
        }
        DraftNodeComposite parent = null;
        if(child.getDraftNode().getParent() instanceof DraftNodeComposite){
            parent = (DraftNodeComposite) child.getDraftNode().getParent();
            parent.removeChild(child.getDraftNode());
        }
        if(parent == null)
            return;
        DefaultMutableTreeNode selected = (DefaultMutableTreeNode) treeView.getSelectionPath().getLastPathComponent();
        treeModel.removeNodeFromParent(selected);
        // Set parent as selected node
        treeView.setSelectionPath(new TreePath(parent));
        treeView.expandPath(new TreePath(parent));
        SwingUtilities.updateComponentTreeUI(treeView);

    }

    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }
}

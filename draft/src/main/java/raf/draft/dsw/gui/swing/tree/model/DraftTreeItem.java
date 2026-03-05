package raf.draft.dsw.gui.swing.tree.model;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.composite.DraftNode;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DraftTreeItem extends DefaultMutableTreeNode {
    private DraftNode draftNode;
    private List<DraftTreeItem> children = new ArrayList<>();

    public DraftTreeItem(DraftNode draftNode)
    {
        this.draftNode = draftNode;
    }

    @Override
    public String toString() {
        return (draftNode != null) ? draftNode.getName() : "Unnamed Node";
    }

    public void setName(String name)
    {
        this.draftNode.setName(name);
    }
}

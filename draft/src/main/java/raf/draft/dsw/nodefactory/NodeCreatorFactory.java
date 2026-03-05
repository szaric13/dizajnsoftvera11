package raf.draft.dsw.nodefactory;

import lombok.NoArgsConstructor;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;

@NoArgsConstructor
public abstract class NodeCreatorFactory  {


    public DraftNode getNode(DraftNodeComposite parent){
        DraftNode n = createNode(parent);
        n.setName(n.getName() + " " + (parent.getChildren().size() + 1));
        parent.addChild(n);
        return n;
    }

    public abstract DraftNode createNode(DraftNodeComposite parent);
}

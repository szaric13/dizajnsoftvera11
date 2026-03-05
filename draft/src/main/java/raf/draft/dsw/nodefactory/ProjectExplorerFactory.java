package raf.draft.dsw.nodefactory;

import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.ProjectExplorer;

public class ProjectExplorerFactory extends NodeCreatorFactory {
    @Override
    public DraftNode createNode(DraftNodeComposite parent) {
        return new ProjectExplorer();
    }
}

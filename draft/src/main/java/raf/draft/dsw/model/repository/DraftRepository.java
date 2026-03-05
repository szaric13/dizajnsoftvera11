package raf.draft.dsw.model.repository;

import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.ProjectExplorer;

public interface DraftRepository {
    ProjectExplorer getRoot();

    public DraftNode createChild(DraftNode parent);
}

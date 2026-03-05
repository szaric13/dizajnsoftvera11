package raf.draft.dsw.model.repository;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.ProjectExplorer;
import raf.draft.dsw.nodefactory.FactoryProduction;
import raf.draft.dsw.nodefactory.NodeCreatorFactory;
@Getter
@Setter
public class DraftRepositoryImplementation implements DraftRepository {

    private ProjectExplorer root;


    public DraftRepositoryImplementation() {
        this.root = new ProjectExplorer();

    }

    @Override
    public ProjectExplorer getRoot() {
        return this.root;
    }



    @Override
    public DraftNode createChild(DraftNode parent) {
        NodeCreatorFactory nf = FactoryProduction.getFactory(parent);
        return nf.createNode((DraftNodeComposite) parent);
    }
}

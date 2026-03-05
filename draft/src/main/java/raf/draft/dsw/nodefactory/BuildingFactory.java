package raf.draft.dsw.nodefactory;

import lombok.NoArgsConstructor;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.Building;
import raf.draft.dsw.model.implementation.Project;

@NoArgsConstructor
public class BuildingFactory extends NodeCreatorFactory {
    private static int num = 1;
    @Override
    public DraftNode createNode(DraftNodeComposite parent) {
        Building building = new Building("Building " + num,  parent);
        return building;
    }


}

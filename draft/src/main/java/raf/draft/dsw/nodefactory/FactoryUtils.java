package raf.draft.dsw.nodefactory;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.gui.swing.view.MainFrame;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.implementation.Building;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.ProjectExplorer;
@Getter
@Setter
public class FactoryUtils {
    private ProjectExplorerFactory projectExplorerFactory;
    private ProjectFactory projectFactory;
    private RoomFactory diagramFactory;
    private BuildingFactory packageFactory;

    public FactoryUtils(){
        initialiseActions();
    }
    private void initialiseActions(){
        projectExplorerFactory = new ProjectExplorerFactory();
        projectFactory = new ProjectFactory();
        packageFactory = new BuildingFactory();
        diagramFactory = new RoomFactory();
    }

    public NodeCreatorFactory getNodeFactory(DraftNode node){
        if((node instanceof Project) && MainFrame.getInstance().getActionManager().
                getNewProjectAction().isCurrentAction())
            return packageFactory;

        if(node instanceof Building){
            return diagramFactory;
        }else if(node instanceof Project){
            return packageFactory;
        }else if(node instanceof ProjectExplorer){
            return projectFactory;
        }else{
            return null;
        }
    }
}

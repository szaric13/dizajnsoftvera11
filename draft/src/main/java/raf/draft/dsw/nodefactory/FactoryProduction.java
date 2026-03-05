package raf.draft.dsw.nodefactory;

import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.implementation.Building;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.ProjectExplorer;
import raf.draft.dsw.model.implementation.Room;

import javax.swing.*;

public class FactoryProduction {
    public static NodeCreatorFactory getFactory(DraftNode node){
        if(node instanceof ProjectExplorer)
            return new ProjectFactory();
        else if (node instanceof Building)
            return new BuildingFactory();
        else if (node instanceof Project){

            String[] options = { "Building", "Room"};
            int selection = JOptionPane.showOptionDialog(null, "Which child do you want to make:", "Opcija",
                    0, 3, null, options, options[0]);
            if (selection == 0) {
                return new BuildingFactory();
            }
            if (selection == 1) {
                return new RoomFactory();
            }
        }

        return null;
    }
}

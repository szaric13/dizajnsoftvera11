package raf.draft.dsw.controller.actions;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ActionManager {
    ExitAction exitAction = new ExitAction();
    AboutUsAction aboutUsAction = new AboutUsAction();
    NewProjectAction newProjectAction = new NewProjectAction();
    DeleteNodeAction deleteNodeAction = new DeleteNodeAction();
    AddNodeAction addNodeAction = new AddNodeAction();
    //NewPackageAction newPackageAction = new NewPackageAction();

}

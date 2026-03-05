package raf.draft.dsw.gui.swing;

import raf.draft.dsw.gui.swing.rightside.ProjectView;

public class PanelImplementation implements Panel{
    private ProjectView projectView;
    @Override
    public ProjectView generatePanel() {
        projectView = new ProjectView();
        return projectView;
    }
}

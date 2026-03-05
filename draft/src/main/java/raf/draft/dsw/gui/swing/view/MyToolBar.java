package raf.draft.dsw.gui.swing.view;

import raf.draft.dsw.controller.actions.ActionManager;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getAboutUsAction());
        add(MainFrame.getInstance().getActionManager().getAddNodeAction());
        add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        //ExitAction ea = new ExitAction();
        //AboutUsAction aa = new AboutUsAction();
        //add(ea);
        //add(aa);
    }
}

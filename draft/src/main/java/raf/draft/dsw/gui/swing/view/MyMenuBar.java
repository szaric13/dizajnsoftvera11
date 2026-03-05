package raf.draft.dsw.gui.swing.view;

import raf.draft.dsw.controller.actions.ActionManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        //ExitAction ea = new ExitAction();
        //AboutUsAction aua = new AboutUsAction();
        //fileMenu.add(ea);
        //fileMenu.add(aua);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getAboutUsAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getAddNodeAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        JMenu source = new JMenu("Edit");
        source.add(MainFrame.getInstance().getActionManager().getAboutUsAction());

        add(fileMenu);
        add(source);
    }
}

package raf.draft.dsw;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.view.MainFrame;

public class AppCore {
    public static void main(String[] args) {

        ApplicationFramework appCore = ApplicationFramework.getInstance();
        MainFrame instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
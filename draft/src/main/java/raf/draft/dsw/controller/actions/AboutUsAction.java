package raf.draft.dsw.controller.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AboutUsAction extends AbstractRoomAction {
public AboutUsAction() {
    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    putValue(SMALL_ICON, loadIcon("/images/abus.png"));
    putValue(NAME, "Creators");
    putValue(SHORT_DESCRIPTION, "Creators");
}

    @Override
    public void actionPerformed(ActionEvent e) {

        String message = "Studenti koji rade na projektu:\n" +
                "1. Strahinja Nikolic RN 28/2022 \n" +
                "2. Strahinja Zaric RN 73/2022 \n";
        JOptionPane.showMessageDialog(null, message, "About Us",JOptionPane.INFORMATION_MESSAGE, loadIcon("/images/aboutus.png"));
    }
}

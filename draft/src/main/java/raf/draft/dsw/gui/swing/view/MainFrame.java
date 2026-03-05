package raf.draft.dsw.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.logger.Message;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.middle.TabbedPanel;
import raf.draft.dsw.gui.swing.tree.DraftTree;
import raf.draft.dsw.gui.swing.tree.DraftTreeImplementation;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru

    private ActionManager actionManager;
    private DraftTree draftTree;
    private static MainFrame instance;
    private DraftTreeView projectExplorer;
    private JMenuBar menu;
    private JToolBar toolbar;




    private MainFrame() {
        //this.applicationFramework = applicationFramework;

    }


    private void initialize(){
        actionManager = new ActionManager();
        draftTree = new DraftTreeImplementation();
        projectExplorer = draftTree.generateTree(ApplicationFramework.getInstance().getDraftRepository().getRoot());
        initialiseGui(projectExplorer);
        ApplicationFramework.getInstance().getMessageGenerator().addSubscriber(this);
    }
    private void initialiseGui(DraftTreeView projcetExplorer){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DraftRoom");
        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolbar = new MyToolBar();
        add(toolbar,BorderLayout.NORTH);



        projectExplorer.setPreferredSize(new Dimension(150, screenHeight / 2));
        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(projcetExplorer);
        scrollPane.setMinimumSize(new Dimension(700, 150));
        add(scrollPane, BorderLayout.WEST);
        //TabbedPanel tp = new TabbedPanel(ApplicationFramework.getInstance().getDraftRepository().getRoot());
        //add(tp, BorderLayout.CENTER);



    }
    public static MainFrame getInstance(){
        if(instance==null){
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }


    @Override
    public void update(Object var1) {
        Message msg = (Message) var1;
        String formattedMsg = String.format("[%s][%s] %s",
                msg.getType(),
                msg.getTime().toString(),msg.getText());
        JOptionPane.showMessageDialog(null, formattedMsg);
    }
}
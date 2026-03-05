package raf.draft.dsw.gui.swing.rightside;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.ProjectExplorer;
import raf.draft.dsw.model.implementation.Room;
import raf.draft.dsw.gui.swing.rightside.RoomView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectView extends JPanel implements ISubscriber {
    private Project project; // Observed Project
    private JLabel projectLabel = new JLabel();
    private JLabel authorLabel = new JLabel();
    private JTabbedPane tabbedPane = new JTabbedPane();
    //private List<RoomView> roomTabs = new ArrayList<>();

    public ProjectView() {
        //this.project = project;
        //project.addSubscriber(this);

        this.setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.add(projectLabel);
        headerPanel.add(authorLabel);
        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        updateProjectDetails();
        loadRoomViews();
    }
    private void updateProjectDetails() {
        projectLabel.setText("Project: " + project.getName());
        authorLabel.setText("Author: " + project.getAuthor());
        revalidate();
        repaint();
    }
    private void loadRoomViews() {
        tabbedPane.removeAll();
        //roomTabs.clear();

        for (DraftNode room : project.getChildren()) {
            addRoomTab((Room) room);
        }
    }
    private void addRoomTab(Room room) {
        RoomView roomView = new RoomView(room);
        //roomTabs.add(roomView);
        tabbedPane.addTab(room.getName(), roomView);
    }
    public void updatePanel(Project selectedProject) {
        // Unsubscribe from the previous project to avoid stale updates
        if (this.project != null) {
            this.project.removeSubscriber(this);
        }

        // Subscribe to the newly selected project
        selectedProject.addSubscriber(this);
        this.project = selectedProject;

        // Update labels for the new project
        this.projectLabel.setText("Project: " + project.getName());
        this.authorLabel.setText("Author: " + project.getAuthor());

        // Remove all existing tabs and clear references
        tabbedPane.removeAll();
        //roomTabs.clear();

        // Load all rooms as tabs
        for (DraftNode room : project.getChildren()) {
            addRoomTab((Room)room);
        }

        // Refresh the UI
        revalidate();
        repaint();
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof DraftNode) {
            DraftNode updatedNode = (DraftNode) notification;
            //projectInfo.setText("Updated: " + updatedNode.getName());
        }
    }
    /*
    *  @Override
    public void update(Object message) {
        switch (message.toString()) {
            case "RENAME":
                updateProjectDetails();
                break;

            case "NEW_CHILD":
                // A new Room has been added to the project
                Room newRoom = project.getChildren().get(project.getChildren().size() - 1);
                addRoomTab(newRoom);
                break;

            case "REMOVE_CHILD":
                loadRoomViews(); // Reload all rooms after deletion
                break;

            case "AUTHOR":
                updateProjectDetails();
                break;

            default:
                System.out.println("Unhandled notification: " + message);
                break;
        }
    }*/


}

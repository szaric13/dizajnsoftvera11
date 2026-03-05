package raf.draft.dsw.gui.swing.middle;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.Building;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.ProjectExplorer;
import raf.draft.dsw.model.implementation.Room;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TabbedPanel extends JPanel implements ISubscriber {
    private JLabel projectLabel;  // Project Name
    private JLabel buildingLabel; // Building Name or '/'
    private JLabel authorLabel;   // Author Name
    private JTabbedPane tabbedPane; // Contains Room Tabs
    private Map<Building, Color> buildingColors;  // Maps Building to a specific color
    private Project project;  // Selected Project
    private ProjectExplorer projectExplorer;

    public TabbedPanel(ProjectExplorer projectExplorer) {
        this.projectExplorer = projectExplorer;
        this.buildingColors = new HashMap<>();
        this.setLayout(new BorderLayout());

        // Top Panel for Labels
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        projectLabel = new JLabel("Project: " + project.getName());
        buildingLabel = new JLabel("Building: /");
        authorLabel = new JLabel("Author: " + project.getAuthor());

        labelPanel.add(projectLabel);
        labelPanel.add(buildingLabel);
        labelPanel.add(authorLabel);
        this.add(labelPanel, BorderLayout.NORTH);

        // Center Panel with JTabbedPane
        tabbedPane = new JTabbedPane();
        this.add(tabbedPane, BorderLayout.CENTER);

        // Subscribe to the project for dynamic updates
        projectExplorer.addSubscriber(this);

        loadRoomTabs();
    }

    private void loadRoomTabs() {
        tabbedPane.removeAll(); // Clear existing tabs
        buildingColors.clear();

        for (DraftNode child : projectExplorer.getChildren()) {
            if (child instanceof Project) {
                Project project = (Project) child;
                roomsForProject(project);
            }
        }
    }
    private void roomsForProject(Project project) {

        for (DraftNode child : project.getChildren()) {
            addRoomTabsRecursively(child, project);
        }
    }

    private void addRoomTabsRecursively(DraftNode node, Project project) {
        if (node instanceof Room) {
            Room room = (Room) node;
            Building parentBuilding = (Building) room.getParent();
            Color buildingColor = getBuildingColor(parentBuilding);
            JPanel roomPanel = new JPanel();
            roomPanel.setBackground(buildingColor);
            roomPanel.add(new JLabel("Room: " + room.getName()));

            // Add the tab
            tabbedPane.addTab(room.getName(), roomPanel);
            updateLabels(project,parentBuilding);

        } else if (node instanceof Building || node instanceof Project) {
            // Recursively add children
            for (DraftNode child : ((DraftNodeComposite) node).getChildren()) {
                addRoomTabsRecursively(child, project);
            }
        }
    }

    private Color getBuildingColor(Building building) {
        if (building == null) {
            return Color.LIGHT_GRAY;
        }
        return building.getBoja();
    }
    private void updateLabels(Project project, Building building) {
        projectLabel.setText("Project: " + project.getName());
        buildingLabel.setText("Building: " + (building != null ? building.getName() : "/"));
        authorLabel.setText("Author: " + project.getAuthor());
    }

    @Override
    public void update(Object notification) {
        /*switch (notification) {
            case "ROOM_ADDED":
            case "ROOM_REMOVED":
            case "BUILDING_UPDATED":
                loadRoomTabs();
                break;
            case "PROJECT_RENAMED":
                projectLabel.setText("Project: " + project.getName());
                break;
            case "AUTHOR_UPDATED":
                authorLabel.setText("Author: " + project.getAuthor());
                break;
        }*/
        revalidate();
        repaint();
    }
}

package raf.draft.dsw.gui.swing.rightside;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.implementation.Room;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RoomView extends JPanel implements ISubscriber {
    private Room room; // Observed Room
    private JLabel roomLabel = new JLabel();
    private JLabel parentLabel = new JLabel();
    //private List<Component> elements = new ArrayList<>();

    public RoomView(Room room) {
        this.room = room;
        room.addSubscriber(this); // Subscribe to updates from the Room
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        roomLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        parentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(roomLabel);
        add(parentLabel);
        updateRoomDetails();
    }

    @Override
    public void update(Object message) {
        switch (message.toString()) {
            case "RENAME":
                updateRoomDetails(); // Update UI to reflect Room's new name
                break;
            case "DELETE":
                Container parent = this.getParent();
                if (parent != null) {
                    parent.remove(this);
                    parent.revalidate();
                    parent.repaint();
                }
                break;
            default:
                System.out.println("Unhandled notification: " + message);
                break;
        }
    }
    private void updateRoomDetails() {
        roomLabel.setText("Room Name: " + room.getName());
        parentLabel.setText("Parent: " + (room.getParent() != null ? room.getParent().getName() : "None"));
        revalidate();
        repaint();
    }
}

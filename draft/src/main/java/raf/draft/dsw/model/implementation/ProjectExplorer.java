package raf.draft.dsw.model.implementation;

import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.controller.logger.MessageGenerator;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.NodeChangeEvent;

public class ProjectExplorer extends DraftNodeComposite {
    private List<ISubscriber> subscribers = new ArrayList<>();
    private List<DraftNode> children = new ArrayList<>();

    public ProjectExplorer() {
        super("Project Explorer", null);
    }

    @Override
    public void addChild(DraftNode child) {
        if (child == null) {
            MessageGenerator msgGen = MessageGenerator.getInstance();
            msgGen.generateMessage(ErrorType.NODE_CANNOT_BE_DELETED);
            return;
        }
        if (!(child instanceof Project)) {
            MessageGenerator msgGen = MessageGenerator.getInstance();
            msgGen.generateMessage(ErrorType.NODE_CANNOT_HAVE_CHILDREN);
            return;
        }
        if (!this.getChildren().contains(child)) {
            this.getChildren().add(child);
            notifySubscriber(this);
        }
    }

    @Override
    public void removeChild(DraftNode child) {
        if (child != null && child instanceof Project) {
            this.getChildren().remove(child);
            notifyStructureChange("Project removed: " + child.getName());
        }

    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub != null && !subscribers.contains(sub)) {
            subscribers.add(sub);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        for (ISubscriber sub : subscribers) {
            sub.update(notification); // Notify all observers
        }
    }
}

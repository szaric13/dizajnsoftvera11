package raf.draft.dsw.model.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.controller.logger.MessageGenerator;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Project extends DraftNodeComposite {
    private String author;
    private String path;
    private List<ISubscriber> subscribers = new ArrayList<>();
    private List<DraftNode> children = new ArrayList<>();

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public Project(String name, DraftNodeComposite parent) {
        super("Project", parent);
        author = "Author";
        path = "Path";
    }

   /* @Override
    public void addChild(DraftNode child) {
        if(child instanceof Building){
            Building building = (Building) child;
            if(!this.getChildren().contains(building)){
                this.getChildren().add(building);
                notifyStructureChange("Building added: " + building.getName());
            }
        }
        else if (child instanceof Room){
            Room room = (Room) child;
            if(!this.getChildren().contains(room)){
                this.getChildren().add(room);
                notifyStructureChange("Room added: " + room.getName());
            }
        }
        else {
            System.out.println("Invalid child type.");
        }
    }*/
    @Override
    public void addChild(DraftNode child){
        if (child == null) {
            MessageGenerator msgGen = MessageGenerator.getInstance();
            msgGen.generateMessage(ErrorType.NODE_CANNOT_BE_DELETED); // Example error message
            return;
        }
        if (!(child instanceof Building) || !(child instanceof Room)) {
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
        if(this.getChildren().contains(child)){
            this.getChildren().remove(child);
            notifyStructureChange("Child removed: " + child.getName());
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

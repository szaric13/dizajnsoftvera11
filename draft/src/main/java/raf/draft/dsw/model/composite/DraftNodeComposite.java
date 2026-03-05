package raf.draft.dsw.model.composite;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.logger.ErrorType;
import raf.draft.dsw.controller.logger.MessageGenerator;
import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class DraftNodeComposite extends DraftNode implements IPublisher{
    private List<DraftNode> children = new ArrayList<>();
    private List<ISubscriber> subscribers = new ArrayList<>();
    private String name;
    private DraftNode parent;
    public DraftNodeComposite(String name, DraftNode parent)
    {
        super(name, parent);
    }
    public List<DraftNode> getChildren() {
        return children;
    }
    public void addChild(DraftNode child){
        if (child != null) {
            if (nameExists(child.getName())) {
                MessageGenerator msgGen = MessageGenerator.getInstance();
                msgGen.generateMessage(ErrorType.NAME_OF_NODE_ALREADY_EXISTS);
                return;
            }
            this.getChildren().add(child);
        }
    }
    public abstract void removeChild(DraftNode child);
    public void setChildren(List<DraftNode> children) {
        this.children = children;
    }
    public boolean nameExists(String name){
        for (DraftNode draftNode : children){
            if(draftNode.getName().trim().equals(name.trim())) {
                return true;
            }
        }
        return false;
    }

    public DraftNode getChildByName(String name) {
        for (DraftNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
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
            sub.update(notification);
        }
    }
    protected void notifyStructureChange(String message) {
        notifySubscriber("Structure change: " + message);
    }

}

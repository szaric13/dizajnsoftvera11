package raf.draft.dsw.model.implementation;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;

public class Room extends DraftNode {

    public Room(String name, DraftNodeComposite parent) {
        super("Room" + " " + " ", parent);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {

    }

    @Override
    public void notifySubscriber(Object notification) {

    }
}

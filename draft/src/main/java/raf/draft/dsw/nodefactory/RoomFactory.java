package raf.draft.dsw.nodefactory;

import lombok.NoArgsConstructor;
import raf.draft.dsw.model.composite.DraftNode;
import raf.draft.dsw.model.composite.DraftNodeComposite;
import raf.draft.dsw.model.implementation.Project;
import raf.draft.dsw.model.implementation.Room;

@NoArgsConstructor
public class RoomFactory extends NodeCreatorFactory {

    private static int num = 1;


    @Override
    public DraftNode createNode(DraftNodeComposite parent) {
        Room room = new Room("Room" + num, (DraftNodeComposite) parent);
        return room;
    }


}

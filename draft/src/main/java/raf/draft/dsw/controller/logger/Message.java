package raf.draft.dsw.controller.logger;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Message {
    private MessageType type;
    private String text;
    private long milis = System.currentTimeMillis();
    private Timestamp time;
    private ErrorType errorType;

    public Message(ErrorType errorType) {
        switch (errorType) {
            case NAME_CANNOT_BE_EMPTY:
                this.type = MessageType.ERROR;
                this.text = "Name can't be empty.";
                break;
            case NODE_CANNOT_BE_DELETED:
                this.type=MessageType.ERROR;
                this.text = "Node can't be deleted.";
                break;
            case NAME_OF_NODE_ALREADY_EXISTS:
                this.type=MessageType.ERROR;
                this.text = "Name od node already exists.";
                break;
            case PROJECTEXPLORER_CANNOT_BE_DELETED:
                this.type= MessageType.ERROR;
                this.text = "ProjectExplorer can't be deleted.";
                break;
            case NODE_NOT_SELECTED:
                this.type = MessageType.ERROR;
                this.text= "Select a node.";
                break;
            case NODE_CANNOT_HAVE_CHILDREN:
                this.type = MessageType.ERROR;
                this.text = "You selected Room, which can't have children.";
        }


    }
}
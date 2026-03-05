package raf.draft.dsw.controller.logger;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements IPublisher {
    private static MessageGenerator instance;
    List<ISubscriber> subscribers;

    //String message = "[" + type + "] " + "[" + time.toString() + "] " + content;
    //Object notification = message;
    private MessageGenerator() {
        this.subscribers = new ArrayList<>();
    }

    public static MessageGenerator getInstance() {
        if (instance == null) {
            instance = new MessageGenerator();
        }
        return instance;
    }

    public void generateMessage(ErrorType errorType) {
        //gde god da nastane greska ja pozivam metodu da napravi poruku
        Message message = new Message(errorType);
        // posalje subs da tu poruku obrade
        notifySubscriber(message);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }



    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        if (subscribers == null || subscribers.isEmpty())
            return;
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }


    /*public void generateSystemMessage(SystemMessageType systemMsgType, MessageType msgType)
    {
        var msgStr = SystemMessageStrings.msgMap.get(systemMsgType);
        notifySubscriber(new Message(msgType, msgStr, LocalDateTime.now()));
    }*/
}

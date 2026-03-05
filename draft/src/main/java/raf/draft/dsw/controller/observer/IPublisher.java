package raf.draft.dsw.controller.observer;

import java.util.concurrent.Flow;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscriber(Object notification);
}

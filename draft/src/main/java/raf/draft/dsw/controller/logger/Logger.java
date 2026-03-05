package raf.draft.dsw.controller.logger;

import raf.draft.dsw.controller.observer.ISubscriber;

public interface Logger extends ISubscriber {
    void log(String message);
}
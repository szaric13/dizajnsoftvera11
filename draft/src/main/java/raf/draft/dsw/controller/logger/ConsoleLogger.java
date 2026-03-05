package raf.draft.dsw.controller.logger;

public class ConsoleLogger implements Logger {
    public ConsoleLogger()
    {

    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void update(Object var1) {
        //kad dobije poruku nek ide log(poruka)
    }
}

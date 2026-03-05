package raf.draft.dsw.controller.logger;

public class LoggerFactory {

    public LoggerFactory(){

    }
    public Logger createLogger(String loggerType)
    {
        if(loggerType == null) return null;
        switch(loggerType){
            case "Console": return new ConsoleLogger();
            case "File": return new FileLogger();
            default: throw new IllegalArgumentException("Invalid logger type");
        }
    }
}

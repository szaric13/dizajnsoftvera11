package raf.draft.dsw.core;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.controller.logger.*;

import raf.draft.dsw.model.repository.DraftRepository;
import raf.draft.dsw.model.repository.DraftRepositoryImplementation;

@Getter
@Setter
public class ApplicationFramework {
    //buduca polja za model celog projekta
    private DraftRepository draftRepository;
    private MessageGenerator messageGenerator;
    private LoggerFactory loggerFactory;
    private Logger consoleLogger;
    private Logger fileLogger;


    private static ApplicationFramework instance;
    public static ApplicationFramework getInstance() {
        if (instance == null) {
            instance = new ApplicationFramework();
        }
        return instance;
    }

    private ApplicationFramework(){
        initialize();
    }


    public void initialize() {
        this.draftRepository = new DraftRepositoryImplementation();
        this.loggerFactory = new LoggerFactory();
        this.messageGenerator = MessageGenerator.getInstance();
        this.fileLogger = loggerFactory.createLogger("File");
        this.consoleLogger= loggerFactory.createLogger("Console");
        //MainFrame mainFrame = MainFrame.getInstance();
        //mainFrame.setVisible(true);
    }

}

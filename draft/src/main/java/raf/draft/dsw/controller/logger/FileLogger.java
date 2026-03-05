package raf.draft.dsw.controller.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger{

    String filePath = "log.txt";

    public FileLogger() {

    }

    @Override
    public void log(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Object var1) {
        //kad dobije update nek ide log(poruka)
    }
}

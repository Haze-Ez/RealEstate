package realestate;
import java.io.IOException;
import java.util.logging.*;

public class logConfig {
    public static void setupLogging() {
        try {
            Logger rootLogger = Logger.getLogger("");
            Handler fileHandler = new FileHandler("realEstateApp.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);
            rootLogger.setLevel(Level.ALL);
        } catch (IOException e) {
            Logger.getLogger(logConfig.class.getName()).log(Level.SEVERE, "Failed to initialize logging", e);
        }
    }
}

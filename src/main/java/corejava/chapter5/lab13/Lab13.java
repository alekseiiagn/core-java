package corejava.chapter5.lab13;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab13 {

    private static final String[] BAD_WORDS_IN_LOWER_CASE = {"sex", "drag", "c++"};
    private static final Logger logger = getCustomLogger();

    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello I'm here");
        logger.log(Level.INFO, "Sex");
        logger.log(Level.INFO, "World");
        logger.log(Level.INFO, "sexy");
        logger.log(Level.INFO, "C++");
        logger.log(Level.INFO, "C/C++");
    }

    private static Logger getCustomLogger() {
        Logger logger = Logger.getLogger("corejava.chapter5.lab13");
        logger.setFilter(record -> {
            String message = record.getMessage().toLowerCase();
            for (String badWord : BAD_WORDS_IN_LOWER_CASE) {
                if (message.contains(badWord)) return false;
            }
            return true;
        });
        return logger;
    }
}

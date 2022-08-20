package corejava.chapter5.lab13;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab13 {

    private static final String[] BAD_WORDS_IN_LOWER_CASE = {"sex", "drag", "c++"};
    private static final Logger logger = getCustomLogger();

    private static Logger getCustomLogger() {
        Logger logger = Logger.getLogger("corejava.chapter5.lab13");
        logger.setFilter(createCustomFilter());
        return logger;
    }

    private static Filter createCustomFilter() {
        return record -> {
            String message = record.getMessage().toLowerCase();
            for (String badWord : BAD_WORDS_IN_LOWER_CASE) {
                if (message.contains(badWord)) return false;
            }
            return true;
        };
    }

    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello I'm here");
        logger.log(Level.INFO, "Sex");
        logger.log(Level.INFO, "World");
        logger.log(Level.INFO, "sexy");
        logger.log(Level.INFO, "C++");
        logger.log(Level.INFO, "C/C++");
    }
}

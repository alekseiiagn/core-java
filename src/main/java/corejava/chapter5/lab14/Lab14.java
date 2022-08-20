package corejava.chapter5.lab14;

import java.io.IOException;
import java.util.logging.*;

public class Lab14 {

    private static final String CURRENT_PACKAGE = "corejava.chapter5.lab14";
    private static final String FORMAT_FILE = "log_%g";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/chapter5/lab14";

    private static final Logger logger;

    static {
        try {
            logger = getLoggerHTML();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello world");
        foo();
    }

    public static void foo() {
        logger.log(Level.INFO, "Hi");
    }

    private static Logger getLoggerHTML() throws IOException {
        Logger logger = Logger.getLogger(CURRENT_PACKAGE);
        Handler handler = new FileHandler(PATH_TO_OUTPUT_FILE + "/" + FORMAT_FILE + ".html");
        logger.addHandler(handler);
        return logger;
    }
}

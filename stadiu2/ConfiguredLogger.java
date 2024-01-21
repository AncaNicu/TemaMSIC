package library;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguredLogger {
    private static Logger logger = Logger.getLogger(ConfiguredLogger.class.getName());
    static {
        // Configure logger
        logger.setUseParentHandlers(false);

        // Create a ConsoleHandler and set its formatter to CustomFormatter
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());

        // Set the logger level to INFO
        logger.setLevel(Level.INFO);

        // Add the ConsoleHandler to the logger
        logger.addHandler(consoleHandler);
    }
    
    public void info(String message)
    {
    	logger.info(message);
    }
    
}

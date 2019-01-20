package creational.factory.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoggerFactory {

    public boolean isFileLoggingEnabled() {
        Properties p = new Properties();
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("logger.properties");
            if (in != null) {
                p.load(in);
                String fileLoggingValue
                        = p.getProperty("FileLogging");
                return fileLoggingValue.equalsIgnoreCase("ON") == true;
            }
        } catch (IOException e) {

        }
        return false;
    }

    //Factory Method
    public Logger getLogger() {
        if (isFileLoggingEnabled()) {
            return new FileLogger();
        } else {
            return new ConsoleLogger();
        }
    }
}

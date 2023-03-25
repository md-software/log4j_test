
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        // ====== args ======
        for (String arg : args) {
            System.out.println("arg: "+arg);
        }
        // ========= Log4j =========
        // Get property -Dlogger.level if exists
        String loggingLevel = System.getProperty("logging.level");
        Level finalLevel = Level.ERROR;  // default value
        if (loggingLevel != null) {
            System.out.println("logging.level="+loggingLevel);
            finalLevel = Level.toLevel(loggingLevel);
        } else {
            Properties p = System.getProperties();
            p.put("logging.level", "ERROR");
            System.setProperties(p);
        }
        Configurator.setRootLevel(finalLevel);
        Logger logger = LogManager.getLogger(Main.class);
        // =========================

        logger.trace("msg de trace");
        logger.debug("msg de debogage");
        logger.info("msg d'information");
        logger.warn("msg d'avertissement");
        logger.error("msg d'erreur");
        logger.fatal("msg d'erreur fatale");
    }
}

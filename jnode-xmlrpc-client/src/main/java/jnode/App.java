package jnode;

import jnode.core.Parameters;
import jnode.ui.MainForm;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public final class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App() {
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            LOGGER.error("need path to config in call parameters");
            return;
        }

        Properties props = tryLoadProperties(args[0]);

        if (props == null) {
            LOGGER.error("config file " + args[0] + " not found");
            return;
        }

        Parameters.getInstance().setConnString(props.getProperty("url"));
        Parameters.getInstance().setUser(props.getProperty("login"));
        Parameters.getInstance().setPwd(props.getProperty("password"));

        MainForm.runMe();
    }

    private static Properties tryLoadProperties(String filename) {
        File config = new File(filename);
        if (config.exists() && config.canRead()) {

            try {
                StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
                encryptor.setPassword("$simpleP00s");
                Properties props = new EncryptableProperties(encryptor);
                try (InputStream is = new FileInputStream(config)) {
                    props.load(is);
                }
                return props;
            } catch (IOException ignored) {
                LOGGER.error("error with file {}", filename, ignored);
            }
        }
        return null;
    }

}

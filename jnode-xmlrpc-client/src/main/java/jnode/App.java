package jnode;

import jnode.core.Parameters;
import jnode.ui.WriteMessage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public final class App {

    private App() {
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("need path to config in call parameters");
            return;
        }

        Properties props = tryLoadProperties(args[0]);

        if (props == null) {
            System.out.println("config file " + args[0] + " not found");
            return;
        }

        Parameters.getInstance().setConnString(props.getProperty("url"));
        Parameters.getInstance().setUser(props.getProperty("login"));
        Parameters.getInstance().setPwd(props.getProperty("password"));

        WriteMessage dialog = new WriteMessage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private static Properties tryLoadProperties(String filename) {
        File config = new File(filename);
        if (config.exists() && config.canRead()) {

            try {
                Properties props = new Properties();
                try (InputStream is = new FileInputStream(config)) {
                    props.load(is);
                }
                return props;
            } catch (IOException ignored) {
            }
        }
        return null;
    }

}

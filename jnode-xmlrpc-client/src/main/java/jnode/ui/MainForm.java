package jnode.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.beans.PropertyVetoException;


/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public class MainForm extends JFrame {

    public MainForm() {
        super("jNode admin");

        setBounds(Sizer.bigSize());

        JDesktopPane desktop = new JDesktopPane();
        setContentPane(desktop);
        setJMenuBar(createMenuBar());


        WriteMessage frame = new WriteMessage();
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException ignored) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.warn("ignored", ignored);
        }

        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void runMe() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MainForm frame = new MainForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Действия");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Написать в эху");
        menu.add(menuItem);

        menuItem = new JMenuItem("Выход");
        menu.add(menuItem);

        return menuBar;
    }
}



package jnode.ui;

import jnode.impl.EchomailToolsProxy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class WriteMessage extends JInternalFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfArea;
    private JTextField tfSubject;
    private JTextArea taBody;
    private JTextField tfFrom;
    private JTextField tfTo;

    public WriteMessage() {
        super("Написать сообщение",
                true,
                true,
                true,
                true);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setSize(Sizer.internalSize());
        setLocation(Sizer.internalLocation());

    }

    private void clear() {
        tfArea.setText("");
        tfSubject.setText("");
        taBody.setText("");
    }

    private boolean isEmptyStr(String value) {
        return value == null || value.length() == 0;
    }

    private boolean isCustomFromTo() {
        return !isEmptyStr(tfFrom.getText()) && !isEmptyStr(tfTo.getText());
    }

    private void onOK() {

        String result;

        if (isCustomFromTo()) {
            result = EchomailToolsProxy.writeEchomail(tfArea.getText(), tfSubject.getText(), taBody.getText(), tfFrom.getText(), tfTo.getText());
        } else {
            result = EchomailToolsProxy.writeEchomail(tfArea.getText(), tfSubject.getText(), taBody.getText());
        }

        if (isEmptyStr(result)) {
            final String message = tfArea.getText() + " " + tfSubject.getText() + " sent successfully";
            clear();
            JOptionPane.showMessageDialog(this, message,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, result,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void onCancel() {
        dispose();
    }

}

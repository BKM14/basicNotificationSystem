import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    private static JLabel keyLabel;
    private static KeyListener keyListener;
    private static DefaultTableModel tableModel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notification system");
        JLabel welcome = new JLabel("Welcome to the notification center");
        JLabel listening = new JLabel();
        keyLabel = new JLabel();

        String[] column = new String[]{"Key", "State"};
        Object[][] data = {
                {"Caps Lock", getLockingKeyState(KeyEvent.VK_CAPS_LOCK)},
                {"Num Lock", getLockingKeyState(KeyEvent.VK_NUM_LOCK)},
                {"Scroll Lock", getLockingKeyState(KeyEvent.VK_SCROLL_LOCK)}
        };

        tableModel = new DefaultTableModel(data, column);
        JTable stateTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(stateTable);

        JButton startButton = new JButton("Start listening");
        JButton stopButton = new JButton("Stop listening");

        keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SCROLL_LOCK || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK || e.getKeyCode() == KeyEvent.VK_NUM_LOCK) {
                    updateKeyStates();
                    playNotificationSound();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SCROLL_LOCK || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK || e.getKeyCode() == KeyEvent.VK_NUM_LOCK) {
                    updateKeyStates();
                }
            }
        };

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listening.setText("Listening to key events...");
                frame.addKeyListener(keyListener);
                frame.setFocusable(true);
                frame.requestFocusInWindow();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.removeKeyListener(keyListener);
                listening.setText("Stopped listening to key events.");
            }
        });

        welcome.setBounds(20, 30, 300, 20);
        startButton.setBounds(20, 100, 200, 40);
        stopButton.setBounds(240, 100, 200, 40);
        listening.setBounds(20, 200, 300, 20);
        keyLabel.setBounds(20, 250, 300, 20);
        scrollPane.setBounds(20, 300, 350, 100);

        frame.add(welcome);
        frame.add(startButton);
        frame.add(stopButton);
        frame.add(listening);
        frame.add(keyLabel);
        frame.add(scrollPane);

        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void updateKeyStates() {
        String capsState = getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        String numState = getLockingKeyState(KeyEvent.VK_NUM_LOCK);
        String scrollState = getLockingKeyState(KeyEvent.VK_SCROLL_LOCK);

        tableModel.setValueAt(capsState, 0, 1);
        tableModel.setValueAt(numState, 1, 1);
        tableModel.setValueAt(scrollState, 2, 1);

        keyLabel.setText("Caps Lock: " + capsState + ", Num Lock: " + numState + ", Scroll Lock: " + scrollState);
    }

    private static String getLockingKeyState(int keyCode) {
        return Toolkit.getDefaultToolkit().getLockingKeyState(keyCode) ? "On" : "Off";
    }

    private static void playNotificationSound() {
        try {
            File soundFile = new File("./tune.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
}

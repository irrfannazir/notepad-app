import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private File currentFile;

    public Main() {
        // Set up the frame
        setTitle("Text Editor");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Text area inside a scroll pane
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // File chooser for open/save dialogs
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> newFile());

        JMenuItem openItem = new JMenuItem("Open...");
        openItem.addActionListener(e -> openFile());

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveFile());

        JMenuItem saveAsItem = new JMenuItem("Save As...");
        saveAsItem.addActionListener(e -> saveFileAs());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        setLocationRelativeTo(null);  // Center the window
    }

    private void newFile() {
        textArea.setText("");
        currentFile = null;
        setTitle("Simple Notepad");
    }

    private void openFile() {
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                textArea.read(reader, null);
                setTitle(currentFile.getName() + " - Simple Notepad");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        if (currentFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                textArea.write(writer);
                setTitle(currentFile.getName() + " - Simple Notepad");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not save file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            saveFileAs();
        }
    }

    private void saveFileAs() {
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            // Ensure file has .txt extension
            if (!currentFile.getName().toLowerCase().endsWith(".txt")) {
                currentFile = new File(currentFile.getAbsolutePath() + ".txt");
            }
            saveFile();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}

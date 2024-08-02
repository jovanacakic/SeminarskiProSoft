package proba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Student Exchange Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu studentMenu = new JMenu("Student");
        JMenu exchangeMenu = new JMenu("Exchange");
        JMenu reportMenu = new JMenu("Report");

        // Create menu items
        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem createStudentItem = new JMenuItem("Create Exchange Student");
        JMenuItem searchStudentItem = new JMenuItem("Search Student");
        JMenuItem updateStudentItem = new JMenuItem("Update Student");
        JMenuItem deleteStudentItem = new JMenuItem("Delete Student");
        JMenuItem createExchangeItem = new JMenuItem("Create Exchange");
        JMenuItem deleteExchangeItem = new JMenuItem("Delete Exchange");
        JMenuItem addSubjectItem = new JMenuItem("Add Subject to Accepted List");
        JMenuItem deleteSubjectItem = new JMenuItem("Delete Subject");
        JMenuItem createReportItem = new JMenuItem("Create Report");
        JMenuItem updateReportItem = new JMenuItem("Update Report");

        // Add menu items to menus
        studentMenu.add(loginItem);
        studentMenu.add(createStudentItem);
        studentMenu.add(searchStudentItem);
        studentMenu.add(updateStudentItem);
        studentMenu.add(deleteStudentItem);

        exchangeMenu.add(createExchangeItem);
        exchangeMenu.add(deleteExchangeItem);
        exchangeMenu.add(addSubjectItem);
        exchangeMenu.add(deleteSubjectItem);

        reportMenu.add(createReportItem);
        reportMenu.add(updateReportItem);

        // Add menus to menu bar
        menuBar.add(studentMenu);
        menuBar.add(exchangeMenu);
        menuBar.add(reportMenu);

        // Set menu bar to the frame
        setJMenuBar(menuBar);

        // Main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adding different panels to main panel
        mainPanel.add(new JPanel(), "Login");
        mainPanel.add(new JPanel(), "Create Student");
        mainPanel.add(new JPanel(), "Search Student");
        mainPanel.add(new JPanel(), "Update Student");
        mainPanel.add(new JPanel(), "Delete Student");
        mainPanel.add(new JPanel(), "Create Exchange");
        mainPanel.add(new JPanel(), "Delete Exchange");
        mainPanel.add(new JPanel(), "Add Subject");
        mainPanel.add(new JPanel(), "Delete Subject");
        mainPanel.add(new JPanel(), "Create Report");
        mainPanel.add(new JPanel(), "Update Report");

        // Adding action listeners to menu items
        loginItem.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        createStudentItem.addActionListener(e -> cardLayout.show(mainPanel, "Create Student"));
        searchStudentItem.addActionListener(e -> cardLayout.show(mainPanel, "Search Student"));
        updateStudentItem.addActionListener(e -> cardLayout.show(mainPanel, "Update Student"));
        deleteStudentItem.addActionListener(e -> cardLayout.show(mainPanel, "Delete Student"));
        createExchangeItem.addActionListener(e -> cardLayout.show(mainPanel, "Create Exchange"));
        deleteExchangeItem.addActionListener(e -> cardLayout.show(mainPanel, "Delete Exchange"));
        addSubjectItem.addActionListener(e -> cardLayout.show(mainPanel, "Add Subject"));
        deleteSubjectItem.addActionListener(e -> cardLayout.show(mainPanel, "Delete Subject"));
        createReportItem.addActionListener(e -> cardLayout.show(mainPanel, "Create Report"));
        updateReportItem.addActionListener(e -> cardLayout.show(mainPanel, "Update Report"));

        // Add main panel to frame
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

import java.awt.*;
import javax.swing.*;

public class AttendanceModule extends JFrame {
    public AttendanceModule() {
        setTitle("Attendance Module");
        setSize(600, 400);
        setLocationRelativeTo(null);  // Center window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel with Padding and Background Color
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245)); // Light background
        add(mainPanel, BorderLayout.CENTER);

        // Title Label with Styling
        JLabel titleLabel = new JLabel("Mark Attendance", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(51, 51, 51));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel for student details (Student ID, Date, Status) with spacing
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 15, 15));
        formPanel.setBackground(new Color(245, 245, 245));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        formPanel.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        studentIdField.setPreferredSize(new Dimension(200, 30));
        studentIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Date (DD/MM/YYYY):"));
        JTextField dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(200, 30));
        dateField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(dateField);

        formPanel.add(new JLabel("Status:"));
        JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Present", "Absent"});
        statusCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        statusCombo.setBackground(new Color(220, 220, 220)); // Soft background color for combobox
        formPanel.add(statusCombo);

        // Button to mark attendance
        JButton markAttendanceBtn = new JButton("Mark Attendance");
        markAttendanceBtn.setBackground(new Color(0, 123, 255)); // Blue color
        markAttendanceBtn.setForeground(Color.WHITE);
        markAttendanceBtn.setFont(new Font("Arial", Font.BOLD, 14));
        markAttendanceBtn.setFocusPainted(false);
        markAttendanceBtn.setPreferredSize(new Dimension(200, 40));
        markAttendanceBtn.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding
        formPanel.add(markAttendanceBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Action Handler for Mark Attendance Button
        markAttendanceBtn.addActionListener(e -> {
            String studentId = studentIdField.getText();
            String date = dateField.getText();
            String status = (String) statusCombo.getSelectedItem();

            if (studentId.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Attendance marked for " + studentId + " on " + date + ": " + status, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Styling the window close button
        setVisible(true);
    }

    public static void main(String[] args) {
        new AttendanceModule();
    }
}

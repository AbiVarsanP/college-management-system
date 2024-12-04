import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("College Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame

        // Create a main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 20, 20)); // Adjusted grid layout
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Set the background color of the panel
        panel.setBackground(new Color(232, 234, 246));

        // Buttons for each module
        JButton studentBtn = createStyledButton("Student Module");
        JButton facultyBtn = createStyledButton("Faculty Module");
        JButton attendanceBtn = createStyledButton("Attendance Module");
        JButton coursesBtn = createStyledButton("Courses Module");
        JButton feesBtn = createStyledButton("Fees Module");
        JButton examBtn = createStyledButton("Exam Module");
        JButton gradeBtn = createStyledButton("Grade Module");

        // Add button actions
        studentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentModule().setVisible(true);
            }
        });

        facultyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FacultyModule().setVisible(true);
            }
        });

        attendanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AttendanceModule().setVisible(true);
            }
        });

        coursesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CoursesModule().setVisible(true);
            }
        });

        feesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeesModule().setVisible(true);
            }
        });

        examBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExamModule().setVisible(true);
            }
        });

        gradeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GradeModule().setVisible(true);
            }
        });

        // Add buttons to the panel
        panel.add(studentBtn);
        panel.add(facultyBtn);
        panel.add(attendanceBtn);
        panel.add(coursesBtn);
        panel.add(feesBtn);
        panel.add(examBtn);
        panel.add(gradeBtn);

        // Add a title label to the top
        JLabel titleLabel = new JLabel("Welcome to the College Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 51, 102));

        // Create a main container panel to hold title and button panel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(titleLabel, BorderLayout.NORTH);
        containerPanel.add(panel, BorderLayout.CENTER);

        // Add the container panel to the frame
        add(containerPanel, BorderLayout.CENTER);
    }

    // Helper method to create a styled button
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
        button.setForeground(Color.WHITE); // Set text color
        button.setBackground(new Color(0, 123, 255)); // Set background color
        button.setFocusPainted(false); // Remove focus border when clicked
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Border style
        button.setPreferredSize(new Dimension(200, 50)); // Button size
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Pointer cursor on hover

        // Add hover effect to change the button color
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 102, 204));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        // Create and show the main frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
}

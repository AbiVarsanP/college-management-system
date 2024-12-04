import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Course Data Class
class Course {
    private String courseId;
    private String courseName;
    private String department;
    private String duration;
    private int credits;
    private String prerequisites;

    public Course(String courseId, String courseName, String department, String duration, int credits, String prerequisites) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.duration = duration;
        this.credits = credits;
        this.prerequisites = prerequisites;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public String getDuration() {
        return duration;
    }

    public int getCredits() {
        return credits;
    }

    public String getPrerequisites() {
        return prerequisites;
    }
}

public class CoursesModule extends JFrame {
    private ArrayList<Course> courseList;

    public CoursesModule() {
        courseList = new ArrayList<>();

        setTitle("Courses Module");
        setSize(750, 600);
        setLocationRelativeTo(null);  // Center window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel with padding and background
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));  // Light background color
        add(mainPanel, BorderLayout.CENTER);

        // Title Label with Styling
        JLabel titleLabel = new JLabel("Course Management", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(51, 51, 51));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form Panel for Course Details with padding and borders
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 15, 15));
        formPanel.setBackground(new Color(240, 240, 240));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        formPanel.add(new JLabel("Course ID:"));
        JTextField courseIdField = new JTextField();
        courseIdField.setPreferredSize(new Dimension(200, 30));
        courseIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(courseIdField);

        formPanel.add(new JLabel("Course Name:"));
        JTextField courseNameField = new JTextField();
        courseNameField.setPreferredSize(new Dimension(200, 30));
        courseNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(courseNameField);

        formPanel.add(new JLabel("Department:"));
        JTextField departmentField = new JTextField();
        departmentField.setPreferredSize(new Dimension(200, 30));
        departmentField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Duration (weeks/months/years):"));
        JTextField durationField = new JTextField();
        durationField.setPreferredSize(new Dimension(200, 30));
        durationField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(durationField);

        formPanel.add(new JLabel("Credits:"));
        JTextField creditsField = new JTextField();
        creditsField.setPreferredSize(new Dimension(200, 30));
        creditsField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(creditsField);

        formPanel.add(new JLabel("Prerequisites:"));
        JTextField prerequisitesField = new JTextField();
        prerequisitesField.setPreferredSize(new Dimension(200, 30));
        prerequisitesField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(prerequisitesField);

        // Add and View Course Buttons with better styling
        JButton addCourseBtn = new JButton("Add Course");
        JButton viewCoursesBtn = new JButton("View Courses");
        addCourseBtn.setBackground(new Color(0, 123, 255)); // Blue color
        addCourseBtn.setForeground(Color.WHITE);
        addCourseBtn.setFont(new Font("Arial", Font.BOLD, 14));
        addCourseBtn.setPreferredSize(new Dimension(200, 40));
        addCourseBtn.setFocusPainted(false);

        viewCoursesBtn.setBackground(new Color(0, 123, 255)); // Blue color
        viewCoursesBtn.setForeground(Color.WHITE);
        viewCoursesBtn.setFont(new Font("Arial", Font.BOLD, 14));
        viewCoursesBtn.setPreferredSize(new Dimension(200, 40));
        viewCoursesBtn.setFocusPainted(false);

        formPanel.add(addCourseBtn);
        formPanel.add(viewCoursesBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Button Handlers
        addCourseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseId = courseIdField.getText();
                String courseName = courseNameField.getText();
                String department = departmentField.getText();
                String duration = durationField.getText();
                String creditsStr = creditsField.getText();
                String prerequisites = prerequisitesField.getText();

                if (courseId.isEmpty() || courseName.isEmpty() || department.isEmpty() || duration.isEmpty() || creditsStr.isEmpty() || prerequisites.isEmpty()) {
                    JOptionPane.showMessageDialog(CoursesModule.this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int credits = Integer.parseInt(creditsStr);
                    courseList.add(new Course(courseId, courseName, department, duration, credits, prerequisites));
                    JOptionPane.showMessageDialog(CoursesModule.this, "Course added successfully!");

                    // Clear the fields after adding
                    courseIdField.setText("");
                    courseNameField.setText("");
                    departmentField.setText("");
                    durationField.setText("");
                    creditsField.setText("");
                    prerequisitesField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CoursesModule.this, "Credits must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewCoursesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (courseList.isEmpty()) {
                    JOptionPane.showMessageDialog(CoursesModule.this, "No courses available!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Display Course List
                StringBuilder courseInfo = new StringBuilder("Courses Details:\n\n");
                for (Course course : courseList) {
                    courseInfo.append("Course ID: ").append(course.getCourseId()).append("\n");
                    courseInfo.append("Course Name: ").append(course.getCourseName()).append("\n");
                    courseInfo.append("Department: ").append(course.getDepartment()).append("\n");
                    courseInfo.append("Duration: ").append(course.getDuration()).append("\n");
                    courseInfo.append("Credits: ").append(course.getCredits()).append("\n");
                    courseInfo.append("Prerequisites: ").append(course.getPrerequisites()).append("\n");
                    courseInfo.append("-----------------------\n");
                }

                JOptionPane.showMessageDialog(CoursesModule.this, courseInfo.toString(), "Course Records", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new CoursesModule();
    }
}

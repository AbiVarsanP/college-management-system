import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StudentModule extends JFrame {

    private JTextField idField, nameField, dobField, genderField, courseField;
    private JTextArea contactArea, parentArea, viewArea;
    private JButton submitButton, viewButton;
    
    // Store students' data in a HashMap for simplicity
    private HashMap<String, Student> studentDatabase = new HashMap<>();

    public StudentModule() {
        setTitle("Student Module");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the window on exit
        setLocationRelativeTo(null); // Center the window on the screen
        
        // Create a panel and set its layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(242, 242, 242)); // Light background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Title label
        JLabel titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(50, 50, 50));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Student ID
        addLabel(panel, "Student ID:", 1, 0, gbc);
        idField = addTextField(panel, 1, 1, gbc);

        // Student Name
        addLabel(panel, "Name:", 2, 0, gbc);
        nameField = addTextField(panel, 2, 1, gbc);

        // Date of Birth
        addLabel(panel, "Date of Birth:", 3, 0, gbc);
        dobField = addTextField(panel, 3, 1, gbc);

        // Gender
        addLabel(panel, "Gender:", 4, 0, gbc);
        genderField = addTextField(panel, 4, 1, gbc);

        // Course
        addLabel(panel, "Course:", 5, 0, gbc);
        courseField = addTextField(panel, 5, 1, gbc);

        // Contact Info
        addLabel(panel, "Contact Info:", 6, 0, gbc);
        contactArea = new JTextArea(3, 20);
        JScrollPane contactScroll = new JScrollPane(contactArea);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(contactScroll, gbc);

        // Parent/Guardian Info
        addLabel(panel, "Parent Info:", 7, 0, gbc);
        parentArea = new JTextArea(3, 20);
        JScrollPane parentScroll = new JScrollPane(parentArea);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(parentScroll, gbc);

        // Submit Button
        submitButton = new JButton("Submit Student");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.setBackground(new Color(28, 134, 238));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText().trim();
                String name = nameField.getText().trim();
                String dob = dobField.getText().trim();
                String gender = genderField.getText().trim();
                String course = courseField.getText().trim();
                String contact = contactArea.getText().trim();
                String parent = parentArea.getText().trim();

                // Validate input
                if (studentId.isEmpty() || name.isEmpty() || dob.isEmpty() || gender.isEmpty() || 
                    course.isEmpty() || contact.isEmpty() || parent.isEmpty()) {
                    JOptionPane.showMessageDialog(StudentModule.this, "All fields are required.");
                } else {
                    // Create a new student object and store it in the database
                    Student student = new Student(studentId, name, dob, gender, course, contact, parent);
                    studentDatabase.put(studentId, student);

                    // Clear the fields after submission
                    clearFields();
                    JOptionPane.showMessageDialog(StudentModule.this, "Student Registered Successfully.");
                }
            }
        });

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(submitButton, gbc);

        // View Button
        viewButton = new JButton("View Student");
        viewButton.setFont(new Font("Arial", Font.PLAIN, 14));
        viewButton.setBackground(new Color(34, 139, 34));
        viewButton.setForeground(Color.WHITE);
        viewButton.setFocusPainted(false);
        viewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText().trim();
                if (studentDatabase.containsKey(studentId)) {
                    // Retrieve and display the student details
                    Student student = studentDatabase.get(studentId);
                    viewArea.setText("Student ID: " + student.getId() + "\n" +
                                     "Name: " + student.getName() + "\n" +
                                     "Date of Birth: " + student.getDob() + "\n" +
                                     "Gender: " + student.getGender() + "\n" +
                                     "Course: " + student.getCourse() + "\n" +
                                     "Contact Info: " + student.getContact() + "\n" +
                                     "Parent Info: " + student.getParentInfo());
                } else {
                    // Display message if student ID is not found
                    viewArea.setText("Student ID not found.");
                }
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(viewButton, gbc);

        // Text area for viewing student details
        viewArea = new JTextArea(6, 20);
        viewArea.setEditable(false);
        viewArea.setBackground(new Color(240, 240, 240));
        JScrollPane viewScroll = new JScrollPane(viewArea);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(viewScroll, gbc);

        // Add the panel to the frame
        add(panel);
    }

    // Add label with appropriate GridBagConstraints
    private void addLabel(JPanel panel, String text, int row, int col, GridBagConstraints gbc) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(50, 50, 50));
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);
    }

    // Add text field with appropriate GridBagConstraints
    private JTextField addTextField(JPanel panel, int row, int col, GridBagConstraints gbc) {
        JTextField textField = new JTextField(20);
        gbc.gridx = col;
        gbc.gridy = row;
        panel.add(textField, gbc);
        return textField;
    }

    // Clear all input fields
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        dobField.setText("");
        genderField.setText("");
        courseField.setText("");
        contactArea.setText("");
        parentArea.setText("");
    }

    // Student class to represent student data
    private static class Student {
        private String id, name, dob, gender, course, contact, parentInfo;

        public Student(String id, String name, String dob, String gender, String course, String contact, String parentInfo) {
            this.id = id;
            this.name = name;
            this.dob = dob;
            this.gender = gender;
            this.course = course;
            this.contact = contact;
            this.parentInfo = parentInfo;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDob() {
            return dob;
        }

        public String getGender() {
            return gender;
        }

        public String getCourse() {
            return course;
        }

        public String getContact() {
            return contact;
        }

        public String getParentInfo() {
            return parentInfo;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentModule frame = new StudentModule();
            frame.setVisible(true);
        });
    }
}

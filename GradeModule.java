import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Grade Data Class
class Grade {
    private String studentId;
    private String courseId;
    private String examId;
    private int marksScored;
    private String grade;
    private String remarks;

    public Grade(String studentId, String courseId, String examId, int marksScored) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.examId = examId;
        this.marksScored = marksScored;
        this.grade = calculateGrade(marksScored);
        this.remarks = generateRemarks(marksScored);
    }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 80) return "B";
        if (marks >= 70) return "C";
        if (marks >= 60) return "D";
        return "F";
    }

    private String generateRemarks(int marks) {
        if (marks >= 60) return "Pass";
        return "Fail";
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getExamId() {
        return examId;
    }

    public int getMarksScored() {
        return marksScored;
    }

    public String getGrade() {
        return grade;
    }

    public String getRemarks() {
        return remarks;
    }
}

public class GradeModule extends JFrame {
    private ArrayList<Grade> gradeList;

    public GradeModule() {
        gradeList = new ArrayList<>();

        setTitle("Grade Module");
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Grade Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Labels and Fields
        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField(15);
        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField(15);
        JLabel examIdLabel = new JLabel("Exam ID:");
        JTextField examIdField = new JTextField(15);
        JLabel marksLabel = new JLabel("Marks Scored:");
        JTextField marksField = new JTextField(15);

        // Add components to the formPanel
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(studentIdLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(studentIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(courseIdLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(courseIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(examIdLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(examIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(marksLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        formPanel.add(marksField, gbc);

        // Buttons
        JButton addGradeBtn = new JButton("Add Grade");
        JButton viewGradesBtn = new JButton("View Grades");

        // Button Styles
        addGradeBtn.setBackground(new Color(53, 113, 255));
        addGradeBtn.setForeground(Color.WHITE);
        addGradeBtn.setFocusPainted(false);
        viewGradesBtn.setBackground(new Color(53, 113, 255));
        viewGradesBtn.setForeground(Color.WHITE);
        viewGradesBtn.setFocusPainted(false);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        formPanel.add(addGradeBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        formPanel.add(viewGradesBtn, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Button Handlers
        addGradeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText();
                String courseId = courseIdField.getText();
                String examId = examIdField.getText();
                String marksStr = marksField.getText();

                if (studentId.isEmpty() || courseId.isEmpty() || examId.isEmpty() || marksStr.isEmpty()) {
                    JOptionPane.showMessageDialog(GradeModule.this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int marks = Integer.parseInt(marksStr);
                    gradeList.add(new Grade(studentId, courseId, examId, marks));
                    JOptionPane.showMessageDialog(GradeModule.this, "Grade added successfully!");

                    // Clear the fields
                    studentIdField.setText("");
                    courseIdField.setText("");
                    examIdField.setText("");
                    marksField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GradeModule.this, "Marks must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewGradesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gradeList.isEmpty()) {
                    JOptionPane.showMessageDialog(GradeModule.this, "No grades available!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Display Grade List
                StringBuilder gradeInfo = new StringBuilder("Grade Details:\n\n");
                for (Grade grade : gradeList) {
                    gradeInfo.append("Student ID: ").append(grade.getStudentId()).append("\n");
                    gradeInfo.append("Course ID: ").append(grade.getCourseId()).append("\n");
                    gradeInfo.append("Exam ID: ").append(grade.getExamId()).append("\n");
                    gradeInfo.append("Marks Scored: ").append(grade.getMarksScored()).append("\n");
                    gradeInfo.append("Grade: ").append(grade.getGrade()).append("\n");
                    gradeInfo.append("Remarks: ").append(grade.getRemarks()).append("\n");
                    gradeInfo.append("-----------------------\n");
                }

                JOptionPane.showMessageDialog(GradeModule.this, gradeInfo.toString(), "Grade Records", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeModule frame = new GradeModule();
            frame.setVisible(true);
        });
    }
}

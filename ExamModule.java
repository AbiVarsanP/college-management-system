import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Exam Data Class
class Exam {
    private String examId;
    private String examName;
    private String courseId;
    private String dateTime;
    private int totalMarks;
    private String examCenter;

    public Exam(String examId, String examName, String courseId, String dateTime, int totalMarks, String examCenter) {
        this.examId = examId;
        this.examName = examName;
        this.courseId = courseId;
        this.dateTime = dateTime;
        this.totalMarks = totalMarks;
        this.examCenter = examCenter;
    }

    public String getExamId() {
        return examId;
    }

    public String getExamName() {
        return examName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public String getExamCenter() {
        return examCenter;
    }
}

public class ExamModule extends JFrame {
    private ArrayList<Exam> examList;

    public ExamModule() {
        examList = new ArrayList<>();

        setTitle("Exam Module");
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Exam Details"));

        formPanel.add(new JLabel("Exam ID:"));
        JTextField examIdField = new JTextField();
        formPanel.add(examIdField);

        formPanel.add(new JLabel("Exam Name:"));
        JTextField examNameField = new JTextField();
        formPanel.add(examNameField);

        formPanel.add(new JLabel("Course ID:"));
        JTextField courseIdField = new JTextField();
        formPanel.add(courseIdField);

        formPanel.add(new JLabel("Date and Time:"));
        JTextField dateTimeField = new JTextField();
        formPanel.add(dateTimeField);

        formPanel.add(new JLabel("Total Marks:"));
        JTextField totalMarksField = new JTextField();
        formPanel.add(totalMarksField);

        formPanel.add(new JLabel("Exam Center:"));
        JTextField examCenterField = new JTextField();
        formPanel.add(examCenterField);

        JButton addExamBtn = new JButton("Add Exam");
        JButton viewExamsBtn = new JButton("View Exams");
        formPanel.add(addExamBtn);
        formPanel.add(viewExamsBtn);

        add(formPanel, BorderLayout.CENTER);

        // Button Handlers
        addExamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String examId = examIdField.getText();
                String examName = examNameField.getText();
                String courseId = courseIdField.getText();
                String dateTime = dateTimeField.getText();
                String totalMarksStr = totalMarksField.getText();
                String examCenter = examCenterField.getText();

                if (examId.isEmpty() || examName.isEmpty() || courseId.isEmpty() || dateTime.isEmpty() || totalMarksStr.isEmpty() || examCenter.isEmpty()) {
                    JOptionPane.showMessageDialog(ExamModule.this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int totalMarks = Integer.parseInt(totalMarksStr);
                    examList.add(new Exam(examId, examName, courseId, dateTime, totalMarks, examCenter));
                    JOptionPane.showMessageDialog(ExamModule.this, "Exam added successfully!");

                    // Clear the fields
                    examIdField.setText("");
                    examNameField.setText("");
                    courseIdField.setText("");
                    dateTimeField.setText("");
                    totalMarksField.setText("");
                    examCenterField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ExamModule.this, "Total Marks must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewExamsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (examList.isEmpty()) {
                    JOptionPane.showMessageDialog(ExamModule.this, "No exams available!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Display Exam List
                StringBuilder examInfo = new StringBuilder("Exam Details:\n\n");
                for (Exam exam : examList) {
                    examInfo.append("Exam ID: ").append(exam.getExamId()).append("\n");
                    examInfo.append("Exam Name: ").append(exam.getExamName()).append("\n");
                    examInfo.append("Course ID: ").append(exam.getCourseId()).append("\n");
                    examInfo.append("Date and Time: ").append(exam.getDateTime()).append("\n");
                    examInfo.append("Total Marks: ").append(exam.getTotalMarks()).append("\n");
                    examInfo.append("Exam Center: ").append(exam.getExamCenter()).append("\n");
                    examInfo.append("-----------------------\n");
                }

                JOptionPane.showMessageDialog(ExamModule.this, examInfo.toString(), "Exam Records", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

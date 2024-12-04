import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Fee Data Class
class Fee {
    private String feeId;
    private String studentId;
    private String feeType;
    private double amount;
    private String dueDate;
    private String paymentStatus;

    public Fee(String feeId, String studentId, String feeType, double amount, String dueDate, String paymentStatus) {
        this.feeId = feeId;
        this.studentId = studentId;
        this.feeType = feeType;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paymentStatus = paymentStatus;
    }

    public String getFeeId() {
        return feeId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFeeType() {
        return feeType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

public class FeesModule extends JFrame {
    private ArrayList<Fee> feeList;

    public FeesModule() {
        feeList = new ArrayList<>();

        setTitle("Fees Module");
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10)); // Adjusted for 7 fields
        formPanel.setBorder(BorderFactory.createTitledBorder("Fee Details"));

        formPanel.add(new JLabel("Fee ID:"));
        JTextField feeIdField = new JTextField();
        formPanel.add(feeIdField);

        formPanel.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        formPanel.add(studentIdField);

        formPanel.add(new JLabel("Fee Type:"));
        JTextField feeTypeField = new JTextField();
        formPanel.add(feeTypeField);

        formPanel.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField();
        formPanel.add(amountField);

        formPanel.add(new JLabel("Due Date:"));
        JTextField dueDateField = new JTextField();
        formPanel.add(dueDateField);

        formPanel.add(new JLabel("Payment Status:"));
        JTextField paymentStatusField = new JTextField();
        formPanel.add(paymentStatusField);

        // Add Buttons
        JButton addFeeBtn = new JButton("Add Fee");
        JButton viewFeesBtn = new JButton("View Fees");
        formPanel.add(addFeeBtn);
        formPanel.add(viewFeesBtn);

        add(formPanel, BorderLayout.CENTER);

        // Button Handlers
        addFeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feeId = feeIdField.getText();
                String studentId = studentIdField.getText();
                String feeType = feeTypeField.getText();
                String amountStr = amountField.getText();
                String dueDate = dueDateField.getText();
                String paymentStatus = paymentStatusField.getText();

                if (feeId.isEmpty() || studentId.isEmpty() || feeType.isEmpty() || amountStr.isEmpty() || dueDate.isEmpty() || paymentStatus.isEmpty()) {
                    JOptionPane.showMessageDialog(FeesModule.this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double amount = Double.parseDouble(amountStr);
                    feeList.add(new Fee(feeId, studentId, feeType, amount, dueDate, paymentStatus));
                    JOptionPane.showMessageDialog(FeesModule.this, "Fee added successfully!");

                    // Clear the fields
                    feeIdField.setText("");
                    studentIdField.setText("");
                    feeTypeField.setText("");
                    amountField.setText("");
                    dueDateField.setText("");
                    paymentStatusField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FeesModule.this, "Amount must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewFeesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (feeList.isEmpty()) {
                    JOptionPane.showMessageDialog(FeesModule.this, "No fees available!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Display Fee List
                StringBuilder feeInfo = new StringBuilder("Fee Details:\n\n");
                for (Fee fee : feeList) {
                    feeInfo.append("Fee ID: ").append(fee.getFeeId()).append("\n");
                    feeInfo.append("Student ID: ").append(fee.getStudentId()).append("\n");
                    feeInfo.append("Fee Type: ").append(fee.getFeeType()).append("\n");
                    feeInfo.append("Amount: ").append(fee.getAmount()).append("\n");
                    feeInfo.append("Due Date: ").append(fee.getDueDate()).append("\n");
                    feeInfo.append("Payment Status: ").append(fee.getPaymentStatus()).append("\n");
                    feeInfo.append("-----------------------\n");
                }

                JOptionPane.showMessageDialog(FeesModule.this, feeInfo.toString(), "Fee Records", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

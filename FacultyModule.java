import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Faculty Data Class
class Faculty {
    private String id;
    private String name;
    private String department;
    private String designation;
    private String contact;

    public Faculty(String id, String name, String department, String designation, String contact) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getContact() {
        return contact;
    }
}

public class FacultyModule extends JFrame {
    private ArrayList<Faculty> facultyList;

    public FacultyModule() {
        facultyList = new ArrayList<>();

        setTitle("Faculty Module");
        setSize(750, 600);  // Increase the size for a more spacious layout
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color of the entire window
        getContentPane().setBackground(new Color(255, 255, 255)); 

        // Font settings for better readability
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 15, 15));  // Increased spacing between components
        formPanel.setBackground(new Color(240, 240, 240));  // Light grey background for form
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(51, 153, 255), 2), "Faculty Details", 0, 0, new Font("Segoe UI", Font.BOLD, 16), new Color(51, 153, 255)));

        // Adding components for faculty details
        formPanel.add(new JLabel("Faculty ID:"));
        JTextField idField = new JTextField();
        idField.setFont(fieldFont);
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        nameField.setFont(fieldFont);
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        JTextField departmentField = new JTextField();
        departmentField.setFont(fieldFont);
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Designation:"));
        JTextField designationField = new JTextField();
        designationField.setFont(fieldFont);
        formPanel.add(designationField);

        formPanel.add(new JLabel("Contact:"));
        JTextField contactField = new JTextField();
        contactField.setFont(fieldFont);
        formPanel.add(contactField);

        // Buttons at the bottom of the form panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240));

        JButton addFacultyBtn = new JButton("Add Faculty");
        JButton viewFacultyBtn = new JButton("View Faculty");

        addFacultyBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        viewFacultyBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        addFacultyBtn.setBackground(new Color(51, 153, 255));  // Professional blue color
        viewFacultyBtn.setBackground(new Color(51, 153, 255));
        
        addFacultyBtn.setForeground(Color.WHITE);
        viewFacultyBtn.setForeground(Color.WHITE);
        
        addFacultyBtn.setPreferredSize(new Dimension(150, 40));
        viewFacultyBtn.setPreferredSize(new Dimension(150, 40));

        // Rounded button corners
        addFacultyBtn.setFocusPainted(false);
        viewFacultyBtn.setFocusPainted(false);
        
        // Add hover effect for buttons
        addFacultyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addFacultyBtn.setBackground(new Color(40, 120, 255));  // Darker blue when hovered
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addFacultyBtn.setBackground(new Color(51, 153, 255));  // Revert to original color
            }
        });

        viewFacultyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewFacultyBtn.setBackground(new Color(40, 120, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewFacultyBtn.setBackground(new Color(51, 153, 255));
            }
        });

        buttonPanel.add(addFacultyBtn);
        buttonPanel.add(viewFacultyBtn);

        // Align the formPanel and buttonPanel vertically
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Handlers
        addFacultyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String department = departmentField.getText();
                String designation = designationField.getText();
                String contact = contactField.getText();

                if (id.isEmpty() || name.isEmpty() || department.isEmpty() || designation.isEmpty() || contact.isEmpty()) {
                    JOptionPane.showMessageDialog(FacultyModule.this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                facultyList.add(new Faculty(id, name, department, designation, contact));
                JOptionPane.showMessageDialog(FacultyModule.this, "Faculty added successfully!");

                // Clear the fields
                idField.setText("");
                nameField.setText("");
                departmentField.setText("");
                designationField.setText("");
                contactField.setText("");
            }
        });

        viewFacultyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (facultyList.isEmpty()) {
                    JOptionPane.showMessageDialog(FacultyModule.this, "No faculty records available!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Display Faculty List
                StringBuilder facultyInfo = new StringBuilder("Faculty Details:\n\n");
                for (Faculty faculty : facultyList) {
                    facultyInfo.append("ID: ").append(faculty.getId()).append("\n");
                    facultyInfo.append("Name: ").append(faculty.getName()).append("\n");
                    facultyInfo.append("Department: ").append(faculty.getDepartment()).append("\n");
                    facultyInfo.append("Designation: ").append(faculty.getDesignation()).append("\n");
                    facultyInfo.append("Contact: ").append(faculty.getContact()).append("\n");
                    facultyInfo.append("-----------------------\n");
                }

                JOptionPane.showMessageDialog(FacultyModule.this, facultyInfo.toString(), "Faculty Records", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FacultyModule().setVisible(true);
            }
        });
    }
}

import java.awt.event.*;
import javax.swing.*;

public class ModuleTemplate extends JFrame implements ActionListener {
    JTextField txt1, txt2, txt3;
    JButton btnAdd, btnView, btnUpdate, btnDelete;

    public ModuleTemplate(String title, String label1, String label2, String label3) {
        setTitle(title);
        setSize(400, 300);
        setLayout(null);

        JLabel lbl1 = new JLabel(label1);
        JLabel lbl2 = new JLabel(label2);
        JLabel lbl3 = new JLabel(label3);

        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();

        btnAdd = new JButton("Add");
        btnView = new JButton("View");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        lbl1.setBounds(50, 50, 100, 30);
        lbl2.setBounds(50, 90, 100, 30);
        lbl3.setBounds(50, 130, 100, 30);

        txt1.setBounds(150, 50, 150, 30);
        txt2.setBounds(150, 90, 150, 30);
        txt3.setBounds(150, 130, 150, 30);

        btnAdd.setBounds(50, 180, 80, 30);
        btnView.setBounds(140, 180, 80, 30);
        btnUpdate.setBounds(230, 180, 80, 30);
        btnDelete.setBounds(320, 180, 80, 30);

        add(lbl1); add(lbl2); add(lbl3);
        add(txt1); add(txt2); add(txt3);
        add(btnAdd); add(btnView); add(btnUpdate); add(btnDelete);

        btnAdd.addActionListener(this);
        btnView.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) JOptionPane.showMessageDialog(this, "Added successfully!");
        else if (e.getSource() == btnView) JOptionPane.showMessageDialog(this, "Viewing records!");
        else if (e.getSource() == btnUpdate) JOptionPane.showMessageDialog(this, "Updated successfully!");
        else if (e.getSource() == btnDelete) JOptionPane.showMessageDialog(this, "Deleted successfully!");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    // Declare components
    private JLabel labelUsername, labelPassword;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton loginButton;
    
    // Admin credentials
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin123";
    
    public LoginPage() {
        // Set up the frame
        setTitle("Login Page");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create components
        labelUsername = new JLabel("Username:");
        labelPassword = new JLabel("Password:");
        textUsername = new JTextField(20);
        textPassword = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Set up layout
        setLayout(new FlowLayout());
        add(labelUsername);
        add(textUsername);
        add(labelPassword);
        add(textPassword);
        add(loginButton);

        // Add event listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if the credentials are correct
                String username = textUsername.getText();
                String password = new String(textPassword.getPassword());
                
                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    // On success, go to MainMenu
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new MainMenu().setVisible(true); // Open the main menu
                    dispose(); // Close login page
                } else {
                    // Show error message if credentials are wrong
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Show the login page
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}

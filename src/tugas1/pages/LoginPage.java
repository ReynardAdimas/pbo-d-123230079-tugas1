package tugas1.pages;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{
    private JLabel userLabel, passLabel, message;
    private JTextField username;
    private JPasswordField password;
    private JButton btnLogin; 
    private JPanel panel, panelBtn;
    
    public LoginPage() {
        super("Halaman Login"); 
        setLayout(new BorderLayout());
        
        panel = new JPanel(new GridLayout(2,2,5,5)); 
        userLabel = new JLabel("Username : "); 
        username = new JTextField(); 
        passLabel = new JLabel("Password : "); 
        password = new JPasswordField(); 
        
        panel.add(userLabel);
        panel.add(username); 
        panel.add(passLabel);
        panel.add(password); 
        add(panel, BorderLayout.NORTH); 
        
        panelBtn = new JPanel();
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        panelBtn.add(btnLogin); 
        add(panelBtn, BorderLayout.CENTER); 
        
        message = new JLabel("", SwingConstants.CENTER);
        add(message, BorderLayout.SOUTH);
        
        pack();
        setSize(300,150);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin)
        {
            String user = username.getText().toLowerCase(); 
            String passWord = new String(password.getPassword());
            if(user.equals("pbo") && passWord.equals("if-d")){
                new MainPage();
                dispose();
            }
            else{
                message.setText("user atau password salah");
            }
        }
    }
}

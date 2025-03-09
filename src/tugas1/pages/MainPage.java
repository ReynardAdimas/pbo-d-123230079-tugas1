package tugas1.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPage extends JFrame implements ActionListener{
    private JLabel namaDepan, namaBelakang, jenisKelamin, message; 
    private JTextField tfNamaDepan, tfNamaBelakang; 
    private JTextArea textArea;
    private JRadioButton rb1, rb2; 
    private JPanel panel1, panel2, panel3;
    private JButton btnSave, ubah;
    private JScrollPane sp;
    private ButtonGroup grup;
    public MainPage(){
        super("Halaman Input Data"); 
        
        setLayout(new BorderLayout(0,0));
        
        panel1 = new JPanel(new GridLayout(3,3)); 
        namaDepan = new JLabel("Nama Depan : "); 
        namaBelakang = new JLabel("Nama Belakang : ");
        tfNamaDepan = new JTextField(10);
        tfNamaBelakang = new JTextField(10); 
        jenisKelamin = new JLabel("Jenis Kelamin"); 
        
        panel2 = new JPanel(new GridLayout(5,2)); 
        panel3 = new JPanel(new GridLayout(1,2));
        
        btnSave = new JButton("Simpan"); 
        btnSave.addActionListener(this);
        rb1 = new JRadioButton("Laki - Laki"); 
        rb2 = new JRadioButton("Perempuan"); 
        message = new JLabel(""); 
        
        textArea = new JTextArea();
        sp = new JScrollPane(textArea); 
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);       
        ubah = new JButton("Convert");
        
        grup = new ButtonGroup();
        grup.add(rb1); 
        grup.add(rb2); 
        
        
        panel3.add(rb1);
        panel3.add(rb2); 
        
        panel2.add(panel3);
        panel2.add(btnSave);
        panel2.add(message);  
        panel2.add(sp);
        panel2.add(ubah);
        
        panel1.add(namaDepan); 
        panel1.add(namaBelakang);
        panel1.add(tfNamaDepan);
        panel1.add(tfNamaBelakang); 
        panel1.add(jenisKelamin);
        panel1.add(panel2);
        
        add(panel1, BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        pack();
        setSize(500,500);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave)
        {
            if(tfNamaDepan.getText().isEmpty() && tfNamaBelakang.getText().isEmpty() && grup.getSelection() == null){
                message.setText("Data harus lengkap!");
            }
            else 
            {
                message.setText("Data berhasil disimpan");
            }
        }
    }
    
    
}

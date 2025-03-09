package tugas1.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPage extends JFrame implements ActionListener{
    private JLabel namaDepan, namaBelakang, jenisKelamin, message; 
    private JTextField tfNamaDepan, tfNamaBelakang; 
    private JRadioButton rb1, rb2; 
    private JPanel panel1, panel2, panel3,panel4;
    private JButton btnSave, ubah;
    private JScrollPane sp;
    private ButtonGroup grup;
    public MainPage(){
        super("Halaman Input Data"); 
        
        setLayout(new BorderLayout());
        
        panel1 = new JPanel(new GridLayout(2,4,5,5)); 
        namaDepan = new JLabel("Nama Depan : "); 
        tfNamaDepan = new JTextField(10);
        namaBelakang = new JLabel("Nama Belakang : "); 
        tfNamaBelakang = new JTextField(10); 
         
        panel1.add(namaDepan); 
        panel1.add(tfNamaDepan);
        panel1.add(namaBelakang); 
        panel1.add(tfNamaBelakang); 
        add(panel1, BorderLayout.PAGE_START);
        
        panel2 = new JPanel(new FlowLayout()); 
        jenisKelamin = new JLabel("Jenis Kelamin"); 
        rb1 = new JRadioButton("Laki - Laki"); 
        rb2 = new JRadioButton("Perempuan"); 
        btnSave = new JButton("Simpan");
        btnSave.addActionListener(this);
        message = new JLabel("");
        sp = new JScrollPane();
        ubah = new JButton("Convert to .txt file");
        grup = new ButtonGroup();
        grup.add(rb1); 
        grup.add(rb2); 
        
        panel2.add(jenisKelamin); 
        panel2.add(rb1);
        panel2.add(rb2); 
        panel2.add(btnSave);
        panel2.add(message); 
        panel2.add(sp);
        panel2.add(ubah);
        add(panel2,BorderLayout.CENTER); 
        
        
//        panel4 = new JPanel();
//        message = new JLabel("");
//        panel4.add(message); 
//        add(panel4, BorderLayout.SOUTH);
        
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

package tugas1.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.*;

public class MainPage extends JFrame implements ActionListener{
    private JLabel namaDepan, namaBelakang, jenisKelamin, message, message2; 
    private JTextField tfNamaDepan, tfNamaBelakang; 
    private JTextArea textArea;
    private JRadioButton rb1, rb2; 
    private JPanel panel1, panel2, panel3;
    private JButton btnSave, ubah;
    private JScrollPane sp;
    private ButtonGroup grup; 
    private ArrayList<String[]> dataNama;
 
    private BufferedWriter writer;
    public MainPage(){
        super("Halaman Input Data"); 
        
        setLayout(new BorderLayout(0,0));
        
        dataNama = new ArrayList<String[]>();
        
        panel1 = new JPanel(new GridLayout(3,3)); 
        namaDepan = new JLabel("Nama Depan : "); 
        namaBelakang = new JLabel("Nama Belakang : ");
        tfNamaDepan = new JTextField(10);
        tfNamaBelakang = new JTextField(10); 
        jenisKelamin = new JLabel("Jenis Kelamin"); 
        
        panel2 = new JPanel(new GridLayout(6,2)); 
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
        ubah.addActionListener(this);
        message2 = new JLabel("");
        
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
        panel2.add(message2);
        
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
            if(tfNamaDepan.getText().isEmpty() || tfNamaBelakang.getText().isEmpty() || grup.getSelection() == null){
                message.setText("Data harus lengkap!");
            }
            else 
            {
                dataNama.add(new String[]{tfNamaDepan.getText() + " " + tfNamaBelakang.getText(), rb1.isSelected() ? rb1.getText() : rb2.getText()});
                // mindah dari arraylist ke textarea 
                for(String[] x:dataNama)
                {
                    textArea.append(String.join(" | ",x) + "\n");
                    
                }
                message.setText("Data berhasil disimpan");
            }
        }
        if(e.getSource() == ubah)
        {
            try {
                if(textArea.getText().trim().isEmpty())
                {
                    message2.setText("Tidak ada data yang tersedia");
                }
                else 
                {
                    textArea.write(new FileWriter("data_123230079.txt")); 
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                
            
        }
    } 

    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */

public class DemoTable extends JFrame{
    
    private JTable tblTaiKhoan;
    private JLabel lbTen,lbTien;
    private JTextField txtTen,txtTien;
    private JButton btThem,btXoa;
    
    public DemoTable(){
        super("Demo Table");
        setSize(600, 400);
        CreateGUI();
        ProcessEvent();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        DemoTable dmtb=new DemoTable();
        dmtb.setVisible(true);
    }

    private void CreateGUI() {
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        //Tạo JTable
        String[] columnName={"Tên tài khoản","Số tiền"};
        Object[][] data= new Object[][]{
            {"Tran Quang Nha",500000},
            {"Le The Nguyen",300000},
        };
        
       DefaultTableModel model=new DefaultTableModel(data,columnName);
        tblTaiKhoan=new JTable(model);
        JScrollPane srollPaneTable=new JScrollPane(tblTaiKhoan);
        
        p.add(srollPaneTable);
        
        //
        JPanel pNhapLieu=new JPanel();
        
        pNhapLieu.add(lbTen=new JLabel("Tên Tài Khoản"));
        pNhapLieu.add(txtTen=new JTextField(15));
        pNhapLieu.add(lbTien=new JLabel("Số Tiền"));
        pNhapLieu.add(txtTien=new JTextField(10));
        pNhapLieu.add(btThem=new JButton("Thêm"));
        pNhapLieu.add(btXoa=new JButton("Xoá"));
        
        
        p.add(pNhapLieu,BorderLayout.NORTH);
        add(p);
    }

    private void ProcessEvent() {
        btThem.addActionListener((e)-> {
            DefaultTableModel model=(DefaultTableModel)tblTaiKhoan.getModel();
            model.addRow(new Object[]{txtTen.getText(),txtTien.getText()});
        });
        btXoa.addActionListener((e)-> {
            
        int selectedRow=tblTaiKhoan.getSelectedRow();
            DefaultTableModel model=(DefaultTableModel)tblTaiKhoan.getModel();
            model.removeRow(selectedRow);
        });
        
        }  
    }

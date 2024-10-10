package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import model.PhieuMuon;
import model.PhieuMuonDAO;
import view.QLMuonTraView;
import java.time.LocalDate;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;



public class QLMuonTraController {
	private PhieuMuonDAO model;
	private QLMuonTraView view;
	
	
	public QLMuonTraController(PhieuMuonDAO model, QLMuonTraView view) {
	
		this.model = model;
		this.view = view;
	}
	public DefaultTableModel getTableModel(String[] columnNames) {
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		for (PhieuMuon pm : model.getDSPhieuMuon()) {
            tableModel.addRow(new Object[]{pm.getMaTheMuon(),pm.getIsbn(),pm.isTinhTrang(),pm.getNgayMuon(),pm.getNgayTraDuKien(),pm.getNgayTraThucTe()});
        }
        return tableModel;
	}


	public void addEventHandlers() {
		view.btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				themPhieuMuon();	
			}
		});
		view.btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaPhieuMuon();
			}
		});
		view.btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				suaPhieuMuon();
				
			}
		});
		view.btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				luuPhieuMuon();
				
			}
		});
		
	}

public void themPhieuMuon() {
	String maTheMuon = view.textField_maTheMuon.getText();
	String isbn = view.textField_isbn.getText();
	boolean tinhTrang = view.textField_tinhTrang.getText().equals("1");
	LocalDate ngayMuon = LocalDate.parse(view.textField_ngayMuon.getText());
	LocalDate ngayTraDuKien = LocalDate.parse(view.textField_ngayMuon.getText());
	LocalDate ngayTraThucTe = null;
	
	String ngayTraThucTeText = view.textField_ngayTraThucTe.getText();
    if (!ngayTraThucTeText.isEmpty()) {
        ngayTraThucTe = LocalDate.parse(ngayTraThucTeText);
    }
	
	PhieuMuon pm = new PhieuMuon(maTheMuon,isbn,tinhTrang, ngayMuon,ngayTraDuKien, ngayTraThucTe);
	
	model.themPhieuMuon(pm);
	view.updateTable(model.getDSPhieuMuon());
	view.xoaForm();
}


public void xoaPhieuMuon() {
	int selectedRow = view.table.getSelectedRow();
    if (selectedRow >= 0) {
        model.xoaPhieuMuon(selectedRow);
        refreshTable();
    }
}
public void luuPhieuMuon() {
    // Thực hiện lưu danh sách sinh viên (có thể lưu vào file hoặc cơ sở dữ liệu)
	try (FileOutputStream fos = new FileOutputStream("phieuMuonData.txt");
	         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	        
	        // Save the list of PhieuMuon to a file
	        oos.writeObject(model.getDSPhieuMuon());
	        System.out.println("Data saved successfully.");
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Error saving data.");
	    }
}


private void refreshTable() {
	DefaultTableModel tableModel = (DefaultTableModel) view.table.getModel();
    tableModel.setRowCount(0); // Xóa toàn bộ dòng hiện tại
    for (PhieuMuon pm : model.getDSPhieuMuon()) {
        tableModel.addRow(new Object[]{pm.getMaTheMuon(),pm.getIsbn(),pm.isTinhTrang(),pm.getNgayMuon(),pm.getNgayTraDuKien(),pm.getNgayTraThucTe()});
    }
	
}
public void suaPhieuMuon() {
    int selectedRow = view.table.getSelectedRow();
    if (selectedRow >= 0) {
    	String maTheMuon = view.textField_maTheMuon.getText();
    	String isbn = view.textField_isbn.getText();
    	boolean tinhTrang = view.textField_tinhTrang.getText().equals("1");
    	LocalDate ngayMuon = LocalDate.parse(view.textField_ngayMuon.getText());
    	LocalDate ngayTraDuKien = LocalDate.parse(view.textField_ngayMuon.getText());
    	LocalDate ngayTraThucTe = null;
    	
    	String ngayTraThucTeText = view.textField_ngayTraThucTe.getText();
        if (!ngayTraThucTeText.isEmpty()) {
            ngayTraThucTe = LocalDate.parse(ngayTraThucTeText);
        }

    	PhieuMuon pm = new PhieuMuon(maTheMuon,isbn,tinhTrang, ngayMuon,ngayTraDuKien, ngayTraThucTe);
        model.suaPhieuMuon(selectedRow, pm);
        refreshTable();
    }
}



}
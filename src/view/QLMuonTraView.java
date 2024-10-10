package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.QLMuonTraController;
import model.PhieuMuon;
import model.PhieuMuonDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QLMuonTraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_maTheMuon;
	public JTextField textField_ngayMuon;
	public JTextField textField_ngayTraDuKien;
	public JTextField textField_ngayTraThucTe;
	public JTable table;
	public JTextField textField_isbn;
	public JTextField textField_tinhTrang;
	private QLMuonTraController controller;
	public JButton btn_tinhTrang;
	
	public JButton btnThem;
	public JButton btnSua;
	public JButton btnXoa;
	public JButton btnLuu;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLMuonTraView frame = new QLMuonTraView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QLMuonTraView(){
		initComponents();
		controller = new QLMuonTraController(new PhieuMuonDAO(), this); 
	}
	public QLMuonTraView(QLMuonTraController controller){
		this.controller = controller; 
        initComponents(); 
	}
	
	public void initComponents() {
		setTitle("Quản lý mượn trả");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_maTheMuon = new JLabel("Mã thẻ mượn");
		Label_maTheMuon.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_maTheMuon.setBounds(78, 39, 165, 67);
		contentPane.add(Label_maTheMuon);
		
		JLabel Label_isbn = new JLabel("ISBN");
		Label_isbn.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_isbn.setBounds(78, 95, 165, 67);
		contentPane.add(Label_isbn);
		
		JLabel Label_tinhTrang = new JLabel("Tình trạng");
		Label_tinhTrang.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_tinhTrang.setBounds(78, 154, 165, 67);
		contentPane.add(Label_tinhTrang);
		
		JLabel Label_ngayMuon = new JLabel("Ngày mượn");
		Label_ngayMuon.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_ngayMuon.setBounds(416, 39, 165, 67);
		contentPane.add(Label_ngayMuon);
		
		JLabel Label_ngayTraDuKien = new JLabel("Ngày trả dự kiến");
		Label_ngayTraDuKien.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_ngayTraDuKien.setBounds(416, 95, 165, 67);
		contentPane.add(Label_ngayTraDuKien);
		
		JLabel Label_ngayTraThucTe = new JLabel("Ngày trả thực tế");
		Label_ngayTraThucTe.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_ngayTraThucTe.setBounds(416, 154, 165, 67);
		contentPane.add(Label_ngayTraThucTe);
		
		textField_maTheMuon = new JTextField();
		textField_maTheMuon.setBounds(217, 53, 165, 43);
		contentPane.add(textField_maTheMuon);
		textField_maTheMuon.setColumns(10);
		
		textField_ngayMuon = new JTextField();
		textField_ngayMuon.setColumns(10);
		textField_ngayMuon.setBounds(580, 53, 165, 43);
		contentPane.add(textField_ngayMuon);
		
		textField_ngayTraDuKien = new JTextField();
		textField_ngayTraDuKien.setColumns(10);
		textField_ngayTraDuKien.setBounds(580, 109, 165, 43);
		contentPane.add(textField_ngayTraDuKien);
		
		textField_ngayTraThucTe = new JTextField();
		textField_ngayTraThucTe.setColumns(10);
		textField_ngayTraThucTe.setBounds(580, 168, 165, 43);
		contentPane.add(textField_ngayTraThucTe);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 344, 860, 2);
		contentPane.add(separator);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(67, 268, 90, 51);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(251, 268, 90, 51);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBounds(452, 268, 90, 51);
		contentPane.add(btnXoa);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLuu.setBounds(655, 268, 90, 51);
		contentPane.add(btnLuu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 358, 860, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u1EBB m\u01B0\u1EE3n", "ISBN", "T\u00ECnh tr\u1EA1ng", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y tr\u1EA3 d\u1EF1 ki\u1EBFn", "Ng\u00E0y tr\u1EA3 th\u1EF1c t\u1EBF"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setPreferredWidth(117);
		scrollPane.setViewportView(table);
		
		textField_isbn = new JTextField();
		textField_isbn.setColumns(10);
		textField_isbn.setBounds(217, 109, 165, 43);
		contentPane.add(textField_isbn);
		
		textField_tinhTrang = new JTextField();
		textField_tinhTrang.setColumns(10);
		textField_tinhTrang.setBounds(217, 168, 165, 43);
		contentPane.add(textField_tinhTrang);
		
		
		
		
		controller.addEventHandlers();
		
		if (controller != null) {
			controller.addEventHandlers();
		} else {
			System.out.println("Controller is not initialized.");
		}
	}

	public void updateTable(List<PhieuMuon> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (PhieuMuon pm : list) {
			String tinhTrang = pm.isTinhTrang() ? "Muộn" : "Không muộn";
			Object[] row = {pm.getMaTheMuon()
					,pm.getIsbn()
					,tinhTrang
					,pm.getNgayMuon()
					,pm.getNgayTraDuKien()
					,pm.getNgayTraThucTe()};
			model.addRow(row);
		}
		
	}

	public void xoaForm() {
		textField_maTheMuon.setText(" ");
		textField_isbn.setText(" ");
		textField_ngayMuon.setText(" ");
		textField_ngayTraDuKien.setText(" ");
		textField_ngayTraThucTe.setText(" ");

	}

	public void setController(QLMuonTraController controller) {
		this.controller = controller;
        // Thiết lập các listener cho các nút bấm
        btnThem.addActionListener(e -> controller.themPhieuMuon());
        btnXoa.addActionListener(e -> controller.xoaPhieuMuon());
        btnSua.addActionListener(e -> controller.suaPhieuMuon());
        btnLuu.addActionListener(e -> controller.luuPhieuMuon());
      
}
}

package view;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.*
;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import controller.QLSVController;public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_HoVaTen;
	public JTextField textField_ID;
	public JTextField textField_NgaySinh;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 723);
		
		ActionListener action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.addActionListener(action);
		menuClose.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuFile.add(menuClose);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenu menuAbout = new JMenu("About ");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About me");
		mntmNewMenuItem.addActionListener(action);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_QueQuan = new JLabel("Quê quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_QueQuan.setBounds(10, 11, 78, 38);
		contentPane.add(label_QueQuan);
		
		JLabel label_MaThiSinh = new JLabel("Mã sinh viên");
		label_MaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_MaThiSinh.setBounds(212, 11, 103, 38);
		contentPane.add(label_MaThiSinh);
		
		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_MaThiSinh_TimKiem.setColumns(10);
		textField_MaThiSinh_TimKiem.setBounds(325, 10, 156, 38);
		contentPane.add(textField_MaThiSinh_TimKiem);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTim.addActionListener(action);
		btnTim.setBounds(498, 10, 90, 38);
		contentPane.add(btnTim);
		
		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_queQuan_timKiem.setBounds(85, 11, 117, 38);
		contentPane.add(comboBox_queQuan_timKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 75, 691, 2);
		contentPane.add(separator_1);
		
		JLabel label_QueQuan_1 = new JLabel("Danh sách thí sinh");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_QueQuan_1.setBounds(10, 75, 136, 38);
		contentPane.add(label_QueQuan_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 113, 701, 211);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 335, 691, 2);
		contentPane.add(separator_1_1);
		
		JLabel label_QueQuan_2 = new JLabel("Thông tin thí sinh");
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_QueQuan_2.setBounds(10, 343, 136, 38);
		contentPane.add(label_QueQuan_2);
		
		JLabel label_MaThiSinh1 = new JLabel("Mã thí sinh");
		label_MaThiSinh1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_MaThiSinh1.setBounds(10, 385, 97, 38);
		contentPane.add(label_MaThiSinh1);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHVTn.setBounds(10, 434, 78, 38);
		contentPane.add(lblHVTn);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(104, 433, 156, 28);
		contentPane.add(textField_HoVaTen);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_ID.setColumns(10);
		textField_ID.setBounds(104, 384, 156, 28);
		contentPane.add(textField_ID);
		
		JLabel label_QueQuan2_1 = new JLabel("Quê quán");
		label_QueQuan2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_QueQuan2_1.setBounds(10, 478, 78, 38);
		contentPane.add(label_QueQuan2_1);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(104, 482, 156, 30);
		contentPane.add(comboBox_queQuan);
		
		JLabel label_NgaySinh = new JLabel("NgaySinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_NgaySinh.setBounds(10, 523, 78, 38);
		contentPane.add(label_NgaySinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(104, 523, 156, 28);
		contentPane.add(textField_NgaySinh);
		
		JLabel label_MaThiSinh1_1 = new JLabel("Giới tính");
		label_MaThiSinh1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_MaThiSinh1_1.setBounds(326, 385, 97, 38);
		contentPane.add(label_MaThiSinh1_1);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nam.setBounds(429, 392, 66, 23);
		contentPane.add(radioButton_nam);
		
		 radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nu.setBounds(522, 392, 66, 23);
		contentPane.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		
		JLabel label_mon1 = new JLabel("Điểm môn 1");
		label_mon1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_mon1.setBounds(326, 434, 96, 38);
		contentPane.add(label_mon1);
		
		textField_mon1 = new JTextField();
		textField_mon1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(432, 433, 156, 28);
		contentPane.add(textField_mon1);
		
		JLabel label_mon2 = new JLabel("Môn 2");
		label_mon2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_mon2.setBounds(326, 478, 66, 38);
		contentPane.add(label_mon2);
		
		textField_mon2 = new JTextField();
		textField_mon2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(432, 481, 156, 28);
		contentPane.add(textField_mon2);
		
		JLabel label_mon3 = new JLabel("Môn 3");
		label_mon3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_mon3.setBounds(326, 523, 59, 38);
		contentPane.add(label_mon3);
		
		textField_mon3 = new JTextField();
		textField_mon3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(432, 523, 156, 28);
		contentPane.add(textField_mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(30, 582, 90, 38);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(158, 582, 90, 38);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(281, 582, 104, 38);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(417, 582, 90, 38);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(556, 582, 90, 38);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 572, 691, 2);
		contentPane.add(separator_1_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(15, 628, 733, -22);
		contentPane.add(separator_2);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 631, 711, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTim.setBounds(598, 11, 117, 38);
		contentPane.add(btnHuyTim);
		
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_mon1.setText("");
		textField_mon2.setText("");
		textField_mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
		
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}
	private ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.textField_ID.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_mon1.setText(ts.getDiemMon1() + "");
		this.textField_mon2.setText(ts.getDiemMon2() + "");
		this.textField_mon3.setText(ts.getDiemMon3() + "");
	}
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienThemThiSinh() {
		// Get du lieu
				int maThiSinh = Integer.valueOf(this.textField_ID.getText());
				String tenThiSinh = this.textField_HoVaTen.getText();
				int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
				Tinh tinh = Tinh.getTinhById(queQuan);
				Date ngaySinh = new Date(this.textField_NgaySinh.getText());
				boolean gioiTinh = true;
				if (this.radioButton_nam.isSelected()) {
					gioiTinh = true;
				} else if (this.radioButton_nu.isSelected()) {
					gioiTinh = false;
				}
				float diemMon1 = Float.valueOf(this.textField_mon1.getText());
				float diemMon2 = Float.valueOf(this.textField_mon2.getText());
				float diemMon3 = Float.valueOf(this.textField_mon3.getText());

				ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
				this.themHoacCapNhatThiSinh(ts);
	}
	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		
		// Thuc hien tim kiem
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}	
	}
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
			
	}
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
}

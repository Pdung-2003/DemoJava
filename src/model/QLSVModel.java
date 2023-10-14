package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;
	private String tenFile;
	

	public String getTenFile() {
		return tenFile;
	}
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	public String getLuaChon() {
		return luaChon;
	}
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
		
	}
	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon = ("");
		this.tenFile = ( "");
	}
	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}
	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	public void insert(ThiSinh thisinh ) {
		this.dsThiSinh.add(thisinh);
	}
	public void delete(ThiSinh thisinh ) {
		this.dsThiSinh.remove(thisinh);
	}
	public void update(ThiSinh thisinh ) {
		this.dsThiSinh.remove(thisinh);
		this.dsThiSinh.add(thisinh);
	}
	public boolean kiemTraTonTai(ThiSinh ts) {
		for(ThiSinh thiSinh: dsThiSinh) {
			if(thiSinh.getMaThiSinh() == ts.getMaThiSinh())
				return true;
		}
		return false;
	}
	
	
}

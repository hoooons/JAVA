package com.ssafy.environment;

public class Kuro {
	String name;
	String ny;
	String add;
	String check;	// 점검사항
	
	public Kuro() { }
	
	public Kuro(String name, String name2, String ny, String check, String add) {
		super();
		this.name = name;
		this.ny = ny;
		this.add = add;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNy() {
		return ny;
	}
	public void setNy(String ny) {
		this.ny = ny;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("업체명 : ");
		builder.append(name);
		builder.append("\t");
		builder.append(" 점검사항 : ");
		builder.append(check);
		builder.append("\t");
		builder.append("업체주소 : ");
		builder.append(add);
		builder.append("\t");
		builder.append("처분대상여부 : ");
		builder.append(ny);
		builder.append("\t");
		return builder.toString();
	}
	
	
	
}

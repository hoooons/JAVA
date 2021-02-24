package com.ssafy.shop;

public class Shop {
	String name;
	String group;
	String add;
	String build;
	
	public Shop() { }

	public Shop(String name, String group, String add, String build) {
		super();
		this.name = name;
		this.group = group;
		this.add = add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("상호명 : ");
		builder.append(name);
		builder.append("///");
		builder.append("업종 : ");
		builder.append(group);
		builder.append("///");
		builder.append("주소 : ");
		builder.append(add);
		builder.append("///");
		return builder.toString();
	}
}

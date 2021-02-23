package com.ssafy.HW10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame f;
	JButton b;
	JList li;
	JTextArea ta;
	INewsDAO dao;
	JScrollPane scroll;
	
	
	public NewsMain() {
		dao = new NewsDAODOMImpl();
		createGUI();
		addEvent();
		showList();
	}
	
	public void createGUI() {
		f = new JFrame("뉴스 리스트");
		JPanel p = new JPanel();
		b = new JButton("뉴스 리스트 목록 ");
		li = new JList();
		scroll = new JScrollPane();
		scroll.setViewportView(li);
		ta = new JTextArea("");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b,"North");
		p.add(scroll);
		f.setLayout(new GridLayout(2,1,5,5));
		f.add(p);
		f.add(ta);
		f.setSize(600,500);
		f.setVisible(true);
	}
	
	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		li.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				News n = (News)li.getSelectedValue();
				String str = n.getDesc() + "\n\nURL : " + n.getLink();
				ta.setText(str);;
			}
		});
	}
	public void showList() {
		List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		li.setListData(datas.toArray());
	}
	public static void main(String[] args) {
		new NewsMain();
	}
}

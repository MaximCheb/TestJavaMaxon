package max.labs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class BaseGraf extends JFrame {
	public static ArrayList<DataProc> ArRes1=new ArrayList<DataProc>();
	public static int[] ColorRes = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private boolean GrafState = false;
	private JPanel contentPane;
	private JTable table;
	private static int CountGraf;
	private static boolean [] TableState = {false,false,false,false};
	public static String[] FileAdress = {"","","",""};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseGraf frame = new BaseGraf();
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
	public BaseGraf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		// File fileRoot = new File("/home/max/eclipse-workspace/Labs6Graf/");
		//DefaultMutableTreeNode   root = new DefaultMutableTreeNode(new FileNode(fileRoot));
		// DefaultTreeModel   treeModel = new DefaultTreeModel(root);
		//JTree filetree = new JTree(treeModel);
		
		//panel_7.add(filetree);
		//DirToTree(filetree);
		JPanel panel_tableM = new JPanel();
		tabbedPane.addTab("Таблицы", null, panel_tableM, null);
		panel_tableM.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_tableMain = new JPanel();
		panel_tableM.add(panel_tableMain, BorderLayout.CENTER);
		panel_tableMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_up = new JPanel();
		panel_tableMain.add(panel_up, BorderLayout.NORTH);
		
		JLabel FileAdressLabel = new JLabel("Файл: не найден");
		panel_up.add(FileAdressLabel);
		
		JPanel panel_table = new JPanel();
		panel_tableMain.add(panel_table, BorderLayout.CENTER);
		Object[] columns = {"№","Кол-во","Тип","Время добавления","Ср. время добавл","Время удаления","Ср. время удал."};
		DefaultTableModel Hmodel = new DefaultTableModel();
		Hmodel.addRow(columns);
		JTable table = new JTable();
		
		panel_table.add(table);
		
		table.setVisible(true);
		
		JPanel panel_TableUP = new JPanel();
		panel_tableM.add(panel_TableUP, BorderLayout.NORTH);
		String[] items_combox_5 = {
			    "Таблица 1",
			    "Таблица 2",
			    "Таблица 3",
			    "Таблица 4"
		};
		JComboBox comboBox_5 = new JComboBox(items_combox_5);
		
		panel_TableUP.add(comboBox_5);
		String[] GrafType = {
		"Общее время добавления",
		"Общее время удаления",
		"Общее время добавления и удаления",
		"Среднее время добавления",
		"Среднее время удаления",
		"Среднее время добавления и удаления"		
		
		};
		JComboBox comboBox_9 = new JComboBox(GrafType);
		panel_TableUP.add(comboBox_9);
		
		JButton btnNewButton_4 = new JButton("Запомнить");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_TableUP.add(btnNewButton_4);
		
		JPanel panel_TableDown = new JPanel();
		panel_tableM.add(panel_TableDown, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Добавить таблицу");
		
		panel_TableDown.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Удалить таблицу");
		
		panel_TableDown.add(btnNewButton_1);
		
		
		
		JPanel panel_graf = new JPanel();
		tabbedPane.addTab("График", null, panel_graf, null);
		panel_graf.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_graf_up = new JPanel();
		panel_graf.add(panel_graf_up, BorderLayout.NORTH);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ArrayList");
		
		panel_graf_up.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("HashMap");
		
		panel_graf_up.add(chckbxNewCheckBox_1);
		
		String[] CBColors = {
			"Черный",	
			"Красный",
			"Синий",
			"Зеленый",
			"Желтый",
			"Фиолетовый",
			"Серый",
			"Рыжий",
			"Розовый",
			"Голубой"
		};
		
		JPanel panel_graf_color = new JPanel();
		panel_graf.add(panel_graf_color, BorderLayout.WEST);
		GridBagLayout gbl_panel_graf_color = new GridBagLayout();
		gbl_panel_graf_color.columnWidths = new int[]{32, 0};
		gbl_panel_graf_color.rowHeights = new int[]{106, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 124, 0};
		gbl_panel_graf_color.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_graf_color.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_graf_color.setLayout(gbl_panel_graf_color);
		
		JLabel lblNewLabel_1 = new JLabel("Первый цвет");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_graf_color.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(CBColors);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel_graf_color.add(comboBox, gbc_comboBox);
		comboBox.setSelectedIndex(0);
		
		JLabel lblNewLabel_2 = new JLabel("Второй цвет");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_graf_color.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox(CBColors);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 3;
		panel_graf_color.add(comboBox_1, gbc_comboBox_1);
		comboBox_1.setSelectedIndex(1);
		JLabel lblNewLabel_4 = new JLabel("Третий цвет");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_graf_color.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Четвертый цвет");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panel_graf_color.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Пятый цвет");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		panel_graf_color.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JComboBox comboBox_2 = new JComboBox(CBColors);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.BOTH;
		gbc_comboBox_2.gridx = 0;
		gbc_comboBox_2.gridy = 5;
		panel_graf_color.add(comboBox_2, gbc_comboBox_2);
		comboBox_2.setSelectedIndex(2);
		
		JComboBox comboBox_3 = new JComboBox(CBColors);
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_3.fill = GridBagConstraints.BOTH;
		gbc_comboBox_3.gridx = 0;
		gbc_comboBox_3.gridy = 7;
		panel_graf_color.add(comboBox_3, gbc_comboBox_3);
		comboBox_3.setSelectedIndex(3);
		
		JComboBox comboBox_4 = new JComboBox(CBColors);
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_4.fill = GridBagConstraints.BOTH;
		gbc_comboBox_4.gridx = 0;
		gbc_comboBox_4.gridy = 9;
		panel_graf_color.add(comboBox_4, gbc_comboBox_4);
		comboBox_4.setSelectedIndex(4);
		
		JLabel lblNewLabel_7 = new JLabel("Шестой цвет");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 10;
		panel_graf_color.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JComboBox comboBox_6 = new JComboBox(CBColors);
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_6.fill = GridBagConstraints.BOTH;
		gbc_comboBox_6.gridx = 0;
		gbc_comboBox_6.gridy = 11;
		panel_graf_color.add(comboBox_6, gbc_comboBox_6);
		comboBox_6.setSelectedIndex(5);
		
		JLabel lblNewLabel_8 = new JLabel("Седьмой цвет");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 12;
		panel_graf_color.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JComboBox comboBox_7 = new JComboBox(CBColors);
		
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.fill = GridBagConstraints.BOTH;
		gbc_comboBox_7.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_7.gridx = 0;
		gbc_comboBox_7.gridy = 13;
		panel_graf_color.add(comboBox_7, gbc_comboBox_7);
		comboBox_7.setSelectedIndex(6);
		
		JLabel lblNewLabel_9 = new JLabel("Восьмой цвет");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 14;
		panel_graf_color.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JComboBox comboBox_8 = new JComboBox(CBColors);
		
		GridBagConstraints gbc_comboBox_8 = new GridBagConstraints();
		gbc_comboBox_8.fill = GridBagConstraints.BOTH;
		gbc_comboBox_8.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_8.gridx = 0;
		gbc_comboBox_8.gridy = 15;
		panel_graf_color.add(comboBox_8, gbc_comboBox_8);
		comboBox_8.setSelectedIndex(7);
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_verticalGlue.gridx = 0;
		gbc_verticalGlue.gridy = 16;
		panel_graf_color.add(verticalGlue, gbc_verticalGlue);
		
		
		JPanel panel_graf_down = new JPanel();
		panel_graf.add(panel_graf_down, BorderLayout.SOUTH);
		
		JPanel panel_graf_main = new JPanel();
		panel_graf.add(panel_graf_main, BorderLayout.CENTER); 
		int i = 1;
		JPanel panel_graf_right = new JPanel();
		panel_graf.add(panel_graf_right, BorderLayout.EAST);
		
		JButton btnNewButton_Color = new JButton("Вывести цвет");
		
		panel_graf_down.add(btnNewButton_Color);
		JButton button = new JButton("Вывести график");
		panel_graf_down.add(button);
		GridBagLayout gbl_panel_graf_right = new GridBagLayout();
		gbl_panel_graf_right.columnWidths = new int[]{112, 0};
		gbl_panel_graf_right.rowHeights = new int[]{31, 14, 23, 14, 23, 0};
		gbl_panel_graf_right.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_graf_right.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_graf_right.setLayout(gbl_panel_graf_right);
		
		JLabel lblNewLabel_3 = new JLabel("Работа с графиком");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_graf_right.add(lblNewLabel_3, gbc_lblNewLabel_3);
		String[] Mashtab = {
				"Линейный",
				"Логарифмический"
		};
		JComboBox comboBox_10 = new JComboBox(Mashtab);
		GridBagConstraints gbc_comboBox_10 = new GridBagConstraints();
		gbc_comboBox_10.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox_10.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_10.gridx = 0;
		gbc_comboBox_10.gridy = 2;
		panel_graf_right.add(comboBox_10, gbc_comboBox_10);
		
		JLabel lblNewLabel_11 = new JLabel("Вывести");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 3;
		panel_graf_right.add(lblNewLabel_11, gbc_lblNewLabel_11);
		String[] PrefGraf = {
				"Все на одном",
				"Первую таблицу",
				"Вторую таблицу",
				"Третью таблицу",
				"Четвертую таблицу"
		};
		JComboBox comboBox_12 = new JComboBox(PrefGraf);
		GridBagConstraints gbc_comboBox_12 = new GridBagConstraints();
		gbc_comboBox_12.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox_12.gridx = 0;
		gbc_comboBox_12.gridy = 4;
		panel_graf_right.add(comboBox_12, gbc_comboBox_12);
		
		JDesktopPane desktopPane = new JDesktopPane();
		panel_graf_main.add(desktopPane);
		
		//colors
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_7.setVisible(false);
		lblNewLabel_8.setVisible(false);
		lblNewLabel_9.setVisible(false);
		comboBox.setVisible(false);
		comboBox_1.setVisible(false);
		comboBox_2.setVisible(false);
		comboBox_3.setVisible(false);
		comboBox_4.setVisible(false);
		comboBox_6.setVisible(false);
		comboBox_7.setVisible(false);
		comboBox_8.setVisible(false);
		//события
		
		chckbxNewCheckBox.addChangeListener(new ChangeListener() { //arraylist
			
			public void stateChanged(ChangeEvent arg0) {
				
				int count = 0;
				int count2 = 0;
				for(int i =0;i<4;i++) {
					if (TableState[i]==true) count++;
				}
					if((comboBox_9.getSelectedIndex()==2)||(comboBox_9.getSelectedIndex()==5)) count = count*2;
				if (chckbxNewCheckBox.isSelected()==true) count2 ++;
				if (chckbxNewCheckBox_1.isSelected()==true) count2 ++;
				CountGraf = count*count2;
				//System.out.println("Потребуется "+ count*count2+ " цветов");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//JButton btnNewButton_4 = new JButton("Запомнить");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;
				int count2 = 0;
				for(int i =0;i<4;i++) {
					if (TableState[i]==true) count++;
				}
					if((comboBox_9.getSelectedIndex()==2)||(comboBox_9.getSelectedIndex()==5)) count = count*2;
				if (chckbxNewCheckBox.isSelected()==true) count2 ++;
				if (chckbxNewCheckBox_1.isSelected()==true) count2 ++;
				CountGraf = count*count2;
				//System.out.println("Потребуется "+ count*count2+ " цветов");
			}
		
		});
		
		//JButton btnNewButton_1 = new JButton("Удалить таблицу");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int item = comboBox_5.getSelectedIndex();
							
				
				if (TableState[item] == false){
					FileAdressLabel.setText("Файл: файл "+ (item+1)+" не найден!");
					panel_table.setVisible(false);
					 DrawTable GraficTable = new DrawTable(item);
					 panel_table.removeAll();
				}
				else {
					panel_table.setVisible(false);
					 DrawTable GraficTable = new DrawTable(item);
					 panel_table.removeAll();
					panel_table.setVisible(true);
					TableState[item] = false;
					FileAdress[item]="";
					for ( int j = 0; j < ArRes1.size(); j++) {
						
						  if(ArRes1.get(j).NumTable==item) {
							  ArRes1.remove(j);  
						  }
						  }
				}
			
			}
		});
		button.addActionListener(new ActionListener() {//вывести график
			public void actionPerformed(ActionEvent arg0) {
				int[] colorTMP = {25,25,25,25,25,25,25,25,7};
				colorTMP[0]=comboBox.getSelectedIndex();
				colorTMP[1]=comboBox_1.getSelectedIndex();
				colorTMP[2]=comboBox_2.getSelectedIndex();
				colorTMP[3]=comboBox_3.getSelectedIndex();
				colorTMP[4]=comboBox_4.getSelectedIndex();
				colorTMP[5]=comboBox_6.getSelectedIndex();
				colorTMP[6]=comboBox_7.getSelectedIndex();
				colorTMP[7]=comboBox_8.getSelectedIndex();
				Boolean AL = chckbxNewCheckBox.isSelected();
				Boolean HM = chckbxNewCheckBox_1.isSelected();
				int GrafArray=0;
				if((AL==false)&&(HM==false))GrafArray=0;
				if((AL==true)&&(HM==false))GrafArray=1;
				if((AL==false)&&(HM==true))GrafArray=2;
				if((AL==true)&&(HM==true))GrafArray=3;
				Boolean DoubleTable = false;
				int tableNumgr = comboBox_12.getSelectedIndex();
				int j =0;
				int k = 0;
				int l = 0;
				if((comboBox_9.getSelectedIndex()==2)||(comboBox_9.getSelectedIndex()==5)) DoubleTable=true;
				//0
				if((TableState[0]==true)&&(AL==true)&&(tableNumgr==0||tableNumgr==1)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//1
				if((TableState[0]==true)&&(HM==true)&&(tableNumgr==0||tableNumgr==1)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//2
				if((TableState[0]==true)&&(AL==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==1)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//3
				if((TableState[0]==true)&&(HM==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==1)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//4
				if((TableState[1]==true)&&(AL==true)&&(tableNumgr==0||tableNumgr==2)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//5
				if((TableState[1]==true)&&(HM==true)&&(tableNumgr==0||tableNumgr==2)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//6
				if((TableState[1]==true)&&(AL==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==2)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//7
				if((TableState[1]==true)&&(HM==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==2)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				
				//8
				if((TableState[2]==true)&&(AL==true)&&(tableNumgr==0||tableNumgr==3)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//9
				if((TableState[2]==true)&&(HM==true)&&(tableNumgr==0||tableNumgr==3)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//10
				if((TableState[2]==true)&&(AL==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==3)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//11
				if((TableState[2]==true)&&(HM==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==3)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//12
				if((TableState[3]==true)&&(AL==true)&&(tableNumgr==0||tableNumgr==4)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//13
				if((TableState[3]==true)&&(HM==true)&&(tableNumgr==0||tableNumgr==4)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//14
				if((TableState[3]==true)&&(AL==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==4)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//15
				if((TableState[3]==true)&&(HM==true)&&(DoubleTable==true)&&(tableNumgr==0||tableNumgr==4)) {
					if(j>7)l =j-7;
					else l = j;
					ColorRes[k] = colorTMP[l];
					j++;
					
				}
				else ColorRes[k]=31;
				k++;
				//System.out.print(ColorRes[k]);
				ChekColor();
				int type = comboBox_9.getSelectedIndex();
				boolean LineAxis = true;
				if (comboBox_10.getSelectedIndex()==1)LineAxis = false;
				int GrafNum = comboBox_12.getSelectedIndex();
				DrawGraf Grafic = new DrawGraf(type,LineAxis,GrafNum,GrafArray);
				panel_graf_main.removeAll();
				
				   panel_graf_main.add(Grafic); //Создаем и добавляем компонент во фрейм
				   pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		chckbxNewCheckBox_1.addChangeListener(new ChangeListener() {//hashMesh
			public void stateChanged(ChangeEvent arg0) {
				int count = 0;
				int count2 = 0;
				for(int i =0;i<4;i++) {
					if (TableState[i]==true) count++;
				}
					if((comboBox_9.getSelectedIndex()==2)||(comboBox_9.getSelectedIndex()==5)) count = count*2;
				if (chckbxNewCheckBox.isSelected()==true) count2 ++;
				if (chckbxNewCheckBox_1.isSelected()==true) count2 ++;
				CountGraf = count*count2;
				//System.out.println("Потребуется "+ count*count2+ " цветов");
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {// add table
			public void actionPerformed(ActionEvent arg0) {
				int item = comboBox_5.getSelectedIndex();
				JFileChooser fileopen = new JFileChooser();
				String Path = "gg"; 
				panel_table.setVisible(true);
				
				 DefaultTableModel model = new DefaultTableModel();
				 model.setColumnIdentifiers(columns);
				 table.setModel(model);
				 
				
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();			
				    Path= file.getAbsolutePath(); 
				    FileAdress[item] = file.getAbsolutePath(); 
				    System.out.println(file.getAbsolutePath());
				    FileAdressLabel.setText("Файл добавлен: "+ Path);
				    
				}			
			
				    try {
				    	FileToArray(item, Path);
				    }
				    catch(IOException exc) {
				    	JFrame BadNews = new JFrame("BadNews");
				    	BadNews.setSize(200, 150);
				    	JOptionPane.showMessageDialog(BadNews," Файл не найден.");
				    }
//				    DrawGraf Grafic = new DrawGraf(i);
//					panel_table.removeAll();
//					
//					panel_table.add(Grafic); //Создаем и добавляем компонент во фрейм
//					pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
				    DrawTable GraficTable = new DrawTable(item);
				    panel_table.removeAll();
				
				    panel_table.add(GraficTable); //Создаем и добавляем компонент во фрейм
					pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
				
			}
		});
		comboBox_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				int item = comboBox_5.getSelectedIndex();
		
			    DefaultTableModel model = new DefaultTableModel();
			    model.setColumnIdentifiers(columns);
				table.setModel(model);
//					
				
				if (TableState[item] == false){
					FileAdressLabel.setText("Файл: файл "+ (item+1)+" не найден!");
					panel_table.setVisible(false);
					 DrawTable GraficTable = new DrawTable(item);
					 panel_table.removeAll();
				}
				else {
					panel_table.setVisible(true);
//									
					 DrawTable GraficTable = new DrawTable(item);
					 panel_table.removeAll();
					
					 panel_table.add(GraficTable); //Создаем и добавляем компонент во фрейм
					 pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int count = 0;
				int count2 = 0;
				for(int i =0;i<4;i++) {
					if (TableState[i]==true) count++;
				}
					if((comboBox_9.getSelectedIndex()==2)||(comboBox_9.getSelectedIndex()==5)) count = count*2;
				if (chckbxNewCheckBox.isSelected()==true) count2 ++;
				if (chckbxNewCheckBox_1.isSelected()==true) count2 ++;
				CountGraf = count*count2;
				System.out.println("Потребуется "+ count*count2+ " цветов");
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_4.setVisible(false);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_6.setVisible(false);
				lblNewLabel_7.setVisible(false);
				lblNewLabel_8.setVisible(false);
				lblNewLabel_9.setVisible(false);
				comboBox.setVisible(false);
				comboBox_1.setVisible(false);
				comboBox_2.setVisible(false);
				comboBox_3.setVisible(false);
				comboBox_4.setVisible(false);
				comboBox_6.setVisible(false);
				comboBox_7.setVisible(false);
				comboBox_8.setVisible(false);
				if (count*count2>=1) {
					lblNewLabel_1.setVisible(true);
					comboBox.setVisible(true);
				}
				if (count*count2>=2) {
					lblNewLabel_2.setVisible(true);
					comboBox_1.setVisible(true);
				}
				if (count*count2>=3) {
					lblNewLabel_4.setVisible(true);
					comboBox_2.setVisible(true);
				}
				if (count*count2>=4) {
					lblNewLabel_5.setVisible(true);
					comboBox_3.setVisible(true);
				}
				if (count*count2>=5) {
					lblNewLabel_6.setVisible(true);
					comboBox_4.setVisible(true);
				}
				if (count*count2>=6) {
					lblNewLabel_7.setVisible(true);
					comboBox_6.setVisible(true);
				}
				if (count*count2>=7) {
					lblNewLabel_8.setVisible(true);
					comboBox_7.setVisible(true);
				}
				if (count*count2>=8) {
					lblNewLabel_9.setVisible(true);
					comboBox_8.setVisible(true);
				}
				
			}
		});
		
	}
	
	 private static int FileToArray(int tablnum,String Path)throws IOException{
			String[] StrokeRes;
			char TypeArList;
			int amount;
			int Time_ADD;
			int Time_Remove;
			System.out.println("tablnum = " + tablnum);
			int max = 0;
			int NumTable = tablnum;
			TableState[tablnum] = true;
			StrokeRes = DataProc.GetDataAT(Path);
			for (int i = 0; i < StrokeRes.length; i++) {
				String[] SplVar = StrokeRes[i].split(":");
				amount = Integer.parseInt(SplVar[1]);
				Time_ADD = Integer.parseInt(SplVar[2]);
				Time_Remove = Integer.parseInt(SplVar[4]);
				if (SplVar[0].equals("ArrayList")) {
					TypeArList = 'A';
				}
					
				else {
					TypeArList = 'W';
									
				}
				DataProc DP = new DataProc(NumTable,TypeArList,amount,Time_ADD,Time_Remove);
				ArRes1.add(DP);
				System.out.println(DP);
				if (Time_ADD>max) max = Time_ADD;
			}
			return max;
			
			
		}
	 public static void ChekColor() {
		int k;
		 for(int j = 0;j<4;j++) {
			 for(int i = 0;i<4;i++) {
				 k=i+j*4;
				 System.out.print(ColorRes[k]+"|");
			 }System.out.println("__________");
		 } System.out.println("__________");
	 }
	
}
	


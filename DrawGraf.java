package max.labs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import java.lang.Math;


public class DrawGraf extends JComponent{
	private static final int W = 650;
	private static final int H = 600;
	private static int type;
	private static boolean linerAxis;
	private static int grafNum;
	private static int max;
	private static int GrafArray;
	
	private static String LabelText;
	public DrawGraf(int type,boolean TypeAxis,int grafNum,int GrafArray) {
		this.linerAxis = TypeAxis;
		this.type = type;
		this.grafNum=grafNum;
		this.GrafArray=GrafArray;
	}
	public void paintComponent(Graphics g) {
		int del = 0;
		int[] GrafColor = BaseGraf.ColorRes;
		Graphics2D g2 = (Graphics2D) g;		
		BaseGraf BG = new BaseGraf();
		ArrayList<DataProc> ArRes= BG.ArRes1;
		
		
		if (linerAxis == true ) {
			DrawLabel(g, type);
			del = LineAxis(ArRes);
			DrawBorderliner(g,del);
			System.out.println(linerAxis);	
			for (int i=0;i<GrafColor.length-1;i++) {
				//System.out.println(i+" "+GrafColor[i]);	
				if( GrafColor[i]!=31)DrawArrayLine(g,i,del,ArRes,GrafColor[i]); 
					
				
			}
		}
		else {
			DrawLabel(g, type);
			DrawBorderLog(g,del);
			del = LogAxis(ArRes);
			//System.out.println(linerAxis);	
			for (int i=0;i<GrafColor.length-1;i++) {
				//System.out.println(i+" "+GrafColor[i]);	
				if( GrafColor[i]!=31)DrawArrayLog(g,i,del,ArRes,GrafColor[i]); 
					
				
			}
		}
		
		//DrawArrayLine( g,typeGraf,del,ArRes);
		//DrawHashLine( g,typeGraf,del,ArRes);
	}
	 //вывод результатов
	public void DrawArrayLine(Graphics g,int nub, int del,ArrayList<DataProc>ArRes,int grafColor) {
		int res = 0, oldres = 0;
		int j= 0;
		int k= 0;
		if(grafColor == 0)g.setColor(Color.BLACK);
		if(grafColor == 1)g.setColor(Color.RED);
		if(grafColor == 2)g.setColor(Color.BLUE);
		if(grafColor == 3)g.setColor(Color.GREEN);
		if(grafColor == 4)g.setColor(Color.YELLOW);
		if(grafColor == 5)g.setColor(Color.MAGENTA);
		if(grafColor == 6)g.setColor(Color.GRAY);
		if(grafColor == 7)g.setColor(Color.RED);
		if(grafColor == 8)g.setColor(Color.PINK);
		if(grafColor == 9)g.setColor(Color.black);
		if(grafColor == 10)g.setColor(Color.red);
		if(grafColor == 11)g.setColor(Color.blue);
		if(grafColor == 12)g.setColor(Color.green);
		if(grafColor == 13)g.setColor(Color.yellow);
		if(grafColor == 14)g.setColor(Color.magenta);
		if(grafColor == 15)g.setColor(Color.gray);
		if(grafColor == 31)g.setColor(Color.WHITE);
		Graphics2D g1 = (Graphics2D) g;
		boolean partGraf = false;
		if (nub%4>2)partGraf = true;
		//System.out.println(nub+" gfff "+grafColor);	
		int addp = nub%2;
		int TabNum = nub/4;
		if (nub<4) TabNum = 0;
		if (nub<8&&nub>3) TabNum = 1;
		if (nub<12&&nub>7) TabNum =2;
		if (nub>11) TabNum = 3;
		int HM = nub%2;
		System.out.println(type+" j "+del+" g "+ArRes.size());	
		for (int i = 0; i < ArRes.size(); i++) {
//			System.out.println(ArRes.get(i).NumTable+" geee "+TabNum);	
//			System.out.println(HM+" HM "+i%2);	
//			System.out.println(" i= "+i+" j= "+j);	
//			System.out.println("type = "+type);
			if ((ArRes.get(i).NumTable==TabNum)&&(HM==i%2)&&(partGraf == false)) {
				switch (type) {
				case (0):
					res = ArRes.get(i).TimeAdd;
					break;
				case (1):
					res = ArRes.get(i).TimeDel;
					break;
				case (2):
					res = ArRes.get(i).TimeAdd;
					break;
				case (3):
					res = ArRes.get(i).TimeAdd/ArRes.get(i).amount;
					break;
				case (4):
					res = ArRes.get(i).TimeDel/ArRes.get(i).amount;
					break;
				case (5):
					res = ArRes.get(i).TimeAdd/ArRes.get(i).amount;
					break;
				}
				if (oldres!=0) {
					g.drawLine((j-1)*100+175, 545-Math.round(oldres*20/del) , j*100+175, 545-Math.round(res*20/del) );
				}
				oldres = res;
				
				//System.out.println(oldres+" j "+del);	 
			j++;
			}
			if ((ArRes.get(i).NumTable==TabNum)&&(HM==i%2)&&(partGraf == true)) {
				switch (type) {
				case (0):
					res = ArRes.get(i).TimeAdd;
					break;
				case (1):
					res = ArRes.get(i).TimeDel;
					break;
				case (2):
					res = ArRes.get(i).TimeDel;
					break;
				case (3):
					res = ArRes.get(i).TimeAdd/ArRes.get(i).amount;
					break;
				case (4):
					res = ArRes.get(i).TimeDel/ArRes.get(i).amount;
					break;
				case (5):
					res = ArRes.get(i).TimeDel/ArRes.get(i).amount;
					break;
				}
				if (oldres!=0) {
					g.drawLine((k-1)*100+175, 545-Math.round(oldres*20/del) , k*100+175, 545-Math.round(res*20/del) );
				}
				oldres = res;
				//System.out.println(oldres+" j "+del);	 
			k++;
			}
		}
	}
	
	public void DrawArrayLog(Graphics g,int nub, int del,ArrayList<DataProc>ArRes,int grafColor) {
		double res = 0; 
		int oldres = 0;
		int j= 0;
		int k= 0;
		if(grafColor == 0)g.setColor(Color.BLACK);
		if(grafColor == 1)g.setColor(Color.RED);
		if(grafColor == 2)g.setColor(Color.BLUE);
		if(grafColor == 3)g.setColor(Color.GREEN);
		if(grafColor == 4)g.setColor(Color.YELLOW);
		if(grafColor == 5)g.setColor(Color.MAGENTA);
		if(grafColor == 6)g.setColor(Color.GRAY);
		if(grafColor == 7)g.setColor(Color.RED);
		if(grafColor == 8)g.setColor(Color.PINK);
		if(grafColor == 9)g.setColor(Color.black);
		if(grafColor == 10)g.setColor(Color.red);
		if(grafColor == 11)g.setColor(Color.blue);
		if(grafColor == 12)g.setColor(Color.green);
		if(grafColor == 13)g.setColor(Color.yellow);
		if(grafColor == 14)g.setColor(Color.magenta);
		if(grafColor == 15)g.setColor(Color.gray);
		if(grafColor == 31)g.setColor(Color.WHITE);
		Graphics2D g1 = (Graphics2D) g;
		boolean partGraf = false;
		if (nub%4>2)partGraf = true;
		System.out.println(nub+" gfff "+grafColor);	
		int addp = nub%2;
		int TabNum = nub/4;
		if (nub<4) TabNum = 0;
		if (nub<8&&nub>3) TabNum = 1;
		if (nub<12&&nub>7) TabNum =2;
		if (nub>11) TabNum = 3;
		int HM = nub%2;
		//System.out.println(type+" j "+del+" g "+ArRes.size());	
		for (int i = 0; i < ArRes.size(); i++) {
//			System.out.println(ArRes.get(i).NumTable+" geee "+TabNum);	
//			System.out.println(HM+" HM "+i%2);	
//			System.out.println(" i= "+i+" j= "+j);	
//			System.out.println("type = "+type);
			if ((ArRes.get(i).NumTable==TabNum)&&(HM==i%2)&&(partGraf == false)) {
				switch (type) {
				case (0):
					res = ArRes.get(i).TimeAdd;
					break;
				case (1):
					res = ArRes.get(i).TimeDel;
					break;
				case (2):
					res = ArRes.get(i).TimeAdd;
					break;
				case (3):
					res = ArRes.get(i).TimeAdd/ArRes.get(i).amount;
					break;
				case (4):
					res = ArRes.get(i).TimeDel/ArRes.get(i).amount;
					break;
				case (5):
					res = ArRes.get(i).TimeAdd/ArRes.get(i).amount;
					break;
				}
				res = Math.log10(res);
				res = res*60;
				int inres=(int)res;
				if (oldres!=0) {
					g.drawLine((j-1)*100+175, 545-Math.round(oldres) , j*100+175, 545-Math.round(inres) );
				}
				oldres = inres;
				//System.out.println(oldres+" j "+del);	 
			j++;
			}
			if ((ArRes.get(i).NumTable==TabNum)&&(HM==i%2)&&(partGraf == true)) {
				switch (type) {
				case (0):
					res = ArRes.get(i).TimeAdd;
					break;
				case (1):
					res = ArRes.get(i).TimeDel;
					break;
				case (2):
					res = ArRes.get(i).TimeDel;
					break;
				case (3):
					res = ArRes.get(i).TimeAdd/ArRes.get(i).amount;
					break;
				case (4):
					res = ArRes.get(i).TimeDel/ArRes.get(i).amount;
					break;
				case (5):
					res = ArRes.get(i).TimeDel/ArRes.get(i).amount;
					break;
				}
				res = Math.log10(res);
				res = res*60;
				int inres=(int)res;
				if (oldres!=0) {
					g.drawLine((k-1)*100+175, 545-Math.round(oldres) , k*100+175, 545-Math.round(inres) );
				}
				oldres = inres;
				//System.out.println(inres+" j "+del);	 
			k++;
			}
		}
	}
	 //название графика
	
	public Dimension getPreferredSize() { 
		return new Dimension(W, H);
	}
	public void DrawLabel(Graphics g, int type) {
		Font FTitle = new Font("Arial", Font.PLAIN, 16);
		g.setFont(FTitle);
		switch (type) {
		case (0):
			g.drawString("Общее время добавление", 250, 15);
			break;
		case (1):
			g.drawString("Общее время удаления", 250, 15);
			break;
		case (2):
			g.drawString("Общее время добaвления и удаления", 150, 15);
			break;
		case (3):
			g.drawString("Среднее время добавление", 250, 15);
			break;
		case (4):
			g.drawString("Среднее время удаления", 250, 15);
			break;
		case (5):
			g.drawString("Среднее время добaвления и удаления", 150, 15);
			break;
			
		}
	}
	 //отрисовка осей графика
	
	public void DrawBorderliner(Graphics g, int del) {	
		Font FTitle = new Font("Arial", Font.PLAIN, 12);
		g.setFont(FTitle);
		
		g.drawLine(75, 15, 75, 550);
		g.drawLine(75, 550, 725, 550);
		g.drawLine(70, 20, 75, 15);
		g.drawLine(80, 20, 75, 15);
		for (int i = 0; i<27;i++ ) {
			g.drawLine(70,550- i*20, 625,550- i*20);
			g.drawString(Integer.toString(i*del), 10, 550- i*20);
		}
		g.drawLine(175,545, 175,555);
		g.drawString(Integer.toString(10), 170, 570);
		g.drawLine(275,545, 275,555);
		g.drawString(Integer.toString(100), 270, 570);
		g.drawLine(375,545, 375,555);
		g.drawString(Integer.toString(1000), 370, 570);
		g.drawLine(475,545, 475,555);
		g.drawString(Integer.toString(10000), 470, 570);
		g.drawLine(575,545, 575,555);
		g.drawString(Integer.toString(100000), 570, 570);
		
		
	}
	public void DrawBorderLog(Graphics g, int del) {	
		Font FTitle = new Font("Arial", Font.PLAIN, 12);
		g.setFont(FTitle);
		int ff = 1;
		g.drawLine(75, 15, 75, 550);
		g.drawLine(75, 550, 650, 550);
		g.drawLine(70, 20, 75, 15);
		g.drawLine(80, 20, 75, 15);
		for (int i = 0; i<9;i++ ) {		
			
			g.drawString(Integer.toString(ff), 10, 550- i*60);
			ff = ff*10;
		}
		for (int i = 0; i<18;i++ ) {
			
			g.drawLine(70,550- i*30, 625,550- i*30);
			
		}
		g.drawLine(175,545, 175,555);
		g.drawString(Integer.toString(10), 170, 570);
		g.drawLine(275,545, 275,555);
		g.drawString(Integer.toString(100), 270, 570);
		g.drawLine(375,545, 375,555);
		g.drawString(Integer.toString(1000), 370, 570);
		g.drawLine(475,545, 475,555);
		g.drawString(Integer.toString(10000), 470, 570);
		g.drawLine(575,545, 575,555);
		g.drawString(Integer.toString(100000), 570, 570);
		
		
	}
	 //Отрисовка легенды 
	public void DrawLegend(Graphics g) {
		Font FTitle = new Font("Arial", Font.PLAIN, 14);
		g.setFont(FTitle);
		g.drawLine(650,0, 650,75);
		g.drawLine(650,75, 800,75);
		g.drawString("ArrayList", 700, 25);
		g.drawString("HashMesh", 700, 50);
		Graphics2D gA = (Graphics2D) g;
		Rectangle2D RecA = new Rectangle2D.Double(675, 15, 20, 10);
		Graphics2D gH = (Graphics2D) g;
		Rectangle2D RecH = new Rectangle2D.Double(675, 40, 20, 10);
		gA.draw(RecA);
		gA.setColor(Color.BLUE);
		gA.fill(RecA);
		gH.draw(RecH);
		gH.setColor(Color.RED);
		gH.fill(RecH);
	}
	
	   public static int LineAxis(ArrayList<DataProc>ArRes) {
			int max = 0;
			
		   for (int i = 0; i < ArRes.size(); i++) {
			   int amount = ArRes.get(i).amount;
				if (type == 0) {
					int loc = ArRes.get(i).TimeAdd;
					if(loc>max)max=loc;
				}
				if (type == 1) {
					int loc = ArRes.get(i).TimeDel;
					if(loc>max)max=loc;
				}
				if (type== 2) {
					int loc1 = ArRes.get(i).TimeAdd;
					int loc2 = ArRes.get(i).TimeDel;
					if((loc1>max))max=loc1;
					if((loc2>max))max=loc2;
				}
				if (type == 3) {
					int loc = ArRes.get(i).TimeAdd/(amount/10);
					if(loc>max)max=loc;
				}
				if (type == 4) {
					int loc = ArRes.get(i).TimeDel/(amount/10);
					if(loc>max)max=loc;
				}
				if (type == 5) {
					int loc1 = ArRes.get(i).TimeAdd/amount;
					int loc2 = ArRes.get(i).TimeDel/(amount/10);
					if((loc1>max))max=loc1;
					if((loc2>max))max=loc2;
				}
				
			}
			int del = 0;
			if (max<250)del=10;
			if (max>250&&max<625)del=250;
			if (max>625&&max<1250)del=50;
			if (max>1250&&max<1875)del=75;
			if (max>1875&&max<2500)del=100;
			if (max>2500&&max<6250)del=250;
			if (max>6250&&max<12500)del=500;
			if (max>12500&&max<18750)del=750;
			if (max>18750&&max<25000)del=1000;
			if (max>25000&&max<62500)del=2500;
			if (max>62500&&max<125000)del=5000;
			if (max>125000&&max<187500)del=7500;
			if (max>187500&&max<250000)del=10000;
			if (max>250000&&max<625000)del=25000;
			if (max>625000&&max<1250000)del=50000;
			if (max>1250000&&max<1875000)del=75000;
			if (max>1875000&&max<2500000)del=100000;
			if (max>2500000&&max<6250000)del=250000;
			if (max>6250000&&max<12500000)del=500000;
			if (max>12500000&&max<18750000)del=750000;
			if (max>18750000&&max<25000000)del=1000000;
			if (max>25000000&&max<62500000)del=2500000;
			if (max>62500000)del=5000000;
			return del;
		}
	   
	   public static int LogAxis(ArrayList<DataProc>ArRes) {
			double max = 0;
			
		   for (int i = 0; i < ArRes.size(); i++) {
			   int amount = ArRes.get(i).amount;
				if (type == 0) {
					int loc = ArRes.get(i).TimeAdd;
					if(loc>max)max=loc;
				}
				if (type == 1) {
					int loc = ArRes.get(i).TimeDel;
					if(loc>max)max=loc;
				}
				if (type== 2) {
					int loc1 = ArRes.get(i).TimeAdd;
					int loc2 = ArRes.get(i).TimeDel;
					if((loc1>max))max=loc1;
					if((loc2>max))max=loc2;
				}
				if (type == 3) {
					int loc = ArRes.get(i).TimeAdd;
					if(loc>max)max=loc;
				}
				if (type == 4) {
					int loc = ArRes.get(i).TimeDel/(amount/10);
					if(loc>max)max=loc;
				}
				if (type == 5) {
					int loc1 = ArRes.get(i).TimeAdd/amount;
					int loc2 = ArRes.get(i).TimeDel/(amount/10);
					if((loc1>max))max=loc1;
					if((loc2>max))max=loc2;
				}
				
			}
		   	max = Math.log10(max);
			
			int resdel = (int)max;			
			
			return resdel;
		}
	 //данные из файла в Array list results
	  
}

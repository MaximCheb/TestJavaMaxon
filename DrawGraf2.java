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

import javax.swing.JComponent;


public class DrawGraf2 extends JComponent{
	private static final int W = 650;
	private static final int H = 600;
	private static int typeGraf;
	private static int max;
	
	private static String LabelText;
	public DrawGraf2(int type) {
		//this.datalines = datalines;
		//this.max= max;
		//this.amount = amount;
		this.typeGraf = type;
	}
	public void paintComponent(Graphics g) {
		//BaseGraf BG = new BaseGraf();
		//ArrayList<DataProc> ArRes= BG.ArRes1;
		
		Graphics2D g2 = (Graphics2D) g;
		int del = 25000;
	    //System.out.println("del"+del);
	    //DrawLabel(g,typeGraf);
		DrawBorder(g,del);
		
		//DrawArrayLine( g,typeGraf,del,ArRes);
		//DrawHashLine( g,typeGraf,del,ArRes);
	}
	
	public void DrawNumb(Graphics g) {
		BaseGraf BG = new BaseGraf();
		ArrayList<DataProc> ArRes= BG.ArRes1;
		for ( int i = 0; i < ArRes.size(); i++) {
			  if(ArRes.get(i).NumTable==item) {
//			  int am = ArRes.get(i).amount;
//			  row[0] = i+1;
//	          row[1] = am;
//	          row[2] = ArRes.get(i).Type;
//	          row[3] = ArRes.get(i).TimeAdd;
//	          row[4] = ArRes.get(i).TimeAdd/am;
//	          row[5] = ArRes.get(i).TimeDel;
//	          row[6] = ArRes.get(i).TimeDel/(am/10);	        
	          int am = ArRes.get(i).amount;
	          g.drawString(Integer.toString(i+1), 10, i*25+50);
	          g.drawString(Integer.toString(am), 10, i*25+50);
	          g.drawString(String.valueOf(ArRes.get(i).Type), 10, i*25+50);
	          g.drawString(Integer.toString(ArRes.get(i).TimeAdd), 10, i*25+50);
	          g.drawString(Integer.toString(ArRes.get(i).TimeAdd/am), 10, i*25+50);
	          g.drawString(Integer.toString(ArRes.get(i).TimeDel), 10, i*25+50);
	          g.drawString(Integer.toString(ArRes.get(i).TimeDel/(am/10)), 10, i*25+50);
	          System.out.println("Рисую данные");
			}
			
	    }	
	}
	public void DrawHeader(Graphics g) {	
		Font FTitle = new Font("Arial", Font.PLAIN, 12);
		g.setFont(FTitle);
		g.drawString("", 10, 10);
		g.drawString("", 10, 10);
		g.drawString("", 10, 10);
		g.drawString("", 10, 10);
		g.drawString("", 10, 10);
		g.drawString("", 10, 10);
		g.drawString("", 10, 10);
		System.out.println("Рисую заголовок");
	}	
	 //вывод результатов
	public void DrawArrayLine(Graphics g,int type, int del,ArrayList<DataProc>ArRes) {
		int res = 0, oldres = 0;
		Graphics2D g1 = (Graphics2D) g;
		g.setColor(Color.BLUE);
		g1.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			switch (type) {
			case (1):
				res = ArRes.get(2*i).TimeAdd;
				break;
			case (2):
				res = ArRes.get(2*i).TimeAdd/ArRes.get(2*i).amount;
				break;
			case (3):
				res = ArRes.get(2*i).TimeDel;
				break;
			case (4):
				res = ArRes.get(2*i).TimeDel/ArRes.get(2*i).amount;
				break;
			}
			Ellipse2D RecA = new Ellipse2D.Double(i*100+170, 540-Math.round(res*20/del) , 10, 10);
			//System.out.println("res Array= "+ res+"del = "+ del);
			//System.out.println(545-Math.round(res*20/del));
			g1.draw(RecA);
			g1.fill(RecA);
			if (oldres!=0) {
				g.drawLine((i-1)*100+175, 545-Math.round(oldres*20/del) , i*100+175, 545-Math.round(res*20/del) );
			}
			oldres = res;
				 
		}
	}
	 //вывод результатов
	public void DrawHashLine(Graphics g,int type, int del,ArrayList<DataProc>ArRes) {
		int res = 0, oldres = 0;
		Graphics2D g1 = (Graphics2D) g;
		g.setColor(Color.RED);
		g1.setColor(Color.RED);
		for (int i = 0; i < 5; i++) {
			switch (type) {
			case (1):
				res = ArRes.get(2*i+1).TimeAdd;
				break;
			case (2):
				res = ArRes.get(2*i+1).TimeAdd/ArRes.get(2*i+1).amount;
				break;
			case (3):
				res = ArRes.get(2*i+1).TimeDel;
				break;
			case (4):
				res = ArRes.get(2*i+1).TimeDel/ArRes.get(2*i+1).amount;
				break;
			}
			Ellipse2D RecA = new Ellipse2D.Double(i*100+170, 540-Math.round(res*20/del) , 10, 10);
			//System.out.println("res Hash = "+ res+"del = "+ del);
			//System.out.println(545-Math.round(res*20/del));
			g1.draw(RecA);
			g1.fill(RecA);
			if (oldres!=0) {
				g.drawLine((i-1)*100+175, 545-Math.round(oldres*20/del) , i*100+175, 545-Math.round(res*20/del) );
			}
			oldres = res;
				 
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
		case (1):
			g.drawString("Общее время добавление", 350, 15);
			break;
		case (3):
			g.drawString("Общее время удаления", 350, 15);
			break;
		case (2):
			g.drawString("Среднее время добавление", 350, 15);
			break;
		case (4):
			g.drawString("Среднее время удаления", 350, 15);
			break;
			
		}
	}
	 //отрисовка осей графика
	
	public void DrawBorder(Graphics g, int del) {	
		Font FTitle = new Font("Arial", Font.PLAIN, 12);
		g.setFont(FTitle);
		
		g.drawLine(75, 15, 75, 550);
		g.drawLine(75, 550, 650, 550);
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
	
	
}

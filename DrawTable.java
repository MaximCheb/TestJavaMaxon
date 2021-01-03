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


public class DrawTable extends JComponent{
	private static final int W = 800;
	private static final int H = 335;
	private static int typeGraf;
	private static int max;
	
	private static String LabelText;
	public DrawTable(int type) {
		//this.datalines = datalines;
		//this.max= max;
		//this.amount = amount;
		this.typeGraf = type;
	}
	public void paintComponent(Graphics g) {
		//BaseGraf BG = new BaseGraf();
		//ArrayList<DataProc> ArRes= BG.ArRes1;
		
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D RecA = new Rectangle2D.Double(0,0, 800, 350);
		
		g2.draw(RecA);
		g2.setColor(Color.WHITE);
		g2.fill(RecA);
		int del = 25000;
		g.setColor(Color.BLACK);
	    //System.out.println("del"+del);
	    //DrawLabel(g,typeGraf);
		DrawBorder(g,del);
		DrawHeader(g);
		DrawNumb(g); 
		//DrawArrayLine( g,typeGraf,del,ArRes);
		//DrawHashLine( g,typeGraf,del,ArRes);
	}
	
	public void DrawNumb(Graphics g) {
		g.setColor(Color.BLACK);
		int i = 0;
		BaseGraf BG = new BaseGraf();
		ArrayList<DataProc> ArRes= BG.ArRes1;
		for ( int j = 0; j < ArRes.size(); j++) {
			
			  if(ArRes.get(j).NumTable==typeGraf) {
//				
	          int am = ArRes.get(j).amount;
	          g.drawString(Integer.toString(j%10+1), 55, 55+30*i);
	          g.drawString(Integer.toString(am), 155,  55+30*i);
	          g.drawString(String.valueOf(ArRes.get(j).Type), 255,  55+30*i);
	          g.drawString(Integer.toString(ArRes.get(j).TimeAdd), 355,  55+30*i);
	          g.drawString(Integer.toString(ArRes.get(j).TimeAdd/am), 455,  55+30*i);
	          g.drawString(Integer.toString(ArRes.get(j).TimeDel), 555,  55+30*i);
	          g.drawString(Integer.toString(ArRes.get(j).TimeDel/(am/10)), 655,  55+30*i);
	          i++;
	         // System.out.println("Рисую данные"+typeGraf+ "table");
	         // System.out.println(Integer.toString(j+1)+"|"+Integer.toString(am)+"|"+String.valueOf(ArRes.get(j).Type)+"|"+Integer.toString(ArRes.get(j).TimeAdd)+"|"+Integer.toString(ArRes.get(j).TimeDel/(am/10)));
			}
			
	    }	
	}
	public void DrawHeader(Graphics g) {	
		Font FTitle = new Font("Arial", Font.PLAIN, 12);
		g.setFont(FTitle);
		g.drawString("№", 55, 25);
		g.drawString("Кол-во", 155, 25);
		g.drawString("Т add", 355, 25);
		g.drawString("Tmid add", 455, 25);
		g.drawString("T del", 555, 25);
		g.drawString("Tmid del", 655, 25);
		g.drawString("Type", 255, 25);
		//System.out.println("Рисую заголовок");
	}	
	 //вывод результатов
	
	 //вывод результатов
	
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
		
		for (int i = 0; i<8;i++ ) {
			g.drawLine(50+i*100, 0, 50+i*100, 330);;
			
		}

		for (int i = 0; i<13;i++ ) {
			g.drawLine(50,30*i, 750,30*i);
			
		}
		
		
		
	}
	
	
}

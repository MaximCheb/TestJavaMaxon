package max.labs;
import java.awt.*;
import javax.swing.*;
import max.labs.DrawGraf;
import java.io.IOException;
import java.util.ArrayList;

public class DrawFrame extends JFrame{
	private static final int W = 800;
	private static final int H = 640;
	public static int[] Dataline;
	   public void DrawFrame() {
		   System.out.println("ggg");
	      setSize(this.W, this.H );
	      
	   }
	   public void Draw(int type) {
		   
		   String text = "GGGGG"+Integer.toString(type);
		   DrawGraf Grafic = new DrawGraf( type);
		   add(Grafic); //Создаем и добавляем компонент во фрейм
		   pack(); //Устанавливаем размеры фрейма по размерам компонента(ов)
		   setSize(this.W, this.H );
		      }
	  
}

		

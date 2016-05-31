package Gamer;

import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Moeda extends Desenho {

	private JLabel moeda_ouro;
	private Rectangle rect_moeda;

	public Moeda(int x, int y, int hight, int width) 
	{	
		super(x,y,hight,width);
		this.rect_moeda = new Rectangle(x, y, hight, width);
		this.setImg(new ImageIcon (getClass().getResource("/images/Moeda1.gif") ));
		this.moeda_ouro = new JLabel(this.getImg());
		this.moeda_ouro.setBounds(rect_moeda);
	}		
	
	public boolean Colisao(Sonic a)
	{
		if (rect_moeda.intersects(a.getRect_sonic()))
			return true;
		else
			return false;
		
	}

	public void LocarlizarMoedas()
	{
		Random n_aleatorio = new Random();
		rect_moeda.x = n_aleatorio.nextInt(700);
		rect_moeda.y = n_aleatorio.nextInt(1100);
		this.moeda_ouro.setBounds(rect_moeda);	
	}
	
	public Rectangle getRect_moeda() {
		return rect_moeda;
	}

	public void setRect_moeda(Rectangle rect_moeda) {
		this.rect_moeda = rect_moeda;
	}
		
	public JLabel getMoeda_ouro() {
		return moeda_ouro;
	}
	
}


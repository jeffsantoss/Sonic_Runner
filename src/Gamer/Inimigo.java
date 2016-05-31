package Gamer;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Inimigo extends DesenhoMovel{
	

	private JLabel inimigo_esquerda,inimigo_direita;
	private Rectangle rect_inimigo,rect_inimigo2;
	private ImageIcon inimigo;
	
	public Inimigo(int x, int y, int vel, int height, int width)
	{	
		super(x,y,height,width,vel);
		
		rect_inimigo = new Rectangle(x,y,height,width);
		rect_inimigo2 = new Rectangle(x,y,height,width);
		
		this.setImg(new ImageIcon(getClass().getResource("/images/inimigo.gif")));	
		this.inimigo = new ImageIcon(getClass().getResource("/images/inimigo2.gif"));
		
		this.inimigo_esquerda = new JLabel(this.getImg());
		this.inimigo_direita = new JLabel(inimigo);
		
		this.inimigo_esquerda.setBounds(rect_inimigo);
		this.inimigo_direita.setBounds(rect_inimigo2);
		
	}
	

	public Rectangle getRect_inimigo() {
		return rect_inimigo;
	}


	public void setRect_inimigo(Rectangle rect_inimigo) {
		this.rect_inimigo = rect_inimigo;
	}


	public Rectangle getRect_inimigo2() {
		return rect_inimigo2;
	}


	public void setRect_inimigo2(Rectangle rect_inimigo2) {
		this.rect_inimigo2 = rect_inimigo2;
	}


	public Inimigo()
	{
			super();
	}
	

	public void Executar_Inimigos()
	{
		
		rect_inimigo.x += this.getVelocidade();
		inimigo_esquerda.setBounds(rect_inimigo);
		rect_inimigo2.x -= this.getVelocidade();
		inimigo_direita.setBounds(rect_inimigo2);
		
	if (rect_inimigo2.x < 0 && rect_inimigo.x > 1100) 
	{ 	
		rect_inimigo.x = 0;
		this.inimigo_esquerda.setBounds(rect_inimigo);
		rect_inimigo2.x = 1100;
		this.inimigo_direita.setBounds(rect_inimigo2);
	}
	
	if(rect_inimigo2.intersects(rect_inimigo))
	{
		rect_inimigo.y += this.getVelocidade();
	}
	
	}
	
	
	public JLabel getInimigo_direita() {
		return inimigo_direita;
	}

	public JLabel getInimigo_esquerda() {
		return inimigo_esquerda;
	}

}

package Gamer;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sonic extends DesenhoMovel{
	
	private JLabel lblsonic;
	private Rectangle rect_sonic;
	private ImageIcon sonicDireita, sonicEsquerda, sonicCima;
	
	public Sonic(int x, int y, int velocidade,int heigth, int width) 
	{
		super(x,y,heigth,width,velocidade);	
		rect_sonic = new Rectangle(x, y, heigth, width);	
		this.setImg(new ImageIcon(getClass().getResource("/images/sonic_correr_baixo.gif")));	
		this.sonicCima = new ImageIcon(getClass().getResource("/images/sonic_correr_cima.gif"));
		this.sonicEsquerda = new ImageIcon(getClass().getResource("/images/sonic_correr_esquerda.gif"));
		this.sonicDireita = new ImageIcon(getClass().getResource("/images/sonic_correr_direita.gif"));
		this.lblsonic = new JLabel(this.getImg());
		this.lblsonic.setBounds(rect_sonic);
	
	}
	
	public synchronized boolean Colisao(Inimigo a) throws ColisaoException
	{
		if (rect_sonic.intersects(a.getRect_inimigo()) || rect_sonic.intersects(a.getRect_inimigo2()))
			throw new ColisaoException();
		else
			return false;
	}
	
	public synchronized boolean Colisao(Moeda a)
	{
		if (rect_sonic.intersects(a.getRect_moeda()))
			return true;
		else
			return false;	
	}


	public void moverCima()
	{
		if(this.getY() > 0)  
		{
			super.moverCima();
			rect_sonic.y -= this.getVelocidade();
			this.lblsonic.setIcon(sonicCima);
			this.lblsonic.setBounds(rect_sonic);
		}
	}
	 
	public void moverBaixo()
	{
		if(this.getY() < 590)  
		{
			super.moverBaixo();
			rect_sonic.y += this.getVelocidade();
			this.lblsonic.setIcon(getImg());
			this.lblsonic.setBounds(rect_sonic);
		}

	}
	
	public void moverDireita()
	{		
		if(this.getX() < 1080) 
		{
			super.moverDireita();
			this.lblsonic.setIcon(sonicDireita);
			rect_sonic.x += this.getVelocidade();
			this.lblsonic.setBounds(rect_sonic);
		}
	}
	
	public void moverEsquerda()
	{

		if(this.getX() > 0) 
		{
			super.moverEsquerda();
			rect_sonic.x -= this.getVelocidade();
			this.lblsonic.setIcon(sonicEsquerda);
			this.lblsonic.setBounds(rect_sonic);
		}
	}
	
	
	// setters / getters

	public JLabel getLblsonic() {
		return lblsonic;
	}

	public Rectangle getRect_sonic() {
		return rect_sonic;
	}

}
	


package Gamer;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class Cenario extends Desenho implements Runnable {

	private JLabel cenario_jlabel, lbltexto;	
	private ArrayList <Inimigo> lista_inimigo = new ArrayList <Inimigo>();
	private ArrayList <Moeda> lista_moeda = new ArrayList <Moeda>();
	private Sonic sonic;
	private int Points;
	
	private Thread SecondTasksd = new Thread(this);
	
	public Cenario() 
	{
		CriarCenario();
		Points();
		sonic = new Sonic(0,0,20,100,100);
		CriarInimigos();
		CriarMoedas();
	}
	
	public void Points()
	{
		this.lbltexto = new JLabel("Ponto(s): 0");
		this.lbltexto.setBounds(500,0,500,50);
	}
	
	public void CriarCenario()
	{
		this.setImg(new ImageIcon(getClass().getResource("/images/cenario_jogo.png")));	
		this.cenario_jlabel = new JLabel(this.getImg());
		this.cenario_jlabel.setBounds(0, 0, 1920, 1080);
	}

	public JLabel getLbltexto() {
		return lbltexto;
	}

	public Sonic getSonic() {
		return sonic;
	}

	public void setSonic(Sonic sonic) {
		this.sonic = sonic;
	}

	public JLabel getCenario_jlabel() 
	{
		return cenario_jlabel;
	}
	
	public void CriarInimigos()
	{
		int i, w;
		for ( i = 0, w = 0 ; i < 5 ; i++, w+= 200)
		{
			lista_inimigo.add(new Inimigo(0,w,50,65,65));
		}
		
		for ( i = 0, w = 0 ; i < 5 ; i++ , w+= 200)
		{	
			lista_inimigo.add(new Inimigo(1100,w,50,65,65));
			
		}
	}
	
	public void CriarMoedas()
	{
		int i, w;
		for ( i = 0, w = 0 ; i < 4 ; i++, w+= 300)
		{
			lista_moeda.add(new Moeda(500,w,32,32));
		}
	
	}
		
	
	public Inimigo getInimigo(int i)
	{
		return lista_inimigo.get(i);
	}
	
	public Moeda getMoeda(int i)
	{
		return lista_moeda.get(i);
	}

	public void run() {
		
		int i;
		
		while (true) {

		try {Thread.sleep(1000);} 
		catch (Exception erro)  {}
		
		for (i = 0; i<4; i++){
		lista_moeda.get(i).LocarlizarMoedas();
		if(sonic.Colisao(lista_moeda.get(i))) {
		this.lbltexto.setText("Ponto(s): " +this.Points++);
		this.lbltexto.setBounds(500,0,500,50);
		}
		}
		for(i=0; i < 10 ; i++) {			
			lista_inimigo.get(i).Executar_Inimigos();	
			try {
				if(sonic.Colisao(lista_inimigo.get(i)));
			} catch (ColisaoException e) {
				System.out.println("Bateu no inimigo........");
			}	
		}
		}
		
	}
	
	public Thread getSecondTasksd() {
		return SecondTasksd;
	}

	public void setSecondTasksd(Thread secondTasksd) {
		SecondTasksd = secondTasksd;
	}
	

	
}

package Gamer;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Janela extends JFrame  {

	Cenario cenario;
	
	public void editarJanela()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
	}
	
	public Janela()
	{
		super("Sonic Runner");
		cenario = new Cenario();
		
		editarJanela();
		add(cenario.getSonic().getLblsonic());
		add(cenario.getInimigo(0).getInimigo_esquerda());
		add(cenario.getInimigo(1).getInimigo_esquerda());
		add(cenario.getInimigo(2).getInimigo_esquerda());
		//add(cenario.getInimigo(3).getInimigo_esquerda());
		add(cenario.getInimigo(4).getInimigo_direita());
		add(cenario.getInimigo(5).getInimigo_direita());
		add(cenario.getInimigo(6).getInimigo_direita());
		add(cenario.getInimigo(7).getInimigo_direita());
		add(cenario.getInimigo(8).getInimigo_direita());
		add(cenario.getInimigo(9).getInimigo_direita());
		
		add(cenario.getMoeda(0).getMoeda_ouro());
		add(cenario.getMoeda(1).getMoeda_ouro());
		add(cenario.getMoeda(2).getMoeda_ouro());
		add(cenario.getMoeda(3).getMoeda_ouro());
	
		//add(cenario.getCenario_jlabel());
		add(cenario.getLbltexto());
		
		cenario.getSecondTasksd().start();
		
		Movimentar();
		
		
		
	}


	public void Movimentar()
	{		
		  addKeyListener(new KeyListener() {
			 
		      public void keyPressed(KeyEvent e) {
		    	  
		    	  if(e.getKeyCode() == 38) // Down
		    	  {
		    		  cenario.getSonic().moverCima();
		    	  }
		    	  
		    	  if(e.getKeyCode() == 40) // down
		    		  cenario.getSonic().moverBaixo(); 
		    	  
		    	  if(e.getKeyCode() == 37) // Left
		    		  cenario.getSonic().moverEsquerda();
		    	  
		    	  if(e.getKeyCode() == 39) // Right
		    		  cenario.getSonic().moverDireita();
		         	
		      }
		      public void keyReleased(KeyEvent e){
		    	 // System.out.println("" + e.getKeyCode());
		      }
		      
		      public void keyTyped(KeyEvent e) {

		      }
		      });
	}

	
	public static void main(String[] args)
	{
		new Janela();
		
	}
	
	
}

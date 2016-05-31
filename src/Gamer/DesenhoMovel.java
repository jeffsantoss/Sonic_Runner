package Gamer;

public class DesenhoMovel extends Desenho {
	
	private int velocidade;
	

	public DesenhoMovel(){}

	public DesenhoMovel(int x, int y, int height, int width, int vel)
	{
		super(x, y, height, width);
		this.setVelocidade(vel);
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public void moverDireita()
	{
		this.setX(this.getX() + velocidade);
	}
	
	public void moverEsquerda()
	{
		this.setX(this.getX() - velocidade);
	}
	
	public void moverCima()
	{
		this.setY(this.getY() - velocidade);
	}
	
	public void moverBaixo()
	{
		this.setY(this.getY() + velocidade);
	}
	
}
package arvoreAVL;

public class Nodo {
	
	private int valor, balanceamento, altura;
	private Nodo esquerda, direita, pai;
	
	
	public Nodo () {
		setValor(0);
		setAltura(0);
		setBalanceamento(0);
		
		setDireita(null);
		setEsquerda(null);
		setPai(null);
	}
	
	public Nodo (int valor) {
		setValor(valor);
		setAltura(0);
		setBalanceamento(0);
		
		setDireita(null);
		setEsquerda(null);
		setPai(null);
	}
	
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getBalanceamento() {
		return balanceamento;
	}
	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Nodo getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(Nodo esquerda) {
		this.esquerda = esquerda;
	}
	public Nodo getDireita() {
		return direita;
	}
	public void setDireita(Nodo direita) {
		this.direita = direita;
	}
	public Nodo getPai() {
		return pai;
	}
	public void setPai(Nodo pai) {
		this.pai = pai;
	}
	
}

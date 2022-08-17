package arvoreBinaria;

public class Nodo {
	
	private int valor;
	private Nodo esquerda, direita;

	public Nodo() {
		setValor(0);
		setEsquerda(setDireita(null));
	}
	public Nodo(int valor) {
		this.setValor(valor);
		setEsquerda(setDireita(null));
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
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
	public Nodo setDireita(Nodo direita) {
		this.direita = direita;
		return direita;
	}
	
}

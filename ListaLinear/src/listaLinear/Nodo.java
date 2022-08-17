package listaLinear;

public class Nodo {
	private int valor;
	private Nodo prox;

	public Nodo() {
		this.valor = 0;
		this.prox = null;
	}
	
	public Nodo(int val, Nodo p) {
		this.valor = val;
		this.prox = p;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int val) {
		this.valor = val;
	}

	public Nodo getProximo() {
		return prox;
	}

	public void setProximo(Nodo p) {
		this.prox = p;
	}	
}



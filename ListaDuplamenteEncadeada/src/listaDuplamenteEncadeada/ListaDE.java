package listaDuplamenteEncadeada;

public class ListaDE {
	
	private Nodo inicio;
	
	public ListaDE() {
		this.inicio = null;
	}
	
	// INSERE NO FINAL
	public void insereFinal(int valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProx(null);
		novo.setAnt(null);
		
		if(this.inicio == null)
			this.inicio = novo;
		else {
			Nodo aux = this.inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			aux.setProx(novo);
			novo.setAnt(aux);
			
		}
	}
	
	// INSERE NO INICIO
	public void insereInicio(int valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProx(null);
		novo.setAnt(null);
		
		if(this.inicio == null)
			this.inicio = novo;
		else {
			novo.setProx(this.inicio);
			this.inicio.setAnt(novo);
			this.inicio = novo;
		}
	}
	
	// REMOVER NO FINAL
	public void removeFinal() {
		Nodo aux;
		if (this.inicio != null) // se o inicio for diferente de nulo

			if (this.inicio.getProx() == null) // se o próximo do inicio for igual a nulo
				this.inicio = null; // o inicio será nulo, nao aparece
			else {
				aux = inicio; // o aux está no inicio
				// Percorre a lista, até o fim, a partir do primeiro nodo
				while (aux.getProx().getProx() != null) // o próximo do próximo do aux for diferente de nulo(pq
																// próximo do próximo? pq ele andou)
					aux = aux.getProx(); // aux passa a ser o próximo do aux
				aux.setProx(null); // tira o último que é nulo e o setProx do aux passa ser nulo
			}
	}
	
	// REMOVER NO INICIO
	public void removeInicio() {
		Nodo aux = this.inicio; // aux está no inicio
		if (aux == null) // se o aux for nulo é pq não tem valor
			System.out.println("");
		else {
			this.inicio = aux.getProx(); // o inicio é o próximo do aux
			aux.setAnt(null);
			// aux = null; // e o aux será nulo, ou seja, nao existe
		}

	}
	
	// PESQUISAR ANTES DE REMOVER
	public Nodo Pesquisa(int valor) {
		Nodo aux = this.inicio;
		if(aux != null) {
			while(aux != null && aux.getValor()!= valor )
				aux = aux.getProx();
		}
		return aux;
	}
	
	// REMOVER POR VALOR
	public void removePorValor(int valor) {
		Nodo aux = Pesquisa(valor);
		if(aux == null)
			System.out.println("Valor nao encontrado!");
		else {
			if(aux.getAnt() != null)
				aux.getAnt().setProx(aux.getProx());
			else
				this.inicio = aux.getProx();
			if(aux.getProx() != null)
				aux.getProx().setAnt(aux.getAnt());
			
			aux = null;
		}
	}
	
	// IMPRIME
	public void Imprime() {
		Nodo aux = this.inicio;
		if(aux == null)
			System.out.println("Lista vazia!");
		else {
			while(aux != null) {
				System.out.println("Valor: "+aux.getValor());
				aux = aux.getProx();
			}
		}
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

}

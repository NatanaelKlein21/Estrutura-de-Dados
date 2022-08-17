package arvoreBinaria;

public class ArvoreBinaria {
	
	private Nodo raiz;
	
	public Nodo getRaiz() {
		return raiz;
	}
	
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	// INSERE NAO RECURSIVA
	public void insereNaoRecursiva(int valor) {
		Nodo novo = new Nodo(valor);
		
		if(raiz == null)
			raiz = novo;
		else {
			Nodo aux = this.raiz;
			boolean inseriu = false;
			while(!inseriu) {
				if(novo.getValor() < aux.getValor()) {
					if(aux.getEsquerda() != null)
						aux = aux.getEsquerda();
					else {
						aux.setEsquerda(novo);
						inseriu = true;
					}
				}
				else {
					if(aux.getDireita() != null)
						aux =aux.getDireita();
					else {
						aux.setDireita(novo);
						inseriu = true;
					}
				}
			}
		}
	}
	
	// INSERE RECURSIVA <-
	public void insereRecursiva(Nodo aux, int valor) {
		if(aux != null) {
			if(valor < aux.getValor()) {
				if(aux.getEsquerda() != null)
					insereRecursiva(aux.getEsquerda(), valor);
				else
					aux.setEsquerda(new Nodo(valor));
					System.out.println("Inseriu"+valor+ " a esquerda de "+aux.getValor());
			}
			else 
				if(valor > aux.getValor()) {
					if(aux.getDireita() != null)
						insereRecursiva(aux.getDireita(), valor);
					else
						aux.setDireita(new Nodo(valor));
					System.out.println("Inseriu"+valor+ " a direita de "+aux.getValor());
				}
		}
		else {
			setRaiz(new Nodo(valor));
			System.out.println("Inseriu "+valor+" na raiz");
		}
		}
	
	// IMPRIME
	public void imprime(Nodo aux) {
		if(aux != null) {
			System.out.println(aux.getValor());
			imprime(aux.getEsquerda());
			imprime(aux.getDireita());
		}
	}

	// PESQUISA
	public void pesquisa(Nodo aux, int valor) {
		while(aux != null && aux.getValor() != valor) {
			if(valor < aux.getValor())
		        aux = aux.getEsquerda();
		    else 
		        aux = aux.getDireita();
		}
		if(aux == null) 
		   System.out.println("Valor "+valor+" não encontrado!");
		else 
		    System.out.println("Valor "+aux.getValor()+" encontrado!");
	}
	
	// REMOVE
	public void remove(Nodo aux, Nodo pai, int Valor) {
		
		if (aux!=null) {
			//se encontrou, testa qual tipo de remoção
			if(aux.getValor() == Valor) {
				//testa se o aux e folha
				if(aux.getEsquerda()==null && aux.getDireita() == null) {
					removeFolha(aux,pai,Valor);
				}
				//se aux tiver apenas uma subárvore à esquerda
				else if(aux.getEsquerda()!= null && aux.getDireita()== null) {
					removeNodoSubArvoreEsquerda(aux,pai,Valor);	
				}
				//se aux tiver apenas uma subárvore à direita
				else if(aux.getEsquerda()==null && aux.getDireita()!=null) {
					removeNodoSubArvoreDireita(aux,pai,Valor);	
				}
				//se o aux tiver duas subarvores
				else {
					removeNodosDuasSubArvores(aux,pai,Valor);	
				}
			}
			//se nao encontrou,procura à esquerda
			else if(aux.getValor()> Valor)
				remove(aux.getEsquerda(), aux,Valor);
			//se não enconrou à esqueda, procura à direita
			else if(aux.getValor()< Valor)
				remove(aux.getDireita(), aux, Valor);
		}
		else
			System.out.println("Valor não encontrado!");
	}
	
	private void removeNodosDuasSubArvores(Nodo aux, Nodo pai, int valor) {
		Nodo aux2= aux.getEsquerda();
		Nodo paiaux2= aux.getEsquerda();
	
		//procura o nodo mais a direita(aux2) e seu pai
		while(aux2.getDireita()!=null) {
		paiaux2= aux2;
		aux2= aux2.getDireita();
		}
	
		paiaux2.setDireita(aux2.getEsquerda());
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) 
				pai.setEsquerda(aux2);
			else 
				pai.setDireita(aux2);
		
	}
		else
			setRaiz(aux2); //se nao ele vai ser a raiz
		aux2.setDireita(aux.getDireita());
		if(aux2!= aux.getEsquerda())
			aux2.setEsquerda(aux.getEsquerda());
		aux=null;
		System.out.println("Nodo "+ valor + " removido!");
	}

	private void removeNodoSubArvoreDireita(Nodo aux, Nodo pai, int valor) {
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) {
				pai.setEsquerda(aux.getDireita());
			}
			else {
				pai.setDireita(aux.getDireita());
			}
		}
		else {
			setRaiz(aux.getDireita());
			aux = null;
					System.out.println("Valor " + valor + " removido" );
		}
		
	}

	private void removeNodoSubArvoreEsquerda(Nodo aux, Nodo pai, int valor) {
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) {
				pai.setEsquerda(aux.getEsquerda());
			}
			else {
				pai.setDireita(aux.getEsquerda());
			}
		}
		else {
			setRaiz(aux.getEsquerda());
			aux = null;
					System.out.println("Valor " + valor + " removido" );
		}
		
	}

	private void removeFolha(Nodo aux, Nodo pai, int valor) {
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) {//se o valor do aux for menor uqe o valor do pai
				pai.setEsquerda(null);
			}
			else {
				pai.setDireita(null);
			}
		}
		else {
			setRaiz(null);
			aux= null;
			System.out.println("Valor: " + valor +" removido!");
		}
		
	}
}

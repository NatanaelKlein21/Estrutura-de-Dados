package listaLinear;

public class Lista {
	
	private Nodo inicio;
	
	///////// CRIA A LISTA
	public Lista() {
		this.inicio = null;
	}
	
	//Devolve o ponteiro para o inicio da lista (ponteiro para o nodo inicial)
	public Nodo getInicio() {
		return inicio;
	}
	
	///////// INSERE NODO NA LISTA VAZIA
	public void insereListaVazia(int valor){
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProximo(null);
		
		this.inicio = novo;
	}
	

	///////// INSERIR NO INICIO DA LISTA
	public void insereInicio(int valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProximo(this.inicio);
		
		this.inicio = novo;
	}
	
	///////// INSERE NO MEIO LISTA
	public void insereMeio(int valor) {
		Nodo novo = new Nodo(valor, null);
		
		//Primeira parte: s� contar
		if(inicio== null) {
			this.inicio=novo;
		}else {
			Nodo contador = inicio;
			int iterador =0;
			
			while(contador != null) {
				iterador++;
				contador = contador.getProximo();
			}
			//System.out.println("O tamanho da lista �: "+iterador);
			
			//Segunda parte: inserir nodo no meio
			Nodo aux=inicio;
			double meio=iterador/2; //tudo o que meu iterador contou, para saber o meio divido por 2 o iterador, q 'guarda' o q contei
			for(int contadorFor=1; contadorFor < meio; contadorFor++) { //contador++ aumenta ex: 1 vai p 2, e aux pula p proximo, ver exemplo da folha 30.07
					aux = aux.getProximo();
					
			}
			
			novo.setProximo(aux.getProximo()); //proximo dele, � o proximo do aux, pois estamos inserindo no meio
			aux.setProximo(novo);
		}
	}
	
	///////// INSERE NO FINAL DA LISTA 
	public void insereFinal(int valor){
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProximo(null);
		
		if(this.inicio == null)
			this.inicio = novo;
		else {
			Nodo aux = inicio;
			//Percorre a lista, at� o fim, a partir do primeiro nodo
			while(aux.getProximo() != null) 
				aux = aux.getProximo();
			aux.setProximo(novo);
		}
	}
	

	///////// REMOVER NO INICIO DA LISTA
	public void RemoveInicio() {
		this.inicio = this.inicio.getProximo();
	}
	
	///////// REMOVER NO MEIO DA LISTA
	public void removeMeio() {
		if(inicio == null) {
			System.out.println("Lista vazia!");
		}else {
			Nodo contador = inicio;
			int iterador=0;
			
			while(contador != null) {
				iterador++;
				contador = contador.getProximo();
			}
			
			
			//segnda parte remover do meio
			Nodo aux=inicio;
			double meio=iterador/2; //tudo o que meu iterador contou, para saber o meio divido por 2 o iterador, q 'guarda' o q contei
			for(int contadorFor=1; contadorFor < meio; contadorFor++) { //contador++ aumenta ex: 1 vai p 2, e aux pula p proximo, ver exemplo da folha 30.07
					aux = aux.getProximo();
					
			}
			
			aux.setProximo(aux.getProximo().getProximo());
			
			//System.out.println("O tamanho da lista �: "+ (iterador-1));
		}
		
		
	}
	
	///////// REMOVE NO FINAL DA LISTA	
	public void RemoveFinal() {
		Nodo aux;
		if(this.inicio != null)
			//Se s� tem um nodo na lista, remove este
			if(this.inicio.getProximo()==null)
				this.inicio = null;
			else {
				aux = inicio;
				//Percorre a lista, ate o fim, a partir do primeiro nodo
				while(aux.getProximo().getProximo() != null) 
					aux = aux.getProximo();
				aux.setProximo(null);	
			}
	}
	
	
	///////// IMPRIMIR A LISTA
	public void Imprimir(){
		if(this.inicio == null)
			System.out.println("Lista vazia!");
		else
			for(Nodo aux = this.inicio; aux != null; aux = aux.getProximo())
				System.out.println(aux.getValor());
	}
	
	///////// PESQUISAR POR VALOR
	public void PesquisaPorValor(int valor) {
		Nodo aux = this.inicio;
		int cont = 1;
		if(this.inicio == null)
			System.out.println("Lista vazia!");
		else
			while(aux != null && aux.getValor() != valor) {
				aux = aux.getProximo();
				cont++;
			}
			if(aux != null)
				System.out.println("Valor encontrado na posicao: "+cont);
			else
				System.out.println("Valor nao encontrado!");
	}
	

}

package listaDuplamenteEncadeada;

public class mainListaDE {

	public static void main(String[] args) {
		ListaDE lista = new ListaDE();
		
		lista.insereInicio(50);
		lista.insereInicio(45);
		lista.insereInicio(33);
		lista.insereFinal(23);
		
		lista.removePorValor(33);
		
		lista.Imprime();
	
	}

}

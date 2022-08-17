package listaLinear;

public class mainLista {

	public static void main(String[] args) {
		
		//CRIA A LISTA
		Lista lista = new Lista();
		
		lista.insereListaVazia(34);
		
		// INSERIR
		lista.insereInicio(89);
		lista.insereFinal(56);
		lista.insereMeio(22);
		
		
		lista.insereFinal(78);

		// REMOVER
		lista.RemoveInicio();
		lista.RemoveFinal();
		lista.removeMeio();

		//IMPRIME
		lista.Imprimir();
		System.out.println("--------");
		
		// PESQUISA POR VALOR
		lista.PesquisaPorValor(22);
		
		
		
	}
}

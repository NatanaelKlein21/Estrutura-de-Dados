package arvoreBinaria;

public class ABmain {

	public static void main(String[] args) {
		
		ArvoreBinaria ab = new ArvoreBinaria();
		
		/*
		ab.insereNaoRecursiva(5);
		ab.insereNaoRecursiva(10);
		ab.insereNaoRecursiva(2);
		ab.insereNaoRecursiva(8);
		*/
		
		///*
		ab.insereRecursiva(ab.getRaiz(), 5);
		ab.insereRecursiva(ab.getRaiz(), 10);
		ab.insereRecursiva(ab.getRaiz(), 2);
		ab.insereRecursiva(ab.getRaiz(), 8);
		//*/
		
		//ab.imprime(ab.getRaiz());
	}

}

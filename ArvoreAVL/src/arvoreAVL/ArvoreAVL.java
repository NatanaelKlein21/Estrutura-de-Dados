package arvoreAVL;

public class ArvoreAVL {
	
	private Nodo raiz;
	
	public ArvoreAVL() {
		
	}	
	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	public ArvoreAVL(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	///////// INSERE /////////////	
	public void insere(Nodo aux, int valor) {
		
		// verifica se a raiz da √°rvore nao e nula
		if(aux != null) {
			Nodo novo = new Nodo(valor);
			// verifica se o valor se o valor a ser inserido √© menor que o nodo corrente da √°rvore, se sim, vai para sub√°rvore esquerda
			if(valor < aux.getValor()) {
				//Se tiver elementos no nodo esquerdo, continua a busca
				if(aux.getEsquerda() != null)
					insere(aux.getEsquerda(),valor);
				else {
					// Se nodo esquerdo vazio, insere o novo nodo aqui
					System.out.println("Inserindo "+valor+" a esquerda de "+aux.getValor());
					aux.setEsquerda(novo);
				}
			// Verifica se o valor a ser inserido √© maior que o nodo corrente da √°rvore, se sim, vai para sub√°rvore direita
			} else if (valor > aux.getValor()) {
				// se tiver elementos no nodo direito, continua a busca
				if(aux.getDireita() != null) {
					insere(aux.getDireita(),valor);
				} else {
					// se nodo direito vazio, insere o nodo aqui
					System.out.println("Inserindo "+valor+" a direita de "+aux.getValor());
					aux.setDireita(novo);
				}
			}
			novo.setPai(aux);
			//aux.setAltura(calculaAltura(aux));
			calculaAltura(aux);
			verificarBalanceamento(aux);
		}
		else {
			System.out.println("Inserindo "+valor+" na raiz");
			setRaiz(new Nodo(valor));
		}	
	} 
	
	/////// BALANCEAMENTO /////////////	
	private void verificarBalanceamento(Nodo aux) {
		if(aux.getBalanceamento() == -2) {
			
			if(aux.getEsquerda().getBalanceamento() < 0)
				rotacaoDireita(aux);
			else
				DuplaRotacaoEsquerdaDireita(aux);
		}
		else {
			if(aux.getBalanceamento() == 2) {
				
				if(aux.getDireita().getBalanceamento() > 0)
					rotacaoEsquerda(aux);
				else
					duplaRotacaoDireitaEsquerda(aux);
			}
		}
		
	}
	
	/////// CALCULAR ALTURA ///////////
	private int calculaAltura(Nodo aux) {
		if (aux == null) 
			return 0;
		else {
			int esq = calculaAltura(aux.getEsquerda());
			int dir = calculaAltura(aux.getDireita());
			aux.setBalanceamento(dir-esq);
			if(esq > dir) {
				aux.setAltura(esq);
				return esq+1;
			}
			else {
				aux.setAltura(dir);
				return dir+1;
			}
		}
	}
	
	////// TENTATIVA
	
	/*
	/////////// ROTACAO ESQUERDA //////////////
	public Nodo rotacaoEsquerda2(Nodo aux) {
		
		Nodo direita = aux.getDireita();
		direita.setPai(aux.getPai());
		
		aux.setDireita(direita.getEsquerda());
		
		if (aux.getDireita() != null) {
			aux.getDireita().setPai(aux);
				}
		direita.setEsquerda(aux);
		aux.setPai(direita);
		if (direita.getPai() != null) {
		if (direita.getPai().getDireita() == aux) {
		direita.getPai().setDireita(direita);
					} else if (direita.getPai().getEsquerda() == aux) {
		direita.getPai().setEsquerda(direita);
					}
				}
		setBalanceamento(aux);
		setBalanceamento(direita);
		return direita;
		}
	
	///////// ROTACAO DIREITA ///////////
	public Nodo rotacaoDireita2(Nodo aux) {
		Nodo esquerda = aux.getEsquerda();
		esquerda.setPai(aux.getPai());
		aux.setEsquerda(esquerda.getDireita());
		if (aux.getEsquerda() != null) {
			aux.getEsquerda().setPai(aux);
				}
		esquerda.setDireita(aux);
		aux.setPai(esquerda);
		if (esquerda.getPai() != null) {
		if (esquerda.getPai().getDireita() == aux) {
		esquerda.getPai().setDireita(esquerda);
					} else if (esquerda.getPai().getEsquerda() == aux) {
		esquerda.getPai().setEsquerda(esquerda);
					}
				}
		setBalanceamento(aux);
		setBalanceamento(esquerda);
		return esquerda;
			}
	
	/////////// DUPLA ROTACAO /////////////////
	public Nodo duplaRotacaoEsquerdaDireita2(Nodo aux) {
		aux.setEsquerda(rotacaoEsquerda(aux.getEsquerda()));
		return rotacaoDireita(aux);
	}
	
	public Nodo duplaRotacaoDireitaEsquerda2(Nodo aux) {
		aux.setDireita(rotacaoDireita(aux.getDireita()));
		return rotacaoEsquerda(aux);
	}
	*/
	///////////// -----------------------
	
	//CALCULOS DE ROTACOES
	private void rotacaoDireita(Nodo aux) {
		Nodo pai = aux.getPai();
		Nodo filho = aux.getEsquerda();
			
		System.out.println("Rotacao direita!");

		aux.setEsquerda(filho.getDireita());
		if(filho.getDireita() != null)
			filho.getDireita().setPai(aux);
		
		filho.setDireita(aux);
		aux.setPai(filho);
			
		if(aux.getValor() < pai.getValor())
			pai.setEsquerda(filho);
		else
			pai.setDireita(filho);
		filho.setPai(pai);
	}

	private void rotacaoEsquerda(Nodo aux) {
		Nodo pai = aux.getPai();
		Nodo filho = aux.getDireita();
		
		System.out.println("Rotacao esquerda!");
		
		aux.setDireita(filho.getEsquerda());
		if(filho.getEsquerda() != null)
			filho.getEsquerda().setPai(aux);
		
		filho.setEsquerda(aux);
		aux.setPai(filho);
		
		if(aux.getValor() < pai.getValor())
			pai.setEsquerda(filho);
		else
			pai.setDireita(filho);
		filho.setPai(pai);
	}
			
	private void duplaRotacaoDireitaEsquerda(Nodo aux) {
		System.out.println("Rotacao direita-esquerda!");
		rotacaoDireita(aux.getDireita());
		rotacaoEsquerda(aux);
	}

	private Nodo DuplaRotacaoEsquerdaDireita(Nodo aux) {
		System.out.println("Rotacao esquerda-direita!");
		rotacaoEsquerda(aux.getEsquerda());
		rotacaoDireita(aux);
		return null;
	}
	
	/////////////////////////
	private void setBalanceamento(Nodo no) {
		no.setBalanceamento(calculaAltura(no.getDireita()) - calculaAltura(no.getEsquerda()));
			}
	
	/////// REMOCAO
	public void remove(Nodo atual, Nodo pai, int Valor) {

		if (atual != null) {
			// se encontrou, testa qual tipo de remoÁ„o
			if (atual.getValor() == Valor) {
				// testa se o atual e folha
				if (atual.getEsquerda() == null && atual.getDireita() == null) {
					removeFolha(atual, pai, Valor);
				}
				// se atual tiver apenas uma sub·rvore ‡ esquerda
				else if (atual.getEsquerda() != null && atual.getDireita() == null) {
					removeNodoSubArvoreEsquerda(atual, pai, Valor);
				}
				// se atual tiver apenas uma sub·rvore ‡ direita
				else if (atual.getEsquerda() == null && atual.getDireita() != null) {
					removeNooSubArvoreDireita(atual, pai, Valor);
				}
				// se o atual tiver duas subarvores
				else {
					removeNodosDuasSubArvores(atual, pai, Valor);
				}
			}
			// se nao encontrou,procura ‡ esquerda
			else if (atual.getValor() > Valor)
				remove(atual.getEsquerda(), atual, Valor);
			// se n„o enconrou ‡ esqueda, procura ‡ direita
			else if (atual.getValor() < Valor)
				remove(atual.getDireita(), atual, Valor);
		} else
			System.out.println("Valor n„o encontrado!");
	}

	private void removeNodosDuasSubArvores(Nodo atual, Nodo pai, int valor) {
		Nodo atual2 = atual.getEsquerda();
		Nodo paiatual2 = atual.getEsquerda();

		// procura o nodo mais a direita(atual2) e seu pai
		while (atual2.getDireita() != null) {
			paiatual2 = atual2;
			atual2 = atual2.getDireita();
		}

		paiatual2.setDireita(atual2.getEsquerda());
		if (pai != null) {
			if (atual.getValor() < pai.getValor())
				pai.setEsquerda(atual2);
			else
				pai.setDireita(atual2);

		} else
			setRaiz(atual2); // se nao ele vai ser a raiz
		atual2.setDireita(atual.getDireita());
		if (atual2 != atual.getEsquerda())
			atual2.setEsquerda(atual.getEsquerda());
		atual = null;
		System.out.println("Nodo " + valor + " removido!");
	}

	private void removeNooSubArvoreDireita(Nodo atual, Nodo pai, int valor) {
		if (pai != null) {
			if (atual.getValor() < pai.getValor()) {
				pai.setEsquerda(atual.getDireita());
			} else {
				pai.setDireita(atual.getDireita());
			}
		} else {
			setRaiz(atual.getDireita());
			atual = null;
			System.out.println("Valor " + valor + " removido");
		}

	}

	private void removeNodoSubArvoreEsquerda(Nodo atual, Nodo pai, int valor) {
		if (pai != null) {
			if (atual.getValor() < pai.getValor()) {
				pai.setEsquerda(atual.getEsquerda());
			} else {
				pai.setDireita(atual.getEsquerda());
			}
		} else {
			setRaiz(atual.getEsquerda());
			atual = null;
			System.out.println("Valor " + valor + " removido");
		}

	}

	private void removeFolha(Nodo atual, Nodo pai, int valor) {
		if (pai != null) {
			if (atual.getValor() < pai.getValor()) {// se o valor do atual for menor uqe o valor do pai
				pai.setEsquerda(null);
			} else {
				pai.setDireita(null);
			}
		} else {
			setRaiz(null);
			atual = null;
			System.out.println("Valor: " + valor + " removido!");
		}

	}
	
}

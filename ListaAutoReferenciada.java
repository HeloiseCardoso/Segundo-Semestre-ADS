package trabalhoListaAutoreferenciada;

import trabalhoListaAutoreferenciada.ItemCompra;

public class ListaAutoReferenciada {
	private class No {
		private ItemCompra dados;
		private No proximo;
		
		public No(ItemCompra aux) {
			dados = aux;
			proximo = null;
		}
	}

	private No primeiro;
	private int qde;

	public ListaAutoReferenciada() {
		primeiro = null;
	}

	public boolean vazia() {
		return primeiro == null;
	}

	public int getQde() {
		return qde;
	}

	public void inserirInicio(ItemCompra objItem) {
		// despensar os testes de vazio com uma atribuição boba
		No aux = new No(objItem);
		// lista vazia troca null por null
		aux.proximo = primeiro;
		primeiro = aux;
	}

	public ItemCompra buscar(ItemCompra objItem) {
		if (vazia()) { // tem que verificar se está vazia diferente de quando é vetor porque não tem
						// tamanho definido
			return null;
		}
		ItemCompra copia = null;
		No noAtual = primeiro; // pq se ela não está vazia automaticamente tem que existir o primeiro
		ItemCompra atual = null;
		
		do {
			atual = noAtual.dados; // a primeira vez que entra está com o primeiro, no resto muda as posições
			if (objItem.getDescricao().equals(atual.getDescricao())) {
				String d = noAtual.dados.getDescricao();
				int qtd = noAtual.dados.getQde();
				double p = noAtual.dados.getPreco();
				copia = new ItemCompra(d, qtd, p);
				break;
			}
			noAtual = noAtual.proximo; // porque a lista é constituída de nós que apontam para outros nós, faz isso pra andar na lista
		} while (noAtual != null);
		return copia;
	}
	
	public ItemCompra retira(ItemCompra objItem) {
		if (vazia()) {
			return null;
		}
		No noAtual = primeiro;
		No posAnt = primeiro;
		ItemCompra atual = null;
		do {
			atual = noAtual.dados;
			if (objItem.getDescricao().equals(atual.getDescricao())) {
				
				break;
			}
			noAtual = noAtual.proximo;
		} while(noAtual != null);
		if (noAtual == null) {
			return null;
		}
		if (noAtual == posAnt) { // para retirar o primeiro
			primeiro = noAtual.proximo;
			noAtual = null;
			qde--;
		} else { // para retirar o resto
				posAnt.proximo = noAtual.proximo;
				noAtual = null;
				qde--;
		}
		return atual;
	}
	
	public String getLista() {
		No noAtual = primeiro;
		ItemCompra aux = new ItemCompra();
		String lista = "";
		do {
			lista += aux.getItemCompra() + "\n" + "\n";
		}while (noAtual.proximo != null);
		return lista;
	}

}

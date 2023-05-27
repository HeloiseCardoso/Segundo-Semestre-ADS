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


package listaordenadaencadeada;

public class ItemCompra {
	private String descricao;
	private int qde;
	private double preco;

	public ItemCompra() {
	}

	public ItemCompra(String d, int qtd, double p) {
		descricao = d;
		qde = qtd;
		preco = p;
	}

	public int getQde() {
		return qde;
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean setQde(int qde) {
		if (qde >= 0) {
			this.qde = qde;
			return true;
		} else {
			return false;
		}

	}

	public boolean setPreco(double preco) {
		if (preco >= 0.0) {
			this.preco = preco;
			return true;
		} else {
			return false;
		}

	}

	public String getItemCompra() {
		String item = descricao + "\n" + qde + "\n" + preco;
		return item;
	}

}


package listaordenadaencadeada;

import java.util.Scanner;

import listaordenadaencadeada.ItemCompra;
import listaordenadaencadeada.ListaOrdenada;

public class Base {
	static Scanner leitor = new Scanner(System.in);

	static ItemCompra obtemItemCompra() {
		String d;
		int qtd;
		double p;

		leitor.skip("\\R");
		System.out.println("Descri��o: ");
		d = leitor.nextLine();

		System.out.println("Quantidade: ");
		qtd = leitor.nextInt();

		System.out.println("Pre�o: ");
		p = leitor.nextDouble();

		ItemCompra aux = new ItemCompra(d, qtd, p);
		return aux;
	}

	public static void main(String[] args) {
		String descricao;
		int qde=0;
		double preco=0;
		ItemCompra objItem = null;
		ListaOrdenada lista = new ListaOrdenada();
		int op;

		do {
			System.out.println("Digite:");
			System.out.println("1 - para inserir ordenado.");
			System.out.println("2 - para pesquisar.");
			System.out.println("3 - para retirar.");
			System.out.println("4 - para mostrar lista.");
			System.out.println("5 - para sair. ");
			op = leitor.nextInt();
			System.out.println();
			switch (op) {

			case 1: // inserir
				objItem = obtemItemCompra();
				lista.inserirOrdenado(objItem);
				System.out.println();
				System.out.println("Item inserido na lista com sucesso!");
				System.out.println(objItem.getItemCompra());
				System.out.println();
				objItem = null;
				break;
				
			case 2: // pesquisar
				System.out.println("Digite a descri��o do item que deseja pesquisar: ");
				descricao = leitor.next();
				objItem = new ItemCompra(descricao,qde,preco);
				objItem = lista.buscar(objItem);
				if (objItem == null) {
					System.out.println("Falha ao pesquisar item! A descri��o procurada n�o existe na lista");
					System.out.println();
				} else {
					System.out.println("Sucesso! Item encontrado.");
					System.out.println();
					System.out.println(objItem.getItemCompra());
					System.out.println();
				}
				break;

			case 3: // retirar
				System.out.println("Digite a descricao do item que deseja retirar: ");
				descricao = leitor.next();
				objItem = new ItemCompra(descricao,qde,preco);
				objItem = lista.retira(objItem);
				if (objItem == null) {
					System.out.println("Item n�o encontrado.");
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Item retirado com sucesso!");
				}
				objItem= null;
				break;
				
			case 4: 
				System.out.println(lista.getLista());
			
			case 5: // sair
				System.out.println("Saindo.");
				break;
			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (op != 5);

	}
}



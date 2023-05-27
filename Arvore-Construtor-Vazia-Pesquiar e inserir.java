public class Tree {

    private No raiz; // raiz
    private int tamanho;

    public Tree() {
        raiz = null;
        tamanho = 0;
    } // inicializa arvore

    public boolean vazia() {
        return (raiz == null);
    }

    private No consultar(Item itemAconsultar) { //passo o que quero pesquisar
        No auxiliar = raiz;
        while (auxiliar != null) {
            if (itemAconsultar.getNome().compareTo(auxiliar.item.getNome()) < 0)
                auxiliar = auxiliar.esquerda;
            else if (itemAconsultar.getNome().compareTo(auxiliar.item.getNome()) > 0) {
                auxiliar = auxiliar.direita;
            } else {
                return auxiliar;
                //sucesso encontrou
            }
        }
        return null; // insucesso, null
    }



    public boolean inserir(Item item) {
        No auxiliar = new No(item); //cria-se um novo no
        if (vazia()) {
            raiz = auxiliar;
            System.out.println("Fim da condicao, no para esquerda" + raiz.getItem().getNome());
            return true;
        }
        No noAtual = raiz;
        No noAnterior = raiz;
        while ( noAtual!= null) {
            if (item.getNome().compareTo(noAtual.item.getNome()) < 0) {
                noAnterior = noAtual;
                noAnterior = noAnterior.esquerda; //fim da condicao ir para esquerda
                System.out.println("Fim da condicao, no para esquerda" + noAtual.getItem().getNome());
            } else {
                if (item.getNome().compareTo(noAtual.item.getNome()) > 0) {
                    noAnterior = noAtual;
                    noAtual = noAtual.direita;
                    System.out.println("Fim da condicao, no para direita");
                } else {
                    System.out.println("Metodo inserir - Insucesso, o item ja esta na arvore"+noAtual.getItem().getNome());
                    return false; //insucesso -- item ja esta na arvore
                }
                //faz o no referernciao por anterior o pai do no auxiliar
                auxiliar.pai = noAnterior;
                //verifica-se e filho a esquerda ou a direita
                if (item.getNome().compareTo(noAnterior.item.getNome()) < 0) {
                    noAnterior.esquerda = auxiliar;
                    System.out.println("Filho a esquerda"+noAtual.getItem().getNome());
                } else {
                    noAnterior.esquerda = auxiliar;
                    System.out.println("Filho a direita"+noAtual.getItem().getNome());
                    return true;
                }
            }
        }
        return false;
    }


        public Item pesquisar(Item item){
            No auxiliar = consultar(item);
            if (auxiliar == null){
                return null; // item nao encontrado
            }
            return (new Item (auxiliar.item.getNome(), auxiliar.item.getTelefone()));//Sucesso encontrou
            }
        }







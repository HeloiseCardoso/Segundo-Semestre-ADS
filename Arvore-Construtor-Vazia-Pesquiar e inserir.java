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




public class No {

        public No direita,esquerda,pai;
        public Item item;


        public No(Item auxiliar) {
           item = auxiliar;
           direita = esquerda = pai = null;
        }


        public No getDireita() {
                return direita;
        }

        public void setDireita(No dir) {
                this.direita = dir;
        }

        public No getEsq() {
                return esquerda;
        }

        public void setEsquerda(No esq) {
                this.esquerda = esq;
        }

        public Item getItem() {
                return item;
        }

        public void setItem(Item item) {
                this.item = item;
        }
}


public class Item {

    private String nome, telefone;

    public Item (String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Item() {

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone(){
        return telefone;
    }

    public String toString(){
        return (nome + "\n" + telefone + "\n");
    }


}


public class Main {
    public static void main(String[] args) {
        Item item = new Item();
        Item item1 = new Item("Heloise", "123");
        Item item2 = new Item("Thiago", "456");
        Item item3 = new Item("Ana", "7898");
        Item item4 = new Item("Maria", "4448");


        Tree arvore = new Tree();

        System.out.println(arvore.inserir(item1));
        System.out.println(arvore.pesquisar(item1));



    }
}

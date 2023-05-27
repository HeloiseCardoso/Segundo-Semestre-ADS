
public class Lista {
    private int ultimo;
    private int maxTam ;
    private Contato vetor[];

    public int getMaxTam() {
        return maxTam;
    }
    public boolean setMaxTam(int tam) {
        if (tam < 2) {
            return false;
        }
        ultimo = 0;
        maxTam = tam;
        vetor = new Contato [maxTam];
        return true;
    }

    public Lista() {
        ultimo = 0;
        maxTam = 2;
        vetor = null;
    }

    public boolean listaVazia() {
        return ultimo == 0;
    }

    public boolean listaCheia() {
        return ultimo == maxTam;
    }

    public boolean insereFinal(Contato objContato) {
        if (listaCheia()) {
            return false;
        }
        vetor[ultimo] = objContato;
        ultimo++;
        return true;
    }

    public Contato pesquisa(Contato objContato) {
        int i;
        for (i=0; i<maxTam; i++) {
            if (objContato.getCpf()==vetor[i].getCpf()) {
                break;
            }
        }
        if(i==maxTam) {
            return null;
        }
        String n = vetor[i].getNome();
        String end = vetor[i].getEndereco();
        long pcpf = vetor[i].getCpf();
        Contato copiaContato = new Contato(n, end, pcpf);
        return copiaContato;
    }

    public Contato retira(Contato objContato) {
        if (listaVazia()) {
            return null;
        }
        Contato contatoRetirado = null;
        for (int i = 0; i < ultimo; i++) {
            if (objContato.getCpf()==vetor[i].getCpf()) {
                String n = vetor[i].getNome();
                String end = vetor[i].getEndereco();
                long pcpf = vetor[i].getCpf();
                contatoRetirado = new Contato(n, end, pcpf);

                for (; i < ultimo -1; i++) {
                    vetor[i] = vetor[i+1];
                }
                ultimo--;
                vetor[ultimo]= null;
                break;
            }
        }
        return contatoRetirado;

    }

    public String getLista() {
        String listaInteira = "";
        for (int i=0; i<ultimo; i++) {
            listaInteira += vetor[i].getContato() + "\n";
        }
        return listaInteira;
    }

}

public class Contato {
    private String nome;
    private String endereco;
    private long cpf;

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Contato(String nome, String endereco, long cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }


    public String getContato() {
        String auxiliar = nome + " \n";
        auxiliar = nome + endereco + "\n";
        auxiliar = nome + endereco + Long.toString(cpf) + " \n";
        return auxiliar;
    }
}

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Contato criarContato() {

        System.out.println("Digite o nome:");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Digite o endere�o:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o cpf:");
        long cpf = scanner.nextLong();

        Contato contato = new Contato(nome, endereco, cpf);
        return contato;
    }

    public static void main(String[] args) {
        int opcao = 0, tamanho = 2;
        Contato contato = null;

        Lista lista = new Lista();

        do {
            System.out.println("Digite:");
            System.out.println("1 - Para criar uma lista");
            System.out.println("2 - Para inserir um contato no final da lista");
            System.out.println("3 - Para pesquisar um contato na lista");
            System.out.println("4 - Para retirar um contato da lista");
            System.out.println("5 - Para mostrar a lista de contatos inteira");
            System.out.println("6 - Para encerrar");
            opcao = scanner.nextInt();
            System.out.println();

            switch(opcao) {
                case 1: // criar lista
                    do {
                        System.out.println("Digite o tamanho da lista (>=2): ");
                        tamanho = scanner.nextInt();
                        System.out.println();
                    }while(!lista.setMaxTam(tamanho));
                    break;

                case 2: // inserir no final
                    contato = criarContato();
                    if(lista.insereFinal(contato)) {
                        System.out.println("Sucesso! O contato foi inserido no final da lista.");
                        System.out.println();
                    }else {
                        System.out.println("Falha ao inserir contato! Lista cheia.");
                        System.out.println();
                    }
                    break;

                case 3: // pesquisar
                    long cpf;
                    System.out.println("Digite o CPF do contato que deseja pesquisar: ");
                    cpf = scanner.nextLong();
                    contato = new Contato(null, null, cpf);
                    contato = lista.pesquisa(contato);
                    if(contato == null) {
                        System.out.println("Falha ao pesquisar contato! O CPF procurado n�o existe na lista");
                        System.out.println();
                    } else {
                        System.out.println("Sucesso! Contato encontrado.");
                        System.out.println();
                        System.out.println(contato.getContato());
                        System.out.println();
                    }
                    break;

                case 4: // retirar
                    System.out.println("Digite o CPF do contato que deseja retirar da lista: ");
                    cpf = scanner.nextLong();
                    contato = new Contato(null, null, cpf);
                    contato = lista.retira(contato);
                    if(contato == null) {
                        System.out.println("Falha ao retirar contato! O CPF procurado n�o existe na lista");
                        System.out.println();

                    } else {
                        System.out.println("Sucesso! Contato retirado.");
                        System.out.println();
                        System.out.println(contato.getContato());
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println(lista.getLista());
                    break;

                case 6:
                    System.out.println("Programa encerrado.");
                    break;
            }

        } while (opcao != 6);
    }
}


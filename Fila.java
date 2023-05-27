public class Fila {
    private int maxTam;
    private int fim;
    private Cliente[] vetor;


    public Fila() {
        this.maxTam = 0;
        this.fim = 0;
        this.vetor = null;
    }

    public boolean enfileirar(Cliente auxiliar) {
        if (filaCheia()) {
            return false;
        }
        vetor[fim] = auxiliar;
        fim++;
        mostarFila();
        return true;
    }

    public int getMaxTam() {
        return maxTam;
    }


    public boolean setMaxTam(int maxTam) {
        if(maxTam <= 2) return false;
        fim = 0;
        this.maxTam = maxTam;
        vetor = new Cliente[maxTam];
        return true;
    }
    public boolean filaCheia() {
        if (fim == maxTam) {
            return true;
        }
        return false;
    }

    public void mostarFila(){
        for(int i= 0; i< maxTam; i++){
            if(vetor[i] == null){
                break;
            }
            System.out.println(vetor[i].getCliente());

        }
    }


    public boolean filaVazia() {
        if (fim == 0) {
            return true;
        }
        return false;
    }

    public Cliente desenfileirar() {
        if (filaVazia()) {
            return null;
        }
        Cliente auxiliar = vetor[0];
        for (int i = 0; i < fim; i++) {
            vetor[i] = vetor[i + 1];
        }
        fim--;
        vetor[fim] = null;
        mostarFila();
        return auxiliar;
    }

    }



public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /*@Override
    public String toString(){
        System.out.println("Nome: " + nome + " " + "Idade: " + idade);
        return null;
    }*/

    public String getCliente() {
        String auxiliar = nome + "\n";
        auxiliar = nome + "  " + Integer.toString(idade) + "\n";
        return auxiliar;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public boolean setIdade(int idade){
        if(idade <0 ){
            return false;
        }
        this.idade = idade;
        return true;
    }

}

import java.util.Scanner;

public class Base {
    static Scanner scanner = new Scanner(System.in);

    static Cliente criarCliente() {
        System.out.println("Nome: ");
        scanner.skip("\\R");
        String nome = scanner.nextLine();
        System.out.println("Idade");
        int idade = scanner.nextInt();
        Cliente auxiliar = new Cliente(nome, idade);
        return auxiliar;
    }

    public static void main(String[] args) {

        Fila fila = new Fila();
        Cliente auxiliar = null;
        int tamanho = 0;

        do {
            System.out.println("Tamanho: ");
            tamanho = scanner.nextInt();
        } while (!fila.setMaxTam(tamanho));
        do {
            System.out.println("Digite: ");
            System.out.println("1: Para enfileirar.");
            System.out.println("2: Para desenfileirar.");
            System.out.println("3: Para encerrar.");
            tamanho = scanner.nextInt();
            switch (tamanho) {
                case 1:
                    auxiliar = criarCliente();
                    if (fila.enfileirar(auxiliar)) {
                        System.out.println("Sucesso.");
                    } else {
                        System.out.println("Erro: Fila cheia.");
                        auxiliar = null;
                    }
                    break;
                case 2:
                    auxiliar = fila.desenfileirar();
                    if (auxiliar == null) {
                        System.out.println("Erro: Fila vazia.");
                    } else {
                        System.out.println(auxiliar.getCliente());
                        auxiliar = null;
                    }
                    break;
                case 3:
                    System.out.println("Programa encerrando.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (tamanho != 3);

    }









public class Fila {

    public class No {
        private Cliente dados;
        private No anterior;

        public No(Cliente auxiliar) {
            dados = auxiliar;
            anterior = null;
        }
    }

    private No inicio;
    private No fim;
    private int quantidade;


    public Fila() {
        inicio = fim = null;
        quantidade = 0;
    }

    public int quantidade() {
        return quantidade;
    }

    public boolean filaVazia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }

    public void enfileirar(Cliente auxiliar) {
        No novo = new No(auxiliar);
        if (filaVazia()) {
            inicio = fim = novo;
        } else {
            fim.anterior = novo;
            fim = novo;
        }
        quantidade++;
    }


    public Cliente desenfileirar() {
        if (filaVazia()) {
            return null;
        }
            No objeto = inicio;
            inicio = objeto.anterior;
            Cliente auxiliar = objeto.dados;
            quantidade--;
            return auxiliar;
        }
    }

public class Cliente {
    private String nome;
    private String cpf;
    private String fone;

    //getCliente():String

    public Cliente (String nome, String cpf, String fone){
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
    }

    public String getCliente(){
        String auxiliar = nome + "\n" + cpf + "\n" + "fone";
        return auxiliar;
    }

import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome, telefone, cpf;
        scanner.skip("\\R");

        System.out.println("Nome: ");
        nome = scanner.next();

        System.out.println("Telefone: ");
        telefone = scanner.next();

        System.out.println("CPF: ");
        cpf = scanner.next();
    }
}

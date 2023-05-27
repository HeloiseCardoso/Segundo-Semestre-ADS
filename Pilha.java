public class Pilha{
    private int topo;
    private int maxTamanho;
    private Contato[]vetorPilha;

    public int getMaxTamanho(){
        return maxTamanho;
    }

    public boolean setMaxTamanho(int auxiliar){
        if(auxiliar < 2) {
            return false;
        }
            topo = 0;
            maxTamanho = auxiliar;
            vetorPilha = new Contato[maxTamanho];
        return true;
    }

    public Pilha(){
        this.topo = 0;
        this.maxTamanho = 2;
        this.vetorPilha = null;

    }

    public boolean pilhaVazia(){
        if(topo == 0){
            return true;
        }
        return false;
    }

    public boolean pilhaCheia(){
        if(topo == maxTamanho){
            return true;
        }
        return false;
    }

    public boolean push(Contato auxiliar) {
        if(pilhaCheia()){
            return false;
        }
        vetorPilha[topo] = auxiliar;
        topo++;
        return true;
    }

    public Contato pop() {
        if(pilhaVazia()){
            return null;
        }
        topo--;
        Contato auxiliar = vetorPilha[topo];
        vetorPilha[topo] = null;
        return auxiliar;
    }


}


public class Contato {
    private String nome;
    private long cpf;
    private String endereco;


    public Contato(String nome,  String endereco, long cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;

    }

    public String getContato(){
        String auxiliar = nome + "\n";
        auxiliar = auxiliar + endereco + "\n";
        auxiliar = auxiliar + Long.toString(cpf) + "\n";
        return auxiliar;
    }

}



import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Contato criarContato() {
        System.out.println("Nome: ");
        ;
        scanner.skip("\\R");
        String nome = scanner.nextLine();
        System.out.println("Endereco: ");
        String endereco = scanner.nextLine();
        System.out.println("cpf: ");
        long cpf = scanner.nextLong();

        Contato contato = new Contato(nome, endereco, cpf);
        return contato;
    }


    static Contato inverterPilha(Pilha auxiliarPilha){
        Pilha inverterPilha = new Pilha();
        while(!auxiliarPilha.pilhaVazia()){
            inverterPilha.push(auxiliarPilha.pop());
            return inverterPilha;
        }
    }




    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Contato auxiliar = null;
        int numero;

        do {
            System.out.println("Tamanho: ");
            numero = scanner.nextInt();
        } while (!pilha.setMaxTamanho(numero));
        do {
            System.out.println("Digite: ");
            System.out.println("1: Para empilhar");
            System.out.println("2: Para desempilhar");
            System.out.println("3: Para encerrar.");
            System.out.println("3: Inverter pilha")
            numero = scanner.nextInt();

            switch (numero) {
                case 1:
                    auxiliar = criarContato();
                    if (pilha.push(auxiliar)) {
                        System.out.println("Sucesso!");
                    } else {
                        System.out.println("Pilha cheia!.");
                        auxiliar = null;
                        break;
                    }
                case 2:
                    auxiliar = pilha.pop();
                    if (auxiliar == null) {
                        System.out.println("Erro: pilha vazia");
                    } else {
                        System.out.println(auxiliar.getContato());
                        auxiliar = null;
                        break;
                    }
                case 3:
                    pilha = inveterPilha(pilha);
                case 4:
                    System.out.println("programa encerrado.");
                    break;
                default:
                    System.out.println("Opacao invalida! ");
            }
        } while (numero !=4);
    }
}















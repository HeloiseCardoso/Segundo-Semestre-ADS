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
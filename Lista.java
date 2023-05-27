
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




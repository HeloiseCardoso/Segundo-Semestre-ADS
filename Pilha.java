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
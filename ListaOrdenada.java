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


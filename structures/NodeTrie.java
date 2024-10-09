package structures;

class NodeTrie {
    char info;
    boolean fimDaPalavra;
    ListaEncadeada filhos;

    public NodeTrie(char info) {
        this.info = info;
        this.fimDaPalavra = false;
        this.filhos = new ListaEncadeada();
    }
}

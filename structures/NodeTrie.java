package structures;

class NodeTrie {
    char info;
    boolean isEndOfWord;
    ListaEncadeada filhos;

    public NodeTrie(char info) {
        this.info = info;
        this.isEndOfWord = false;
        this.filhos = new ListaEncadeada();
    }
}

package structures;

class Node {
    protected char info;
    protected Boolean fimDaPalavra;
    protected Node filho;
    protected Node irmao;

    public Node(char info){
        this.info = info;
        this.fimDaPalavra = false;
    }

}
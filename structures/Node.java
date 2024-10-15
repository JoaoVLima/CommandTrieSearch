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

//    public Node adiciona_filho(char info){
//        Node novo_no = new Node(info);
//
//        if (this.filho == null){
//            this.filho = novo_no;
//            return novo_no;
//        }
//
//        Node no = this.filho;
//        while(no.filho != null){
//            no = no.filho;
//        }
//
//        no.filho = novo_no;
//        return novo_no;
//    }
//
//    public Node adiciona_irmao(char info){
//        Node novo_no = new Node(info);
//
//        if (this.irmao == null){
//            this.irmao = novo_no;
//            return novo_no;
//        }
//
//        Node no = this.irmao;
//        while(no.irmao != null){
//            no = no.irmao;
//        }
//
//        no.irmao = novo_no;
//        return novo_no;
//    }
//
//    public void remove_filho(char valor){
//        Node no = this.filho;
//
//        if (no.info == valor) {
//            this.filho = no.filho;
//            return;
//        }
//
//        while (no.filho != null && !(no.filho.info == valor)) {
//            no = no.filho;
//        }
//
//        if (no.filho == null) {
//            return;
//        }
//
//        no.filho = no.filho.filho;
//    }
//
//    public void remove_irmao(char valor){
//        Node no = this.irmao;
//
//        if (no.info == valor) {
//            this.irmao = no.irmao;
//            return;
//        }
//
//        while (no.irmao != null && !(no.irmao.info == valor)) {
//            no = no.irmao;
//        }
//
//        if (no.irmao == null) {
//            return;
//        }
//
//        no.irmao = no.irmao.irmao;
//    }
//
//    public Node busca_filho(char valor){
//        if (this.irmao == null) {
//            return null;
//        }
//
//        Node no = this.filho;
//
//        if (no.info == valor) {
//            return no;
//        }
//
//        while (no.filho != null && !(no.filho.info == valor)) {
//            no = no.filho;
//        }
//
//        if (no.filho == null) {
//            return null;
//        }
//
//        return no.filho;
//    }
//
//    public Node busca_irmao(char valor){
//        if (this.info == valor) {
//            return this;
//        }
//
//        if (this.irmao == null) {
//            return null;
//        }
//
//        Node no = this.irmao;
//        if (no.info == valor) {
//            return no;
//        }
//
//        while (no.irmao != null && !(no.irmao.info == valor)) {
//            no = no.irmao;
//        }
//
//        if (no.irmao == null) {
//            return null;
//        }
//
//        return no.irmao;
//    }

}
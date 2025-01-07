import structures.ArvoreTrie;

public class Main {
    public static void main(String[] args) throws Exception {
        ArvoreTrie arvore = new ArvoreTrie();
        arvore.insere("AR");
        arvore.insere("OBA");
        arvore.insere("OBO");
        arvore.insere("OK");
        arvore.insere("OKO");
        // arvore.remove("AR");
        arvore.exibir();
        System.out.println();
    }
}

import structures.ArvoreTrie;

public class Main {
    public static void main(String[] args) throws Exception {
        ArvoreTrie arvore = new ArvoreTrie();
        arvore.insere("AR");
        arvore.insere("OBA");
        arvore.insere("OK");
        arvore.remove("AR");
        System.out.println();
    }
}

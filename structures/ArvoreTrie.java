//package structures;
//
//import java.util.Scanner;
//
//public class ArvoreTrie {
//    private NodeTrie inicio;
//
//    public ArvoreTrie() {
//        this.inicio = null;
//    }
//
//    public void insere(String palavra) {
//        insere_recursivo(this.inicio, palavra, 0);
//    }
//
//    private void insere_recursivo(NodeTrie no, String palavra, int indice) {
//        if (indice == palavra.length()) {
//            no.fimDaPalavra = true;
//            return;
//        }
//        char caractere = palavra.charAt(indice);
//
//        NodeTrie filho = procuraOuCriaFilho(no, caractere);
//
//        insere_recursivo(filho, palavra, indice + 1);
//    }
//
//    private NodeTrie procuraOuCriaFilho(NodeTrie no, char caractere) {
//        Node noLista = no.filhos.get_inicio();
//        while (noLista != null) {
//            NodeTrie filho = (NodeTrie) noLista.info;
//            if (filho.info == caractere) {
//                return filho;
//            }
//            noLista = noLista.direita;
//        }
//
//        NodeTrie novoFilho = new NodeTrie(caractere);
//        no.filhos.insere(novoFilho);
//        return novoFilho;
//    }
//
//    public boolean busca(String palavra) {
//        return busca_recursivo(this.raiz, palavra.toLowerCase(), 0);
//    }
//
//    private boolean busca_recursivo(NodeTrie noAtual, String palavra, int indice) {
//        if (indice == palavra.length()) {
//            return noAtual.isEndOfWord;
//        }
//
//        char caractere = palavra.charAt(indice);
//        NodeTrie filho = procuraFilho(noAtual, caractere);
//
//        if (filho == null) {
//            return false;
//        }
//
//        return busca_recursivo(filho, palavra, indice + 1);
//    }
//
//    private NodeTrie procuraFilho(NodeTrie no, char caractere) {
//        Node noLista = no.filhos.get_inicio();
//        while (noLista != null) {
//            NodeTrie filho = (NodeTrie) noLista.info;
//            if (filho.info == caractere) {
//                return filho;
//            }
//            noLista = noLista.direita;
//        }
//        return null;
//    }
//
//    public void remove(String palavra) {
//        remove_recursivo(this.raiz, palavra.toLowerCase(), 0);
//    }
//
//    private boolean remove_recursivo(NodeTrie noAtual, String palavra, int indice) {
//        if (indice == palavra.length()) {
//            if (!noAtual.isEndOfWord) {
//                return false; // Palavra não encontrada
//            }
//            noAtual.isEndOfWord = false;
//            return noAtual.filhos.is_vazio(); // Se não tem filhos, pode remover
//        }
//
//        char caractere = palavra.charAt(indice);
//        NodeTrie filho = procuraFilho(noAtual, caractere);
//
//        if (filho == null) {
//            return false; // Palavra não encontrada
//        }
//
//        boolean deveRemoverFilho = remove_recursivo(filho, palavra, indice + 1);
//
//        if (deveRemoverFilho) {
//            noAtual.filhos.remove(filho); // Remove o filho da lista de filhos
//            return noAtual.filhos.is_vazio() && !noAtual.isEndOfWord; // Se não tem filhos e não é fim de palavra, pode remover
//        }
//
//        return false;
//    }
//
//    public void imprime() {
//        imprime_recursivo(this.raiz, "");
//    }
//
//    private void imprime_recursivo(NodeTrie noAtual, String prefixo) {
//        if (noAtual.isEndOfWord) {
//            System.out.println(prefixo);
//        }
//
//        Node noLista = noAtual.filhos.get_inicio();
//        while (noLista != null) {
//            NodeTrie filho = (NodeTrie) noLista.info;
//            imprime_recursivo(filho, prefixo + filho.info);
//            noLista = noLista.direita;
//        }
//    }
//
//    public void menu() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("1 - Inserir palavra");
//            System.out.println("2 - Buscar palavra");
//            System.out.println("3 - Remover palavra");
//            System.out.println("4 - Imprimir Trie");
//            System.out.println("0 - Sair");
//
//            int opcao = scanner.nextInt();
//            scanner.nextLine(); // Limpa buffer
//
//            switch (opcao) {
//                case 1:
//                    System.out.print("Digite a palavra para inserir: ");
//                    String palavraInserir = scanner.nextLine();
//                    insere(palavraInserir);
//                    break;
//                case 2:
//                    System.out.print("Digite a palavra para buscar: ");
//                    String palavraBuscar = scanner.nextLine();
//                    boolean encontrado = busca(palavraBuscar);
//                    System.out.println(encontrado ? "Palavra encontrada!" : "Palavra não encontrada.");
//                    break;
//                case 3:
//                    System.out.print("Digite a palavra para remover: ");
//                    String palavraRemover = scanner.nextLine();
//                    remove(palavraRemover);
//                    break;
//                case 4:
//                    imprime();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Opção inválida.");
//            }
//        }
//    }
//}
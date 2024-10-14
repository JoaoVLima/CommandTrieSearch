package structures;

public class ArvoreNaria {
    private Node inicio;

    public ArvoreNaria() {
        this.inicio = new Node(' ');
    }

    public boolean insere(String word){
        char[] chars = word.toCharArray();
        int indice = 0;

        if(this.inicio.filho == null){
            this.inicio.filho = new Node(chars[indice]);
        }

        insere_recursivo(this.inicio.filho, chars, indice);

        return true;
    }

    public void insere_recursivo(Node no, char[] chars, int indice){
        if(indice == chars.length){
            return;
        }

        Node no_buscado = no.busca_irmao(chars[indice]);
        if(no_buscado == null){
            no.adiciona_irmao(chars[indice]);
        }

        indice++;
        insere_recursivo(no.filho, chars, indice);
    }
//
//    public boolean inserirNo(int valor, int paiValor) {
//        No pai = buscarNo(paiValor, this.inicio);
//        if (pai == null) {
//            System.out.println("Pai não encontrado.");
//            return false;
//        }
//
//        No novoNo = new No(valor);
//        novoNo.setPai(pai);
//
//        if (pai.getPrimeiroFilho() == null) {
//            pai.setPrimeiroFilho(novoNo);
//            System.out.println("Nó inserido com sucesso.");
//            return true;
//        } else {
//            No aux = pai.getPrimeiroFilho();
//            while (aux.getProximoIrmao() != null) {
//                aux = aux.getProximoIrmao();
//            }
//            aux.setProximoIrmao(novoNo);
//            System.out.println("Nó inserido com sucesso.");
//            return true;
//        }
//    }
//
//    public No buscarNo(int valor, No inicio) {
//        if (this.inicio == null) {
//            return null;
//        } else if (this.inicio.getValor() == valor) {
//            System.out.println("Nó encontrado.");
//            return this.inicio;
//        }
//
//        No aux = this.inicio.getPrimeiroFilho();
//        while (aux != null) {
//            No no = buscarNo(valor, aux);
//            if (no != null) {
//                return no;
//            }
//            aux = aux.getProximoIrmao();
//        }
//        return null;
//    }
//
//    public void exibirArvore(No inicio) {
//        if (this.inicio == null) {
//            return;
//        }
//
//        System.out.print(this.inicio.getValor() + "(");
//        No aux = this.inicio.getPrimeiroFilho();
//        while (aux != null) {
//            exibirArvore(aux);
//            aux = aux.getProximoIrmao();
//        }
//        System.out.print(")");
//    }
//
//    public boolean removerNo(int valor) {
//        No no = buscarNo(valor, this.inicio);
//        if (no == null) {
//            System.out.println("Nó não encontrado.");
//            return false;
//        }
//
//        No pai = no.getPai();
//        No primeiroFilho = no.getPrimeiroFilho();
//        No proximoIrmao = no.getProximoIrmao();
//
//        if (pai != null) {
//            if (pai.getPrimeiroFilho() == no) {
//                pai.setPrimeiroFilho(proximoIrmao);
//            } else {
//                No aux = pai.getPrimeiroFilho();
//                while (aux.getProximoIrmao() != no) {
//                    aux = aux.getProximoIrmao();
//                }
//                aux.setProximoIrmao(proximoIrmao);
//            }
//
//            if (primeiroFilho != null) {
//                No aux = pai.getPrimeiroFilho();
//                if (aux == null) {
//                    proximoIrmao.setPrimeiroFilho(primeiroFilho);
//                } else {
//                    while (aux.getProximoIrmao() != null) {
//                        aux = aux.getProximoIrmao();
//                    }
//                    aux.setProximoIrmao(primeiroFilho);
//                }
//            }
//        } else {
//            this.inicio = primeiroFilho;
//        }
//
//        no = null;
//        return true;
//    }
}

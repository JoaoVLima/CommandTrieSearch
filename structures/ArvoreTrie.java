package structures;

public class ArvoreTrie {
    private Node inicio;

    public ArvoreTrie() {
        this.inicio = null;
    }

    public boolean insere(String word){
        char[] chars = word.toCharArray();
        int indice = 0;

        this.inicio = insere_recursao(this.inicio, chars, indice);

        return true;
    }

    private Node insere_recursao(Node no, char[] chars, int indice) {
        if (indice == chars.length) {
            if (no != null) {
                no.fimDaPalavra = true;
            }
            return no;
        }

        if (no == null) {
            no = new Node(chars[indice]);
        }

        if (no.info == chars[indice]) {
            no.filho = insere_recursao(no.filho, chars, indice+1);

            if (indice == chars.length-1) {
                no.fimDaPalavra = true;
            }
        }
        else {
            no.irmao = insere_recursao(no.irmao, chars, indice);
        }

        return no;
    }


    public boolean remove(String word){
        char[] chars = word.toCharArray();
        int indice = 0;

        return remove_recursao(this.inicio, chars, indice);
    }

    private boolean remove_recursao(Node no, char[] chars, int indice) {
        if (no == null) {
            return false;
        }

        if (indice == chars.length) {
            if (no.fimDaPalavra) {
                no.fimDaPalavra = false;
                return no.filho == null && no.irmao == null;
            }
            return false;
        }

        if (no.info == chars[indice]) {
            boolean is_remove = remove_recursao(no.filho, chars, indice + 1);

            if (is_remove) {
                no.filho = null;

                return !no.fimDaPalavra && no.irmao == null;
            }
        } else {
            boolean is_remove = remove_recursao(no.irmao, chars, indice);

            if (is_remove) {
                no.irmao = null;
            }
        }

        return false;
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

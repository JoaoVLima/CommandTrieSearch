package structures;

public class ArvoreNaria {
    private Node inicio;

    public ArvoreNaria() {
        this.inicio = new Node(' ');
    }

    boolean is_vazio() {
        return (this.inicio == null);
    }

    boolean inserir(String word){
        char[] chars = word.toCharArray();

        Node novo_no = new Node(chars[0]);

        if(this.is_vazio()){
            this.inicio = novo_no;
            return true;
        }

        Node no = this.inicio;
        while(no.irmao != null){
            no = no.irmao;
        }

        no.irmao = novo_no;
        return true;
    }

    public boolean inserirNo(int valor, int paiValor) {
        No pai = buscarNo(paiValor, this.inicio);
        if (pai == null) {
            System.out.println("Pai não encontrado.");
            return false;
        }

        No novoNo = new No(valor);
        novoNo.setPai(pai);

        if (pai.getPrimeiroFilho() == null) {
            pai.setPrimeiroFilho(novoNo);
            System.out.println("Nó inserido com sucesso.");
            return true;
        } else {
            No aux = pai.getPrimeiroFilho();
            while (aux.getProximoIrmao() != null) {
                aux = aux.getProximoIrmao();
            }
            aux.setProximoIrmao(novoNo);
            System.out.println("Nó inserido com sucesso.");
            return true;
        }
    }

    public No buscarNo(int valor, No inicio) {
        if (this.inicio == null) {
            return null;
        } else if (this.inicio.getValor() == valor) {
            System.out.println("Nó encontrado.");
            return this.inicio;
        }

        No aux = this.inicio.getPrimeiroFilho();
        while (aux != null) {
            No no = buscarNo(valor, aux);
            if (no != null) {
                return no;
            }
            aux = aux.getProximoIrmao();
        }
        return null;
    }

    public void exibirArvore(No inicio) {
        if (this.inicio == null) {
            return;
        }

        System.out.print(this.inicio.getValor() + "(");
        No aux = this.inicio.getPrimeiroFilho();
        while (aux != null) {
            exibirArvore(aux);
            aux = aux.getProximoIrmao();
        }
        System.out.print(")");
    }

    public boolean removerNo(int valor) {
        No no = buscarNo(valor, this.inicio);
        if (no == null) {
            System.out.println("Nó não encontrado.");
            return false;
        }

        No pai = no.getPai();
        No primeiroFilho = no.getPrimeiroFilho();
        No proximoIrmao = no.getProximoIrmao();

        if (pai != null) {
            if (pai.getPrimeiroFilho() == no) {
                pai.setPrimeiroFilho(proximoIrmao);
            } else {
                No aux = pai.getPrimeiroFilho();
                while (aux.getProximoIrmao() != no) {
                    aux = aux.getProximoIrmao();
                }
                aux.setProximoIrmao(proximoIrmao);
            }

            if (primeiroFilho != null) {
                No aux = pai.getPrimeiroFilho();
                if (aux == null) {
                    proximoIrmao.setPrimeiroFilho(primeiroFilho);
                } else {
                    while (aux.getProximoIrmao() != null) {
                        aux = aux.getProximoIrmao();
                    }
                    aux.setProximoIrmao(primeiroFilho);
                }
            }
        } else {
            this.inicio = primeiroFilho;
        }

        no = null;
        return true;
    }
}

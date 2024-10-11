package structures;

import java.util.Scanner;

public class ListaEncadeada {
    private Node inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    boolean is_vazio() {
        return (this.inicio == null);
    }

    void insere(char info){
        Node novo_no = new Node(info);

        if (this.is_vazio()){
            this.inicio = novo_no;
            return;
        }

        Node no = this.inicio;
        while(no.irmao != null){
            no = no.irmao;
        }

        no.irmao = novo_no;
    }

    String remove_ultimo() throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        Node no = this.inicio;

        if (no.irmao == null) {
            String valor_removido = this.inicio.info;
            this.inicio = null;
            return valor_removido;
        }

        while(no.irmao.irmao != null){
            no = no.irmao;
        }
        String valor_removido = no.irmao.info;
        no.irmao = null;
        return valor_removido;
    }

    String remove_posicao(int posicao) throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        if (posicao == 1){
            String valor_removido = this.inicio.info;
            this.inicio = this.inicio.irmao;
            return valor_removido;
        }

        Node no = this.inicio;

        int contador = 2;
        while (no.irmao.irmao != null && contador < posicao) {
            no = no.irmao;
            contador++;
        }

        if (posicao != contador) {
            throw new Exception("Nó na posição " + posicao + " não existe.");
        }

        String valor_removido = no.irmao.info;
        no.irmao = no.irmao.irmao;
        return valor_removido;
    }

    String remove(String valor) throws Exception {
        if (this.is_vazio()) {
            throw new Exception("Lista Vazia");
        }

        Node no = this.inicio;

        if (no.info.equals(valor)) {
            String valor_removido = no.info;
            this.inicio = no.irmao;
            return valor_removido;
        }

        while (no.irmao != null && !no.irmao.info.equals(valor)) {
            no = no.irmao;
        }

        if (no.irmao == null) {
            throw new Exception("Nó com valor " + valor + " não encontrado.");
        }

        String valor_removido = no.irmao.info;
        no.irmao = no.irmao.irmao;
        return valor_removido;
    }

    Node get(String valor) throws Exception {
        if (this.is_vazio()) {
            throw new Exception("Lista Vazia");
        }

        Node no = this.inicio;

        if (no.info.equals(valor)) {
            return no;
        }

        while (no.irmao != null && !no.irmao.info.equals(valor)) {
            no = no.irmao;
        }

        if (no.irmao == null) {
            throw new Exception("Nó com valor " + valor + " não encontrado.");
        }

        return no.irmao;
    }

    void imprime() {
        System.out.print("[");

        if (this.is_vazio()){
            System.out.println("]");
            return;
        }

        Node no = this.inicio;
        while(no != null){
            System.out.print(no.info);
            no = no.irmao;
            if(no != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        this.imprime();
        while(true){
            System.out.println("1 - Inserir");
            System.out.println("2 - Excluir");
            System.out.println("0 - Parar");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                this.imprime();
                break;
            } else if (opcao == 1) {
                System.out.print("Digite o valor para inserir: ");
                String valor = scanner.next();
                this.insere(valor);
                this.imprime();
            } else if (opcao == 2) {
                System.out.print("Digite o valor do nó para excluir: ");
                String valor = scanner.next();
                this.remove(valor);
                this.imprime();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
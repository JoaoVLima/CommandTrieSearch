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

    void insere(int info){
        Node novo_no = new Node(info);

        if (this.is_vazio()){
            this.inicio = novo_no;
            return;
        }

        Node no = this.inicio;
        while(no.direita != null){
            no = no.direita;
        }

        no.direita = novo_no;
    }

    int remove_ultimo() throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        Node no = this.inicio;

        if (no.direita == null) {
            int valor_removido = this.inicio.info;
            this.inicio = null;
            return valor_removido;
        }

        while(no.direita.direita != null){
            no = no.direita;
        }
        int valor_removido = no.direita.info;
        no.direita = null;
        return valor_removido;
    }

    int remove(int posicao) throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        if (posicao == 1){
            int valor_removido = this.inicio.info;
            this.inicio = this.inicio.direita;
            return valor_removido;
        }

        Node no = this.inicio;

        int contador = 2;
        while (no.direita.direita != null && contador < posicao) {
            no = no.direita;
            contador++;
        }

        if (posicao != contador) {
            throw new Exception("Nó na posição " + posicao + " não existe.");
        }

        int valor_removido = no.direita.info;
        no.direita = no.direita.direita;
        return valor_removido;
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
            no = no.direita;
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
                int valor = scanner.nextInt();
                this.insere(valor);
                this.imprime();
            } else if (opcao == 2) {
                System.out.print("Digite a posição do nó para excluir: ");
                int posicao = scanner.nextInt();
                this.remove(posicao);
                this.imprime();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
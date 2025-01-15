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

    public boolean exibir() {
        this.inicio = exibir_recursao(this.inicio, new StringBuilder());
        return true;
    }

    private Node exibir_recursao(Node no, StringBuilder palavra) {
        if (no == null) {
            return no;
        }

        palavra.append(no.info);

        if (no.fimDaPalavra) {
            System.out.println(palavra);
        }

        exibir_recursao(no.filho, palavra);

        palavra.deleteCharAt(palavra.length() - 1);

        exibir_recursao(no.irmao, palavra);

        return no;
    }
}

public class EstruturaDeFilaEncadeada {
    No inicio = null;
    No fim;
    class No {
        int dado;
        No proximo;

        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }

    public void insereElemento( int elemento ){
        No novoNo = new No(elemento);
        No atual = inicio;

        if (inicio == null){
            inicio = novoNo;
            fim = inicio;
        }else{
            fim.proximo = novoNo;
            fim = novoNo;

        }
    }

    public void removeElemento() {
        if (inicio == null) {
            System.out.println("Lista nao possui elementos");
        }else if (inicio.proximo != fim || inicio != fim){
            inicio = inicio.proximo;
        }else {
            System.out.println("Lista vazia");
        }
    }

    public void imprimir() {
        No atual = inicio;
        while ( atual != fim){
            System.out.print(atual.dado + ", ");
            atual = atual.proximo;
        }
        System.out.println(atual.dado);
    }

    public static void main(String[] args) {
        EstruturaDeFilaEncadeada pilha = new EstruturaDeFilaEncadeada();
        pilha.insereElemento(1);
        pilha.insereElemento(2);
        pilha.insereElemento(3);
        pilha.insereElemento(4);
        pilha.insereElemento(5);
        pilha.insereElemento(6);
        pilha.imprimir();
        pilha.removeElemento();
        pilha.imprimir();

    }

}
import java.sql.BatchUpdateException;

public class EstruturaDePilhaEncadeada {
  No inicio = null;

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
      novoNo.proximo = null;
    }else{
      while ( atual.proximo != null) {
        atual = atual.proximo;
      }
      atual.proximo = novoNo;
    }
  }

  public void removeElemento() {
    No atual = inicio;
    if (inicio == null) {
      System.out.println("Lista ja esta vazia");
    }else {
      No anterior = atual;
      while (atual.proximo != null) {
        anterior = atual;
        atual = atual.proximo;
      }
      anterior.proximo = null;
    }
  }

  public void imprimir() {
    No atual = inicio;
    while ( atual.proximo != null){
      System.out.print(atual.dado + ", ");
      atual = atual.proximo;
    }
    System.out.println(atual.dado);
  }

  public static void main(String[] args) {
    EstruturaDePilhaEncadeada pilha = new EstruturaDePilhaEncadeada();
    pilha.insereElemento(30);
    pilha.insereElemento(40);
    pilha.imprimir();
    pilha.removeElemento();
    pilha.imprimir();

  }

}
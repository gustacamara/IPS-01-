
public class MergeFila {
    static class Fila {
        private int[] fila;
        private int maximo;
        private int inicio;
        private int fim;

        public Fila(int maximo) {
            this.maximo = maximo;
            this.fila = new int[maximo];
            fim = -1;
            inicio = -1;
        }


        public void inserir(int dado) {
            if(!ehCheia()) {
                fim++;
                fim = fim % maximo;
                fila[fim] = dado;
            }else{
                System.out.println("Fila está cheia, não é possivel inserir!");
            }
            if (inicio == -1) {
                inicio = 0;
            }
        }

        public void remover() {

            if(!ehVazia()) {
                fila[inicio % maximo] = 0;
                inicio++;
                inicio = inicio % maximo;
            }else{
                System.out.println("Fila está vazia, não é possivel remover!");
            }

        }

        public void exibir() {
            System.out.println("Sua pilha: \n");
            for (int i = 0; i <= maximo - 1; i++) {
                if ( fim == i) {
                    System.out.println(fila[i] + " -> topo");
                }else if (inicio == i) {
                    System.out.println(fila[i] + " -> primeiro");
                }else {
                    System.out.println(fila[i]);
                }
            }
            System.out.println("fim.\n");
        }

        public boolean ehCheia() {
            int aux = fim + 1;
            return (aux % maximo == inicio);
        }

        public boolean ehVazia() {
            int aux = inicio + 1;
            return  (aux % maximo == fim);
        }

        public int getMaximo() {
            return maximo;
        }

        public int getInicio() {
            return inicio;
        }

        public int getFim() {
            return fim;
        }

    }
    public static Fila mergeFilas(Fila filaA, Fila filaB) {
        Fila resultado = new Fila(filaA.maximo + filaB.maximo);
        int inicioA = filaA.inicio;
        int inicioB = filaB.inicio;
        while( inicioA <= filaA.maximo || inicioB <= filaB.maximo){

            if( filaA.fila[inicioA] < filaB.fila[inicioB]){
                resultado.inserir(filaA.fila[filaA.inicio]);
                inicioA ++;

            }else if( filaA.fila[inicioA] > filaB.fila[inicioB]){
                resultado.inserir(filaB.fila[filaB.inicio]);
                inicioB ++;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {

        Fila fila1 = new Fila(5);
        fila1.inserir(5);
        fila1.inserir(6);
        fila1.inserir(7);
        fila1.inserir(8);
        fila1.inserir(9);
        fila1.exibir();
        Fila fila2 = new Fila(5);
        fila2.inserir(1);
        fila2.inserir(12);
        fila2.inserir(28);
        fila2.inserir(29);
        fila2.inserir(100);
        fila2.exibir();
        Fila superfila = mergeFilas(fila1, fila2);
        superfila.exibir();

        fila1.exibir();
        fila2.exibir();


    }

}

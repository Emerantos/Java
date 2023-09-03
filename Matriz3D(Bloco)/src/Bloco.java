public class Bloco {
    private int[][][] matriz;
    private int dimensaoX;
    private int dimensaoY;
    private int dimensaoZ;
    private int limiteResfriamento;

    public Bloco(int dimensaoX, int dimensaoY, int dimensaoZ, int limiteResfriamento) {
        this.dimensaoX = dimensaoX;
        this.dimensaoY = dimensaoY;
        this.dimensaoZ = dimensaoZ;
        this.limiteResfriamento = limiteResfriamento;

        matriz = new int[dimensaoX][dimensaoY][dimensaoZ];
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int x = 0; x < dimensaoX; x++) {
            for (int y = 0; y < dimensaoY; y++) {
                for (int z = 0; z < dimensaoZ; z++) {
                    matriz[x][y][z] = 1000;
                }
            }
        }
    }

    public void resfriarBloco() {
        int maiorValor = 0;
        int ciclos = 0;

        do {
            maiorValor = 0;
            int[][][] novaMatriz = new int[dimensaoX][dimensaoY][dimensaoZ];

            for (int x = 0; x < dimensaoX; x++) {
                for (int y = 0; y < dimensaoY; y++) {
                    for (int z = 0; z < dimensaoZ; z++) {
                        int valor = calcularNovoValor(x, y, z);
                        novaMatriz[x][y][z] = valor;

                        if (valor > maiorValor) {
                            maiorValor = valor;
                        }
                    }
                }
            }

            matriz = novaMatriz;
            ciclos++;
            imprimirMatriz();
        } while (maiorValor >= limiteResfriamento);

        System.out.println("Ciclos de resfriamento: " + ciclos);
    }

    private int calcularNovoValor(int x, int y, int z) {
        int acima = (x > 0) ? matriz[x - 1][y][z] : 10;
        int abaixo = (x < dimensaoX - 1) ? matriz[x + 1][y][z] : 10;
        int esquerda = (y > 0) ? matriz[x][y - 1][z] : 10;
        int direita = (y < dimensaoY - 1) ? matriz[x][y + 1][z] : 10;
        int frente = (z > 0) ? matriz[x][y][z - 1] : 10;
        int fundo = (z < dimensaoZ - 1) ? matriz[x][y][z + 1] : 10;
        int centro = matriz[x][y][z];

        return (acima + abaixo + esquerda + direita + frente + fundo + centro) / 7;
    }

    private void imprimirMatriz() {
        for (int x = 0; x < dimensaoX; x++) {
            for (int y = 0; y < dimensaoY; y++) {
                for (int z = 0; z < dimensaoZ; z++) {
                    System.out.print(matriz[x][y][z] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    public static void main(String[] args) {
        int cubo = 5;
        int limiteResfriamento = 100;

        Bloco bloco = new Bloco(cubo, cubo, cubo, limiteResfriamento);
        bloco.resfriarBloco();
    }
}

import java.util.Random;

class Sapinho extends Thread {
    private String nome;
    private int distanciaPercorrida;
    private int numeroPulos;
    public static final int distanciaTotal = 100;

    public Sapinho(String nome) {
        this.nome = nome;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public int getNumeroPulos() {
        return numeroPulos;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            while (!isInterrupted()) {
                int pulo = random.nextInt(5) + 1; // Gera um número aleatório entre 1 e 5
                distanciaPercorrida += pulo;
                numeroPulos++;
                System.out.println(nome + " pulou " + pulo + " e percorreu " + distanciaPercorrida + "cm.");

                if (distanciaPercorrida >= distanciaTotal) {
                    break;
                }

                Thread.sleep(100); // Tempo de espera entre cada pulo
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " foi interrompido.");
        }
    }
}
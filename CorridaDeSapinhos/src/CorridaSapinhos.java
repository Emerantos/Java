import java.util.ArrayList;
import java.util.List;

public class CorridaSapinhos {
    public static void main(String[] args) {
        // Criação dos sapinhos
        List<Sapinho> sapinhos = new ArrayList<>();
        sapinhos.add(new Sapinho("Sapinho 0"));
        sapinhos.add(new Sapinho("Sapinho 1"));
        sapinhos.add(new Sapinho("Sapinho 2"));
       /* sapinhos.add(new Sapinho("Sapinho 3"));
        sapinhos.add(new Sapinho("Sapinho 4"));
        sapinhos.add(new Sapinho("Sapinho 5"));
        sapinhos.add(new Sapinho("Sapinho 6"));
        sapinhos.add(new Sapinho("Sapinho 7"));
        sapinhos.add(new Sapinho("Sapinho 8"));
        sapinhos.add(new Sapinho("Sapinho 9"));*/

        // Início da corrida
        for (Sapinho sapinho : sapinhos) {
            sapinho.start();
        }

        // Espera até que um sapinho vença
        boolean corridaTerminada = false;
        while (!corridaTerminada) {
            for (Sapinho sapinho : sapinhos) {
                if (sapinho.getDistanciaPercorrida() >= Sapinho.distanciaTotal) {
                    sapinho.interrupt();
                    corridaTerminada = true;
                    break;
                }
            }
        }

        // Verifica e mostra o resultado
        System.out.println("\nCorrida terminada!");
        Sapinho vencedor = null;
        for (Sapinho sapinho : sapinhos) {
            System.out.println(sapinho.getNome() + " percorreu " + sapinho.getDistanciaPercorrida() + " em " + sapinho.getNumeroPulos() + " pulos.");
            if (vencedor == null || sapinho.getDistanciaPercorrida() > vencedor.getDistanciaPercorrida()) {
                vencedor = sapinho;
            }
        }


 
        System.out.println("\nO " + vencedor.getNome() + " venceu a corrida!");
        System.out.println("Distancia percorrida: " + vencedor.getDistanciaPercorrida() + " ");
        System.out.println("Numero de pulos: " + vencedor.getNumeroPulos());
        
        // Encerra o programa
        System.exit(0);
    }
}

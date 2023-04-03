import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EscalonadorSJF {
    private PriorityQueue<Processo> filaDeProcessos;
    private List<Processo> listaDeProcessos;
    private int tempoTotalDeExecucao;
    private int tempoTotalDeEspera;
    private int tempoTotalDeRetorno;

    public EscalonadorSJF() {
        filaDeProcessos = new PriorityQueue<Processo>(new Comparator<Processo>() {
            @Override
            public int compare(Processo p1, Processo p2) {
                return p1.getTempoExecucao() - p2.getTempoExecucao();
            }
        });
        listaDeProcessos = new ArrayList<Processo>();
        tempoTotalDeExecucao = 0;
        tempoTotalDeEspera = 0;
        tempoTotalDeRetorno = 0;
    }

    public void adicionarProcesso(Processo processo) {
        filaDeProcessos.add(processo);
        listaDeProcessos.add(processo);
    }

    public void executar() {
        int tempoAtual = 0;

        while (!filaDeProcessos.isEmpty()) {
            Processo processoAtual = filaDeProcessos.poll();

            processoAtual.setTempoEspera(tempoAtual - processoAtual.getTempoChegada());
            tempoAtual += processoAtual.getTempoExecucao();
            processoAtual.setTempoRetorno(tempoAtual - processoAtual.getTempoChegada());

            tempoTotalDeExecucao += processoAtual.getTempoExecucao();
            tempoTotalDeEspera += processoAtual.getTempoEspera();
            tempoTotalDeRetorno += processoAtual.getTempoRetorno();
        }
    }

    public void imprimirEstatisticas() {
        int numeroDeProcessos = listaDeProcessos.size();
        double tempoMedioDeEspera = (double) tempoTotalDeEspera / numeroDeProcessos;
        double tempoMedioDeRetorno = (double) tempoTotalDeRetorno / numeroDeProcessos;

        System.out.println("Tempo médio de espera: " + tempoMedioDeEspera);
        System.out.println("Tempo médio de retorno: " + tempoMedioDeRetorno);
    }
}

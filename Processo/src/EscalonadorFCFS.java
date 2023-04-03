import java.util.ArrayList;

public class EscalonadorFCFS {
    private ArrayList<Processo> listaProcessos;
    private int tempoCorrente;

    public EscalonadorFCFS() {
        this.listaProcessos = new ArrayList<>();
        this.tempoCorrente = 0;
    }

    public void adicionarProcesso(Processo processo) {
        listaProcessos.add(processo);
    }

    public void executar() {
        for (Processo processo : listaProcessos) {
            // Calcular o tempo de espera e o tempo de retorno do processo
            processo.setTempoEspera(tempoCorrente - processo.getTempoChegada());
            processo.setTempoRetorno(processo.getTempoEspera() + processo.getTempoExecucao());

            // Atualizar o tempo corrente
            tempoCorrente += processo.getTempoExecucao();
        }
    }

    public void imprimirEstatisticas() {
        // Calcular o tempo médio de espera e o tempo médio de retorno
        double tempoMedioEspera = 0;
        double tempoMedioRetorno = 0;

        for (Processo processo : listaProcessos) {
            tempoMedioEspera += processo.getTempoEspera();
            tempoMedioRetorno += processo.getTempoRetorno();
        }

        tempoMedioEspera /= listaProcessos.size();
        tempoMedioRetorno /= listaProcessos.size();

        // Imprimir as estatísticas
        System.out.println("Tempo médio de espera: " + tempoMedioEspera);
        System.out.println("Tempo médio de retorno: " + tempoMedioRetorno);
    }
}

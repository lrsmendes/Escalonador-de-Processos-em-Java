public class Main {
    public static void main(String[] args) {
        // Criar alguns processos para testar o escalonador FCFS
        Processo p1 = new Processo("1", 0, 5);
        Processo p2 = new Processo("2", 2, 3);
        Processo p3 = new Processo("3", 4, 1);

        // Criar um escalonador FCFS e adicionar os processos
        EscalonadorFCFS escalonadorFCFS = new EscalonadorFCFS();
        escalonadorFCFS.adicionarProcesso(p1);
        escalonadorFCFS.adicionarProcesso(p2);
        escalonadorFCFS.adicionarProcesso(p3);

        // Executar o escalonador FCFS e imprimir as estatísticas
        escalonadorFCFS.executar();
        escalonadorFCFS.imprimirEstatisticas();

        // Criar alguns processos para testar o escalonador SJF
        Processo p4 = new Processo("4", 0, 4);
        Processo p5 = new Processo("5", 1, 3);
        Processo p6 = new Processo("6", 2, 1);

        // Criar um escalonador SJF e adicionar os processos
        EscalonadorSJF escalonadorSJF = new EscalonadorSJF();
        escalonadorSJF.adicionarProcesso(p4);
        escalonadorSJF.adicionarProcesso(p5);
        escalonadorSJF.adicionarProcesso(p6);

        // Executar o escalonador SJF e imprimir as estatísticas
        escalonadorSJF.executar();
        escalonadorSJF.imprimirEstatisticas();
    }
}

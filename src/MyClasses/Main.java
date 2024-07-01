package MyClasses;

import MyClasses.ListaFuncionarios;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ListaFuncionarios listaFunc = new ListaFuncionarios();

        // ideal seria criar um método que recebe uma estrutura de dados com os dados dos funcionários a serem adicionados
        // e adiciona-os sequencialmente
        listaFunc.cadastrarFuncionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador");
        listaFunc.cadastrarFuncionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador");
        listaFunc.cadastrarFuncionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador");
        listaFunc.cadastrarFuncionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor");
        listaFunc.cadastrarFuncionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista");
        listaFunc.cadastrarFuncionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador");
        listaFunc.cadastrarFuncionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador");
        listaFunc.cadastrarFuncionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente");
        listaFunc.cadastrarFuncionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista");
        listaFunc.cadastrarFuncionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), "Gerente");

        listaFunc.excluirFuncionario("João");

        listaFunc.aplicarAumentoSalarial(10);

        listaFunc.imprimirListaFuncionarios();

        listaFunc.imprimirListaFuncionariosPorFuncao();

        listaFunc.imprimirAniversariantesPorMes(10);
        listaFunc.imprimirAniversariantesPorMes(12);

        listaFunc.imprimirFuncionarioMaisVelho();

        listaFunc.imprimirNumSalariosMinimos(1212.00);

        listaFunc.imprimirTotalSalarios();

        listaFunc.imprimirListaAlfabeticaFuncionarios();

        listaFunc.imprimirListaFuncionarios();
    }
}
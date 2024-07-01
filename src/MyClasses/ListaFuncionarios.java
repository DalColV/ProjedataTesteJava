package MyClasses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

public class ListaFuncionarios
{
    private ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

    public void cadastrarFuncionario(String nome, LocalDate dataNasc, BigDecimal salario, String funcao) {
        // para melhorar pode-se colocar aqui um validador de parâmetros: nome, dataNasc, salario, funcao
        Funcionario obj_Funcionario = new Funcionario(nome, dataNasc, salario, funcao);
        lista.add(obj_Funcionario);
    }

    public void excluirFuncionario(String nome) {
        for (Funcionario f: lista) {
            // Remove apenas a primeira ocorrência de "nome"
            if (f.getNome() == nome)
            {
                lista.remove(f);
                return; // Sai do loop for se o usuário foi encontrado e deletado
            }
        }
        // Só é executado após o loop for
        System.out.println("Nenhum usuário encontrado com o nome " + nome);
    }

    private void imprimirFuncionario(Funcionario funcionario) {
        // formatar data de nascimento
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = funcionario.getDataNasc().format(formatter);

        // formatar moeda (salário)
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        String formattedSalario = numberFormatter.format(funcionario.getSalario());

        System.out.println(funcionario.getNome() + ", " + formattedDate + ", " + formattedSalario + ", " + funcionario.getFuncao());
    }

    public void imprimirListaFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario f: lista) {
            imprimirFuncionario(f);
        }
    }

    public void imprimirListaFuncionariosPorFuncao() {
        // cria um conjunto com as funções existentes
        HashSet<String> funcoes = new HashSet<>();
        for (Funcionario f: lista) {
            funcoes.add(f.getFuncao());
        }

        // criar um hashmap vazio
        // chave - nome da função
        // valor - lista de funcionários que desempenham tal função
        HashMap<String, ArrayList<Funcionario>> hashMap = new HashMap<>();

        // para cada função existente
        for (String funcao: funcoes) {
            // cria uma lista vazia de funcionários
            ArrayList<Funcionario> funcionarios_que_executam_a_funcao = new ArrayList<>();

            // buscar por funcionários que executam a função
            // este loop pode ser melhorado (lembrado quais funcionários já foram colocados na lista)
            for (Funcionario f: lista) {
                if (f.getFuncao() == funcao)
                {
                    funcionarios_que_executam_a_funcao.add(f);
                }
            }

            // salvar a lista de funcionários que executam a função
            hashMap.put(funcao, funcionarios_que_executam_a_funcao);
        }

        // imprimir o hashmap
        for (String funcao: hashMap.keySet())
        {
            System.out.println("Funcionários que desempenham a função " + funcao);
            ArrayList<Funcionario> lista_de_funcionario = hashMap.get(funcao);
            for (Funcionario f: lista_de_funcionario) {
                imprimirFuncionario(f);
            }
        }
    }

    public void aplicarAumentoSalarial(double percentualAumento) {
        // Percentual decimal de aumento
        percentualAumento = 1 + (percentualAumento/100); // double
        // Criando um BigDecimal do valor percentual de aumento decimal a partir do double da linha anterior
        BigDecimal percentual = BigDecimal.valueOf(percentualAumento);

        // Será aplicado a cada objeto funcionário dentro da lista
        for (Funcionario f: lista) {
            BigDecimal salarioAntigo = f.getSalario();
            // novo salário será multiplicado pelo percentual decimal calculado
            BigDecimal novoSalario = salarioAntigo.multiply(percentual);
            f.setSalario(novoSalario);
        }
    }

    public void imprimirAniversariantesPorMes(int mes) {
        System.out.println("Aniversariante(s) do mês " + mes);
        for (Funcionario f: lista) {
            int mesAniversario = f.getDataNasc().getMonth().getValue();
            if (mesAniversario == mes) {
                imprimirFuncionario(f);
            }
        }
    }

    public void imprimirFuncionarioMaisVelho() {
        Funcionario maisVelho = null;
        int idadeMaisVelho = 0;

        LocalDate DataAtual = LocalDate.now();
        for (Funcionario f: lista) {
            int idade = DataAtual.compareTo(f.getDataNasc());
            // Se já existe uma idade
            if (idadeMaisVelho != 0) {
                // se a idade atual é maior que a antiga idade
                if (idade > idadeMaisVelho) {
                    idadeMaisVelho = idade;
                    maisVelho = f;
                }
                // se não existe uma idade
            } else {
                idadeMaisVelho = idade;
                maisVelho = f;
            }
        }

        if (maisVelho != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = maisVelho.getDataNasc().format(formatter);

            System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", " + formattedDate);
        }

    }

    public void imprimirTotalSalarios() {
        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario f: lista) {
            total = total.add(f.getSalario());
        }

        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        String formattedTotal = numberFormatter.format(total);
        System.out.println("Salário total dos funcionários: " + formattedTotal);
    }

    public void imprimirNumSalariosMinimos(double valorSalarioMinimo) {
        BigDecimal salarioMinimo = BigDecimal.valueOf(valorSalarioMinimo);
        System.out.println("Número de salários mínimos por funcionário");
        for (Funcionario f: lista) {
            BigDecimal numSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.DOWN);
            System.out.println(f.getNome() + ", " + numSalariosMinimos + " salários mínimos");
        }
    }

    public void imprimirListaAlfabeticaFuncionarios() {
        lista.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("Lista de funcionários em ordem alfabética");
        for (Funcionario f: lista) {
            imprimirFuncionario(f);
        }
    }
}

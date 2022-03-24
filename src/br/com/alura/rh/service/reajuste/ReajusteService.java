package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getDadosPessoais().getSalario();

        validacoes.forEach(v -> v.validar(funcionario, aumento));

        BigDecimal salarioReajustado = salarioAtual.add(aumento);

        funcionario.atualizarSalario(salarioReajustado);
    }

}

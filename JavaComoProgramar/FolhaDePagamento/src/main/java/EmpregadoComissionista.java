public class EmpregadoComissionista extends Empregado {
    private double vendasBrutas; // Vendas brutas semanais
    private double porcentagemComissao; // Porcentagem de comissão

    // Construtor
    public EmpregadoComissionista(String nome,
                                  String sobrenome,
                                  String numeroDeSeguroSocial,
                                  double vendasBrutas,
                                  double porcentagemComissao)
    {
        super(nome, sobrenome, numeroDeSeguroSocial);
        // Tratamento de exceção:
        if (porcentagemComissao <=0.0 || porcentagemComissao >= 1.0 ) // validador de porcentagem de comissão
            throw new IllegalArgumentException(
                    " A porcentagem de Comissão deve flutuar entre 0 e 1 " );
        if (vendasBrutas < 0.0) // valida o valor bruto das vendas
            throw new IllegalArgumentException(
                    " O valor bruto das vendas deve ser maior ou igual a 0 ");

        this.porcentagemComissao = porcentagemComissao;
        this.vendasBrutas = vendasBrutas;
    }

    // Configura a porcentagem de comissão:
    public void setPorcentagemComissao(double porcentagemComissao)
    {
        if (porcentagemComissao <=0.0 || porcentagemComissao >= 1.0 ) // validador de porcentagem de comissão
            throw new IllegalArgumentException(
                    " A porcentagem de Comissão deve flutuar entre 0 e 1 " );
    }
    // Retorna a porcentagem de comissão:
    public double getPorcentagemComissao()
    {
        return porcentagemComissao;
    }

    // Configura o valor bruto das vendas:
    public void setVendasBrutas()
    {
        if (vendasBrutas < 0.0) // valida o valor bruto das vendas
            throw new IllegalArgumentException(
                    " O valor bruto das vendas deve ser maior ou igual a 0 ");
    }
    // Retorna o valor bruto das vendas:
    public double getVendasBrutas()
    {
        return vendasBrutas;
    }

    // Cálcula os rendimentos: sobrescreve o método ganhos na classe Empregado:
    @Override
    public double ganhos()
    {
        return getPorcentagemComissao() * getVendasBrutas();
    }
    // Retorna a representação String do objeto EmpregadoComissionista:
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%, .2f; %s: %.2f",
                "Empregado Comissionista", super.toString(),
                "Valor bruto de vendas", getVendasBrutas(),
                "Taxa de comissão", getPorcentagemComissao());
    }
}

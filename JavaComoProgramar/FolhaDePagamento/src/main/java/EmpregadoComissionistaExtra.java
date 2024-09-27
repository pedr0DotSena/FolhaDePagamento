public class EmpregadoComissionistaExtra extends EmpregadoComissionista{
    private double salarioBase; // salário semanal base

    public EmpregadoComissionistaExtra(String nome,
                                       String sobrenome,
                                       String numeroDeSeguroSocial,
                                       double vendasBrutas,
                                       double porcentagemComissao,
                                       double salarioBase)
    {
        super(nome, sobrenome, numeroDeSeguroSocial, vendasBrutas, porcentagemComissao);

        if (salarioBase < 0.0) // validador de salário semanal base
            throw new IllegalArgumentException(" O salário base deve ser maior ou igual a 0");

        this.salarioBase = salarioBase;
    }

    // Configura o salário-base
    public void setSalarioBase(double salarioBase)
    {
        if (salarioBase < 0.0) // validador de salário semanal base
            throw new IllegalArgumentException(" O salário base deve ser maior ou igual a 0");

        this.salarioBase = salarioBase;
    }
    // Retorna o salário-base:
    public double getSalarioBase()
    {
        return salarioBase;
    }

    // Calcula os vencimentos: sobrescreve o método ganhos em EmpregadoComissionista:
    @Override
    public double ganhos()
    {
        return getSalarioBase() + super.ganhos();
    }
    // Retorna a representação String do objeto EmpregadoComissionistaExtra:
    @Override
    public String toString()
    {
        return String.format("%s %s: %s: $%, .2f",
                "Empregado extra comissionado", super.toString(),
                "Salário base", getSalarioBase());
    }
}

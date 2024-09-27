public class EmpregadoAssalariado extends Empregado {

    private double salarioSemanal;

    // Construtor:
    public EmpregadoAssalariado(
            String nome,
            String sobrenome,
            String numeroDeSeguroSocial,
            double salarioSemanal)
    {
        super(nome, sobrenome, numeroDeSeguroSocial);

        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException(
                    "O salário semanal deve ser maior ou igual a 0");
        this.salarioSemanal = salarioSemanal;
    }

    // Configuração do salário semanal:
    public void setSalarioSemanal(double salarioSemanal){
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException(
                    "Salário semanal deve ser maior ou igual a 0");
        this.salarioSemanal = salarioSemanal;
    }

    // Retorna o salário semanal:
    public double getSalarioSemanal(){
        return salarioSemanal;
    }

    // Calcula os rendimentos: sobrescreve o método ganhos em Empregado:
    @Override
    public double ganhos() {
        return getSalarioSemanal();
    }

    // Retorna a representação String do objeto EmpregadoAssalariado:
    @Override
    public String toString()
    {
        return String.format(("Empregado assalariado: %s%n%s: $%, .2f"),
        super.toString(), "salário semanal", getSalarioSemanal());
    }
}

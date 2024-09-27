// Esta é uma subclasse concreta qual me refiro ao trabalhador remunerado por hora/trabalho;
public class EmpregadoHorista extends Empregado{
    private double salarioHora; // Salário por hora
    private double horasTrabalho; // Horas trabalhadas durante a semana

    // Construtor:

    public EmpregadoHorista(String nome,
                            String sobrenome,
                            String numeroDeSeguroSocial,
                            double salarioHora,
                            double horasTrabalho)
    {
        super(nome, sobrenome, numeroDeSeguroSocial);

        // Tratamento de exceção:
        if (salarioHora < 0.0) // validador da remuneração: Valor deve ser superior a 0
            throw new IllegalArgumentException(
                    " A remuneração por hora deve ser maior ou igual a 0. ");
        if ((horasTrabalho < 0.0) ||(horasTrabalho > 168.0)) // validador de horas: Valor deve flutuar entre 0 e 168
            throw new IllegalArgumentException(
                    " O valor de horas trabalhadas deve ser maior ou igual a 0, e menor ou igual a 168. ");

        this.salarioHora = salarioHora;
        this.horasTrabalho = horasTrabalho;
    }

    // Configura a remuneração:
    public void setSalarioHora(double salarioHora){
        if (salarioHora < 0.0) // validador da remuneração: Valor deve ser superior a 0
            throw new IllegalArgumentException(
                    " A remuneração por hora deve ser maior ou igual a 0. ");
        this.salarioHora = salarioHora;
    }
    // Retorna a remuneração:
    public double getSalarioHora(){
        return salarioHora;
    }

    // Configura as horas trabalhadas:
    public void setHorasTrabalho(double horasTrabalho){
        if ((horasTrabalho < 0.0) ||(horasTrabalho > 168.0)) // validador de horas: Valor deve flutuar entre 0 e 168
            throw new IllegalArgumentException(
                    " O valor de horas trabalhadas deve ser maior ou igual a 0, e menor ou igual a 168. ");
        this.horasTrabalho = horasTrabalho;
    }
    // Retorna as horas trabalhadas:
    public double getHorasTrabalho(){
        return horasTrabalho;
    }

    // Calcula os rendimentos: sobrescreve o método ganhos em Empregado:
    @Override
    public double ganhos() {
        if (getHorasTrabalho() <=44) // Nenhuma hora extra de produção
            return getSalarioHora() * getHorasTrabalho();
        else
            return 44 * getSalarioHora() + (getHorasTrabalho() - 44) * getSalarioHora() * 1.5;
    }

    // Retorna a representação String do objeto EmpregadoHorista:
    @Override
    public String toString()
    {
     return String.format
                    (" Empregado horista: %s%n%s: $%, .2f; %s, %, .2f",
                     super.toString(),
                     " Remuneração por hora ", getSalarioHora(),
                     " Horas Trabalhadas ", getHorasTrabalho());
    }
}

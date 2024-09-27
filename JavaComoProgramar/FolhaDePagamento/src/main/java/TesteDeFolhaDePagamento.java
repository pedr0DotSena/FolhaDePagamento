public class TesteDeFolhaDePagamento {
    public static void main (String[] args)
    {
        // Criando objetos da subclasse
        EmpregadoAssalariado empregadoAssalariado =
                new EmpregadoAssalariado(
                        "Tasha",
                        "Tracie",
                        "1660-555-888",
                        800.00);
        EmpregadoHorista empregadoHorista =
                new EmpregadoHorista(
                        "Zubumafu",
                        "Fi",
                        "7777-777-777",
                        16.00,
                        44);
        EmpregadoComissionista empregadoComissionista =
                new EmpregadoComissionista(
                        "Igor",
                        "Kanario",
                        "2770-000-000",
                        790,
                        .06);
        EmpregadoComissionistaExtra empregadoComissionistaExtra =
                new EmpregadoComissionistaExtra(
                        "Pedro",
                        "Henrique Gold",
                        "6969-171-100",
                        1200,
                        .04,
                        250);

        System.out.println("Trabalhadores: ");
        System.out.printf(
                "%n%s%n%s: $%,.2f%n%n",
                empregadoAssalariado, "recebe",
                empregadoAssalariado.ganhos());
        System.out.printf(
                "%s%n%s: $%, .2f%n%n",
                empregadoHorista, "recebe",
                empregadoHorista.ganhos());
        System.out.printf(
                "%s%n%s: $%, .2f%n%n",
                empregadoComissionista, "recebe",
                empregadoComissionista.ganhos());
        System.out.printf("%s%n%s: $%, .2f%n%n",
                empregadoComissionistaExtra, "recebe",
                empregadoComissionistaExtra.ganhos());

        // Criando um array Empregados, com as 4 subclasses:
        Empregado[] empregados = new Empregado[4];
        // Inicializa o array os empregados:
        empregados[0] = empregadoAssalariado;
        empregados[1] = empregadoHorista;
        empregados[2] = empregadoComissionista;
        empregados[3] = empregadoComissionistaExtra;

        System.out.printf(" Trabalhadores polimorficamente processados:%n%n");

        // Processando genericamente cada elemento em Empregados
        for (Empregado atualEmpregado : empregados)
        {
            System.out.println(atualEmpregado); // chama toString

            // Determina se o elemento é empregadoComissionistaExtra:
            if (atualEmpregado instanceof EmpregadoComissionistaExtra empregado)
            {
            // downcast da referência de Empregados para referência a EmpregadoComissionistaExtra:
                empregado.setSalarioBase(1.10 * empregado.getSalarioBase());

            System.out.printf(
                    "Novo salário base com 10%% de adicional é: $%, .2f%n",
                    empregado.getSalarioBase());

            System.out.printf(
                    "$%,.2f%n%n", atualEmpregado.ganhos());
        }
            // Consegue o nome dos tipos de cada objeto no array:
            for (int j = 0; j < empregados.length; j++)
                System.out.printf("O empregado %d é um %s%n", j,
                        empregados[j].getClass().getName());
        }

    }
}

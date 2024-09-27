 // Método abstrato para estudo de caso de polimorfismo.
public abstract class Empregado {
    private final String nome;
    private final String sobrenome;
    private final String numeroDeSeguroSocial;

     public Empregado(String nome, String sobrenome, String numeroDeSeguroSocial) {
         this.nome = nome;
         this.sobrenome = sobrenome;
         this.numeroDeSeguroSocial = numeroDeSeguroSocial;
     }

     public String getNome() {
         return nome;
     }

     public String getSobrenome() {
         return sobrenome;
     }

     public String getNumeroDeSeguroSocial() {
         return numeroDeSeguroSocial;
     }

     // Retorna representação de String do objeto Empregado:
     @Override
     public String toString(){
         return String.format("%s %s%nNumero de Seguro Social: %s",
                 getNome(),
                 getSobrenome(),
                 getNumeroDeSeguroSocial());
     }

     // O método abstrato será sobrescrito pelas subclasses concretas.
     public abstract double ganhos(); // nenhuma implementação na classe abstrata!
 }

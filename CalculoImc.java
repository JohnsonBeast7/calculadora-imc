import java.util.Scanner;

public class CalculoImc {
    public static void main(String[] args) {
        Scanner lerTeclado = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = lerTeclado.nextLine();
        System.out.println("Digite seu sexo (M, F ou N): ");
        char genero = Character.toUpperCase(lerTeclado.next().charAt(0));
        System.out.println("Digite sua altura (metros): ");
        double altura = lerTeclado.nextDouble();
        System.out.println("Digite seu peso (kg): ");
        double peso = lerTeclado.nextDouble();
        
        if(peso <= 0 || altura <= 0 || nome.isEmpty() || (genero != 'M' && genero != 'F' && genero != 'N')){
            System.out.println("Digite um valor válido");
            return; 
        }
        
        double resultadoCalculoImc = CalculoImc.calcularImc(peso, altura);

        String resultadoFinalImc = CalculoImc.classificarImc(genero, resultadoCalculoImc);

        System.out.printf("%s, seu IMC é %.2f\nO resultado final é %s", nome, resultadoCalculoImc, resultadoFinalImc);
    }

    static double calcularImc(double peso, double altura) {
        return peso/(altura * altura);
    }

    static String classificarImc(char genero, double resultadoImc) {
        return switch (genero) {
            case 'M':
                if(resultadoImc >= 40){
                    yield "Obesidade Mórbida";
                } else if (resultadoImc >= 30) {
                    yield "Obesidade Moderada";
                } else if (resultadoImc >= 25) {
                    yield "Obesidade Leve";
                } else if (resultadoImc >= 20) {
                    yield "Normal";
                } else {
                    yield "Abaixo do Normal";
                }
            case 'F':
                if(resultadoImc >= 39){
                    yield "Obesidade Mórbida";
                } else if (resultadoImc >= 29) {
                    yield "Obesidade Moderada";
                } else if (resultadoImc >= 24) {
                    yield "Obesidade Leve";
                } else if (resultadoImc >= 19) {
                    yield "Normal";
                } else {
                    yield "Abaixo do Normal";
                }
            case 'N':
                if(resultadoImc >= 39){
                    yield "Obesidade Mórbida";
                } else if (resultadoImc >= 29) {
                    yield "Obesidade Moderada";
                } else if (resultadoImc >= 24) {
                    yield "Obesidade Leve";
                } else if (resultadoImc >= 19) {
                    yield "Normal";
                } else {
                    yield "Abaixo do Normal";
                }
            default:
                yield "Desconhecido";
        };
    }
}

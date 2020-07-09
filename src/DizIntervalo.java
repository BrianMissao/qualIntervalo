import java.util.Scanner;

public class DizIntervalo {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Qual é o intervalo?");
        double numeroDoUsuario = obterNumeroDoUsuario("Digite um número no (ex: 0,25):");
        calcularEImprimirIntervalo(numeroDoUsuario);
    }

    private static void calcularEImprimirIntervalo(double numeroDoUsuario) {
        double intervalo = 0.0;
        if (pertenceAoIntervalo(0.25, numeroDoUsuario)) {
            intervalo = 0.25;
        } else if (pertenceAoIntervalo(25.50, numeroDoUsuario)) {
            intervalo = 25.50;
        } else if (pertenceAoIntervalo(50.75, numeroDoUsuario)) {
            intervalo = 50.75;
        } else if (pertenceAoIntervalo(75.100, numeroDoUsuario)) {
            intervalo = 75.100;
        } else {
            System.out.println("Fora de intervalo.");
            return;
        }
        String numeroDeCasas = intervalo == 75.100 ? "%.3f" : "%.2f";
        System.out.printf("Intervalo: "+numeroDeCasas, intervalo);
    }

    private static double obterNumeroDoUsuario(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextDouble();
    }

    private static boolean pertenceAoIntervalo(double intervalo, double numeroAVerificar) {
        double primeiroValorDoProximoIntervalo = Math.round(intervalo)+25.1;
        return (numeroAVerificar == intervalo || (numeroAVerificar < primeiroValorDoProximoIntervalo && numeroAVerificar >= 0));
    }
}

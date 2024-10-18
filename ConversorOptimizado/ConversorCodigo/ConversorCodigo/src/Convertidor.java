import java.util.InputMismatchException;
import java.util.Scanner;

public class Convertidor {
    public static void conversion(String monedaBase, String monedaTarget , ConsultaCurrency consulta, Scanner lectura) {
        boolean continuar;
        double cantidad;
        double cantidadConvertida;

        MonedaAconvertir moneda = consulta.buscarTasaDeConversion(monedaBase, monedaTarget);

        System.out.println("Ingrese la cantidad a convertir");
        do{

            try {continuar=false;
                cantidad = lectura.nextDouble();
                cantidadConvertida = cantidad * moneda.conversion_rate();
                String val1 = String.format("%.2f", cantidadConvertida);

                System.out.println("Ud requirio convertir " + cantidad + " " + monedaBase + " a " + monedaTarget + " El resultado es: " + val1 + " " + monedaTarget);
            } catch (InputMismatchException ime) {
                System.out.println("solo puedes insetar numeros");
                System.out.println("Ingrese la cantidad a convertir");
                lectura.nextLine();
                continuar=true;
            }}
        while (continuar);
    }
}

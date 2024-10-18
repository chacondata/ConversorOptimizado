import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> currencies = new ArrayList<>();
        currencies.add("ARS");
        currencies.add("BRL");
        currencies.add("COP");
        currencies.add("JPY");
        currencies.add("MXN");
        currencies.add("USD");
        currencies.add("EUR");

        Scanner lectura = new Scanner(System.in);

        boolean existe = false;
        boolean existeOtro = false;
        int controlSalida;

        try {
            do {
                System.out.println("""
                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Bienvenido al Conversor de Monedas.
                        Ud puede realizar conversiones en tiempo real desde y hacia cualquiera de las monedas
                        listadas a continuacion utilizando los codigos mostrados:
                        
                        Peso Argentino           ARS
                        Real Brasileño           BRL
                        Peso Colombiano          COP
                        Euro                     EUR
                        Yen Japones              JPY
                        Peso Mexicano            MXN
                        Dolar Estadounidense     USD
                        
                        Pulse "1" para comenzar. Pulse "2" para salir.
                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        """);

                controlSalida = lectura.nextInt();

                if (controlSalida == 1) {

                    lectura = new Scanner(System.in);

                    System.out.println("Por favor introduzca el codigo de la moneda que desea convertir: ");
                    String monedaBase = lectura.nextLine().toUpperCase();
                    existe = currencies.contains(monedaBase);

                    System.out.println(" Por favor introduzca el codigo de la moneda destino:");
                    String monedaTarget = lectura.nextLine().toUpperCase();
                    existeOtro = currencies.contains(monedaTarget);

                    if (existe && existeOtro != false) {

                        ConsultaCurrency consulta = new ConsultaCurrency();
                        MonedaAconvertir monedaAconvertir = consulta.buscarTasaDeConversion(monedaBase, monedaTarget);
                        //System.out.println(monedaAconvertir);
                        Convertidor.conversion(monedaBase, monedaTarget, consulta, lectura);
                        System.out.println("Si desea seguir utilizando el conversor digite 1 o pulse 2 para salir");
                        controlSalida = lectura.nextInt();
                    } else {
                        System.out.println("Codigo no valido");
                        System.out.println("Si desea seguir utilizando el conversor digite 1 o pulse 2 para salir");
                        controlSalida = lectura.nextInt();
                    }
                } else if (controlSalida == 2) {
                } else {
                    System.out.println("Por favor introduzca 1 o 2");
                }
            } while (controlSalida != 2);
        }catch (InputMismatchException ime){
            System.out.println("Solo se aceptan las opciones 1 y 2");}

        System.out.println("Gracias por usar el conversor");
    }
}
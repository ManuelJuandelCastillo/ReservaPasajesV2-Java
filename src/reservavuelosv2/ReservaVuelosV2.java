/*
una compania de vuelos cuenta con 6 destinos 
a los que realiza 3 vuelos diarios (manana, mediodia, noche).

Se necesita un programa que permita la carga de los asientos disponibles para cada vuelo.

Permitir al ussuario ingresar numero de destino, numero de horario de vuelo
y cantidad de asientos que quiere reservar.

El programa debe controlar si hay la cantidad de asientos solicitados
y comunicar el exito de la reserva o la no realizacion por falta de asientos disponibles

La compania no puede saber cuantas personas van a reservar pasajes en un dia dado
por lo tanto para salir del programa se ingresa la palabra finish
*/
package reservavuelosv2;
import java.util.Scanner;

public class ReservaVuelosV2 {

    public static void main(String[] args) {
        // declaracion entradas
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaStr = new Scanner(System.in);
        
        // vector de destinos
        String destinos[] = {"Rio de Janeiro","Cancun","Madrid","Roma","Milan","Iguazu"};
        
        // matriz de asientos disponibles
        int asientosDisponibles[][] = new int[6][3];
        
        // variables a usar 
        String destino;
        int indiceDestino = -1, horario, asientos;
        boolean bandera = false;
        
        // carga inicial
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("         Inicio de sistema");
        System.out.println(" Carga inicial de asientos disponibles");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        
        for (int i = 0; i < destinos.length; i++) {
            System.out.println("vuelos con destino " + destinos[i]);
            System.out.println("0: manana. 1: mediodia. 2: noche.");
            for (int j = 0; j < 3; j++) {
                System.out.println("Ingrese asientos disponibles para vuelo "+j);
                asientosDisponibles[i][j] = entradaInt.nextInt();   
            }
            System.out.println("**************************************");
        }
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("         Sistema de reservas");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        
        while (true) {
            
            do {
                System.out.println("Seleccione el destino:");
                for (int i = 0; i < destinos.length; i++) {
                    System.out.println(i+": "+destinos[i]);
                }
                destino = entradaStr.nextLine();
                
                if (destino.equalsIgnoreCase("finish")) {
                break;
                }
                try {
                    indiceDestino = Integer.parseInt(destino);
                    bandera = false;
                    if (indiceDestino<0 || indiceDestino>6){
                        bandera = true;
                        System.out.println("Codigo incorrecto");
                    }
                } catch (Exception e) {
                    bandera = true;
                    System.out.println("Codigo incorrecto.");
                }
                
            } while (bandera);
            
            if (destino.equalsIgnoreCase("finish")) {
                break;
            }
            
            
            
            System.out.println("Seleccione el horario:");
            System.out.println("0: manana");
            System.out.println("1: mediodia");
            System.out.println("2: noche");
            horario = entradaInt.nextInt();
            
            System.out.println("Indique cantidad de asientos a reservar:");
            asientos = entradaInt.nextInt();
            
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            if(asientos <= asientosDisponibles[indiceDestino][horario]) {
                asientosDisponibles[indiceDestino][horario] -= asientos;
                System.out.println("Su reserva fue realizada con exito.");
            }
            else {
                System.out.println("Disculpe, no se pudo realizar su operacion\ndado que no hay asientos disponibles");
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            
        }
    }
    
}

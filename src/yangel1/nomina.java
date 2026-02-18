import java.util.Scanner;

public class nomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int maxPersonas = 10;
        String[][] datos = new String[maxPersonas][15]; 
        int contador = 0; 
        int opcion;

        do {
            System.out.println("\n********************************************************");
            System.out.println("* Yangel Batista #19 5toE");
            System.out.println("* SISTEMA DE GESTIÓN EMPRESARIAL        *");
            System.out.println("* CHEBERLAIN S.R.L.                     *");
            System.out.println("********************************************************");
            System.out.println("1. Registrar Nuevo Colaborador");
            System.out.println("2. Generar Reporte de Nómina Operativa");
            System.out.println("3. Finalizar Sesión");
            System.out.print("\nSeleccione una acción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (contador < maxPersonas) {
                        System.out.println("\n--- Formulario de Ingreso #" + (contador + 1) + " ---");
                        System.out.print("Nombre: ");
                        String nombre = sc.next();
                        System.out.print("Apellido: ");
                        String apellido = sc.next();
                        sc.nextLine(); 
                        System.out.print("Departamento / Posición: ");
                        String puesto = sc.nextLine(); 
                        System.out.print("Año de Ingreso: ");
                        String anio = sc.next();
                        System.out.print("Salario Base (RD$): ");
                        double salario = sc.nextDouble();
                        System.out.print("Préstamo (RD$): ");
                        double prestamo = sc.nextDouble();

                        String codigo = (contador + 1) + nombre.substring(0,1).toUpperCase() + apellido.substring(0,1).toUpperCase() + anio;

                        
                        double sfsEmp = salario * 0.0304;  
                        double afpEmp = salario * 0.0287;  
                        double sfsPatron = salario * 0.0709; 
                        double afpPatron = salario * 0.0710; 
                        double baseISR = salario - sfsEmp - afpEmp;
                        double isr = (baseISR > 34685.00) ? (baseISR - 34685.00) * 0.15 : 0;
                        double salarioNeto = salario - (prestamo + sfsEmp + afpEmp + isr);

                        
                        datos[contador][0] = codigo;
                        datos[contador][1] = puesto;
                        datos[contador][2] = nombre;
                        datos[contador][3] = apellido;
                        datos[contador][4] = String.format("RD$%,.2f", salario);
                        datos[contador][5] = String.format("RD$%,.2f", sfsEmp);     
                        datos[contador][6] = String.format("RD$%,.2f", afpEmp);     
                        datos[contador][7] = String.format("RD$%,.2f", sfsPatron);  
                        datos[contador][8] = String.format("RD$%,.2f", afpPatron);  
                        datos[contador][9] = String.format("RD$%,.2f", isr);
                        datos[contador][11] = String.format("RD$%,.2f", salarioNeto);

                        contador++;
                        System.out.println("\n>> ¡Empleado Registrado!");
                    }
                    break;

                case 2:
                    if (contador > 0) {
                        
                        String lineaIgual = "=".repeat(168);
                        String lineaGuion = "-".repeat(168);
                        
                        System.out.println("\n" + lineaIgual);
                        System.out.printf("| %-164s |\n", "                                            CHEBERLAIN S.R.L.");
                        System.out.printf("| %-164s |\n", "                              REPORTE DE NOMINA OPERATIVA - FEBRERO 2026 (RD$)");
                        System.out.println(lineaIgual);
                        
                        
                        System.out.printf("| %-10s | %-15s | %-10s | %-10s | %-14s | %-12s | %-12s | %-12s | %-12s | %-10s | %-14s |\n", 
                            "CÓDIGO", "PUESTO", "NOMBRE", "APELLIDO", "SALARIO", "SFS_EM", "AFP_EM", "SFS_PAT", "AFP_PAT", "ISR", "NETO");
                        System.out.println(lineaGuion);
                        
                        
                        for (int i = 0; i < contador; i++) {
                            System.out.printf("| %-10s | %-15s | %-10s | %-10s | %-14s | %-12s | %-12s | %-12s | %-12s | %-10s | %-14s |\n", 
                                datos[i][0], datos[i][1], datos[i][2], datos[i][3], datos[i][4], 
                                datos[i][5], datos[i][6], datos[i][7], datos[i][8], datos[i][9], datos[i][11]);
                        }
                        System.out.println(lineaIgual);
                    } else {
                        System.out.println("\nNo hay registros activos.");
                    }
                    break;
            }
        } while (opcion != 3);
        sc.close();
    }
}

package com.univa.fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bienvenido al proyecto de fechas!\nPorfavor eliga una opcion del menu del menu:\n" +
                "1.-Inicialisar con fecha predeterminada (1-1-1990)\n" +
                "2.-Inicialisar con fecha customisada (formato con numero dd mm yyyy)");
        int eleccion = scanner.nextInt();
        switch (eleccion) {
            case 1 -> {
                while (true){
                fechasProceso fp = new fechasProceso();
                System.out.println("Ingrese programa a ejecutar:\n" +
                        "1.-Ingrse una nueva fecha manualmente en formato dd mm yyyy\n" +
                        "2.-Bisiesto\n" +
                        "3.-Dias del mes del mes para el anio de la fecha\n" +
                        "4.-Mostrar fecha en formato corto\n" +
                        "5.-Dias trasncuridos desde 1-1-1990\n" +
                        "6.-Dia de la semana de la fecha\n" +
                        "7.-Mostrar la fecha en formato largo\n" +
                        "8.-Fecha desde \"x\" dias transcurridos desdes 1-1-1990\n" +
                        "9.-Dias entre la fecha inicialisada y la proporcionadada\n" +
                        "10.-Pasar al dia siguiente\n" +
                        "11.-Pasar al dia anterior\n" +
                        "12.-Un clon de la fecha\n" +
                        "13.-Igual que la fecha\n" +
                        "14.-Menor que la fecha\n" +
                        "15.-Mayor que la fecha\n" +
                        "16.-Salir del Programa");
                int seleccion = scanner.nextInt();
                switch (seleccion) {
                    case 1 -> {
                        System.out.println("Ingrese un dia");
                        int dia = scanner.nextInt();
                        System.out.println("Ingrese un mes en numero");
                        int mes = scanner.nextInt();
                        System.out.println("Ingrese un anio en numero");
                        int anio = scanner.nextInt();
                        fp.leer(dia, mes, anio);
                    }
                    case 2 -> {
                        fp.bisiesto();
                    }
                    case 3 -> {
                        System.out.println("No entiendo que me pide");
                    }
                    case 4 -> {
                        fp.corto();
                    }
                    case 5 -> {
                        fp.diasTranscuridos();
                    }
                    case 6 -> {
                        fp.diaSemana();
                    }
                    case 7 -> {
                        fp.largo();
                    }
                    case 8 -> {
                        System.out.println("Ingrse dias transcurridos: ");
                        int dias = scanner.nextInt();
                        fp.fechaTras(dias);
                    }
                    case 9 -> {
                        try {
                            System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                            scanner.nextLine();
                            String fecha = scanner.nextLine();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                            LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                            fp.diasEntre(fechaDos);
                        } catch (Exception e) {
                            System.out.println("Error en programa!");
                            e.printStackTrace();
                        }
                    }
                    case 10 -> {
                        fp.siguiente();
                    }
                    case 11 -> {
                        fp.anterior();
                    }
                    case 12 -> {
                        System.out.println(fp.copy());
                    }
                    case 13 -> {
                        System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                        scanner.nextLine();
                        String fecha = scanner.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                        LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                        System.out.println(fp.igual(fechaDos));
                    }
                    case 14 -> {
                        System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                        scanner.nextLine();
                        String fecha = scanner.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                        LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                        System.out.println(fp.menorQue(fechaDos));
                    }
                    case 15 -> {
                        System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                        scanner.nextLine();
                        String fecha = scanner.nextLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                        LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                        System.out.println(fp.mayorQue(fechaDos));
                    }case  16 -> {
                        System.out.println("Gracias por todo! Saliendo del programa");
                        System.exit(0);
                    }
                }
                }
            }case 2 -> {
                System.out.println("Porfavor escriba un dia en numero: ");
                int dia, mes, anio;
                try {
                    dia = scanner.nextInt();
                    System.out.println("Ingrese un mes en numero");
                    mes = scanner.nextInt();
                    System.out.println("Ingrese un anio en numero");
                    anio = scanner.nextInt();
                    fechasProceso fp = new fechasProceso(dia,mes,anio);
                  while (true) {
                      System.out.println("Ingrese programa a ejecutar:\n" +
                              "1.-Ingrse una nueva fecha manualmente en formato dd mm yyyy\n" +
                              "2.-Bisiesto\n" +
                              "3.-Dias del mes del mes para el anio de la fecha\n" +
                              "4.-Mostrar fecha en formato corto\n" +
                              "5.-Dias trasncuridos desde 1-1-1990\n" +
                              "6.-Dia de la semana de la fecha\n" +
                              "7.-Mostrar la fecha en formato largo\n" +
                              "8.-Fecha desde \"x\" dias transcurridos desdes 1-1-1990\n" +
                              "9.-Dias entre la fecha inicialisada y la proporcionadada\n" +
                              "10.-Pasar al dia siguiente\n" +
                              "11.-Pasar al dia anterior\n" +
                              "12.-Un clon de la fecha\n" +
                              "13.-Igual que la fecha\n" +
                              "14.-Menor que la fecha\n" +
                              "15.-Mayor que la fecha\n");
                      int seleccion = scanner.nextInt();
                      switch (seleccion) {
                          case 1 -> {
                              System.out.println("Ingrese un dia");
                              int diaDos = scanner.nextInt();
                              System.out.println("Ingrese un mes en numero");
                              int mesDos = scanner.nextInt();
                              System.out.println("Ingrese un anio en numero");
                              int anioDos = scanner.nextInt();
                              fp.leer(diaDos, mesDos, anioDos);
                          }
                          case 2 -> {
                              fp.bisiesto();
                          }
                          case 3 -> {
                              System.out.println("No entiendo que me pide");
                          }
                          case 4 -> {
                              fp.corto();
                          }
                          case 5 -> {
                              fp.diasTranscuridos();
                          }
                          case 6 -> {
                              fp.diaSemana();
                          }
                          case 7 -> {
                              fp.largo();
                          }
                          case 8 -> {
                              System.out.println("Ingrse dias transcurridos: ");
                              int dias = scanner.nextInt();
                              fp.fechaTras(dias);
                          }
                          case 9 -> {
                              try {
                                  System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                                  scanner.nextLine();
                                  String fecha = scanner.nextLine();
                                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                                  LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                                  fp.diasEntre(fechaDos);
                              } catch (Exception e) {
                              }
                          }
                          case 10 -> {
                              fp.siguiente();
                          }
                          case 11 -> {
                              fp.anterior();
                          }
                          case 12 -> {
                              System.out.println(fp.copy());
                          }
                          case 13 -> {
                              System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                              scanner.nextLine();
                              String fecha = scanner.nextLine();
                              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                              LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                              System.out.println(fp.igual(fechaDos));
                          }
                          case 14 -> {
                              System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                              scanner.nextLine();
                              String fecha = scanner.nextLine();
                              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                              LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                              System.out.println(fp.menorQue(fechaDos));
                          }
                          case 15 -> {
                              System.out.println("Ingrese una fecha en formato (dd mm yyyy)");
                              scanner.nextLine();
                              String fecha = scanner.nextLine();
                              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
                              LocalDate fechaDos = LocalDate.parse(fecha, dtf);
                              System.out.println(fp.mayorQue(fechaDos));
                          }
                          case 16 -> {
                              System.out.println("Gracias por todo! Saliendo del programa");
                              System.exit(0);
                          }
                      }
                  }
                }catch (NumberFormatException e) {
                    System.out.println("Se tiene que ingresar un numero!");
                    e.printStackTrace(System.out);
                }
            }
        }
    }
}

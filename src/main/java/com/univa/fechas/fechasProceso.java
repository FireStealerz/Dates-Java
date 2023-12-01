package com.univa.fechas;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;

public class fechasProceso {

    private int dia;

    private int mes;

    private int anio;

    private final String FECHA_BASE = "1 1 1990";
    fechasProceso() { //Const predeterminad
        setDia(1);
        setMes(1);
        setAnio(1990);
    }

    fechasProceso(int dia, int mes, int anio) { //COnst presonalisado
      leer(dia, mes, anio);
    }

    //Getters y setters
    private int getDia() {
        return dia;
    }

    private void setDia(int dia) {
        this.dia = dia;
    }

    private int getMes() {
        return mes;
    }

    private void setMes(int mes) {
        this.mes = mes;
    }

    private int getAnio() {
        return anio;
    }

    private void setAnio(int anio) {
        this.anio = anio;
    }

    public void leer(int dia,int mes,int anio) { //manda a validar el valor y dependiendo de la validacion assigna valor
        switch (valida(dia,mes, anio)) {
            case 0 -> {
                setDia(dia);
                setMes(mes);
                setAnio(anio);
            }case 1 -> {
                setMes(mes);
                setAnio(anio);
            }case 2 -> {
                setDia(dia);
                setAnio(anio);
            }case 3 -> {
                setDia(dia);
                setMes(mes);
            }case 4 -> {
                setAnio(anio);
            }case 5 -> {
                setMes(mes);
            }case 6 -> {
                setDia(dia);
            }
        }
    }

    private int valida(int dia,int mes,int anio) {
        if (dia < 1 || dia > 31 && mes >= 1 && mes <= 12 && anio >= 1990 && anio <= 2050) {
            setDia(1);
            System.out.println("Dia no valido!, poniendo 1 de remplazo!");
            return 1;
        } else if (dia >= 1 && dia <= 31 && mes < 1 || mes > 12 && anio >= 1990 && anio <= 2050) {
            setMes(1);
            System.out.println("Mes no valido, poniendo 1 de remplazo!");
            return 2;
        } else if ( dia >= 1 && dia <= 31 && anio < 1990 || anio > 2050 && mes >= 1 && mes <= 12 ) {
            setMes(1990);
            System.out.println("Anio no valido, poniendo 1990 de remplazo!");
            return 3;
        } else if (dia < 1 || dia > 31 && mes < 1 || mes > 12 && anio >= 1990 && anio <= 2050) {
            setMes(1);
            setDia(1);
            System.out.println("Dia y Mes no valido, poniendo 1 de remplazo!");
            return 4;
        } else if ( dia < 1 || dia > 31 && mes >= 1 && mes <= 12 && anio < 1990 || anio > 2050) {
            setDia(1);
            setAnio(1990);
            System.out.println("Dia y Anio no valido poniendo 1 y 1990 de rempalzo!");
            return 5;
        } else if ( dia >= 1 && dia <= 31 && mes < 1 || mes > 12 && anio < 1990 || anio > 2050) {
            setMes(1);
            setAnio(1990);
            System.out.println("Mes y Anio no valido, poniendo 1 y 1990 de remplazo!");
            return 6;
        }
        return 0;
    }

    public void diasTranscuridos() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d M yyyy"); //Poenmos formato de la fecha
        String dateOne = String.valueOf(getDia()) + " " + String.valueOf(getMes()) + " " + String.valueOf(getAnio()); //Agarra todos los valores y los pone en un solo String para manipurlaos
        LocalDate date1 = LocalDate.parse(dateOne, dtf); //Convierte el string en Objeto fecho
        LocalDate date2 = LocalDate.parse(FECHA_BASE, dtf); //Convierte el string en Objeto fehca
        Duration diasEntre = Duration.ofDays(DAYS.between(date1, date2)); //ca;cula los dias entre las dos fechas  te lo da en 24 horas//
        System.out.println("Dias entre " + date1 + " y " + date2 + ": " + diasEntre);
        System.out.println("Este numero es dado entre dias de 24-horas, no dias del calendario! Entre dias del calendario es el siguiente");
        long diasEntreMes = DAYS.between(date1, date2); //Este te da los dias tal cual
        System.out.println(diasEntreMes);
    }

    public void diaSemana() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d M yyyy");//Pone
        String dateOne = (Integer.toString(getDia()) + " " + Integer.toString(getMes()) + " " + Integer.toString(getAnio()));
        DayOfWeek date1 = LocalDate.parse(dateOne, dtf).getDayOfWeek(); //Te da el dia de la semana
        System.out.println("El dia de la semana de la fecha es: " + date1);
    }

    public void largo() {
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("d M yyyy");
        String dateOne = (Integer.toString(getDia()) + " " + Integer.toString(getMes()) + " " + Integer.toString(getAnio()));
        LocalDate date = LocalDate.parse(dateOne,df1);
        DayOfWeek dayOfWeek = date.getDayOfWeek(); //Te da el dia de la semama
        System.out.println(dayOfWeek + ", " + df1.format(date)); //Impirme la fecha en formato largo
    }

    public void corto() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d-M-yyyy");
        String fecha = String.valueOf(getDia()) + "-" + String.valueOf(getMes()) +"-"+ String.valueOf(getAnio());
        LocalDate dateOne =  LocalDate.parse(fecha,df); //Te lo convierte en objetco fecha esperando el formato df
        System.out.println(df.format(dateOne)); //Te lo pone en el formato  df
    }

        public void fechaTras(long dias) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fechaTrasDos = LocalDate.parse(Integer.toString(getDia()) + " " + Integer.toString(getMes()) + " " + Integer.toString(getAnio()),df);
        LocalDate fechaTrasTres = fechaTrasDos.plusDays(dias); //LE sume los dias a la fehca
        System.out.println("Fecha desde " + df.format(fechaTrasDos)
                + " : " + df.format(fechaTrasTres));
    }

    public void diasEntre(LocalDate fecha) { //Mismo que dias transcurridos Con fehca customisada
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fechaInicalisada = LocalDate.parse(Integer.toString(getDia()) + " " + Integer.toString(getMes()) + " " + Integer.toString(getAnio()),dtf);
        Duration diasEntre = Duration.ofDays(DAYS.between(fechaInicalisada, fecha));
        System.out.println("Dias entre " + fecha + " y " + fechaInicalisada + ": " + diasEntre);
        System.out.println("Este numero es dado entre dias de 24-horas, no dias del calendario! Entre dias del calendario es el siguiente");
        long diasEntreMes = DAYS.between(fechaInicalisada, fecha);
        System.out.println(diasEntreMes);
    }


    public void siguiente() { //Te da el dia iguiente
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fechaSiguiente = LocalDate.parse(Integer.toString(getDia()) + " " //Primero te convierte la fechna en string para manipularla
                        + Integer.toString(getMes()) + " " + Integer.toString(getAnio()),dtf) //Despues lo convierte a objeto fecha
                .plusDays(1); //Le suma 1 solo dia
        System.out.println(fechaSiguiente);
    }

    public void anterior() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fechaSiguiente = LocalDate.parse(Integer.toString(getDia()) +" "
                        + Integer.toString(getMes()) +" "+ Integer.toString(getAnio()),dtf)
                .minusDays(1); //MEnos un dia
        System.out.println(fechaSiguiente);
    }

    public LocalDate copy() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fecha = LocalDate.parse(Integer.toString(getDia()) + " " +
                Integer.toString(getMes()) + " " +Integer.toString(getAnio()),df);
        LocalDate nuevo = fecha; //Copia la fecha a un nuevo obketo fecha
        System.out.println("Devolviendo clon de la fecha:");
        return nuevo;
    }

    public boolean igual(LocalDate fechaDos) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fecha = LocalDate.parse(Integer.toString(getDia()) + " " +
                Integer.toString(getMes()) + " " + Integer.toString(getAnio()),df); //Compara las dos fehcas
        return fecha.equals(fechaDos);
    }

    public boolean menorQue(LocalDate fechaDos) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fecha = LocalDate.parse(Integer.toString(getDia()) + " "
                + Integer.toString(getMes()) + " " + Integer.toString(getAnio()),df);
        if (fecha.compareTo(fechaDos) < 0 ) { //Checa si la fecha es menor
            return false;
        }else return true;
    }

    public boolean mayorQue(LocalDate fechaDos) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate fecha = LocalDate.parse(Integer.toString(getDia()) + " "
                + Integer.toString(getMes()) + " " + Integer.toString(getAnio()),df);
        if (fecha.compareTo(fechaDos) > 0 ) {  //Checa si es mayor  //Comparacoin
            return false;
        }else return true;
    }

   public void bisiesto () {
       int year = getAnio();
       boolean isLeapYear;

       isLeapYear = (year % 4 == 0);

       isLeapYear = isLeapYear && (year % 100 != 0 || year % 400 == 0);  //Es la formula para encontrar el anio bisisesto

       if (isLeapYear) {
           System.out.println(year + " Es anio bisiesto.");
       } else {
           System.out.println(year + " No es anio bisiesto.");
       }
   }
}

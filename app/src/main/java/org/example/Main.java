package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1 - Расчитать минимальное время полета между городами
                2 - Расчитать разницу между средней ценой  и медианой для полета между городами
                0 - выход""");
        System.out.print("Выберите необходимое действие: ");
        String num = scanner.next();

        TicketDes ticketDes = new TicketDes();
        List<TicketModel> ticketModels = ticketDes.getTickets();
        TicketServise ticketServise = new TicketServise();
        switch(num){
            case "1" -> ticketServise.MinFlightTimes(ticketModels);
            case "2" -> ticketServise.PriceMedDiff(ticketModels);
            case "0" -> System.out.println("До скорых встреч.");
            default -> System.out.println("Ошибка выбора");
        }
        scanner.close();
    }
}
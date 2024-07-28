package org.example;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketServise {
    public void MinFlightTimes(List<TicketModel> ticketModels){
        Map<String,Integer> minFlightTimes = new HashMap<>();
        for (TicketModel ticketModel:ticketModels){
            if (ticketModel.getOrigin().equals("VVO") && ticketModel.getDestination().equals("TLV") ||
                    ticketModel.getOrigin_name().equals("Владивосток") && ticketModel.getDestination_name().equals("Тель-Авив")){
                String carrier = ticketModel.getCarrier();
                int duration = Duration(ticketModel.getDeparture_date(),ticketModel.getDeparture_time(),ticketModel.getArrival_date(),ticketModel.getArrival_time());
                if (!minFlightTimes.containsKey(carrier)){
                    minFlightTimes.put(carrier,duration);
                }else {
                    int minDuration = minFlightTimes.get(carrier);
                    if (duration < minDuration) {
                        minFlightTimes.put(carrier, duration);
                    }
                }
            }
        }
        for (Map.Entry<String,Integer> entry:minFlightTimes.entrySet()){
            System.out.println("Минимальное время полета " + entry.getKey() + ": " + entry.getValue() + " минут.");
        }
    }
    public void PriceMedDiff(List<TicketModel> ticketModels){
        List<Integer> prices = new ArrayList<>();
        for (TicketModel ticketModel : ticketModels){
            if (ticketModel.getOrigin().equals("VVO") && ticketModel.getDestination().equals("TLV") ||
                    ticketModel.getOrigin_name().equals("Владивосток") && ticketModel.getDestination_name().equals("Тель-Авив")){
                prices.add(ticketModel.getPrice());
            }
        }
        prices.sort(null);
        double med;
        if (prices.size() % 2 ==0){
            med = (prices.get(prices.size() /2 -1) + prices.get(prices.size()/2)) /2.0;
        }else {
            med = prices.get(prices.size()/2);
        }
        double sum =0;
        for (int price : prices){
            sum+=price;
        }
        double avgprice = sum/prices.size();
        double diff = avgprice - med;
        System.out.println("Разница между средней ценой и медианой: " + diff);
    }
    private int Duration(String departureDate, String departureTime, String arrivalDate, String arrivalTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        LocalDateTime departureDateTime = LocalDateTime.parse(departureDate + " " + departureTime, dateTimeFormatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDate + " " + arrivalTime, dateTimeFormatter);
        return (int) ChronoUnit.MINUTES.between(departureDateTime, arrivalDateTime);
    }
}


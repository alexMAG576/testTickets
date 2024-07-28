package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TicketDes {
    private static final String FILE_PATH = "app/src/main/resources/tickets.json";
    public List<TicketModel> getTickets(){
        ObjectMapper mapper = new ObjectMapper();
        TicketModelList ticketModelList;
        try {
            ticketModelList = mapper.readValue(new File(FILE_PATH),TicketModelList.class);
            return Arrays.asList(ticketModelList.getTickets());
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}

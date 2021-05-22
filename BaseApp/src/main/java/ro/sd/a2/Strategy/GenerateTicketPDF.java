package ro.sd.a2.Strategy;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.UserDTO;

import java.io.FileOutputStream;


public class GenerateTicketPDF implements Strategy {
    @Override
    public String generateTicket(TicketDTO ticket, UserDTO user) {
        String ticketName = user.getFirstName()+user.getLastName()+"ticket.pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ticketName));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            Chunk chunk = new Chunk("ticket name: " + ticket.getName() + "\n", font);
            Paragraph paragraph = new Paragraph(chunk);
            Chunk chunk1 = new Chunk("ticket price:" + ticket.getPrice() + "\n", font);
            Paragraph paragraph1 = new Paragraph(chunk1);
            Chunk chunk2 = new Chunk("owner:" + user.getFirstName() + " " +user.getLastName() + "\n", font);
            Paragraph paragraph2 = new Paragraph(chunk2);

            document.add(paragraph);
            document.add(paragraph1);
            document.add(paragraph2);
            document.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return ticketName;
    }
}

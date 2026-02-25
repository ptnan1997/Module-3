package Session11.Bai6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {
     List<Message> messages = new ArrayList<>();

    public void SendMessage(String sender, String content) {
        messages.add(new Message(sender, content));
        System.out.println("Gửi tin nhắn thành công");
    }
    public void History(){
        System.out.println("----- Lịch sử chat -----");
        messages.forEach(Message::display);
    }
    public void filterBySender(String  sender){
        List<Message> filterBySender = messages.stream()
                .filter(s -> s.getSender().equals(sender)).toList();
        System.out.println("Tin nhắn từ " + sender + ":");
        filterBySender.forEach(System.out::println);
    }
    public void filterByDate(LocalDate date){
        List<Message> filteredMessages = messages.stream()
                .filter(msg -> msg.getTimetamp().toLocalDate().equals(date))
                .toList();

        System.out.println("Tin nhắn trong ngày " + date + ":");
        filteredMessages.forEach(System.out::println);
    }
}

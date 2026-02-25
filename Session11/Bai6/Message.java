package Session11.Bai6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String sender;
    private String content;
    private LocalDateTime timetamp;
    //Constructor không tham số
    public Message(){
        this.timetamp = LocalDateTime.now();
    }
    //Constructor
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timetamp = LocalDateTime.now();
    }
    // Getter and Setter

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(LocalDateTime timetamp) {
        this.timetamp = timetamp;
    }

    public void display(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.printf("Người gửi: %s | Nội dung: %s | Thời gian: %s \n", sender, content, timetamp.format(dtf));
    }
}


import java.io.Serializable;
import java.util.Date;

public class ChatMessage implements Serializable {

    private String from;
    private String to;
    private String leavedate;
    private String returndate;
    private String traveller;

    public ChatMessage(String from, String to, String leavedate, String returndate, String traveller) {
        this.from = from;
        this.to = to;
        this.leavedate = leavedate;
        this.returndate = returndate;
    }

    

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String getLeavedate() {
        return this.leavedate;
    }
    
    public String getReturndate() {
        return this.returndate;
    }
    
    public String gettraveller() {
        return this.traveller;
    }

}

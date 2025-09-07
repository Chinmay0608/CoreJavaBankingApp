import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private Date timeStamp;
    private double amount;
    private String type;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }


    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        this.timeStamp = new Date();
    }

    public String getTransactionSummary(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Type : " + type +"| Amount : " + amount + "| Date : " + dateFormat.format(timeStamp);
    }
}

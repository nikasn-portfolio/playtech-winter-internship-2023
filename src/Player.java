import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private UUID id;
    private Long balance;
    private StatusType status;
    List<Transaction> transactions;

    public Player(UUID id) {
        this.id = id;
        this.balance = 0L;
        this.transactions = new ArrayList<>();
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    public Transaction getLastTransaction() {
        return this.transactions.get(this.transactions.size() - 1);
    }


}

public class Casino {
    private Long balance;

    private Long tempBalance;

    public Casino(Long balance, Long tempBalance) {
        this.balance = balance;
        this.tempBalance = tempBalance;
    }

    public Long getTempBalance() {
        return tempBalance;
    }

    public void setTempBalance(Long tempBalance) {
        this.tempBalance = tempBalance;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}

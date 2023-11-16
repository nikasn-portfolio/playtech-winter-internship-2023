public class Transaction {
    private OperationType operationType;
    private Match match;
    private int amount;
    private MatchType matchType;

    private StatusType statusType;

    private boolean isWin = false;

    public Transaction(String operationType, Match match, String amount) {
        this.operationType = OperationType.valueOf(operationType);
        this.match = match;
        this.amount = Integer.parseInt(amount);
        this.matchType = MatchType.NO_MATCH;
    }

    public Transaction(String operationType, Match match, String amount, String matchType) {
        this.operationType = OperationType.valueOf(operationType);
        this.match = match;
        this.amount = Integer.parseInt(amount);
        this.matchType = MatchType.valueOf(matchType);
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public StatusType getTransactionStatus() {
        return statusType;
    }

    public void setTransactionStatus(StatusType statusType) {
        this.statusType = statusType;
    }
}

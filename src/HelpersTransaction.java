import java.util.List;

public class HelpersTransaction {

    private static Boolean validateTransaction(Transaction transaction, Player player) {
        switch (transaction.getOperationType()) {
            case BET, WITHDRAW:
                if (transaction.getAmount() > player.getBalance()) {
                    transaction.setTransactionStatus(StatusType.ILLEGAL);
                    return false;
                } else {
                    transaction.setTransactionStatus(StatusType.LEGAL);
                    return true;
                }
            case DEPOSIT:
                transaction.setTransactionStatus(StatusType.LEGAL);
                return true;
        }
        throw new IllegalArgumentException("Invalid operation type");
    }

    public static void executeTransactions(List<Player> players, Casino casino) {
        for (Player player : players) {
            for (Transaction transaction : player.getTransactions()) {
                executeTransaction(transaction, player, casino);
            }
            if(player.getStatus().equals(StatusType.LEGAL)){
                casino.setBalance(casino.getBalance() + casino.getTempBalance());
            }
            casino.setTempBalance(0L);
        }

    }

    private static void executeTransaction(Transaction transaction, Player player, Casino casino) {
        Boolean isTransactionValid = validateTransaction(transaction, player);
        if(isTransactionValid){
            if(player.getStatus() == null){
                player.setStatus(StatusType.LEGAL);
            }
            switch (transaction.getOperationType()) {
                case BET:
                    executeBetTransaction(transaction, player, casino);
                    break;
                case DEPOSIT:
                    executeDepositTransaction(transaction, player);
                    break;

                case WITHDRAW:
                    executeWithdrawTransaction(transaction, player);
                    break;
            }
        }else{
            player.setStatus(StatusType.ILLEGAL);
        }

    }

    private static void executeDepositTransaction(Transaction transaction, Player player) {
        player.setBalance(player.getBalance() + transaction.getAmount());
    }

    private static void executeBetTransaction(Transaction transaction, Player player, Casino casino){
        Match match = transaction.getMatch();
        MatchType matchWinner = match.getMatchType();
        if(matchWinner == transaction.getMatchType()){
            switch (transaction.getMatchType()) {
                case A:
                    transaction.setWin(true);
                    Long WonCaseA = (long) Math.floor(transaction.getAmount() * match.getRateA());
                    casino.setTempBalance(casino.getTempBalance() - WonCaseA);
                    player.setBalance(player.getBalance() + WonCaseA);
                    break;
                case B:
                    transaction.setWin(true);
                    Long WonCaseB = (long) Math.floor(transaction.getAmount() * match.getRateB());
                    casino.setTempBalance(casino.getTempBalance() - WonCaseB);
                    player.setBalance(player.getBalance() + WonCaseB);
                    break;

            }
        }else{
            if(!matchWinner.equals(MatchType.DRAW)){
                player.setBalance(player.getBalance() - transaction.getAmount());
                casino.setTempBalance(casino.getTempBalance() + transaction.getAmount());
            }

        }
    }

    private static void executeWithdrawTransaction(Transaction transaction, Player player){
        player.setBalance(player.getBalance() - transaction.getAmount());
    }

    public static Transaction getFirstIllegalTransaction(Player player){
        for (Transaction transaction : player.getTransactions()) {
            if(transaction.getTransactionStatus().equals(StatusType.ILLEGAL)){
                return transaction;
            }
        }
        throw new RuntimeException("No illegal transactions found");
    }
}

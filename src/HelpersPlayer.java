import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HelpersPlayer {
    public static Boolean isPlayerExist(List<Player> listOfPlayers, UUID playerId) {
        return listOfPlayers.stream().anyMatch(player -> player.getId().equals(playerId));
    }

    public static Player getPlayerById(List<Player> players, UUID playerId) {
        return players.stream().filter(player -> player.getId().equals(playerId)).findFirst().orElse(null);
    }

    public static List<Player> setFullMatchData(List<Player> players,Map<UUID, Match> matches){
        for (Player player : players) {
            player.getTransactions().forEach(transaction -> {
                if(transaction.getMatch() != null){
                    transaction.setMatch(matches.get(transaction.getMatch().getId()));
                }
            });
        }
        return players;
    }

    public static BigDecimal getWinRateOfPlayerById(Player player){
        BigDecimal winRate = BigDecimal.ZERO;
        BigDecimal winCount = BigDecimal.ZERO;
        BigDecimal loseCount = BigDecimal.ZERO;
        for (Transaction transaction : player.getTransactions()) {
            if(transaction.getMatch() != null){
                if(transaction.isWin()){
                    winCount = winCount.add(BigDecimal.ONE);
                }else {
                    loseCount = loseCount.add(BigDecimal.ONE);
                }
            }
        }
        if(winCount.compareTo(BigDecimal.ZERO) != 0){
            winRate = winCount.divide(winCount.add(loseCount),2, RoundingMode.HALF_UP);
        }
        return winRate;
    }
}

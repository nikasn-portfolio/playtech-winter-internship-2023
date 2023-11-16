import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWriter {
    public void outputFileWriter(List<Player> players, Casino casino){
        String groupOfLegalPlayers = generateStringForLegalPlayers(players);
        String groupOfIllegalPlayers = generateStringForIllegalPlayers(players);
        try(FileWriter writer = new FileWriter("src/result.txt", false))
        {
            String text = groupOfLegalPlayers + groupOfIllegalPlayers + casino.getBalance();
            writer.write(text);
            writer.flush();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateStringForLegalPlayers(List<Player> players){
        StringBuilder sb = new StringBuilder();
        List<Player> legalPlayersList = players.stream().filter(player -> player.getStatus().equals(StatusType.LEGAL)).collect(Collectors.toList());
        if(legalPlayersList.size() == 0){
            sb.append("\n");
            sb.append("\n");
            return sb.toString();
        }
        for (Player player : legalPlayersList) {
            if(player.getStatus().equals(StatusType.LEGAL)){
                sb.append(player.getId());
                sb.append(" ");
                sb.append(player.getBalance());
                sb.append(" ");
                sb.append(HelpersPlayer.getWinRateOfPlayerById(player));
                sb.append("\n");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    private String generateStringForIllegalPlayers(List<Player> players){
        StringBuilder sb = new StringBuilder();
        List<Player> illegalPlayersList = players.stream().filter(player -> player.getStatus().equals(StatusType.ILLEGAL)).collect(Collectors.toList());
        if(illegalPlayersList.size() == 0){
            sb.append("\n");
            sb.append("\n");
            return sb.toString();
        }
        for (Player player : illegalPlayersList) {
            if(player.getStatus().equals(StatusType.ILLEGAL)){
                Transaction firstIllegalTransaction = HelpersTransaction.getFirstIllegalTransaction(player);
                sb.append(player.getId());
                sb.append(" ");
                sb.append(firstIllegalTransaction.getOperationType());
                sb.append(" ");
                if(firstIllegalTransaction.getMatch() == null){
                    sb.append("null");
                }else {
                    sb.append(firstIllegalTransaction.getMatch().getId());
                }
                sb.append(" ");
                sb.append(firstIllegalTransaction.getAmount());
                sb.append(" ");
                if(firstIllegalTransaction.getMatchType().equals(MatchType.NO_MATCH)){
                    sb.append("null");
                }else {
                    sb.append(firstIllegalTransaction.getMatchType());
                }
                sb.append("\n");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}

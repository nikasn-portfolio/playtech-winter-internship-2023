import java.util.*;

public class Main {
    public static void main(String[] args) {
        Casino casino = new Casino(0L, 0L);
        List<Player> players = new ArrayList<>();
        Map<UUID,Match> matches = new LinkedHashMap<>();
        InputReader inputReader = new InputReader();
        inputReader.readPlayersFile(players);
        inputReader.readMatchesFile(matches);
        HelpersPlayer.setFullMatchData(players,matches);
        HelpersTransaction.executeTransactions(players, casino);
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.outputFileWriter(players, casino);

    }
}
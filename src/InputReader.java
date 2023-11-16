import java.io.*;
import java.util.*;

public class InputReader {
    public void readPlayersFile(List<Player> players) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("player_data.txt");
        Player player = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(",");
                if(players.isEmpty()){
                    player = new Player(UUID.fromString(parts[0]));
                }else if(!HelpersPlayer.isPlayerExist(players, UUID.fromString(parts[0]))){
                    if(!HelpersPlayer.isPlayerExist(players, player.getId())){
                        players.add(player);
                    }else {
                        player = new Player(UUID.fromString(parts[0]));
                    }
                }else {
                    player = HelpersPlayer.getPlayerById(players, UUID.fromString(parts[0]));
                }
                if(parts.length == 4){
                    player.addTransaction(new Transaction(parts[1]
                            ,parts[2].equals("") ? null : new Match(UUID.fromString(parts[2]))
                            ,parts[3]));
                }else {
                    player.addTransaction(new Transaction(parts[1]
                            ,parts[2].equals("") ? null : new Match(UUID.fromString(parts[2]))
                            ,parts[3]
                            ,parts[4]));
                }
                if(players.isEmpty()){
                    players.add(player);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMatchesFile(Map<UUID, Match> matches){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("match_data.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(",");
                Match match = new Match(UUID.fromString(parts[0]),parts[1],parts[2],parts[3]);
                matches.put(match.getId(),match);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

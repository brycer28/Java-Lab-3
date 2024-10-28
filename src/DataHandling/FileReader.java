package DataHandling;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader {
    // reads a .csv file of data and populates a DataHandling.PlayerStats record
    public static ArrayList<PlayerStats> readPlayerStats(String filename) throws IOException {
        String contents = Files.readString(Path.of(filename), StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(contents);
        ArrayList<PlayerStats> playerStats = new ArrayList<>();
        scanner.nextLine();
        scanner.useDelimiter(",");

        // read each line of the .csv conents and fill in each field of DataHandling.PlayerStats
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {continue;}
            String[] data = line.split(",");
            try {
                PlayerStats datum = new PlayerStats(
                        Byte.parseByte(data[0]),    //rank
                        data[1],                    //name
                        Byte.parseByte(data[2]),    //GP
                        Byte.parseByte(data[3]),    //GS
                        Integer.parseInt(data[4]),  //MP
                        Integer.parseInt(data[5]),  //FG
                        Integer.parseInt(data[6]),  //FGA
                        Float.parseFloat(data[7]),  //FGP
                        Integer.parseInt(data[8]),  //FG2
                        Integer.parseInt(data[9]),  //FG2A
                        Float.parseFloat(data[10]),  //FG2P
                        Integer.parseInt(data[11]),  //FG3
                        Integer.parseInt(data[12]),  //FG3A
                        Float.parseFloat(data[13]),  //FG3P
                        Integer.parseInt(data[14]),  //FT
                        Integer.parseInt(data[15]),  //FTA
                        Float.parseFloat(data[16]),  //FTP
                        Integer.parseInt(data[17]),  //ORB
                        Integer.parseInt(data[18]),  //DRB
                        Integer.parseInt(data[19]),  //TRB
                        Integer.parseInt(data[20]),  //AST
                        Integer.parseInt(data[21]),  //STL
                        Integer.parseInt(data[22]),  //BLK
                        Integer.parseInt(data[23]),  //TOV
                        Integer.parseInt(data[24]),  //PF
                        Integer.parseInt(data[25])   //PTS
                );
                playerStats.add(datum);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        return playerStats;
    }
}

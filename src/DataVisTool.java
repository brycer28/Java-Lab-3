import java.io.IOException;
import java.util.ArrayList;

// reads data creates frame for various panels
public class DataVisTool {
    public static void main(String[] args) throws IOException {
        ArrayList<PlayerStats> data = FileReader.readPlayerStat("UARK_Basketball_Stats_2019.csv");

        for (PlayerStats playerStats : data) {
            printPlayerStats(playerStats);
        }
    }

    public static void printPlayerStats(PlayerStats data) {
        System.out.println("2019 Basketball Season Statistics");
        System.out.println("Rank:\t" + data.rank());
        System.out.println("Name:\t" + data.name());
        System.out.println("GP:\t\t" + data.GP());
        System.out.println("GS:\t\t" + data.GS());
        System.out.println("MP:\t\t" + data.MP());
        System.out.println("FG:\t\t" + data.FG());
        System.out.println("FGA:\t" + data.FGA());
        System.out.println("FGP:\t" + data.FGP());
        System.out.println("FG2:\t" + data.FG2());
        System.out.println("FG2A:\t" + data.FG2A());
        System.out.println("FG2P:\t" + data.FG2P());
        System.out.println("FG3:\t" + data.FG3());
        System.out.println("FG3A:\t" + data.FG3A());
        System.out.println("FG3P:\t" + data.FG3P());
        System.out.println("FT:\t\t" + data.FT());
        System.out.println("FTA:\t" + data.FTA());
        System.out.println("FTP:\t" + data.FTP());
        System.out.println("ORB:\t" + data.ORB());
        System.out.println("DRB:\t" + data.DRB());
        System.out.println("TRB:\t" + data.TRB());
        System.out.println("AST:\t" + data.AST());
        System.out.println("STL:\t" + data.STL());
        System.out.println("BLK:\t" + data.BLK());
        System.out.println("TOV:\t" + data.TOV());
        System.out.println("PF:\t\t" + data.PF());
        System.out.println("PTS:\t" + data.PTS());
        System.out.println("\n");
    }
}

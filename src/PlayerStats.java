// a record to hold stats for each individual player
public record PlayerStats(
        byte rank,      // player rank
        String name,    // player name
        byte GP,        // games played
        byte GS,        // games started
        int MP,         // minutes played
        int FG,         // field goals made
        int FGA,        // field goal attempts
        float FGP,      // field goal percentage
        int FG2,        // 2 point field goals made
        int FG2A,       // 2 point field goals attempted
        float FG2P,     // 2 point field goals percentage
        int FG3,        // 3 point field goals made
        int FG3A,       // 3 point field goals attempted
        float FG3P,     // 3 point field goals percentage
        int FT,         // free throws made
        int FTA,        // free throws attempted
        float FTP,      // free throws percentage
        int ORB,        // offensive rebounds
        int DRB,        // defensive rebounds
        int TRB,        // total rebounds
        int AST,        // assists
        int STL,        // steals
        int BLK,        // blocks
        int TOV,        // turnovers
        int PF,         // personal fouls
        int PTS         // total points
){}





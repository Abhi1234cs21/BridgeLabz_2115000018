package org.example;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)  // ✅ Ignore extra fields in JSON
class IPLMatch {
    private int match_id;
    private String team1;
    private String team2;
    private Score score;
    private String winner;
    private String player_of_match;

    // Getters & Setters
    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }
}

class Score {
    private Map<String, Integer> score = new HashMap<>();  // ✅ Ensure map is initialized

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }

    @JsonAnySetter  // ✅ Handle dynamic keys (team names)
    public void addScore(String teamName, Integer teamScore) {
        if (score == null) {
            score = new HashMap<>();
        }
        score.put(teamName, teamScore);
    }

    public int getTeamScore(String teamName) {
        return score.getOrDefault(teamName, 0);
    }
}

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            String jsonInputPath = "src/main/resources/ipl_matches.json";
            String csvInputPath = "src/main/resources/ipl_matches.csv";
            String jsonOutputPath = "src/main/resources/censored_ipl_matches.json";
            String csvOutputPath = "src/main/resources/censored_ipl_matches.csv";

            List<IPLMatch> matches = new ArrayList<>();
            matches.addAll(readJson(jsonInputPath));
            matches.addAll(readCsv(csvInputPath));

            List<IPLMatch> censoredMatches = applyCensorship(matches);

            writeJson(jsonOutputPath, censoredMatches);
            writeCsv(csvOutputPath, censoredMatches);

            System.out.println("Censored data successfully written to output files.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static List<IPLMatch> readJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  // ✅ Prevent errors from extra fields

        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("JSON file not found: " + filePath);
            return new ArrayList<>();
        }

        return Arrays.asList(objectMapper.readValue(file, IPLMatch[].class));
    }

    private static List<IPLMatch> readCsv(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("CSV file not found: " + filePath);
            return matches;
        }

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                IPLMatch match = new IPLMatch();
                match.setMatch_id(Integer.parseInt(record.get("match_id")));
                match.setTeam1(record.get("team1"));
                match.setTeam2(record.get("team2"));
                match.setWinner(record.get("winner"));
                match.setPlayer_of_match(record.get("player_of_match"));

                // ✅ Use HashMap instead of Map.of() to allow modification
                Map<String, Integer> scoreMap = new HashMap<>();
                scoreMap.put(match.getTeam1(), Integer.parseInt(record.get("score_team1")));
                scoreMap.put(match.getTeam2(), Integer.parseInt(record.get("score_team2")));

                Score score = new Score();
                score.setScore(scoreMap);
                match.setScore(score);

                matches.add(match);
            }
        }
        return matches;
    }

    private static List<IPLMatch> applyCensorship(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.setTeam1(censorTeamName(match.getTeam1()));
            match.setTeam2(censorTeamName(match.getTeam2()));
            match.setWinner(censorTeamName(match.getWinner()));
            match.setPlayer_of_match("REDACTED");
        }
        return matches;
    }

    private static String censorTeamName(String teamName) {
        if (teamName.contains(" ")) {
            String[] parts = teamName.split(" ", 2);
            return parts[0] + " ***";
        }
        return teamName;
    }

    private static void writeJson(String filePath, List<IPLMatch> matches) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(filePath), matches);
    }

    private static void writeCsv(String filePath, List<IPLMatch> matches) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                     "match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"))) {

            for (IPLMatch match : matches) {
                Score score = match.getScore();
                csvPrinter.printRecord(
                        match.getMatch_id(),
                        match.getTeam1(),
                        match.getTeam2(),
                        (score != null) ? score.getTeamScore(match.getTeam1()) : 0,  // ✅ Handle missing scores safely
                        (score != null) ? score.getTeamScore(match.getTeam2()) : 0,
                        match.getWinner(),
                        match.getPlayer_of_match()
                );
            }
        }
    }
}

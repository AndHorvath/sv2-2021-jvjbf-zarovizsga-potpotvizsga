package learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ExamLearnings {

    // --- attributes ---------------------------------------------------------

    private Map<String, Integer> learnings;

    // --- constructors -------------------------------------------------------

    public ExamLearnings() {
        learnings = new HashMap<>();
    }

    // --- getters and setters ------------------------------------------------

    public Map<String, Integer> getLearnings() { return learnings; }

    // --- public methods -----------------------------------------------------

    public void readFromFile(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                updateLearnings(line);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    public double getAverageLearningInMinutes() {
        validateInitialData();
        return learnings.values().stream().mapToInt(time -> time).sum() / (double) learnings.size();
    }

    // --- private methods ----------------------------------------------------

    private void updateLearnings(String line) {
        int overallTime = 0;
        String[] data = line.split(";");
        validateParameter(data);
        for (int i = 1; i < data.length; i++) {
            overallTime += Double.parseDouble(data[i].replace(',', '.')) * 60;
        }
        learnings.put(data[0], overallTime);
    }

    private void validateParameter(String[] data) {
        if (data.length <= 1) {
            throwMissingDataException();
        }
    }

    private void validateInitialData() {
        if (learnings.size() == 0) {
            throwMissingDataException();
        }
    }

    private void throwMissingDataException() {
        throw new IllegalArgumentException("There are no learning times.");
    }
}
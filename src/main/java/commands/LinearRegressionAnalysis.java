package commands;

import java.util.List;

/**
 * A helper class for the StatPredictor classes; it performs a linear regression analysis on given data
 */
public class LinearRegressionAnalysis {
    List<Integer> seasons;
    List<Double> stats;
    double slope;
    double intercept;

    /**
     * Find the slope and y-intercept with the given data
     * @param xAxis a list of integers representing seasons
     * @param yAxis a list of a player's stats for each season in xAxis
     * @throws Exception if there is not enough data to make a prediction, or if the data is invalid
     */
    public LinearRegressionAnalysis(List<Integer> xAxis, List<Double> yAxis) throws Exception {

        if (xAxis.size() != yAxis.size()) {
            throw new Exception("Invalid data!");
        } else if (xAxis.size() < 2) {
            throw new Exception("Not enough data to make prediction!");
        }

        this.seasons = xAxis;
        this.stats = yAxis;
        int n = seasons.size();
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXSquared = 0;
        double sumYSquared = 0;

        for (int i = 0; i < seasons.size(); i++) {
            sumX = sumX + this.seasons.get(i);
            sumY = sumY + this.stats.get(i);
            sumXY = sumXY + (this.seasons.get(i) * this.stats.get(i));
            sumXSquared = sumXSquared + (this.seasons.get(i) * this.seasons.get(i));
            sumYSquared = sumYSquared + (this.stats.get(i) * this.stats.get(i));
        }

        double denominator = ((n * (sumXSquared)) - Math.pow(sumX, 2));

        this.slope = ((sumY * sumXSquared) - (sumX * sumXY)) / denominator;
        this.intercept = ((n * sumXY) - (sumX * sumY)) / denominator;
    }

    public double makePrediction() {
        int xValue = this.seasons.get(seasons.size() - 1) + 1;
        return (this.slope * xValue) + this.intercept;
    }
}

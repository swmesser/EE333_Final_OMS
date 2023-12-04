package OMS;

/* 
 * File: FixedInductorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class FixedInductorInfo extends InductorCoilAndChokesInfo{
    private int coilNumber;
    //Assuming value has no prefix
    private double parallelInductance;
    private double seriesInductance;
    private double parallelCurrentRating;
    private double seriesCurrentRating;
    private double parallelCurrentSaturation;
    private double seriesCurrentSaturation;
    private double parallelDCResistance;
    private double seriesDCResistance;
    private double operatingTemp;
    private ArrayInductorShielding shielding;
    private InductorRating rating;
    private String height;
    private String size;


    @Override
    public String toCSV() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the coilNumber
     */
    public int getCoilNumber() {
        return coilNumber;
    }

    /**
     * @param coilNumber the coilNumber to set
     */
    public void setCoilNumber(int coilNumber) {
        this.coilNumber = coilNumber;
    }

    /**
     * @return the parallelInductance
     */
    public double getParallelInductance() {
        return parallelInductance;
    }

    /**
     * @param parallelInductance the parallelInductance to set
     */
    public void setParallelInductance(double parallelInductance) {
        this.parallelInductance = parallelInductance;
    }

    /**
     * @return the seriesInductance
     */
    public double getSeriesInductance() {
        return seriesInductance;
    }

    /**
     * @param seriesInductance the seriesInductance to set
     */
    public void setSeriesInductance(double seriesInductance) {
        this.seriesInductance = seriesInductance;
    }

    /**
     * @return the parallelCurrentRating
     */
    public double getParallelCurrentRating() {
        return parallelCurrentRating;
    }

    /**
     * @param parallelCurrentRating the parallelCurrentRating to set
     */
    public void setParallelCurrentRating(double parallelCurrentRating) {
        this.parallelCurrentRating = parallelCurrentRating;
    }

    /**
     * @return the seriesCurrentRating
     */
    public double getSeriesCurrentRating() {
        return seriesCurrentRating;
    }

    /**
     * @param seriesCurrentRating the seriesCurrentRating to set
     */
    public void setSeriesCurrentRating(double seriesCurrentRating) {
        this.seriesCurrentRating = seriesCurrentRating;
    }

    /**
     * @return the parallelCurrentSaturation
     */
    public double getParallelCurrentSaturation() {
        return parallelCurrentSaturation;
    }

    /**
     * @param parallelCurrentSaturation the parallelCurrentSaturation to set
     */
    public void setParallelCurrentSaturation(double parallelCurrentSaturation) {
        this.parallelCurrentSaturation = parallelCurrentSaturation;
    }

    /**
     * @return the seriesCurrentSaturation
     */
    public double getSeriesCurrentSaturation() {
        return seriesCurrentSaturation;
    }

    /**
     * @param seriesCurrentSaturation the seriesCurrentSaturation to set
     */
    public void setSeriesCurrentSaturation(double seriesCurrentSaturation) {
        this.seriesCurrentSaturation = seriesCurrentSaturation;
    }

    /**
     * @return the parallelDCResistance
     */
    public double getParallelDCResistance() {
        return parallelDCResistance;
    }

    /**
     * @param parallelDCResistance the parallelDCResistance to set
     */
    public void setParallelDCResistance(double parallelDCResistance) {
        this.parallelDCResistance = parallelDCResistance;
    }

    /**
     * @return the seriesDCResistance
     */
    public double getSeriesDCResistance() {
        return seriesDCResistance;
    }

    /**
     * @param seriesDCResistance the seriesDCResistance to set
     */
    public void setSeriesDCResistance(double seriesDCResistance) {
        this.seriesDCResistance = seriesDCResistance;
    }

    /**
     * @return the operatingTemp
     */
    public double getOperatingTemp() {
        return operatingTemp;
    }

    /**
     * @param operatingTemp the operatingTemp to set
     */
    public void setOperatingTemp(double operatingTemp) {
        this.operatingTemp = operatingTemp;
    }

    /**
     * @return the shielding
     */
    public ArrayInductorShielding getShielding() {
        return shielding;
    }

    /**
     * @param shielding the shielding to set
     */
    public void setShielding(ArrayInductorShielding shielding) {
        this.shielding = shielding;
    }

    /**
     * @return the rating
     */
    public InductorRating getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(InductorRating rating) {
        this.rating = rating;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }
}

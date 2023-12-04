package OMS;

/* 
 * File: AutomotiveRelayInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class AutomotiveRelayInfo extends RelayInfo{
    private double coilCurrent;
    private RelayCoilType coil;

    @Override
    public String toCSV() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the coilCurrent
     */
    public double getCoilCurrent() {
        return coilCurrent;
    }

    /**
     * @param coilCurrent the coilCurrent to set
     */
    public void setCoilCurrent(double coilCurrent) {
        this.coilCurrent = coilCurrent;
    }

    /**
     * @return the coil
     */
    public RelayCoilType getCoil() {
        return coil;
    }

    /**
     * @param coil the coil to set
     */
    public void setCoil(RelayCoilType coil) {
        this.coil = coil;
    }
}

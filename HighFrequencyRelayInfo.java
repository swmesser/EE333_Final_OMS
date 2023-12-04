package OMS;

/* 
 * File: HighFrequencyRelayInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class HighFrequencyRelayInfo extends RelayInfo{
    private String contactForm;
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
     * @return the contactForm
     */
    public String getContactForm() {
        return contactForm;
    }

    /**
     * @param contactForm the contactForm to set
     */
    public void setContactForm(String contactForm) {
        this.contactForm = contactForm;
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

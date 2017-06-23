
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="azimuth" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="zenithAngle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", namespace = "http://schemas.hu.fnt.nl/berichten/response", propOrder = {

})
public class Response {

    protected double azimuth;
    protected double zenithAngle;

    /**
     * Gets the value of the azimuth property.
     * 
     */
    public double getAzimuth() {
        return azimuth;
    }

    /**
     * Sets the value of the azimuth property.
     * 
     */
    public void setAzimuth(double value) {
        this.azimuth = value;
    }

    /**
     * Gets the value of the zenithAngle property.
     * 
     */
    public double getZenithAngle() {
        return zenithAngle;
    }

    /**
     * Sets the value of the zenithAngle property.
     * 
     */
    public void setZenithAngle(double value) {
        this.zenithAngle = value;
    }

}

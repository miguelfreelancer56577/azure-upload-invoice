//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.17 a las 11:13:39 AM CDT 
//


package com.github.mangelt.azure.upload.invoice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.sat.gob.mx/aerolineas}Aerolineas"/&gt;
 *         &lt;element ref="{http://www.sat.gob.mx/implocal}ImpuestosLocales"/&gt;
 *         &lt;element ref="{http://www.sat.gob.mx/TimbreFiscalDigital}TimbreFiscalDigital"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aerolineas",
    "impuestosLocales",
    "timbreFiscalDigital"
})
@XmlRootElement(name = "Complemento")
public class Complemento {

    @XmlElement(name = "Aerolineas", namespace = "http://www.sat.gob.mx/aerolineas", required = true)
    protected Aerolineas aerolineas;
    @XmlElement(name = "ImpuestosLocales", namespace = "http://www.sat.gob.mx/implocal", required = true)
    protected ImpuestosLocales impuestosLocales;
    @XmlElement(name = "TimbreFiscalDigital", namespace = "http://www.sat.gob.mx/TimbreFiscalDigital", required = true)
    protected TimbreFiscalDigital timbreFiscalDigital;

    /**
     * Obtiene el valor de la propiedad aerolineas.
     * 
     * @return
     *     possible object is
     *     {@link Aerolineas }
     *     
     */
    public Aerolineas getAerolineas() {
        return aerolineas;
    }

    /**
     * Define el valor de la propiedad aerolineas.
     * 
     * @param value
     *     allowed object is
     *     {@link Aerolineas }
     *     
     */
    public void setAerolineas(Aerolineas value) {
        this.aerolineas = value;
    }

    /**
     * Obtiene el valor de la propiedad impuestosLocales.
     * 
     * @return
     *     possible object is
     *     {@link ImpuestosLocales }
     *     
     */
    public ImpuestosLocales getImpuestosLocales() {
        return impuestosLocales;
    }

    /**
     * Define el valor de la propiedad impuestosLocales.
     * 
     * @param value
     *     allowed object is
     *     {@link ImpuestosLocales }
     *     
     */
    public void setImpuestosLocales(ImpuestosLocales value) {
        this.impuestosLocales = value;
    }

    /**
     * Obtiene el valor de la propiedad timbreFiscalDigital.
     * 
     * @return
     *     possible object is
     *     {@link TimbreFiscalDigital }
     *     
     */
    public TimbreFiscalDigital getTimbreFiscalDigital() {
        return timbreFiscalDigital;
    }

    /**
     * Define el valor de la propiedad timbreFiscalDigital.
     * 
     * @param value
     *     allowed object is
     *     {@link TimbreFiscalDigital }
     *     
     */
    public void setTimbreFiscalDigital(TimbreFiscalDigital value) {
        this.timbreFiscalDigital = value;
    }

}

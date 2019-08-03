//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.17 a las 11:13:39 AM CDT 
//


package com.github.mangelt.azure.upload.invoice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{http://www.sat.gob.mx/aerolineas}OtrosCargos"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="TUA" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "otrosCargos"
})
@XmlRootElement(name = "Aerolineas", namespace = "http://www.sat.gob.mx/aerolineas")
public class Aerolineas {

    @XmlElement(name = "OtrosCargos", namespace = "http://www.sat.gob.mx/aerolineas", required = true)
    protected OtrosCargos otrosCargos;
    @XmlAttribute(name = "Version")
    protected Float version;
    @XmlAttribute(name = "TUA")
    protected Float tua;

    /**
     * Obtiene el valor de la propiedad otrosCargos.
     * 
     * @return
     *     possible object is
     *     {@link OtrosCargos }
     *     
     */
    public OtrosCargos getOtrosCargos() {
        return otrosCargos;
    }

    /**
     * Define el valor de la propiedad otrosCargos.
     * 
     * @param value
     *     allowed object is
     *     {@link OtrosCargos }
     *     
     */
    public void setOtrosCargos(OtrosCargos value) {
        this.otrosCargos = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVersion(Float value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad tua.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTUA() {
        return tua;
    }

    /**
     * Define el valor de la propiedad tua.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTUA(Float value) {
        this.tua = value;
    }

}

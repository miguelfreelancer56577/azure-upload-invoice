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
 *         &lt;element ref="{http://www.sat.gob.mx/cfd/3}DomicilioFiscal"/&gt;
 *         &lt;element ref="{http://www.sat.gob.mx/cfd/3}ExpedidoEn"/&gt;
 *         &lt;element ref="{http://www.sat.gob.mx/cfd/3}RegimenFiscal"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="rfc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "domicilioFiscal",
    "expedidoEn",
    "regimenFiscal"
})
@XmlRootElement(name = "Emisor")
public class Emisor {

    @XmlElement(name = "DomicilioFiscal", required = true)
    protected DomicilioFiscal domicilioFiscal;
    @XmlElement(name = "ExpedidoEn", required = true)
    protected ExpedidoEn expedidoEn;
    @XmlElement(name = "RegimenFiscal", required = true)
    protected RegimenFiscal regimenFiscal;
    @XmlAttribute(name = "rfc")
    protected String rfc;
    @XmlAttribute(name = "nombre")
    protected String nombre;

    /**
     * Obtiene el valor de la propiedad domicilioFiscal.
     * 
     * @return
     *     possible object is
     *     {@link DomicilioFiscal }
     *     
     */
    public DomicilioFiscal getDomicilioFiscal() {
        return domicilioFiscal;
    }

    /**
     * Define el valor de la propiedad domicilioFiscal.
     * 
     * @param value
     *     allowed object is
     *     {@link DomicilioFiscal }
     *     
     */
    public void setDomicilioFiscal(DomicilioFiscal value) {
        this.domicilioFiscal = value;
    }

    /**
     * Obtiene el valor de la propiedad expedidoEn.
     * 
     * @return
     *     possible object is
     *     {@link ExpedidoEn }
     *     
     */
    public ExpedidoEn getExpedidoEn() {
        return expedidoEn;
    }

    /**
     * Define el valor de la propiedad expedidoEn.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpedidoEn }
     *     
     */
    public void setExpedidoEn(ExpedidoEn value) {
        this.expedidoEn = value;
    }

    /**
     * Obtiene el valor de la propiedad regimenFiscal.
     * 
     * @return
     *     possible object is
     *     {@link RegimenFiscal }
     *     
     */
    public RegimenFiscal getRegimenFiscal() {
        return regimenFiscal;
    }

    /**
     * Define el valor de la propiedad regimenFiscal.
     * 
     * @param value
     *     allowed object is
     *     {@link RegimenFiscal }
     *     
     */
    public void setRegimenFiscal(RegimenFiscal value) {
        this.regimenFiscal = value;
    }

    /**
     * Obtiene el valor de la propiedad rfc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Define el valor de la propiedad rfc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

}

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
 *         &lt;element ref="{http://www.sat.gob.mx/cfd/3}Retenciones"/&gt;
 *         &lt;element ref="{http://www.sat.gob.mx/cfd/3}Traslados"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="totalImpuestosRetenidos" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="totalImpuestosTrasladados" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "retenciones",
    "traslados"
})
@XmlRootElement(name = "Impuestos")
public class Impuestos {

    @XmlElement(name = "Retenciones", required = true)
    protected Retenciones retenciones;
    @XmlElement(name = "Traslados", required = true)
    protected Traslados traslados;
    @XmlAttribute(name = "totalImpuestosRetenidos")
    protected Float totalImpuestosRetenidos;
    @XmlAttribute(name = "totalImpuestosTrasladados")
    protected Float totalImpuestosTrasladados;

    /**
     * Obtiene el valor de la propiedad retenciones.
     * 
     * @return
     *     possible object is
     *     {@link Retenciones }
     *     
     */
    public Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Define el valor de la propiedad retenciones.
     * 
     * @param value
     *     allowed object is
     *     {@link Retenciones }
     *     
     */
    public void setRetenciones(Retenciones value) {
        this.retenciones = value;
    }

    /**
     * Obtiene el valor de la propiedad traslados.
     * 
     * @return
     *     possible object is
     *     {@link Traslados }
     *     
     */
    public Traslados getTraslados() {
        return traslados;
    }

    /**
     * Define el valor de la propiedad traslados.
     * 
     * @param value
     *     allowed object is
     *     {@link Traslados }
     *     
     */
    public void setTraslados(Traslados value) {
        this.traslados = value;
    }

    /**
     * Obtiene el valor de la propiedad totalImpuestosRetenidos.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    /**
     * Define el valor de la propiedad totalImpuestosRetenidos.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalImpuestosRetenidos(Float value) {
        this.totalImpuestosRetenidos = value;
    }

    /**
     * Obtiene el valor de la propiedad totalImpuestosTrasladados.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    /**
     * Define el valor de la propiedad totalImpuestosTrasladados.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalImpuestosTrasladados(Float value) {
        this.totalImpuestosTrasladados = value;
    }

	@Override
	public String toString() {
		return "Impuestos [retenciones=" + retenciones + ", traslados="
				+ traslados + ", totalImpuestosRetenidos="
				+ totalImpuestosRetenidos + ", totalImpuestosTrasladados="
				+ totalImpuestosTrasladados + "]";
	}
    
}

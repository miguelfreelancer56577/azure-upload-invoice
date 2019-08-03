//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.26 a las 12:45:21 PM CDT 
//


package com.github.mangelt.azure.upload.invoice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="noIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="unidad" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="cantidad" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="importe" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="valorUnitario" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "Concepto")
public class Concepto {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "noIdentificacion")
    protected String noIdentificacion;
    @XmlAttribute(name = "unidad")
    protected String unidad;
    @XmlAttribute(name = "cantidad")
    protected Float cantidad;
    @XmlAttribute(name = "importe")
    protected Float importe;
    @XmlAttribute(name = "valorUnitario")
    protected Float valorUnitario;
    @XmlAttribute(name = "descripcion")
    protected String descripcion;

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la propiedad noIdentificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    /**
     * Define el valor de la propiedad noIdentificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoIdentificacion(String value) {
        this.noIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad unidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Define el valor de la propiedad unidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidad(String value) {
        this.unidad = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCantidad(Float value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad importe.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getImporte() {
        return importe;
    }

    /**
     * Define el valor de la propiedad importe.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setImporte(Float value) {
        this.importe = value;
    }

    /**
     * Obtiene el valor de la propiedad valorUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Define el valor de la propiedad valorUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setValorUnitario(Float value) {
        this.valorUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}

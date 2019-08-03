//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.17 a las 11:13:39 AM CDT 
//


package com.github.mangelt.azure.upload.invoice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="RetencionesLocales" form="qualified"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attribute name="ImpLocRetenido" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                   &lt;attribute name="TasadeRetencion" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *                   &lt;attribute name="Importe" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="TrasladosLocales" form="qualified"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attribute name="ImpLocTrasladado" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                   &lt;attribute name="TasadeTraslado" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *                   &lt;attribute name="Importe" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="TotaldeRetenciones" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="TotaldeTraslados" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "retencionesLocalesOrTrasladosLocales"
})
@XmlRootElement(name = "ImpuestosLocales", namespace = "http://www.sat.gob.mx/implocal")
public class ImpuestosLocales {

    @XmlElements({
        @XmlElement(name = "RetencionesLocales", namespace = "http://www.sat.gob.mx/implocal", type = ImpuestosLocales.RetencionesLocales.class),
        @XmlElement(name = "TrasladosLocales", namespace = "http://www.sat.gob.mx/implocal", type = ImpuestosLocales.TrasladosLocales.class)
    })
    protected List<Object> retencionesLocalesOrTrasladosLocales;
    @XmlAttribute(name = "version", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String version;
    @XmlAttribute(name = "TotaldeRetenciones", required = true)
    protected BigDecimal totaldeRetenciones;
    @XmlAttribute(name = "TotaldeTraslados", required = true)
    protected BigDecimal totaldeTraslados;

    /**
     * Gets the value of the retencionesLocalesOrTrasladosLocales property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retencionesLocalesOrTrasladosLocales property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetencionesLocalesOrTrasladosLocales().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImpuestosLocales.RetencionesLocales }
     * {@link ImpuestosLocales.TrasladosLocales }
     * 
     * 
     */
    public List<Object> getRetencionesLocalesOrTrasladosLocales() {
        if (retencionesLocalesOrTrasladosLocales == null) {
            retencionesLocalesOrTrasladosLocales = new ArrayList<Object>();
        }
        return this.retencionesLocalesOrTrasladosLocales;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad totaldeRetenciones.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotaldeRetenciones() {
        return totaldeRetenciones;
    }

    /**
     * Define el valor de la propiedad totaldeRetenciones.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotaldeRetenciones(BigDecimal value) {
        this.totaldeRetenciones = value;
    }

    /**
     * Obtiene el valor de la propiedad totaldeTraslados.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotaldeTraslados() {
        return totaldeTraslados;
    }

    /**
     * Define el valor de la propiedad totaldeTraslados.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotaldeTraslados(BigDecimal value) {
        this.totaldeTraslados = value;
    }


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
     *       &lt;/sequence&gt;
     *       &lt;attribute name="ImpLocRetenido" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="TasadeRetencion" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
     *       &lt;attribute name="Importe" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RetencionesLocales {

        @XmlAttribute(name = "ImpLocRetenido", required = true)
        protected String impLocRetenido;
        @XmlAttribute(name = "TasadeRetencion", required = true)
        protected BigDecimal tasadeRetencion;
        @XmlAttribute(name = "Importe", required = true)
        protected BigDecimal importe;

        /**
         * Obtiene el valor de la propiedad impLocRetenido.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImpLocRetenido() {
            return impLocRetenido;
        }

        /**
         * Define el valor de la propiedad impLocRetenido.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImpLocRetenido(String value) {
            this.impLocRetenido = value;
        }

        /**
         * Obtiene el valor de la propiedad tasadeRetencion.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTasadeRetencion() {
            return tasadeRetencion;
        }

        /**
         * Define el valor de la propiedad tasadeRetencion.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTasadeRetencion(BigDecimal value) {
            this.tasadeRetencion = value;
        }

        /**
         * Obtiene el valor de la propiedad importe.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getImporte() {
            return importe;
        }

        /**
         * Define el valor de la propiedad importe.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setImporte(BigDecimal value) {
            this.importe = value;
        }

    }


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
     *       &lt;/sequence&gt;
     *       &lt;attribute name="ImpLocTrasladado" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="TasadeTraslado" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
     *       &lt;attribute name="Importe" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TrasladosLocales {

        @XmlAttribute(name = "ImpLocTrasladado", required = true)
        protected String impLocTrasladado;
        @XmlAttribute(name = "TasadeTraslado", required = true)
        protected BigDecimal tasadeTraslado;
        @XmlAttribute(name = "Importe", required = true)
        protected BigDecimal importe;

        /**
         * Obtiene el valor de la propiedad impLocTrasladado.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImpLocTrasladado() {
            return impLocTrasladado;
        }

        /**
         * Define el valor de la propiedad impLocTrasladado.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImpLocTrasladado(String value) {
            this.impLocTrasladado = value;
        }

        /**
         * Obtiene el valor de la propiedad tasadeTraslado.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTasadeTraslado() {
            return tasadeTraslado;
        }

        /**
         * Define el valor de la propiedad tasadeTraslado.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTasadeTraslado(BigDecimal value) {
            this.tasadeTraslado = value;
        }

        /**
         * Obtiene el valor de la propiedad importe.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getImporte() {
            return importe;
        }

        /**
         * Define el valor de la propiedad importe.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setImporte(BigDecimal value) {
            this.importe = value;
        }

    }

}

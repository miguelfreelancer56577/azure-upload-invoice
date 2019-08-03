//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.17 a las 11:13:39 AM CDT 
//


package com.github.mangelt.azure.upload.invoice.model;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.sat.gob.mx/aerolineas}Cargo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TotalCargos" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cargo"
})
@XmlRootElement(name = "OtrosCargos", namespace = "http://www.sat.gob.mx/aerolineas")
public class OtrosCargos {

    @XmlElement(name = "Cargo", namespace = "http://www.sat.gob.mx/aerolineas")
    protected List<Cargo> cargo;
    @XmlAttribute(name = "TotalCargos")
    protected Float totalCargos;

    /**
     * Gets the value of the cargo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cargo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCargo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cargo }
     * 
     * 
     */
    public List<Cargo> getCargo() {
        if (cargo == null) {
            cargo = new ArrayList<Cargo>();
        }
        return this.cargo;
    }

    /**
     * Obtiene el valor de la propiedad totalCargos.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTotalCargos() {
        return totalCargos;
    }

    /**
     * Define el valor de la propiedad totalCargos.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTotalCargos(Float value) {
        this.totalCargos = value;
    }

}

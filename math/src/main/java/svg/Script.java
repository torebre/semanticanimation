//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.13 at 05:25:35 PM CEST 
//


package svg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "script")
public class Script {

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(name = "xml:base")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlBase;
    @XmlAttribute(name = "xml:lang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xmlLang;
    @XmlAttribute(name = "xml:space")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xmlSpace;
    @XmlAttribute(name = "xmlns:xlink")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlnsXlink;
    @XmlAttribute(name = "xlink:type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xlinkType;
    @XmlAttribute(name = "xlink:href")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xlinkHref;
    @XmlAttribute(name = "xlink:role")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xlinkRole;
    @XmlAttribute(name = "xlink:arcrole")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xlinkArcrole;
    @XmlAttribute(name = "xlink:title")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xlinkTitle;
    @XmlAttribute(name = "xlink:show")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xlinkShow;
    @XmlAttribute(name = "xlink:actuate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xlinkActuate;
    @XmlAttribute(name = "externalResourcesRequired")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String externalResourcesRequired;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlValue
    protected String value;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the xmlBase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlBase() {
        return xmlBase;
    }

    /**
     * Sets the value of the xmlBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlBase(String value) {
        this.xmlBase = value;
    }

    /**
     * Gets the value of the xmlLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlLang() {
        return xmlLang;
    }

    /**
     * Sets the value of the xmlLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlLang(String value) {
        this.xmlLang = value;
    }

    /**
     * Gets the value of the xmlSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlSpace() {
        return xmlSpace;
    }

    /**
     * Sets the value of the xmlSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlSpace(String value) {
        this.xmlSpace = value;
    }

    /**
     * Gets the value of the xmlnsXlink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlnsXlink() {
        if (xmlnsXlink == null) {
            return "http://www.w3.org/1999/xlink";
        } else {
            return xmlnsXlink;
        }
    }

    /**
     * Sets the value of the xmlnsXlink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlnsXlink(String value) {
        this.xmlnsXlink = value;
    }

    /**
     * Gets the value of the xlinkType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkType() {
        if (xlinkType == null) {
            return "simple";
        } else {
            return xlinkType;
        }
    }

    /**
     * Sets the value of the xlinkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkType(String value) {
        this.xlinkType = value;
    }

    /**
     * Gets the value of the xlinkHref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkHref() {
        return xlinkHref;
    }

    /**
     * Sets the value of the xlinkHref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkHref(String value) {
        this.xlinkHref = value;
    }

    /**
     * Gets the value of the xlinkRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkRole() {
        return xlinkRole;
    }

    /**
     * Sets the value of the xlinkRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkRole(String value) {
        this.xlinkRole = value;
    }

    /**
     * Gets the value of the xlinkArcrole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkArcrole() {
        return xlinkArcrole;
    }

    /**
     * Sets the value of the xlinkArcrole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkArcrole(String value) {
        this.xlinkArcrole = value;
    }

    /**
     * Gets the value of the xlinkTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkTitle() {
        return xlinkTitle;
    }

    /**
     * Sets the value of the xlinkTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkTitle(String value) {
        this.xlinkTitle = value;
    }

    /**
     * Gets the value of the xlinkShow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkShow() {
        if (xlinkShow == null) {
            return "other";
        } else {
            return xlinkShow;
        }
    }

    /**
     * Sets the value of the xlinkShow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkShow(String value) {
        this.xlinkShow = value;
    }

    /**
     * Gets the value of the xlinkActuate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkActuate() {
        if (xlinkActuate == null) {
            return "onLoad";
        } else {
            return xlinkActuate;
        }
    }

    /**
     * Sets the value of the xlinkActuate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlinkActuate(String value) {
        this.xlinkActuate = value;
    }

    /**
     * Gets the value of the externalResourcesRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalResourcesRequired() {
        return externalResourcesRequired;
    }

    /**
     * Sets the value of the externalResourcesRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalResourcesRequired(String value) {
        this.externalResourcesRequired = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getvalue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setvalue(String value) {
        this.value = value;
    }

}

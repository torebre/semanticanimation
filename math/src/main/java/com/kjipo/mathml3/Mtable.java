//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.05 at 04:13:41 PM CEST 
//


package com.kjipo.mathml3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mtrOrMlabeledtr"
})
@XmlRootElement(name = "mtable")
public class Mtable {

    @XmlAttribute(name = "xmlns")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlns;
    @XmlAttribute(name = "xmlns:xlink")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlnsXlink;
    @XmlAttribute(name = "xmlns:xsi")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlnsXsi;
    @XmlAttribute(name = "xlink:href")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xlinkHref;
    @XmlAttribute(name = "xlink:type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xlinkType;
    @XmlAttribute(name = "xml:lang")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlLang;
    @XmlAttribute(name = "xml:space")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xmlSpace;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "xref")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xref;
    @XmlAttribute(name = "class")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String clazz;
    @XmlAttribute(name = "style")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String style;
    @XmlAttribute(name = "href")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String href;
    @XmlAttribute(name = "other")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String other;
    @XmlAttribute(name = "mathcolor")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mathcolor;
    @XmlAttribute(name = "mathbackground")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mathbackground;
    @XmlAttribute(name = "align")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String align;
    @XmlAttribute(name = "rowalign")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rowalign;
    @XmlAttribute(name = "columnalign")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String columnalign;
    @XmlAttribute(name = "groupalign")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String groupalign;
    @XmlAttribute(name = "alignmentscope")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String alignmentscope;
    @XmlAttribute(name = "columnwidth")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String columnwidth;
    @XmlAttribute(name = "width")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String width;
    @XmlAttribute(name = "rowspacing")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rowspacing;
    @XmlAttribute(name = "columnspacing")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String columnspacing;
    @XmlAttribute(name = "rowlines")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rowlines;
    @XmlAttribute(name = "columnlines")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String columnlines;
    @XmlAttribute(name = "frame")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String frame;
    @XmlAttribute(name = "framespacing")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String framespacing;
    @XmlAttribute(name = "equalrows")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String equalrows;
    @XmlAttribute(name = "equalcolumns")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String equalcolumns;
    @XmlAttribute(name = "displaystyle")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String displaystyle;
    @XmlAttribute(name = "side")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String side;
    @XmlAttribute(name = "minlabelspacing")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String minlabelspacing;
    @XmlElements({
        @XmlElement(name = "mtr", type = Mtr.class),
        @XmlElement(name = "mlabeledtr", type = Mlabeledtr.class)
    })
    protected List<Object> mtrOrMlabeledtr;

    /**
     * Gets the value of the xmlns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlns() {
        if (xmlns == null) {
            return "http://www.w3.org/1998/Math/MathML";
        } else {
            return xmlns;
        }
    }

    /**
     * Sets the value of the xmlns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlns(String value) {
        this.xmlns = value;
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
     * Gets the value of the xmlnsXsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlnsXsi() {
        return xmlnsXsi;
    }

    /**
     * Sets the value of the xmlnsXsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlnsXsi(String value) {
        this.xmlnsXsi = value;
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
     * Gets the value of the xlinkType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlinkType() {
        return xlinkType;
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
     * Gets the value of the xref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXref() {
        return xref;
    }

    /**
     * Sets the value of the xref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXref(String value) {
        this.xref = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOther() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOther(String value) {
        this.other = value;
    }

    /**
     * Gets the value of the mathcolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMathcolor() {
        return mathcolor;
    }

    /**
     * Sets the value of the mathcolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMathcolor(String value) {
        this.mathcolor = value;
    }

    /**
     * Gets the value of the mathbackground property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMathbackground() {
        return mathbackground;
    }

    /**
     * Sets the value of the mathbackground property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMathbackground(String value) {
        this.mathbackground = value;
    }

    /**
     * Gets the value of the align property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlign() {
        return align;
    }

    /**
     * Sets the value of the align property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Gets the value of the rowalign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowalign() {
        return rowalign;
    }

    /**
     * Sets the value of the rowalign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowalign(String value) {
        this.rowalign = value;
    }

    /**
     * Gets the value of the columnalign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnalign() {
        return columnalign;
    }

    /**
     * Sets the value of the columnalign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnalign(String value) {
        this.columnalign = value;
    }

    /**
     * Gets the value of the groupalign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupalign() {
        return groupalign;
    }

    /**
     * Sets the value of the groupalign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupalign(String value) {
        this.groupalign = value;
    }

    /**
     * Gets the value of the alignmentscope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlignmentscope() {
        return alignmentscope;
    }

    /**
     * Sets the value of the alignmentscope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlignmentscope(String value) {
        this.alignmentscope = value;
    }

    /**
     * Gets the value of the columnwidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnwidth() {
        return columnwidth;
    }

    /**
     * Sets the value of the columnwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnwidth(String value) {
        this.columnwidth = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the rowspacing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowspacing() {
        return rowspacing;
    }

    /**
     * Sets the value of the rowspacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowspacing(String value) {
        this.rowspacing = value;
    }

    /**
     * Gets the value of the columnspacing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnspacing() {
        return columnspacing;
    }

    /**
     * Sets the value of the columnspacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnspacing(String value) {
        this.columnspacing = value;
    }

    /**
     * Gets the value of the rowlines property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowlines() {
        return rowlines;
    }

    /**
     * Sets the value of the rowlines property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowlines(String value) {
        this.rowlines = value;
    }

    /**
     * Gets the value of the columnlines property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnlines() {
        return columnlines;
    }

    /**
     * Sets the value of the columnlines property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnlines(String value) {
        this.columnlines = value;
    }

    /**
     * Gets the value of the frame property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Sets the value of the frame property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrame(String value) {
        this.frame = value;
    }

    /**
     * Gets the value of the framespacing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFramespacing() {
        return framespacing;
    }

    /**
     * Sets the value of the framespacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFramespacing(String value) {
        this.framespacing = value;
    }

    /**
     * Gets the value of the equalrows property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqualrows() {
        return equalrows;
    }

    /**
     * Sets the value of the equalrows property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqualrows(String value) {
        this.equalrows = value;
    }

    /**
     * Gets the value of the equalcolumns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqualcolumns() {
        return equalcolumns;
    }

    /**
     * Sets the value of the equalcolumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqualcolumns(String value) {
        this.equalcolumns = value;
    }

    /**
     * Gets the value of the displaystyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplaystyle() {
        return displaystyle;
    }

    /**
     * Sets the value of the displaystyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplaystyle(String value) {
        this.displaystyle = value;
    }

    /**
     * Gets the value of the side property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSide() {
        return side;
    }

    /**
     * Sets the value of the side property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSide(String value) {
        this.side = value;
    }

    /**
     * Gets the value of the minlabelspacing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinlabelspacing() {
        return minlabelspacing;
    }

    /**
     * Sets the value of the minlabelspacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinlabelspacing(String value) {
        this.minlabelspacing = value;
    }

    /**
     * Gets the value of the mtrOrMlabeledtr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mtrOrMlabeledtr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMtrOrMlabeledtr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mtr }
     * {@link Mlabeledtr }
     * 
     * 
     */
    public List<Object> getMtrOrMlabeledtr() {
        if (mtrOrMlabeledtr == null) {
            mtrOrMlabeledtr = new ArrayList<Object>();
        }
        return this.mtrOrMlabeledtr;
    }

}

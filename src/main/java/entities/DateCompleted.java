package main.java.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DateCompleted")
public class DateCompleted {
    private String Year;
    private String Month;
    private String Day;


    // Getter Methods
    @XmlElement(name = "Year")
    public String getYear() {
        return Year;
    }

    @XmlElement(name = "Month")
    public String getMonth() {
        return Month;
    }

    @XmlElement(name = "Day")
    public String getDay() {
        return Day;
    }

    // Setter Methods

    public void setYear(String Year) {
        this.Year = Year;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }
}

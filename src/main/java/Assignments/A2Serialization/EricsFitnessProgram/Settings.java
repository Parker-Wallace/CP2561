package Assignments.A2Serialization.EricsFitnessProgram;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Settings {
    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Weight")
    private int weight;

    @XmlElement(name = "Height")
    private int height;

    @XmlElement(name = "Birthday")
    private Date birthday;

    @XmlElement(name = "FTP")
    private int ftp;

    public String getName() {
        return name;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public int getFTP() {
        return ftp;
    }
}

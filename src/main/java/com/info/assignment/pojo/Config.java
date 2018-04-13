package com.info.assignment.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Configuration class.
 */
@Entity
@Table(name = "Config")
public class Config {

    /**
     * Primary key.
     */
    @Id
    private String macAddress;

    /**
     * IP address.
     */
    @Column
    private String ipAddress;

    /**
     * IP address creation time.
     */
    @Column
    private Date createdDate;

    /**
     * Config default constructor.
     */
    public Config() {
    }

    /**
     * Config configuration parameterized constructor.
     *
     * @param macAddress  mac address.
     * @param ipAddress   IP address.
     * @param createdDate IP address creation time.
     */
    public Config(String macAddress, String ipAddress, Date createdDate) {
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
        this.createdDate = createdDate;
    }

    /**
     * Getter method mac address.
     *
     * @return Mac address.
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Setter method for mac address.
     *
     * @param macAddress mac address.
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * Getter method for IP address.
     *
     * @return IP address.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Setter method for IP address.
     *
     * @param ipAddress IP address.
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * IP address creation date.
     *
     * @return Creation date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Setter method for creation date.
     *
     * @param createdDate Creation date.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

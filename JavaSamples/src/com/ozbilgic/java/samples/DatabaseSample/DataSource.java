package com.ozbilgic.java.samples.DatabaseSample;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 20.12.2014
 */
public interface DataSource {
    public void getAllData();
    public void setData(String isim, String tel);
    public boolean isConnectionStatus();
    public void connect();
    public void disconnect();
}

package model;

public class JSON {

    private String name;
    private String key;
    private String platform;
    private String [] apps;
    private String [] device;
    private String []os_version;


    public String getUserName(){
        return name;
    }

    public String getAccessKey(){
        return key;
    }

    public String getPlatform(){
        return platform;
    }

    public String[] getApps() {
        return apps;
    }

    public String [] getDevices(){
        return device;
    }

    public String [] getOSVersions(){
        return os_version;
    }
}

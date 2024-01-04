
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class M_Log {
    private int logID;
    private String performerName; 
    private String actionType ; 
    private String tableName;
    private String record;  
    private Date changeTime;

    // Định nghĩa định dạng ngày giờ
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public M_Log() {
    }

    public M_Log(int logID, String performerName, String actionType, String tableName, String record, Date changeTime) {
        this.logID = logID;
        this.performerName = performerName;
        this.actionType = actionType;
        this.tableName = tableName;
        this.record = record;
        this.changeTime = changeTime;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    
    @Override
    public String toString() {
        return "LogID/" + logID + "_PerformerName/" + performerName + "_ActionType/" + actionType
                + "_TableName/" + tableName + "_Record/" + record + "_ChangeTime/" + sdf.format(changeTime);
    }

    public static M_Log fromString(String str) {
        M_Log log = new M_Log();
        String[] parts = str.split("_");
        for (String part : parts) {
            String[] keyValue = part.split("/");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                    case "LogID":
                        log.setLogID(Integer.parseInt(value));
                        break;
                    case "PerformerName":
                        log.setPerformerName(value);
                        break;
                    case "ActionType":
                        log.setActionType(value);
                        break;
                    case "TableName":
                        log.setTableName(value);
                        break;
                    case "RecordID":
                        log.setRecord(value);
                        break;
                    case "ChangeTime":
                        try {
                            log.setChangeTime(sdf.parse(value));
                        } catch (Exception e) {
                            System.out.println("M_Log.fromString()");
                        }
                        break;
                }
            }
        }

        return log;
    }
}

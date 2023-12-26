
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class M_Log {
    private int logID;
    private String performerName; 
    private String actionType ; 
    private String tableName;
    private int recordID;  
    private Date changeTime;

    // Định nghĩa định dạng ngày giờ
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public M_Log() {
    }

    public M_Log(int logID, String performerName, String actionType, String tableName, int recordID, Date changeTime) {
        this.logID = logID;
        this.performerName = performerName;
        this.actionType = actionType;
        this.tableName = tableName;
        this.recordID = recordID;
        this.changeTime = changeTime;
    }

    public int getLog_id() {
        return logID;
    }

    public void setLog_id(int logID) {
        this.logID = logID;
    }

    public String getPerformer_name() {
        return performerName;
    }

    public void setPerformer_name(String performerName) {
        this.performerName = performerName;
    }

    public String getAction_type() {
        return actionType;
    }

    public void setAction_type(String actionType) {
        this.actionType = actionType;
    }

    public String getTable_name() {
        return tableName;
    }

    public void setTable_name(String tableName) {
        this.tableName = tableName;
    }

    public int getRecord_id() {
        return recordID;
    }

    public void setRecord_id(int recordID) {
        this.recordID = recordID;
    }

    public Date getChange_time() {
        return changeTime;
    }

    public void setChange_time(Date changeTime) {
        this.changeTime = changeTime;
    }
    
    @Override
    public String toString() {
        return "LogID/" + logID + "_PerformerName/" + performerName + "_ActionType/" + actionType
                + "_TableName/" + tableName + "_RecordID/" + recordID + "_ChangeTime/" + sdf.format(changeTime);
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
                        log.setLog_id(Integer.parseInt(value));
                        break;
                    case "PerformerName":
                        log.setPerformer_name(value);
                        break;
                    case "ActionType":
                        log.setAction_type(value);
                        break;
                    case "TableName":
                        log.setTable_name(value);
                        break;
                    case "RecordID":
                        log.setRecord_id(Integer.parseInt(value));
                        break;
                    case "ChangeTime":
                        try {
                            log.setChange_time(sdf.parse(value));
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

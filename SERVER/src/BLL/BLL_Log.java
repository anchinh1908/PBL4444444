
package BLL;

import DTO.M_Log;
import java.util.ArrayList;

public class BLL_Log {
    public ArrayList<M_Log> getListLog()
    {
        return new DAL.DAO_log().getListLog();
    } 
}

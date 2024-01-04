
package DTO;

public class M_Client {
    private String Username, Password,Fullname,Status; 

    public M_Client() {
    }

    public M_Client(String Username, String Password, String Fullname) {
        this.Username = Username;
        this.Password = Password;
        this.Fullname = Fullname;
    }
    
    public M_Client(String Username, String Password, String Fullname, String Status) {
        this.Username = Username;
        this.Password = Password;
        this.Fullname = Fullname;
        this.Status = Status;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    @Override
    public String toString() {
        return "M_Client{" + "Username=" + Username + ", Password=" + Password + ", Fullname=" + Fullname + ", Status=" + Status + '}';
    }
  
}

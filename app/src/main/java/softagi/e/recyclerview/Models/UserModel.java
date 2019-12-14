package softagi.e.recyclerview.Models;

public class UserModel
{
    private String name;
    private String mobile;
    private String address;

    public UserModel(String name, String mobile, String address)
    {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

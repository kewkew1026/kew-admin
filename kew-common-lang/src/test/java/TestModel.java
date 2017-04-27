import com.kew.annotation.KEWValid;

/**
 * Created by qiudanping on 2017/4/27.
 */
public class TestModel {

    @KEWValid(name = "姓名",min=5,max=6,required = true)
    private String name;


    @KEWValid(name = "手机号码",min=11,max=11,required = true)
    private String mobile;

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
}

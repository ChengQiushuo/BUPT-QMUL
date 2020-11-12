package entity;
/**
 * Title        : MemberInfo.java
 * Description  : This class is used for processing membership information.
 * @author      : Qiushuo Cheng
 * @author      : Hu Zhenming
 * @version     : 1.2
 */
public class MemberInfo {
    public String memberNumber;

    public String stamps;
    public MemberInfo(String number, String stamps){
        this.stamps = stamps;
        this.memberNumber = number;
    }
}

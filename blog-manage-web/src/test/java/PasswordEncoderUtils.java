import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密
 *
 * @author wangfujie
 * @version v1.0.0
 * @create 2019年10月17日
 */
public class PasswordEncoderUtils {

    @Test
    public void password(){
        //加密密码
        System.out.println(new BCryptPasswordEncoder().encode("1"));
    }
}

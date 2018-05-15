/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 13:49 2018/5/15
 * @Modified By:
 */
public class question434 {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}

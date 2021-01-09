package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/12 0012
 * @description：
 */
public class IP地址划分93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(0, res, sb, s);
        return res;
    }

    private void dfs(int cnt, List<String> res, StringBuffer sb, String s) {
        if (cnt == 4 || s.length() == 0) {
            if (cnt == 4 && s.length() == 0) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i <= 2 && i < s.length(); i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (cnt != 0) {
                    part = "." + part;
                }
                sb.append(part);
                dfs(cnt + 1, res, sb, s.substring(i + 1));
                sb.delete(sb.length() - part.length(), sb.length());
            }
        }
    }
}

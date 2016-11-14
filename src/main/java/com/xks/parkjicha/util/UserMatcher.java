package com.xks.parkjicha.util;

import com.xks.parkjicha.bean.LoginReqBean;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Xingfeng on 2016/8/11.
 */
public class UserMatcher {

    private static Logger logger = Logger.getLogger(UserMatcher.class);

    private UserMatcher() {
    }

    /**
     * 查询文本中是否含有该用户
     *
     * @param loginReqBean 登录请求报文体
     * @return
     */
    public static boolean hasUser(LoginReqBean loginReqBean) {

        boolean result = false;

        BufferedReader reader = null;
        try {

            String line = "";
            String[] lineArrays = null;
            File file = new File("D:\\IDE\\users.txt");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((line = reader.readLine()) != null) {

                lineArrays = line.split("/");
                String username = lineArrays[0].trim();
                String passwd = lineArrays[1].trim();
                if (loginReqBean.getWorkerid().equals(username) && loginReqBean.getPassword().equals(passwd)) {
                    result = true;
                    return result;
                }

            }

        } catch (Exception e) {

            logger.error(e);

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;

    }

}

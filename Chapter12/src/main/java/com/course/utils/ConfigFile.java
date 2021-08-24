package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName ConfigFile
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:19 下午
 * @Version 1.0
 **/
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    private static String getUrl(InterfaceName name) {
        String address = bundle.getString("test.url");
        String uri = "";
        //最终的测试地址
        String testUrl;

        if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("getUserList.uri");
        }else if (name == InterfaceName.LOGIN) {
            uri = bundle.getString("login.uri");
        }else if (name == InterfaceName.UPDATEUSERINFO) {
            uri = bundle.getString("updateUserInfo.uri");
        }else if (name == InterfaceName.GETUSERINFO) {
            uri = bundle.getString("getUserInfo.uri");
        }else if (name == InterfaceName.ADDUSERINFO) {
            uri = bundle.getString("addUser.uri");
        }

        testUrl = address + uri;
        return testUrl;
    }
}

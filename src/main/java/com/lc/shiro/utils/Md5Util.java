package com.lc.shiro.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/24 0:14
 */
public class Md5Util {

    private final static Logger LOG = LogManager.getLogger(Md5Util.class);

    public static void main(String[] args) {
        //使用MD5加密
        String hashAlgorithmName = "MD5";
        //加密的密码
        String source = "123";
        //盐
        //String salt = "精英";
        //加密的次数
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName,source,null,hashIterations);
        LOG.info("加密密码:" + simpleHash);
    }
}

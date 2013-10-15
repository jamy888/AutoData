package com.huateng.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.huateng.common.LOG;

public class BusParam {

    private static final String BUNDLE_NAME = "BusParam"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE =
        ResourceBundle.getBundle(BUNDLE_NAME);
    private BusParam() {
    }

    public static String getBusParam(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            LOG.MNTINFO("BusParam参数["+key+"]未配置:",e);
            return key;
        }
    }
}

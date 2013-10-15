package com.huateng.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class SysParam {

    private static final String BUNDLE_NAME = "SysParam";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private SysParam() {
    }

    public static String getSysParam(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return key;
        }
    }
}

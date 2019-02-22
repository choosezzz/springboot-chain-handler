package com.bj58.lego.onlinedebug.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 15:53
 */
public class PathUtil {
    private static final Logger logger = LoggerFactory.getLogger(PathUtil.class);

    public PathUtil() {
    }

    public static String getCurrentPath() {
        String path = System.getProperty("serviceframe.config.path");
        if (path == null || path.equalsIgnoreCase("")) {
            Class<?> caller = getCaller();
            if (caller == null) {
                caller = PathUtil.class;
            }

            path = getCurrentPath(caller);
        }

        logger.info("utility path getCurrentPath:" + path);
        return path;
    }

    public static void setCurrentPath(String path) {
        if (path == null || path.equalsIgnoreCase("")) {
            Class<?> caller = getCaller();
            if (caller == null) {
                caller = PathUtil.class;
            }

            path = getCurrentPath(caller);
        }

        System.setProperty("serviceframe.config.path", path);
    }

    public static Class<?> getCaller() {
        StackTraceElement[] stack = (new Throwable()).getStackTrace();
        if (stack.length < 3) {
            return PathUtil.class;
        } else {
            String className = stack[2].getClassName();

            try {
                return Class.forName(className);
            } catch (ClassNotFoundException var3) {
                var3.printStackTrace();
                return null;
            }
        }
    }

    public static String getCurrentPath(Class<?> cls) {
        String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.replaceFirst("file:/", "");
        path = path.replaceAll("!/", "");
        if (path.lastIndexOf(File.separator) >= 0) {
            path = path.substring(0, path.lastIndexOf(File.separator));
        }

        if (path.substring(0, 1).equalsIgnoreCase("/")) {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.indexOf("window") >= 0) {
                path = path.substring(1);
            }
        }

        return path;
    }
}

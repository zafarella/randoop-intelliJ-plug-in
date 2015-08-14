/**
 * Created by z1 on 8/14/15.
 */
package com.zafarella.intellij.plugin.randoop;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Version {

    private static final String PLUGIN_VERSION;

    static {
        try {
            URL url = Version.class.getClassLoader().getResource("META-INF/plugin.xml");
            PLUGIN_VERSION = parseVersionFromFile(url);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    private static String parseVersionFromFile(URL url) throws IOException {
        String text = Resources.toString(url, Charsets.UTF_8);

        Pattern versionTagPattern = Pattern.compile(".*?<version>(.+?)</version>");
        Matcher matcher = versionTagPattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "<unknown>";
        }
    }

    public static String get() {
        return PLUGIN_VERSION;
    }


}

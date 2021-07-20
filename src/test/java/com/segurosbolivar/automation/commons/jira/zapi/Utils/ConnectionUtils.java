package com.segurosbolivar.automation.commons.jira.zapi.Utils;

import com.segurosbolivar.automation.commons.jira.JiraConstants;
import org.apache.commons.codec.binary.Base64;

import java.util.logging.Logger;

/**
 * Created by Chaitanya on 31-May-15.
 */
public class ConnectionUtils {
    static Logger logger = Logger.getLogger(ConnectionUtils.class.getName());

    public static String getEncodedAuthKey() {
        String username = JiraConstants.JIRA_USER;
        String password = JiraConstants.JIRA_PASSWORD;
        String combo = username + ":" + password;
        byte[] base64EncodedUsername = Base64.encodeBase64(combo.getBytes());
        String temp = new String(base64EncodedUsername);
        String encodedUsername = "Basic " + temp;
        System.out.println("encodedUsername "+encodedUsername);
        return encodedUsername;
    }
}

/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PatternUtils.
 */
public class PatternUtils {

    private final static Logger logger = LoggerFactory.getLogger(PatternUtils.class);

    private static final long MEGABYTE = 1024L * 1024L;

    private static final long GIGABYTE = 1024L;

    public static final String svcTagPattern = "^[A-Za-z0-9&&[^AEIOUaeiou]]{7}$";

    public static final Pattern NFS_PATTERN = Pattern.compile(".*[:]{1}[/]{1}[^/].*$");

    public static final Pattern CIFS_PATTERN = Pattern.compile("[\\\\][\\\\][^\\\\].{0,255}[\\\\]{1}[^\\\\]*.*");

    public static final Pattern NFS_FILE_PATTERN = Pattern.compile(".*[:]{1}[/]{1}[^/].*[.]{1}.*$");

    public static final Pattern CIFS_FILE_PATTERN = Pattern.compile("[\\\\][\\\\][^\\\\].{0,255}[\\\\]{1}[^\\\\]*.*[.]{1}.*");

    public static final Pattern STRING_PATTERN = Pattern.compile("[!@#$%*()_0-9A-Za-z]*");

    public static final Pattern IPADDRESS_PATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");


    /**
     * Convert bytes to MegaBytes.
     *
     * @param bytes the bytes
     * @return megabytes
     */
    public static long bytesToMegaBytes(long bytes) {
        return bytes / MEGABYTE;
    }


    /**
     * Convert megaBytes to GigaBytes.
     *
     * @param megaBytes the mega bytes
     * @return gigaBytes
     */
    public static double megaBytesToGigaBytes(double megaBytes) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(megaBytes / GIGABYTE));
    }


    /**
     * Matches input string with pattern string.
     *
     * @param inputStr the input str
     * @param patternStr the pattern str
     * @return bool value
     */
    public static boolean isMatch(String inputStr, String patternStr) {
        boolean matchFound = false;
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputStr);
        matchFound = matcher.matches();
        return matchFound;
    }


    /**
     * Matches input string with pattern string.
     *
     * @param inputStr the input str
     * @param patternStr the pattern str
     * @return bool value
     */
    public static boolean isMatch(String[] inputStr, String patternStr) {
        boolean matchFound = false;
        for (String str : inputStr) {
            if (str == null)
                return matchFound;
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(str);
            matchFound = matcher.matches();
            if (matchFound)
                return matchFound;
        }
        return matchFound;
    }


    /**
     * Matches search string in a string.
     *
     * @param inputStr the input str
     * @param subStrSearch the sub str search
     * @param separator the separator
     * @return bool value
     */
    public static boolean isSubStrMatch(String inputStr, String subStrSearch, String separator) {
        if (subStrSearch == null || inputStr == null)
            return false;

        StringTokenizer tokens = new StringTokenizer(inputStr, separator);
        String strValue = null;

        while (tokens.hasMoreTokens()) {
            strValue = tokens.nextToken().trim();
            if (strValue != null && strValue.equalsIgnoreCase(subStrSearch))
                return true;
        }
        return false;
    }


    /**
     * Validate cifs userinfo.
     *
     * @param checkDomain the check domain
     * @param checkUser the check user
     * @param checkPassword the check password
     * @return true if the user info supplied is ok; false if it can't be used.
     * 
     * From the jcifs javadocs, http://jcifs.samba.org/src/docs/api/, "The userinfo component of the SMB URL (domain;user:pass) must be URL encoded if it contains reserved
     * characters. According to RFC 2396 these characters are non US-ASCII characters and most meta characters however jCIFS will work correctly with anything but '@' which is used
     * to delimit the userinfo component from the server and '%' which is the URL escape character itself."
     * 
     * Note: This method will not return False if something is null. It's only checking for the above two illegal characters. If an empty password won't work, check for that
     * elsewhere.
     */
    public static boolean validateCifsUserinfo(String checkDomain, String checkUser, String checkPassword) {
        // final String AT = "@";
        // final String PERCENT = "%";
        boolean result = true;

        // if (checkUser == null || checkUser.isEmpty() || checkUser.contains(AT) || checkDomain.contains(PERCENT)) {
        // ExceptionUtilities.handleRuntimeSpectre(2008);
        // }
        // if (checkPassword == null || checkPassword.isEmpty() || checkPassword.contains(AT) || checkPassword.contains(PERCENT) ) {
        // ExceptionUtilities.handleRuntimeSpectre(2007);
        // }
        //
        // if ( checkDomain != null && ( checkDomain.contains(AT) || checkDomain.contains(PERCENT) ) )
        // {
        // ExceptionUtilities.handleRuntimeSpectre(2009);
        // }

        return result;
    }


    /**
     * Checks if is NFS path.
     *
     * @param nfsPath the nfs path
     * @return true, if is NFS path
     */
    public static boolean isNFSPath(String nfsPath) {
        if (StringUtils.isNotEmpty(nfsPath) && StringUtils.isNotBlank(nfsPath)) {
            if (nfsPath.endsWith("/")) {
                nfsPath = nfsPath.substring(0, nfsPath.length() - 1);
            }
            Matcher nfsPattern = NFS_PATTERN.matcher(nfsPath);
            return nfsPattern.matches();
        }

        return false;
    }


    /**
     * Checks if is CIFS path.
     *
     * @param cifsPath the cifs path
     * @return true, if is CIFS path
     */
    public static boolean isCIFSPath(String cifsPath) {
        if (StringUtils.isNotEmpty(cifsPath) && StringUtils.isNotBlank(cifsPath)) {
            if (cifsPath.endsWith("\\")) {
                cifsPath = cifsPath.substring(0, cifsPath.length() - 1);
            }
            Matcher nfsPattern = CIFS_PATTERN.matcher(cifsPath);
            return nfsPattern.matches();
        }

        return false;
    }


    /**
     * Checks if is NFS file path.
     *
     * @param shareFilePath the share file path
     * @return true, if is NFS file path
     */
    public static boolean isNFSFilePath(String shareFilePath) {
        if (shareFilePath != null) {
            return NFS_FILE_PATTERN.matcher(shareFilePath).matches();
        }

        return false;
    }


    /**
     * Checks if is CIFS file path.
     *
     * @param cifsFilePath the cifs file path
     * @return true, if is CIFS file path
     */
    public static boolean isCIFSFilePath(String cifsFilePath) {
        if (StringUtils.isNotEmpty(cifsFilePath) && StringUtils.isNotBlank(cifsFilePath)) {
            if (cifsFilePath.endsWith("\\")) {
                cifsFilePath = cifsFilePath.substring(0, cifsFilePath.length() - 1);
            }
            Matcher nfsPattern = CIFS_FILE_PATTERN.matcher(cifsFilePath);
            return nfsPattern.matches();
        }

        return false;
    }


    /**
     * Checks if is valid path.
     *
     * @param path the path
     * @param domain the domain
     * @param shareUsername the share username
     * @param sharePassword the share password
     * @return true, if is valid path
     */
    public static boolean isValidPath(String path, String domain, String shareUsername, String sharePassword) {

        if (StringUtils.isNotEmpty(path) && StringUtils.isNotBlank(path)) {
            if (isNFSPath(path)) {
                return true;
            } else if (isCIFSPath(path)) {
                // validate if the username and password are provided or not.
                return validateCifsUserinfo(domain, shareUsername, sharePassword);
            }
        } else {
            ExceptionUtilities.handleInvalidArgs("Share Path");
        }

        return false;
    }


    /**
     * Checks if is valid file path.
     *
     * @param path the path
     * @param domain the domain
     * @param shareUsername the share username
     * @param sharePassword the share password
     * @return true, if is valid file path
     */
    public static boolean isValidFilePath(String path, String domain, String shareUsername, String sharePassword) {

        if (StringUtils.isNotEmpty(path) && StringUtils.isNotBlank(path)) {
            if (isNFSFilePath(path)) {
                return true;
            } else if (isCIFSFilePath(path)) {
                // validate if the username and password are provided or not.
                return validateCifsUserinfo(domain, shareUsername, sharePassword);
            }
        } else {
            ExceptionUtilities.handleInvalidArgs("Share Path");
        }

        return false;
    }


    /**
     * Strip the build number from a version string. The build number will be the last digits, always.
     *
     * 1.0.1.15 becomes 1.0.1 1.1.12 becomes 1.1 1.0.1 becomes 1.0
     *
     * This method ASSUMES that that LAST token is a build number!
     *
     * NOTE: This method was created to compare the appliance version to the db version (which is always major.minor.micro). The db version should not use this method because it
     * doesn't need cleaning.
     *
     * @param version A version string in the format X.Y.Z.build#
     * @return A version string in the format X.Y.X
     */
    public static String stripVersionBuild(String version) {
        logger.debug("Stripping the build from the appliance version " + version);
        StringBuilder newVersion = new StringBuilder("");
        String[] digittokens = null;
        String[] newdigits = null;

        try {
            if (version != null) {
                digittokens = version.split("[.]");
                newdigits = new String[digittokens.length - 1];

                if (digittokens.length > 1) {
                    // drop the last number
                    for (int i = 0; i < (digittokens.length - 1); i++) {
                        newdigits[i] = digittokens[i];
                    }
                    // make the new string
                    for (String digit : newdigits) {
                        newVersion.append(digit).append(".");
                    }
                    newVersion.deleteCharAt(newVersion.length() - 1);
                } else {
                    newVersion.append(version);
                }
            }
        } catch (ArrayIndexOutOfBoundsException aie) {
            logger.warn("Array index out of bounds:" + digittokens + ":" + newdigits);
            newVersion = new StringBuilder(version);
        }

        return newVersion.toString();
    }


    /**
     * Decides which version string is the most recent. Version strings with non-numerics are NOT tested.
     * 
     * @param left A String of the format major.minor.build; eg, 1.0.1
     * @param right A String of the format major.minor.build; eg. 1.0.1.587
     * @return The most recent version
     */
    public static String getRecentVersion(String left, String right) {
        // logger.debug("Comparing " + left + " and " + right + " versions");
        String[] leftTokens = left.split("[.]");
        String[] rightTokens = right.split("[.]");

        if (leftTokens.length > rightTokens.length) {
            String[] tmp = leftTokens;

            leftTokens = rightTokens;
            rightTokens = tmp;

            String tmpStr = left;
            left = right;
            right = tmpStr;
        }

        String recent = right; // the longer of the two
        for (int i = 0; i < leftTokens.length; i++) {
            int leftInt = Integer.parseInt(leftTokens[i]);
            int rightInt = Integer.parseInt(rightTokens[i]);

            if (leftInt < rightInt) {
                recent = right;
                break;
            } else if (leftInt > rightInt) {
                recent = left;
                break;
            }

        }
        logger.debug("Compare " + left + " and " + right + " version:" + recent);
        return recent;
    }


    /**
     * Write to file.
     *
     * @param pathToFile the path to file
     * @param stringToWrite the string to write
     */
    public static void writeToFile(String pathToFile, String stringToWrite) {

        logger.debug("Entering method writeToFile() ");

        if (StringUtils.isEmpty(pathToFile) || StringUtils.isBlank(pathToFile)) {
            ExceptionUtilities.handleInvalidArgs(pathToFile);
        }

        if (StringUtils.isEmpty(stringToWrite) || StringUtils.isBlank(stringToWrite)) {
            ExceptionUtilities.handleInvalidArgs(stringToWrite);
        }

        FileWriter fstream = null;
        BufferedWriter outobj = null;
        try {

            fstream = new FileWriter(new File(pathToFile));
            outobj = new BufferedWriter(fstream);
            outobj.write(stringToWrite);

        } catch (Exception e) {
            logger.error("Error while updating the file " + pathToFile, e);
            ExceptionUtilities.handleRuntimeCore(210002, e, pathToFile);
        } finally {

            try {
                if (null != outobj) {
                    outobj.close();
                }
                if (null != fstream) {
                    fstream.close();
                }

            } catch (IOException e) {
                logger.error("Error cleaning the buffered objects ", e);
            }
        }

        logger.debug("Exiting method writeToFile() ");
    }


    /**
     * Validate encryption password.
     *
     * @param password the password
     * @return true, if successful
     */
    public static boolean validateEncryptionPassword(String password) {
        boolean isMatching = STRING_PATTERN.matcher(password).matches();
        if (!isMatching || password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }


    public static int diff(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);
        int diffDay = 0;

        if (c1.before(c2)) {
            diffDay = countDiffDay(c1, c2);
        } else {
            diffDay = countDiffDay(c2, c1);
        }

        return diffDay;
    }


    /**
     * Count diff day.
     *
     * @param c1 the c 1
     * @param c2 the c 2
     * @return the int
     */
    public static int countDiffDay(Calendar c1, Calendar c2) {
        int returnInt = 0;
        while (!c1.after(c2)) {
            c1.add(Calendar.DAY_OF_MONTH, 1);
            returnInt++;
        }

        if (returnInt > 0) {
            returnInt = returnInt - 1;
        }

        return (returnInt);
    }


    /**
     * Gets the client locale.
     *
     * @param locale the locale
     * @return the client locale
     */
    public static Locale getClientLocale(String locale) {
        try {
            String[] localeSplit = locale.split("_");
            return new Locale(localeSplit[0], localeSplit[1]);
        } catch (Exception ex) {
            return Locale.US;
        }
    }


    /**
     * Validates an ipAddress.
     *
     * @param ipAddress IP Address
     * @return True or False
     */
    public static boolean isValidIP(String ipAddress) {
        Matcher matcher;

        if (ipAddress.trim().equals("0.0.0.0")) {
            return false;
        }

        matcher = IPADDRESS_PATTERN.matcher(ipAddress);
        return matcher.matches();
    }
}

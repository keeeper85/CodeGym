package com.codegym.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* 
Data integrity

Imagine this situation: you're downloading a zip file from the Internet and in the middle of the download you lose your connection for a few seconds.
You need to be sure that the downloaded zip file is valid. To do this, check its MD5 hash.
Read about MD5 on Wikipedia.
Read about MessageDigest.

Implement the compareMD5() method, which should get an MD5 hash from the passed ByteArrayOutputStream and compare it against the reference MD5 passed as the second argument.
The main() method is not tested.

*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); // true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(byteArrayOutputStream.toByteArray());
        byte[] digest = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            String hex = Integer.toHexString(0xFF & digest[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }


        return hexString.toString().equals(md5);
    }
}

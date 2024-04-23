package com.DEVLooping.challengesAPI.service;

import java.util.Base64;


public class EncryptService {
    
    public String encrypt(String string) {
        byte[] encrypt = Base64.getEncoder().encode(string.getBytes());
        return new String(encrypt);
    }

    public String decrypt(String string) {
        byte[] decrypt = Base64.getDecoder().decode(string.getBytes());
        return new String(decrypt);
    }
}


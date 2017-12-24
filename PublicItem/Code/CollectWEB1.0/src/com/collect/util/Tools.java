package com.collect.util;

import java.util.UUID;

public class Tools {
	public static String creatUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

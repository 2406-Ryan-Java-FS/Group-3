package com.revature.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Static helper functions to do basic things.
    May need a Util class that is a @Service in case it has to tie into spring beans in any way.
 */
public class Help
{
    /**
     * @param anything to be converted to json for viewing
     * @param indentIt will toggle pretty indented json
     * @param limitStringLength will toggle limiting the length to 300 characters
     * @returns a json string to view for debugging
     */
    public static String json(Object anything,boolean indentIt,boolean limitStringLength){
        ObjectMapper m=new ObjectMapper();
        if(indentIt) m.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String json=m.writeValueAsString(anything);
            return limitStringLength?json.substring(0,Math.min(json.length(),300))+"........":json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String randomString()
    {
        String s1="";
        for(int i=0;i<50;i++){
            switch((int)(Math.random()*10))
            {
                case 0:s1+="i193hIId8dq!wdsWEfdqwd1dw";break;
                case 1:s1+="bslcU98uNW_DSh9rfond981Fdhniwd";break;
                case 2:s1+="3g8smYcpoiejW9823hifn";break;
                case 3:s1+="2by9sfWgvq3t82h9Fdbansoicn0298hri";break;
                case 4:s1+="insc9Tu13bGd9oaiFsnEbf!owief";break;
                case 5:s1+="c9n0S8$RA2Z3Cy0nec";break;
                case 6:s1+="0912WEucSnr07tgw";break;
                case 7:s1+="2oc8ikQnsv9uwrFFtqBikmsp";break;
                case 8:s1+="09t0nSwh943%2r4r3f1srehe";break;
                case 9:s1+="ois#j9iqwerZqCwdqwd";break;
                case 10:s1+="091CsmjvnQ@QiaKiuq";break;
            }
        }

        String[] a1=s1.split("9");
        List<String> a2=new ArrayList<>(Arrays.asList(a1));
        Collections.shuffle(a2);
        String s2=String.join("",a2);
        return s2.substring(0,Math.min(s2.length(),255));
    }
}

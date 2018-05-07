package com.manage.utils;

import org.apache.commons.lang3.StringEscapeUtils;




public class StringEscape {
	
	public static String escape(String data){
		data = escape2(data);
		data = data.replaceAll("\n", "<br>");
		data = data.replaceAll("\r", "<br>");
		return data;
	}
	
	public static String escape2(String data)  
    {  
        StringBuilder sb = new StringBuilder(data.length() + 16);  
        for (int i = 0; i < data.length(); i++)  
        {  
            char c = data.charAt(i);  
            switch (c)  
            {  
            case '>':  
                sb.append("&gt;");// 全角大于号  
                break;  
            case '<':  
                sb.append("&lt;");// 全角小于号  
                break;  
            case '\'':  
                sb.append("&apos;");// 全角单引号  
                break;  
            case '\"':  
                sb.append("&quot;");// 全角双引号  
                break;  
            case '\\':  
                sb.append("\\\\");// 全角斜线  
                break;  
            case ' ':  
            	sb.append("&nbsp;"); // 全角冒号  
            	break;  
            case '&':
            	sb.append("&amp;");
            	break;
            default:  
                sb.append(c);  
                break;  
            }  
  
        }  
        return sb.toString();  
    }  
}

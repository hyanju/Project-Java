package wordCount;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Word {
	
    
    public static void main(String[] args) throws IOException {
       
    	File file = new File("D:/eclipse/a.txt");//����һ��file����������ʼ��FileReader
    	if(!file.exists()){
    		System.out.println(0);
        }
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte bytes[] = new byte[length];
        inputStream.read(bytes);
        inputStream.close();
        String str =new String(bytes, StandardCharsets.UTF_8);
        System.out.println(str);
        
        String[] str1 = str.split("\\s+");
        for(String ss : str1){
            System.out.println(ss);
        }
        int i;
        
        // ��ָ��ģʽ���ַ�������
        String pattern = "[a-zA-Z]{4}[a-zA-Z0-9]";
        String pattern1 = "[a-zA-Z]{4}$";
        // ���� Pattern ����
        Pattern r = Pattern.compile(pattern);
        Pattern r1 = Pattern.compile(pattern1);
        String[] str2 = new String[str1.length];
        int k=0;
        // ���ڴ��� matcher ����
        for(i=0;i<str1.length;i++){
        	Matcher m = r.matcher(str1[i]);
        	Matcher m1 = r1.matcher(str1[i]);
        	if(m.find()||m1.find()) {
        		StringBuffer sb = new StringBuffer();
        		for(int j=0; j < str1[i].length(); j++) {
        			
    				//����ָ��λ�õ��ַ�
    				char c = str1[i].charAt(j);
    				
    				//�ж��Ƿ�ΪСд��ĸ
    				if(Character.isUpperCase(c)) {
    					sb.append(Character.toLowerCase(c));
    				}else {
    					sb.append(Character.toLowerCase(c));
    				}
    				
    			}
        		str1[i]=sb.toString();
        		System.out.println(str1[i]);
        		str2[k]=str1[i];
        		k++;
        	}
        }

        
        List list=Arrays.asList(str2);
        
        Set set=new HashSet(list);
        set.remove(null);
        System.out.println("words"+set.size());

    }
}









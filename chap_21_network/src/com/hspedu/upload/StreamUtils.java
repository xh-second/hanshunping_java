package com.hspedu.upload;

import java.io.*;

/**
 * @author Yang XinHua
 * @date 2022/7/19
 */
public class StreamUtils {
    /**
     * 将输入流转换成byte[],即可以把文件内容读入到字节数组中
     * @param is
     * @return
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while((length = is.read(buffer)) != -1){
            bos.write(buffer, 0, length);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    /**
     * 将InputStream转换成String
     */
    public static String streamToString(InputStream is) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str;
        while ((str = br.readLine()) != null){
            sb.append(str+"\n\r");
        }
        return sb.toString();
    }
}

package com.yyxk.rxjava_retrofit.utils;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：WheelMedical
 * 包名:com.yyxk.wheelmedical.util
 * 类描述：
 * 创建人：Random
 * 创建时间：17:54
 * 修改人：Random
 * 修改时间：17:54
 * 修改备注：
 */

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：WheelMedicalUtils
 * 包名:com.yyxk.wheelmedicalutils
 * 类描述： 加密与解密类
 * 创建人：Random
 * 创建时间：17:41
 * 修改人：Random
 * 修改时间：17:41
 * 修改备注：
 */
public class DES3Util {

    String key;

//	  String key = "www.baoo^#($@gu.com!=#$%";   //加密密钥（24字节）

    public DES3Util(String str) {
        setKey(str); // 生成密匙
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }





    /**
     * 字符串 DESede(3DES) 加密
     */
    private static final String Algorithm = "DESede"; // 定义 加密算法,可用

    /**
     * 加密方法
     * @Create_by:yinsy
     * @Create_date:2013-11-11
     * @param keybyte 加密密钥，长度为24字节
     * @param src 被加密的数据缓冲区（源）
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:BaooguDetails 1.0
     */
    public byte[] encryptMode(byte[] keybyte, byte[] src) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {

        keybyte = build3DesKey(key);
        // 生成密钥
        SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
        // 加密
        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(Cipher.ENCRYPT_MODE, deskey);
        return c1.doFinal(src);

    }

    /**
     * 解密方法
     * @Create_by:yinsy
     * @Create_date:2013-11-11
     * @param keybyte 加密密钥，长度为24字节
     * @param src 加密后的缓冲区
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:BaooguDetails 1.0
     */
    public byte[] decryptMode(byte[] keybyte, byte[] src) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {

        keybyte = build3DesKey(key);
        // 生成密钥
        SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
        // 解密
        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(Cipher.DECRYPT_MODE, deskey);
        return c1.doFinal(src);
    }

    /**
     * 加密字符串
     * @Create_by:yinsy
     * @Create_date:2013-11-11
     * @param str 加密后的缓冲区
     * @return
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:BaooguDetails 1.0
     */
    public String encryptMode(String str) throws InvalidKeyException,
            UnsupportedEncodingException, NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        byte[] encoded = encryptMode(null, str.getBytes());
        System.out.println("des3:  "+new String(encoded));
        return byte2hex(encoded);
    }

    /**
     * 解密字符串
     * @Create_by:yinsy
     * @Create_date:2013-11-11
     * @param str 解密后的缓冲区
     * @return
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:BaooguDetails 1.0
     */
    public String decryptMode(String str) throws InvalidKeyException,
            UnsupportedEncodingException, NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        byte[] decode = decryptMode(null,parseHexStr2Byte(str));
        String decodeStr = new String(decode);
//        if(MessyCodeCheck.isMessyCode(decodeStr)){
//            throw new BadPaddingException("解密错误");
//        }

        return decodeStr;
    }

    /**
     * 二行制转字符串
     */
    public static String byte2hex(byte[] b) { // 一个字节的数，
        // 转成16进制字符串
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            // 整数转成十六进制表示
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase(); // 转成大写
    }



    /**
     * 将指定字符串src，以每两个字符分割转换为16进制形式 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
     * 0xD9}
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 根据字符串生成密钥字节数组
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组
        /**
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if(key.length > temp.length){
            System.arraycopy(temp, 0, key, 0, temp.length);  //temp不够24位，则拷贝temp数组整个长度的内容到key数组中
        }else{
            System.arraycopy(temp, 0, key, 0, key.length); //temp大于24位，则拷贝temp数组24个长度的内容到key数组中
        }
        return key;
    }
    public static void main(String[] args) throws Exception {
        DES3Util des = new DES3Util("9tong-bnote!@#$0");
        //	String mainDispatcher = "http://127.0.0.1:8080/bnotephone/mainDispatcher?v=1A82E2DC53775FC65D020166099ABB83D013165815E1284CF05495D96BBC975A813E2EFEE9EFC661B210AD670987DE601A6A5A3C3652F097B274F46DA9736DE283E5162535A82E64727AE5234551A8E3FEB959B7D4642FCB176";
        //  String szSrc = "http://127.0.0.1:8080/bnotephone/bizstate/checkout.htm?name=zhangsan&code=123456";
//		String mingwen = "test-DESdemo!@#$%^&*()010玖通?';\".htm";
        String mingwen = "123456";
        System.out.println("加密前的字符串:" + mingwen);
        String encoded = des.encryptMode(mingwen);
        System.out.println("加密后的字符串:" +encoded);
        System.out.println(""+encoded.length());
        String decode = des.decryptMode("E64BBB8436E2CD376258BD6BA47BD8AC78602EEAA528A51CF092BDDD38FB40DEADFD72266DB80383");
        System.out.println("??");
        System.out.println("ss解密后的字符串:" + decode);
    }
}
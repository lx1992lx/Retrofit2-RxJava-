package com.yyxk.rxjava_retrofit.bean;

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
 * 类描述：bean的基础类
 * 创建人：Random
 * 创建时间：9:46
 * 修改人：Random
 * 修改时间：9:46
 * 修改备注：
 */
public class BaseBean<T> {
    private int code;
    /**
     * isAus : 0
     * orders : [{"id":16,"orderNum":"001464839340491","patientNum":"11461349059036","doctorId":25,"desp":"主症状：发热\n主要症状：发热\n病情描述：大夫您好，我的宝宝（男），30年7个月，发热持续时间在48~72小时之间","pics":"http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=ed0xQvBZZ50nZbvRQ1VHJzqFjEHQP31xCMvCERjHWleJGhF8nqCqTVKhz0YXxrec&order_id=59","conPhone":"13701381411","patientName":"田力男","birthdayStr":"30岁6个月零22天","status":1,"orderNo":"59","createTime":"2016-06-02 11:49:00","telStatus":1,"urls":["http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=ed0xQvBZZ50nZbvRQ1VHJzqFjEHQP31xCMvCERjHWleJGhF8nqCqTVKhz0YXxrec&order_id=59"]},{"id":17,"orderNum":"001464845838369","patientNum":"01464831543281","doctorId":25,"desp":"主症状：皮疹\n主要症状：皮疹\n病情描述：大夫您好，我的宝宝（女），，皮疹至今已持续3~5天，主要出现在面部，病灶部位皮肤发红，病灶部位有痒感，小红包上有白尖","pics":"http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=b-hqoWc7dPONIjlmQWYHLurA14UTHV1cFJMmrliMlyV5EdaD_CmvqKbp9PVEKN4o&order_id=1,http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=5uoyTUJccnDLf5YwEt6z8yWkRHU3du_-qk6_UB8xZ9XnZYWuaqAuJirWkLHxYV4D&order_id=1,http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=V_JPY34B1eZo0r-44ys-kg9Xre9IRRR0wpsypBTv-3rdCm4ZcJ__SSRDx4qPho1t&order_id=1","conPhone":"13701381411","patientName":"李昱瑶","birthdayStr":"零25天","status":1,"orderNo":"1","createTime":"2016-06-02 13:37:18","telStatus":1,"urls":["http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=b-hqoWc7dPONIjlmQWYHLurA14UTHV1cFJMmrliMlyV5EdaD_CmvqKbp9PVEKN4o&order_id=1","http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=5uoyTUJccnDLf5YwEt6z8yWkRHU3du_-qk6_UB8xZ9XnZYWuaqAuJirWkLHxYV4D&order_id=1","http://amcare.acumeninnovation.com/xiaofengche_medical/em_img.php?media_id=V_JPY34B1eZo0r-44ys-kg9Xre9IRRR0wpsypBTv-3rdCm4ZcJ__SSRDx4qPho1t&order_id=1"]}]
     */

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

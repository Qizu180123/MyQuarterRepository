package com.example.menglucywhh.myquarter.bean;

import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class MyAttentionBean {
//我的关注 bean类
    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":"d42406598587a66f","appsecret":"35BCEFFD6533E3028488A3CE12AD03FB","createtime":"2017-11-23T09:09:44","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18801220726","money":null,"nickname":null,"password":"31CFCA1A340F13FCBFA7683CF164476C","praiseNum":null,"token":null,"uid":2680,"userId":null,"username":"18801220726"},{"age":null,"appkey":"e4fcf57de0c71e9a","appsecret":"5DF1641CE7A319288588B6263AD679F7","createtime":"2018-01-24T19:47:06","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13504801372","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"4DBFB1AFEE4D3FB13325C051A227CF1F","uid":2686,"userId":null,"username":"13504801372"},{"age":null,"appkey":"715509a963ce81b1","appsecret":"C021DDD433EC5DCECC753AA1ADC8674E","createtime":"2017-11-23T09:33:56","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18410340118","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2684,"userId":null,"username":"18410340118"},{"age":null,"appkey":"6a8e829dacfc2a31","appsecret":"27ADE6A2B9AD1C220DF343F57E482533","createtime":"2017-11-24T14:14:55","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13903940744","money":null,"nickname":null,"password":"96D4B05BC40E9CA4386CFE31668FB848","praiseNum":null,"token":"3935A368C7F57F6ADFF3A056AC4E8B08","uid":2654,"userId":null,"username":"13903940744"},{"age":null,"appkey":"7c3935defcb1f9e2","appsecret":"50427327FADA200BCFA5C29E1DD28E32","createtime":"2017-11-07T12:37:28","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18612991111","money":null,"nickname":null,"password":"96D4B05BC40E9CA4386CFE31668FB848","praiseNum":null,"token":"E1F47457735BD3875230613D5C64DFAB","uid":1654,"userId":null,"username":"18612991111"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : d42406598587a66f
         * appsecret : 35BCEFFD6533E3028488A3CE12AD03FB
         * createtime : 2017-11-23T09:09:44
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 18801220726
         * money : null
         * nickname : null
         * password : 31CFCA1A340F13FCBFA7683CF164476C
         * praiseNum : null
         * token : null
         * uid : 2680
         * userId : null
         * username : 18801220726
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private Object token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

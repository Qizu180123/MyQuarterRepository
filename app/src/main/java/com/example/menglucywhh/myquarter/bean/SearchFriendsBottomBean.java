package com.example.menglucywhh.myquarter.bean;

import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/26.
 */

public class SearchFriendsBottomBean {
//搜索好友 下面的接口,,我这里用的是 23.随机钟友
//   https://www.zhaoapi.cn/quarter/randomFriends?source=android&appVersion=101

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"894867f04b872787","appsecret":"F4F6C9FCE910A8818CD9B97F86F46B25","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13920415954","money":null,"nickname":null,"password":"5E928E04875463D8749755C1D37E9B2D","praiseNum":null,"token":null,"uid":8264,"userId":null,"username":"13920415954"},{"age":null,"appkey":"8b5f0e7c355ace66","appsecret":"DCD6BBB2B5019DDE00FB4733D59A1000","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13942676763","money":null,"nickname":null,"password":"45832832F306101EEB4A0D0FD6FDBAD2","praiseNum":null,"token":null,"uid":8265,"userId":null,"username":"13942676763"},{"age":null,"appkey":"a5efb0d9d5649e7f","appsecret":"509DA1A12ABD0EAE04599C666A64ED90","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13969799335","money":null,"nickname":null,"password":"5D5980719208B11970677C421263D71E","praiseNum":null,"token":null,"uid":8266,"userId":null,"username":"13969799335"},{"age":null,"appkey":"7e6f5e01ecf1be2c","appsecret":"D1ED8181F53FA8524AF55198CA405842","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13942562526","money":null,"nickname":null,"password":"D9382B4FA59CC1E31D4E139A330DEE63","praiseNum":null,"token":null,"uid":8267,"userId":null,"username":"13942562526"},{"age":null,"appkey":"835dc8040c8057be","appsecret":"2BCB0713969CFBE8D138DAB5DF030922","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13939217539","money":null,"nickname":null,"password":"BD2DD18BB0B9FAE75DB066C5CC34319F","praiseNum":null,"token":null,"uid":8268,"userId":null,"username":"13939217539"},{"age":null,"appkey":"9cc656d9c7ab2bca","appsecret":"8AE0707D43864B62F781010646EE6CD8","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13969244179","money":null,"nickname":null,"password":"514A6E50E592416683E5051103A4B44F","praiseNum":null,"token":null,"uid":8269,"userId":null,"username":"13969244179"},{"age":null,"appkey":"5189ebe8d8c46afc","appsecret":"6409B742799CF881A76EBF0C0635585B","createtime":"2017-12-23T10:55:38","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13964161496","money":null,"nickname":null,"password":"9BEBB9ECEAA17BA9765249A203FD9B76","praiseNum":null,"token":null,"uid":8270,"userId":null,"username":"13964161496"},{"age":null,"appkey":"c822531bbfd9d87d","appsecret":"357002B2F1B9B93EB32646910B1F10D8","createtime":"2017-12-23T10:55:39","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13943471403","money":null,"nickname":null,"password":"C7DFF536FAC86471CC097FFAC76F5438","praiseNum":null,"token":null,"uid":8271,"userId":null,"username":"13943471403"},{"age":null,"appkey":"dd6c190c6ac02f85","appsecret":"620239D73C75492C66363015774267F7","createtime":"2017-12-23T10:55:39","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13928281812","money":null,"nickname":null,"password":"9FE9961A1A3190C58C83DAD1C3F0CE75","praiseNum":null,"token":null,"uid":8272,"userId":null,"username":"13928281812"},{"age":null,"appkey":"29aea03dde69da75","appsecret":"BBE27155F4CB730071F006D840B1EE7D","createtime":"2017-12-23T10:55:39","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13910902101","money":null,"nickname":null,"password":"7C95B82D6400A137222D92BFF9C06388","praiseNum":null,"token":null,"uid":8273,"userId":null,"username":"13910902101"}]
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
         * appkey : 894867f04b872787
         * appsecret : F4F6C9FCE910A8818CD9B97F86F46B25
         * createtime : 2017-12-23T10:55:38
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 13920415954
         * money : null
         * nickname : null
         * password : 5E928E04875463D8749755C1D37E9B2D
         * praiseNum : null
         * token : null
         * uid : 8264
         * userId : null
         * username : 13920415954
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

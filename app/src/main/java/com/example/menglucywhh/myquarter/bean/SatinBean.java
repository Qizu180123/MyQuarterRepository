package com.example.menglucywhh.myquarter.bean;

import java.util.List;

/**
 * Created by MK on 2018/1/26.
 */

public class SatinBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"成功回访成功后","createTime":"2018-01-26T18:39:19","imgUrls":null,"jid":1309,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":", hey","createTime":"2018-01-26T18:34:41","imgUrls":null,"jid":1308,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"叫我昊哥好吗！","praiseNum":"null"}},{"commentNum":null,"content":"王帅帅没弟弟","createTime":"2018-01-26T17:13:28","imgUrls":null,"jid":1307,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"王帅帅没弟弟","createTime":"2018-01-26T17:13:28","imgUrls":null,"jid":1306,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"王帅帅没弟弟","createTime":"2018-01-26T17:13:27","imgUrls":null,"jid":1305,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"王帅帅没弟弟","createTime":"2018-01-26T17:13:23","imgUrls":null,"jid":1304,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"斤斤计较","createTime":"2018-01-26T17:02:55","imgUrls":null,"jid":1303,"praiseNum":null,"shareNum":null,"uid":5408,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"斤斤计较","createTime":"2018-01-26T17:02:55","imgUrls":null,"jid":1302,"praiseNum":null,"shareNum":null,"uid":5408,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"斤斤计较","createTime":"2018-01-26T17:02:47","imgUrls":null,"jid":1301,"praiseNum":null,"shareNum":null,"uid":5408,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"斤斤计较","createTime":"2018-01-26T17:02:47","imgUrls":null,"jid":1300,"praiseNum":null,"shareNum":null,"uid":5408,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}}]
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
         * commentNum : null
         * content : 成功回访成功后
         * createTime : 2018-01-26T18:39:19
         * imgUrls : null
         * jid : 1309
         * praiseNum : null
         * shareNum : null
         * uid : 1497
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15160825477571516082546650.png
             * nickname : 哈哈
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}

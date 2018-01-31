package com.example.menglucywhh.myquarter.bean;

import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/27.
 */

public class MyCollectionBean {

    /**
     * msg : 获取收藏列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1513740661638video_1513249056836.mp4","createTime":"2017-12-20T11:31:01","favoriteNum":1,"latitude":"40.040472","localUri":null,"longitude":"116.300041","playNum":1,"praiseNum":0,"uid":169,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514355656170cropped_1514355656472.jpg","nickname":"不熟","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513740661638video_1513249056836.mp4","wid":234,"workDesc":"视频播放不了"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517016896244jqr.png","createTime":"2018-01-27T09:34:56","favoriteNum":1,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016896244ymh.mp4","wid":266,"workDesc":"俞敏洪小视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1516884385549s5.jpg","createTime":"2018-01-25T20:46:25","favoriteNum":2,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":1,"uid":1758,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15168843855498b9d38e2416441b4d34e6be3229ff777.mp4","wid":255,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1514463086752tab_2_pressed.png","createTime":"2017-12-28T20:11:26","favoriteNum":1,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":4,"praiseNum":1,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1514463086752d74a602735ab4f70996a59c4ab1aad55.mp4","wid":244,"workDesc":"Ffd"},{"commentNum":1,"comments":[{"cid":223,"content":"%E5%93%88%E5%93%88%E5%93%88","createTime":"2017-12-20T13:51:03","jid":null,"mvp":null,"nickname":"GUODONG.","praiseNum":0,"uid":86,"wid":236}],"cover":"https://www.zhaoapi.cn/images/quarter/1513741401788截屏_20170909_205940.jpg","createTime":"2017-12-20T11:43:21","favoriteNum":1,"latitude":"40.040474","localUri":null,"longitude":"116.300043","playNum":3,"praiseNum":1,"uid":169,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514355656170cropped_1514355656472.jpg","nickname":"不熟","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513741401788录屏_20171220_114253.mp4","wid":236,"workDesc":"终于可以播放了"},{"commentNum":6,"comments":[{"cid":57,"content":"bbj","createTime":"2017-12-16T09:48:56","jid":null,"mvp":null,"nickname":"muzi","praiseNum":0,"uid":188,"wid":222},{"cid":65,"content":"lcc","createTime":"2017-12-16T11:53:05","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":222},{"cid":101,"content":"哇哇哇","createTime":"2017-12-18T15:34:32","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":222},{"cid":112,"content":"好好？","createTime":"2017-12-18T16:17:34","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":222},{"cid":147,"content":"666","createTime":"2017-12-19T11:15:12","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":222},{"cid":201,"content":",,,,,,,,,","createTime":"2017-12-19T15:19:04","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":222}],"cover":"https://www.zhaoapi.cn/images/quarter/15133878221070ffff64b399bee9d0413aee42c886f7e.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":6,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":13,"praiseNum":5,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15133878221071512894754287.mp4","wid":222,"workDesc":"卡丁车"}]
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
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/1513740661638video_1513249056836.mp4
         * createTime : 2017-12-20T11:31:01
         * favoriteNum : 1
         * latitude : 40.040472
         * localUri : null
         * longitude : 116.300041
         * playNum : 1
         * praiseNum : 0
         * uid : 169
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514355656170cropped_1514355656472.jpg","nickname":"不熟","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1513740661638video_1513249056836.mp4
         * wid : 234
         * workDesc : 视频播放不了
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
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

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1514355656170cropped_1514355656472.jpg
             * nickname : 不熟
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

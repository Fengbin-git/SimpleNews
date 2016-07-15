package com.fengbin.simplenews.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class NewsEntity implements Serializable{

    /**
     * date : 20160712
     * stories : [{"title":"不只是超强台风，还是最强一号台风","ga_prefix":"071207","images":["http://pic1.zhimg.com/310af9bf4ff70435e71b9e6c13d06c40.jpg"],"multipic":true,"type":0,"id":8554006},{"images":["http://pic1.zhimg.com/918b7425292a9373ee9375f2ee97d5c8.jpg"],"type":0,"id":8533294,"ga_prefix":"071207","title":"原来大熊猫一直在用颜值拯救动物保护事业"},{"images":["http://pic3.zhimg.com/52284f469b1fa509fff1128454740662.jpg"],"type":0,"id":8552167,"ga_prefix":"071207","title":"「感觉」天气预报再不准，看预警也得认准官方渠道"},{"images":["http://pic4.zhimg.com/6bec7a511b1597cf47356b79413e300b.jpg"],"type":0,"id":8554482,"ga_prefix":"071207","title":"读读日报 24 小时热门 TOP 5 · 这个摄影师拍下的地标建筑和平日里不一样"},{"images":["http://pic1.zhimg.com/8d20bce1dd56ce091eb26bbeb9a65b30.jpg"],"type":0,"id":8547653,"ga_prefix":"071206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/28f2b15c5c2631764f086c7bdf403a53.jpg","type":0,"id":8554482,"ga_prefix":"071207","title":"读读日报 24 小时热门 TOP 5 · 这个摄影师拍下的地标建筑和平日里不一样"},{"image":"http://pic3.zhimg.com/fca7e8db521848555e814f499131cebe.jpg","type":0,"id":8533294,"ga_prefix":"071207","title":"原来大熊猫一直在用颜值拯救动物保护事业"},{"image":"http://pic2.zhimg.com/a715c41ca31b2fa16e88fab687175d0d.jpg","type":0,"id":8552556,"ga_prefix":"071121","title":"不要晚上看这部高级喜剧，担心你看着看着就通宵了"},{"image":"http://pic4.zhimg.com/7218f1db1007090d9c4c144762e144a3.jpg","type":0,"id":8553705,"ga_prefix":"071119","title":"职人介绍所第 24 期：舒克贝塔皮皮鲁要做中国的漫威"},{"image":"http://pic3.zhimg.com/96cafd4ebf870db1a14faf7ff402c3aa.jpg","type":0,"id":8548909,"ga_prefix":"071117","title":"知乎好问题 · 正确的慢跑姿势，以及，如何快速集中注意力？"}]
     */

    private String date;
    /**
     * title : 不只是超强台风，还是最强一号台风
     * ga_prefix : 071207
     * images : ["http://pic1.zhimg.com/310af9bf4ff70435e71b9e6c13d06c40.jpg"]
     * multipic : true
     * type : 0
     * id : 8554006
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic4.zhimg.com/28f2b15c5c2631764f086c7bdf403a53.jpg
     * type : 0
     * id : 8554482
     * ga_prefix : 071207
     * title : 读读日报 24 小时热门 TOP 5 · 这个摄影师拍下的地标建筑和平日里不一样
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean implements Serializable{
        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

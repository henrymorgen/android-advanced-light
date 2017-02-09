package com.example.liuwangshu.moonvolley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/2.
 */
public class Article {
    private String desc;
    private String status;
    private List<detail> detail = new ArrayList<detail>();

    public List<Article.detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Article.detail> detail) {
        this.detail = detail;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public class detail {
        private String title;
        private String article_url;
        private String my_abstract;
        private String article_type;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public String getMy_abstract() {
            return my_abstract;
        }

        public void setMy_abstract(String my_abstract) {
            this.my_abstract = my_abstract;
        }

        public String getArticle_type() {
            return article_type;
        }

        public void setArticle_type(String article_type) {
            this.article_type = article_type;
        }
    }
}

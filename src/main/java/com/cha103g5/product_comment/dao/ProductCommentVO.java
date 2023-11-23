package com.cha103g5.product_comment.dao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cha103g5.product.dao.ProductVO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productcomment")
public class ProductCommentVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotNull
    @Size(min = 0, max = 200)
    private String comment;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @Column(name = "createdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productno")
    private ProductVO product;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }


    @JsonIgnore
    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }


}

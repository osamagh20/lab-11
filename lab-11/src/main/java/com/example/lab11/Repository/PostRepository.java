package com.example.lab11.Repository;

import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostByPostId(Integer id);

    List<Post> findPostByUserId(Integer userId);

    @Query("select p from Post p where p.title=?1")
    Post getPostByTitle(String title);

    List<Post> findPostByPublishDate(Date publishDate);


    @Query("select p from Post p where p.publishDate<=?1")
    List<Post> getAllPostsBeforeDate(Date publishDate);


}

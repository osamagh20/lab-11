package com.example.lab11.Service;

import com.example.lab11.ApiResponse.ApiException;
import com.example.lab11.Model.Comment;
import com.example.lab11.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }
    public void addComment(Comment comment){
         commentRepository.save(comment);
    }
    public void updateComment(Integer id,Comment comment){
        Comment oldComment = commentRepository.findCommentByCommentId(id);
        if(oldComment == null){
            throw new ApiException("id not found");
        }
        oldComment.setCommentId(id);
        oldComment.setUserId(comment.getUserId());
        oldComment.setPostId(comment.getPostId());
        oldComment.setContent(comment.getContent());
        oldComment.setCommentDate(comment.getCommentDate());
        commentRepository.save(oldComment);
    }
    public void deleteComment(Integer id){
        Comment delComment = commentRepository.findCommentByCommentId(id);
        if(delComment == null){
            throw new ApiException("id not found");
        }
        commentRepository.delete(delComment);
    }


    public List<Comment> getCommentByUserId(Integer userId){
        List<Comment> commentList = commentRepository.getCommentByUserId(userId);
        if(commentList == null){
            throw new ApiException("userId not found");
        }
        return commentList;
    }

    public List<Comment> getCommentByPostId(Integer postId){
        List<Comment> commentList = commentRepository.getCommentByPostId(postId);
        if(commentList == null){
            throw new ApiException("postId not found");
        }
        return commentList;
    }

    public List<Comment> getCommentByCommentDate(Date commentDate){
        List<Comment> commentList = commentRepository.getAllCommentsByDate(commentDate);
        if(commentList == null){
            throw new ApiException("commentDate not found");
        }
        return commentList;
    }
}

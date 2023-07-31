package spring.server.answerVote.dto;

import lombok.*;
import spring.server.answer.entity.Answer;
import spring.server.answerVote.entity.AnswerVote;
import spring.server.user.entity.User;

import java.time.LocalDateTime;

public class AnswerVoteDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post{
        private Boolean answerVoteStatus;
        private Long userId;
        private Long answerId;

        public void setAnswerId(Long answerId) {
            this.answerId = answerId;
        }

        public static Answer getAnswer(Long answerId) {
            Answer answer = new Answer();
            answer.setAnswerId(answerId);
            return answer;
        }

        public static User getUser(Long userId) {
            User user = new User();
            user.setUserId(userId);
            return user;
        }

        public static AnswerVote toAnswerVote(AnswerVoteDto.Post answerVoteDto){
            AnswerVote answerVote = new AnswerVote();
            answerVote.setAnswerVoteStatus(answerVoteDto.getAnswerVoteStatus());
            answerVote.setAnswer(getAnswer(answerVoteDto.getAnswerId()));
            answerVote.setUser(getUser(answerVoteDto.getUserId()));
            return answerVote;
        }

    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch{
        private long userId;
        private long answerId;
        private Boolean answerVoteStatus;

        public static AnswerVote dtoToAnswerVote(Patch requestBody){
            return AnswerVote.builder()
                    .answerVoteStatus(requestBody.getAnswerVoteStatus())
                    .build();
        }
    }
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response{
        private long answerVoteId;
        private long answerId;
        private long userId;
        private Boolean answerVoteStatus;

        public static Response response(AnswerVote updateAnswerVote) {
            return Response.builder()
                    .answerVoteId(updateAnswerVote.getAnswerVoteId())
                    .answerVoteStatus(updateAnswerVote.getAnswerVoteStatus())
                    .answerId(updateAnswerVote.getAnswer().getAnswerId())
                    .userId(updateAnswerVote.getUser().getUserId())
                    .build();
        }
    }



}
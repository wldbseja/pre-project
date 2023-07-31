package spring.server.advice;

import lombok.Getter;

public enum ExceptionCode {
    USER_NOT_FOUND(404, "User not found"),
    USER_EXISTS(409, "User exists"),

    QUESTION_NOT_FOUND(404, "Question not found"),
    CANNOT_CHANGE_QUESTION(403, "Question can not change"),
    CANNOT_READ_QUESTION(403, "Question can not read"),
    QUESTION_USER_NOT_MATCH(403, "Question and user don't match"),

    ANSWER_NOT_FOUND(404, "Answer not found"),
    ANSWER_FILTER_NOT_FOUND(404, "Answer filter not found"),
    CANNOT_UPDATE_ANSWER(403, "Answer can not be changed"),
    ANSWER_ALREADY_ACCEPTED(404, "Answer already accepted"),

    TAG_NOT_FOUND(404, "Tag not found"),
    TAG_EXISTS(409, "Tag exists"),
    UN_AUTHORIZED(404, "Only the author can delete"),
    VOTE_NOT_FOUNT(404,"Vote not found"),
    ALREADY_EXIST_VOTE(404,"Already exist vote");



    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
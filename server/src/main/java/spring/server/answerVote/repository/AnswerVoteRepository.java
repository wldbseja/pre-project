package spring.server.answerVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.server.answerVote.entity.AnswerVote;
import spring.server.questionVote.entity.QuestionVote;

import java.util.Optional;

public interface AnswerVoteRepository extends JpaRepository<AnswerVote, Long> {
    @Query("select av from AnswerVote av where av.answer.answerId = :answerId")
    Optional<AnswerVote> findByAnswerId(@Param("answerId") Long answerId);
}
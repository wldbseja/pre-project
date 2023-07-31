package spring.server.answerVote.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.server.answer.service.AnswerService;
import spring.server.answerVote.entity.AnswerVote;
import spring.server.answerVote.repository.AnswerVoteRepository;


import java.util.Optional;

@Service
@Transactional
public class AnswerVoteService {
    private final AnswerVoteRepository answerVoteRepository;
    private final AnswerService answerService;

    public AnswerVoteService(AnswerVoteRepository answerVoteRepository, AnswerService answerService) {
        this.answerVoteRepository = answerVoteRepository;
        this.answerService = answerService;
    }

    public AnswerVote createAnswerVote(AnswerVote answerVote){

        long answerId = answerVote.getAnswer().getAnswerId();
        answerService.findVerifiedAnswer(answerId);  // 해당 답변 글 유무

        Optional<AnswerVote> optionalAnswerVote =
                answerVoteRepository.findByAnswerId(answerId);
        if (optionalAnswerVote.isPresent()) {  // 답변이 있다면
            AnswerVote answerVote1 = optionalAnswerVote.get();  // 답변을 가져온다.
            if (answerVote1.getAnswerVoteStatus() == answerVote.getAnswerVoteStatus()) {  // 투표를 한번 더 누른다면
                deleteAnswerVote(answerVote1.getAnswerVoteId());  // voteId 삭제
                return null;
            } else {
                throw new RuntimeException("ALREADY_EXIST_VOTE");
            }
        }
        return answerVoteRepository.save(answerVote);
    }

    public void deleteAnswerVote(long answerVoteId){
        AnswerVote findAnswerVote = findVerifiedAnswerVote(answerVoteId);
        answerVoteRepository.delete(findAnswerVote);
    }

    public AnswerVote findVerifiedAnswerVote(Long answerVoteId) {
        Optional<AnswerVote> answerVote = answerVoteRepository.findById(answerVoteId);

        return answerVote.orElseThrow(() ->
                new RuntimeException("NOT_EXIST_VOTE"));
    }
}











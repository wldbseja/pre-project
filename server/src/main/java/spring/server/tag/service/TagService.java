package spring.server.tag.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.server.advice.BusinessLogicException;
import spring.server.advice.ExceptionCode;
import spring.server.tag.entity.Tag;
import spring.server.tag.repository.TagQuestionRepository;
import spring.server.tag.repository.TagRepository;
import spring.server.utils.CustomBeanUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final TagQuestionRepository tagQuestionRepository;
//    private final CustomBeanUtils<Tag> beanUtils;

    public Tag createTag(Tag tag){
        Optional<Tag> optionalTag = tagRepository.findTagByTagName(tag.getTagName()); //태그 이름을 조회해서
        if (optionalTag.isPresent()){
            throw new BusinessLogicException(ExceptionCode.TAG_EXISTS);
        }
//        Tag.checkExistTagName(findTag);
// 동일한 태그가 있는지 확인
//        Optional.ofNullable(tag.getTagName())                           //들어온 값이 있으면 저장
//                .ifPresent(tagName -> tag.setTagName(tagName));
//        Optional.ofNullable(tag.getTagContent())
//                .ifPresent(tagContent ->findTag.setTagContent(tagContent));
//        Optional.ofNullable(tag.getTagMentionCount())
//                .ifPresent(tagMentionCount -> findTag.setTagMentionCount(tagMentionCount));
        return tagRepository.save(tag);
    }

    public Tag updateTag(Tag tag){
        Tag findTag = findTag(tag.getTagId());
//        Tag updateTag = findTag.changeTagInfo(tag, beanUtils);
        setTagInfos(findTag, tag);
        return tagRepository.save(findTag);
    }

    private void setTagInfos(Tag findTag, Tag tag) {
        Optional.ofNullable(tag.getTagName())
                .ifPresent(tagName -> findTag.setTagName(tagName));
        Optional.ofNullable(tag.getTagContent())
                .ifPresent(tagContent ->findTag.setTagContent(tagContent));
    }

    @Transactional(readOnly = true)
    public Tag findTag(Long tagId){
        Tag findTag = tagRepository.
                findById(tagId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));
        return findTag;
    }

//    @Transactional(readOnly = true)
//    public Page<Tag> findTags(int page, int size){
//        return tagRepository.findAll(PageRequest.of(page, size, Sort.by("tagId").descending()));
//        //todo 정렬기준 고려하기
//    }

    @Transactional(readOnly = true)  //정렬
    public Page<Tag> findTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }



    @Transactional(readOnly = true)
    public Page<Tag> findTagsSortedByTagMentionCount(int page) {
        return tagRepository.findAll(PageRequest.of(page, 6, Sort.by("tagMentionCount").descending()));
    }

    public void deleteTag(Long tagId){
        //tagQuestion 삭제도 같이 해야 함
        Tag findTag = findTag(tagId);
        tagQuestionRepository.deleteById(tagId);
        tagRepository.delete(findTag);
    }




}

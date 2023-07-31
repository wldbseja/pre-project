package spring.server.tag.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import spring.server.advice.BusinessLogicException;
import spring.server.advice.ExceptionCode;
import spring.server.utils.CustomBeanUtils;
import spring.server.audit.BaseEntity;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Tag")
public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String tagName;
    private String tagContent;
    private Long tagMentionCount;

    @OneToMany(mappedBy = "tag")
    private List<TagQuestion> tagQuestions = new ArrayList<>();

    public static void checkExistTagName(Tag targetTag) {
        if(targetTag != null)
            throw new BusinessLogicException(ExceptionCode.TAG_EXISTS);
    }


    public Tag changeTagInfo(Tag sourceTag, CustomBeanUtils<Tag> beanUtils) {
        return beanUtils.copyNonNullProperties(sourceTag, this);
    }

    @Builder
    public Tag(String tagName, String tagContent, Long tagMentionCount) {
        this.tagName = tagName;
        this.tagContent = tagContent;
        this.tagMentionCount = tagMentionCount;
    }

    public static void addMemtionCount(Tag tag){
        tag.tagMentionCount += 1;
    }

    public static void subtractMemtionCount(Tag tag){
        tag.tagMentionCount -= 1;
    }



}

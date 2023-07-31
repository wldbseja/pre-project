package spring.server.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import spring.server.tag.entity.Tag;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TagDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        private String tagName;

        private String tagContent;

        public static Tag dtoToTag(Post requestBody) {
            return Tag.builder()
                    .tagName(requestBody.tagName)
                    .tagContent(requestBody.tagContent)
                    .tagMentionCount(0L)
                    .build();
        }



    }

    @Getter
    @AllArgsConstructor
    public static class Patch {

        private String tagName;

        private String tagContent;


//        public Patch addTagId(long tagId) {
//            Assert.notNull(tagId, "tag id must not be null.");
//            this.tagId = tagId;
//            return this;
//        }

        public static Tag patchTag(Patch requestBody) {
            return Tag.builder()
                    .tagName(requestBody.tagName)
                    .tagContent(requestBody.tagContent)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Long tagId;
        private String tagName;
        private String tagContent;
        private Long tagMentionCount;
        public static Response response(Tag tag) {
            return Response.builder()
                    .tagId(tag.getTagId())
                    .tagName(tag.getTagName())
                    .tagContent(tag.getTagContent())
                    .tagMentionCount(tag.getTagMentionCount())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class TagInfo {
        private Long tagId;
        private String tagName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ListElement {
        private Long tagId;
        private String tagName;
        private String tagContent;
        private Long tagMentionCount;
    }

    public static List<ListElement> getList(List<Tag> tags) {
        return tags.stream()
                .map(tag -> ListElement.builder()
                        .tagId(tag.getTagId())
                        .tagName(tag.getTagName())
                        .tagContent(tag.getTagContent())
                        .tagMentionCount(tag.getTagMentionCount())
                        .build()
                )
                .collect(Collectors.toList());
    }





}

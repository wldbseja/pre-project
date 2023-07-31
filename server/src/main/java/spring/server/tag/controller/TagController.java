package spring.server.tag.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.server.response.MultiResponseDto;
import spring.server.response.SingleResponseDto;
import spring.server.tag.dto.TagDto;
import spring.server.tag.entity.Tag;
import spring.server.tag.mapper.TagMapper;
import spring.server.tag.service.TagService;
import spring.server.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tags")
@Validated
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class TagController {
    private final static String TAG_DEFAULT_URL = "/tags";
    private final TagService tagService;

    @PostMapping
    public ResponseEntity postTag(@Valid @RequestBody TagDto.Post requestBody) {
        Tag tag = TagDto.Post.dtoToTag(requestBody);
        Tag createdTag = tagService.createTag(tag);
        URI location = UriCreator.createUri(TAG_DEFAULT_URL, createdTag.getTagId());
        return new ResponseEntity<>(TagDto.Response.response(createdTag), HttpStatus.CREATED);
    }

    @PatchMapping("/{tagId}")
    public ResponseEntity patchTag(@PathVariable("tagId") @Positive Long tagId,
                                   @Valid @RequestBody TagDto.Patch requestBody) {
//        Tag tag = tagService.updateTag(mapper.tagPatchDtoToTag(requestBody.addTagId(tagId)));
        Tag tag = TagDto.Patch.patchTag(requestBody);
        tag.setTagId(tagId);
        Tag updateTag = tagService.updateTag(tag);
        return new ResponseEntity<>(new SingleResponseDto<>(TagDto.Response.response(updateTag)), HttpStatus.OK);
    }

    @GetMapping("/{tagId}")
    public ResponseEntity getTag(@PathVariable("tagId") @Positive Long tagId) {
        Tag tag = tagService.findTag(tagId);
        return new ResponseEntity<>(new SingleResponseDto<>(TagDto.Response.response(tag)), HttpStatus.OK);
    }

//    @GetMapping("/{page}")
//    public ResponseEntity getTags(@Positive @RequestParam int page) {
//        Page<Tag> pageTags = tagService.findTags(page - 1);
//        List<Tag> tags = pageTags.getContent();
//        return new ResponseEntity<>(new MultiResponseDto<>(mapper.tagsToResponseDtos(tags), pageTags), HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity getTags(@Positive @RequestParam int page,
//                                  @Positive @RequestParam(defaultValue = "6") int size) {
//        Page<Tag> pageInfo = tagService.findTags(page -1, size);
//        List<Tag> tags = pageInfo.getContent();
//        List<TagDto.ListElement> tagInfoList = TagDto.getList(tags);
//        return new ResponseEntity<>(new MultiResponseDto<>(tagInfoList, pageInfo), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity getTags(@Positive @RequestParam int page,
                                  @Positive @RequestParam(defaultValue = "6") int size,
                                  @RequestParam(defaultValue = "popular") String tab) {
        Page<Tag> pageInfo;
        Pageable pageable;

        if (tab.equals("popular")) {
            pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "tagMentionCount"));
        } else if (tab.equals("name")) {
            pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "tagName"));
        } else if (tab.equals("new")) {
            pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        } else {
            throw new IllegalArgumentException("Invalid sort parameter");
        }

        pageInfo = tagService.findTags(pageable);
        List<Tag> tags = pageInfo.getContent();
        List<TagDto.ListElement> tagInfoList = TagDto.getList(tags);

        return new ResponseEntity<>(new MultiResponseDto<>(tagInfoList, pageInfo), HttpStatus.OK);
    }




    @DeleteMapping("/{tagId}")
    public ResponseEntity deleteTag(@PathVariable("tagId") @Positive Long tagId) {
        tagService.deleteTag(tagId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




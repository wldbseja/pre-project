package spring.server.tag.mapper;

import org.mapstruct.Mapper;
import spring.server.tag.dto.TagDto;
import spring.server.tag.entity.Tag;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagPostDtoToTag(TagDto.Post requestBody);
    Tag tagPatchDtoToTag(TagDto.Patch requestBody);
    TagDto.Response tagToResponseDto(Tag tag);
    List<TagDto.Response> tagsToResponseDtos(List<Tag> tags);

}

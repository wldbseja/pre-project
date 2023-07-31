import React from 'react';

import {
  TagTopSection,
  Top,
  TopTitle,
  TopContent,
  Bottom,
  InputSection,
  TagSearchInput,
} from '../../styles/Tags/TagTop';
import TagFilter from './TagFilter';

function TagTop() {
  return (
    <TagTopSection>
      <Top>
        <TopTitle>Tags</TopTitle>
        <TopContent>
          A tag is a keyword or label that categorizes your question with other, similar questions.
        </TopContent>
        <TopContent>
          Using the right tags makes it easier for others to find and answer your question.
        </TopContent>
      </Top>
      <Bottom>
        <InputSection>
          <TagSearchInput
            placeholder="Filter by tag name"
          />
        </InputSection>
        <TagFilter />
      </Bottom>
    </TagTopSection>

  );
}

export default TagTop;

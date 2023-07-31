import styled from 'styled-components';

const TagsTopSection = styled.section`
  display: flex;
  align-items: center;
`;

const TagsCardSection = styled.section`
  display: grid;
  grid-template-rows: 220px 220px;
  grid-template-columns: repeat(3,1fr);
  align-items: center;
  width: 850px;
  padding: 16px;
`;

const TagsSection = styled.section`
  display: flex;
  align-items: center;
  margin-left: 12vw;
  flex-direction: column;
`;

export {
  TagsTopSection, TagsCardSection, TagsSection,
};

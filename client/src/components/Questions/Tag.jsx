import React from 'react';
import styled from 'styled-components';

function Tag({ name }) {
  return (
    <TagSection>{name}</TagSection>
  );
}

export default Tag;

const TagSection = styled.section`
  height: 17px;
  background-color: #E1ECF4;
  border-radius: 3px;
  color: #39739D;
  font-size: x-small;
  margin-right: 4px;
  padding: 4.8px 6px;
  cursor: pointer;
`;

import React from 'react';
import styled from 'styled-components';
import { VscTriangleDown, VscTriangleUp } from 'react-icons/vsc';

function Vote({ votes }) {
  return (
    <VoteSection>
      <VoteAngleBox>
        <VscTriangleUp size="25" />
      </VoteAngleBox>
      <VoteCount>{votes}</VoteCount>
      <VoteAngleBox>
        <VscTriangleDown size="25" />
      </VoteAngleBox>
    </VoteSection>
  );
}

export default Vote;

const VoteSection = styled.section`
  width: 44.78px;
`;

const VoteAngleBox = styled.div`
  width: 25px;
  height: 25px;
  padding: 10px;
  border: 1px solid #BABFC4;
  border-radius: 100%;
`;

const VoteCount = styled.div`
  text-align: center;
  font-weight: 500;
  font-size: 1.3rem;
  margin: 8px 0;
`;

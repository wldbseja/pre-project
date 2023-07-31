import React from 'react';
import styled from 'styled-components';

import Vote from './Vote';
import Tag from './Tag';

function QuestionDetailBody({ detailData }) {
  console.log(detailData);
  return (
    <DetailMain>
      {detailData && <Vote votes={detailData.votes} />}
      <DetailBody>
        {detailData && (
          <>
            <DetailContent>{detailData.content}</DetailContent>
            {detailData.tagInfos
              && (
              <TagList>
                {detailData.tagInfos.map((tag) => (
                  <Tag key={tag.tagId} name={tag.tagName} />
                ))}
              </TagList>
              )}
            <BodyBottom>
              <BodyBottomLeft>
                <LeftElement>Share</LeftElement>
                <LeftElement>Edit</LeftElement>
                <LeftElement>Delete</LeftElement>
              </BodyBottomLeft>
              <BodyBottomRight>
                <div>프로필 이미지</div>
                {detailData.userInfo && <div>{detailData.userInfo.userName}</div>}
              </BodyBottomRight>
            </BodyBottom>
          </>
        )}
      </DetailBody>
    </DetailMain>
  );
}

export default QuestionDetailBody;

const DetailMain = styled.section`
  margin-top: 20px;
  padding-bottom: 30px;
  display: flex;
`;

const DetailBody = styled.div`
  width: 700px;
  margin-left: 20px;
`;

const DetailContent = styled.div`
  font-size: 0.9rem;
  line-height: 25px;
`;

const TagList = styled.div`
  display: flex;
  margin-top: 30px;
`;

const BodyBottom = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
`;

const BodyBottomLeft = styled.div`
  display: flex;
  
`;

const LeftElement = styled.div`
  margin-right: 10px;
  font-size: 0.9rem;
  color: #696969;
`;

const BodyBottomRight = styled.div`
  display: flex;
  width: 200px;
  height: 60px;
  background-color: #d0e2f0;
  border-radius: 3px;
`;

import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useLocation } from 'react-router-dom';

import QuestionDetailBody from '../../components/Questions/QuestionDetailBody';

function QuestionDetail() {
  const [detailData, setDetailData] = useState({});
  const [answerPost, setAnswerPost] = useState('');
  const location = useLocation();
  const detailId = location.pathname.substring(11);
  const url = import.meta.env.VITE_URL;

  const detailFetch = async () => {
    const res = await fetch(`${url}${location.pathname}`, {
      method: 'GET',
      headers: {
        'ngrok-skip-browser-warning': true,
      },
    });
    const json = await res.json();
    json.createdAt = new Date(json.createdAt).toLocaleDateString();
    setDetailData(json);
  };

  const createAnswerFetch = async () => {
    await fetch(`${url}/answers`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'ngrok-skip-browser-warning': true,
      },
      body: JSON.stringify({
        userId: 1,
        questionId: detailId,
        body: answerPost,
      }),
    })
      .then(() => window.location.reload());
  };

  const answerOnChangeHandler = (e) => {
    setAnswerPost(e.target.value);
  };

  useEffect(() => {
    detailFetch();
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <DetailSection>
      {detailData && (
        <>
          <DetailTop>
            <DetailTopTitle>{detailData.title}</DetailTopTitle>
            <DetailTopTime>
              Asked
              {' '}
              {detailData.createdAt}
            </DetailTopTime>
          </DetailTop>
          <QuestionDetailBody detailData={detailData} />
          <Answered>
            {detailData.answers && (
              <AnswerCount>
                {detailData.answers.answerCount}
                {' '}
                Answers
              </AnswerCount>
            )}
            {detailData.answers && detailData.answers.answers.length
              ? detailData.answers.answers.map((answer) => (
                <AnswerBox key={answer.id}>
                  <QuestionDetailBody detailData={answer} />
                </AnswerBox>
              )) : <div>답변 없음</div>}
          </Answered>
        </>
      )}
      <AnswerInputBox>
        <AnswerInputTitle>Your Answer</AnswerInputTitle>
        <AnswerInput onChange={(e) => answerOnChangeHandler(e)} />
        <AnswerPostButton onClick={createAnswerFetch}>Post Your Answer</AnswerPostButton>
      </AnswerInputBox>
    </DetailSection>
  );
}

export default QuestionDetail;

const DetailSection = styled.section`
  padding: 24px;
  width: 80%;
  max-width: 700px;
  margin-left: calc(25vw - 1.8vw);
`;

const DetailTop = styled.section`
  border-bottom: 1px solid #ccced1;
`;

const DetailTopTitle = styled.div`
  font-size: x-large;
  margin-bottom: 10px;
`;

const DetailTopTime = styled.div`
  color: #6A737C;
  margin-bottom: 15px;
  font-size: 13px;
`;

const Answered = styled.section`
  margin-top: 50px;
`;

const AnswerCount = styled.div`
  margin-bottom: 40px;
  font-size: large;
`;

const AnswerBox = styled.div`
  border-bottom: 1px solid #cacaca;
`;

const AnswerInputBox = styled.section`
  color: black;
`;

const AnswerInputTitle = styled.div`
  font-size: x-large;
  margin-top: 10px;
  margin-bottom: 20px;
`;

const AnswerInput = styled.textarea`
  width: 100%;
  height: 100px;
`;

const AnswerPostButton = styled.button`
  color: white;
  background-color: #0A95FF;
  padding: 10.4px;
  font-size: small;
  border: 1px solid white;
  border-radius: 3px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  text-decoration: none;
  margin-top: 20px;
  cursor: pointer;
`;

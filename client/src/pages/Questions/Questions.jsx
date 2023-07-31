import React, { useEffect, useState } from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';
import styled from 'styled-components';

import QuestionTop from '../../components/Questions/QuestionTop';
import QuestionCard from '../../components/Questions/QuestionCard';
import QuestionPagination from '../../components/Questions/QuestionPagination';

function Questions() {
  const [questions, setQuestions] = useState({});
  const location = useLocation();
  const [searchParams] = useSearchParams();
  const page = searchParams.get('page') || 1;
  const tab = searchParams.get('tab') || 'newest';
  const keyword = searchParams.get('keyword');
  const url = import.meta.env.VITE_URL;

  const questionsFetch = async () => {
    const res = await fetch(`${url}/questions?page=${page}&tab=${tab}`, {
      method: 'GET',
      headers: {
        'ngrok-skip-browser-warning': true,
      },
    });
    const json = await res.json();
    setQuestions(json);
  };

  const searchFetch = async () => {
    const res = await fetch(`${url}/questions/search?type=title&keyword=${keyword}&page=${page}`, {
      method: 'GET',
      headers: {
        'ngrok-skip-browser-warning': true,
      },
    });
    const json = await res.json();
    setQuestions(json);
  };

  const tagFetch = async () => {
    const tagName = location.pathname.slice(16);
    const res = await fetch(`${url}/questions/search?type=tag&keyword=${tagName}&page=${page}`, {
      method: 'GET',
      headers: {
        'ngrok-skip-browser-warning': true,
      },
    });
    const json = await res.json();
    setQuestions(json);
  };

  useEffect(() => {
    console.log(location.pathname.slice(0, 16));
    if (location.pathname === '/search') {
      searchFetch();
    }
    if (location.pathname === '/questions') {
      questionsFetch();
    }
    if (location.pathname.slice(0, 15) === '/questions/tags') {
      tagFetch();
    }
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <QuestionsSection>
      {questions.result && <QuestionTop totalQuestion={questions.pageInfo.totalElements} />}
      {questions.result && questions.result.map((question) => (
        <QuestionCard question={question} key={question.questionId} />
      ))}
      {questions.pageInfo && <QuestionPagination pageInfo={questions.pageInfo} />}
    </QuestionsSection>
  );
}

export default Questions;

const QuestionsSection = styled.section`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Questions from '../pages/Questions/Questions';
import QuestionDetail from '../pages/Questions/QuestionDetail';
import QuestionAsk from '../pages/Questions/QuestionAsk';

export default function QuestionRouter() {
  return (
    <Routes>
      <Route path="/questions" element={<Questions />} />
      <Route path="/questions/ask" element={<QuestionAsk />} />
      <Route path="/questions/:id" element={<QuestionDetail />} />
      <Route path="/questions/tags/:tagname" element={<Questions />} />
      <Route path="/search" element={<Questions />} />
    </Routes>
  );
}

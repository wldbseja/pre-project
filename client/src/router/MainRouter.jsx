import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Main from '../pages/Main/Main';

export default function MainRouter() {
  return (
    <Routes>
      <Route path="/" element={<Main />} />
    </Routes>
  );
}

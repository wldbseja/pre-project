import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Tags from '../pages/Tags/Tags';

export default function UserRouter() {
  return (
    <Routes>
      <Route path="/tags" element={<Tags />} />
    </Routes>
  );
}

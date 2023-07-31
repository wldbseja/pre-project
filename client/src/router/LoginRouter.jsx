import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Login from '../pages/Login/Login';

export default function LoginRouter() {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
    </Routes>
  );
}

import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Users from '../pages/User/Users';
import UserProfile from '../pages/User/UserProfile';

export default function UserRouter() {
  return (
    <Routes>
      <Route path="/users" element={<Users />} />
      <Route path="/users/:id" element={<UserProfile />} />
    </Routes>
  );
}

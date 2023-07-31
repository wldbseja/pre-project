import React from 'react';

import './App.css';
import Header from './components/header/Header';
import QuestionRouter from './router/QuestionsRouter';
import TagsRouter from './router/TagsRouter';
import MainRouter from './router/MainRouter';
import Login from './router/LoginRouter';
import Users from './router/UserRouter';
import Footer from './components/Footer/Footer';
import SideBar from './components/header/SideBar';

function App() {
  return (
    <section>
      <Header />
      <SideBar />
      <MainRouter />
      <QuestionRouter />
      <TagsRouter />
      <Login />
      <Users />
      <Footer />
    </section>

  );
}

export default App;

/* eslint-disable react/jsx-no-bind */
import React, { useState, useEffect, useRef } from 'react';

import {
  HeaderBody,
  HeaderSection,
  HeaderMenuImg,
  HeaderLogoImg,
  InputSection,
  HeaderSearchIconImg,
  HeaderSearchInput,
  HeaderLoginButton,
  HeaderSignUpButton,
} from '../../styles/header/Header';
import HeaderMenuClose from '../../assets/header/HeaderMenuClose.png';
import HeaderMenuOpen from '../../assets/header/HeaderMenuOpen.png';
import DropDown from './DropDown';

function Header() {
  const dropDownRef = useRef(null);
  const [isDropClick, setDropClick] = useState(false);
  const [imageSrc, setImageSrc] = useState(HeaderMenuClose);
  const [searchText, setSearchText] = useState('');

  function DropClickHandler() {
    if (isDropClick) {
      setImageSrc(HeaderMenuClose);
      setDropClick(false);
    } else {
      setImageSrc(HeaderMenuOpen);
      setDropClick(true);
    }
  }

  const searchOnChangeHandler = (e) => {
    setSearchText(e.target.value);
  };

  const searchClickHandler = () => {
    window.location.href = `http://localhost:5173/search?keyword=${searchText}`;
  };

  useEffect(() => {
    const pageClickEvent = (e) => {
      if (dropDownRef.current !== null && !dropDownRef.current.contains(e.target)) {
        setDropClick(!isDropClick);
        setImageSrc(HeaderMenuClose);
      }
    };
    if (isDropClick) {
      window.addEventListener('click', pageClickEvent);
    }
    return () => {
      window.removeEventListener('click', pageClickEvent);
    };
  }, [isDropClick]);

  return (
    <HeaderBody ref={dropDownRef}>
      {isDropClick && <DropDown />}
      <HeaderSection>
        <HeaderMenuImg src={imageSrc} onClick={DropClickHandler} />
      </HeaderSection>
      <HeaderSection href="/questions">
        <HeaderLogoImg />
      </HeaderSection>
      <InputSection>
        <HeaderSearchIconImg onClick={searchClickHandler} />
        <HeaderSearchInput placeholder=" [tag] search within a tag" onChange={(e) => searchOnChangeHandler(e)} />
      </InputSection>
      <HeaderSection href="/login">
        <HeaderLoginButton>Log in</HeaderLoginButton>
      </HeaderSection>
      <HeaderSection href="/">
        <HeaderSignUpButton>Sign up</HeaderSignUpButton>
      </HeaderSection>
    </HeaderBody>

  );
}

export default Header;

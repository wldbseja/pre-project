import React from 'react';

import {
  DropDownBody,
  DropDownSectionTop,
  DropDownTopText,
  DropDownText1,
  DropDownText2,
  DropDownSection,
  WorldIconImg,
} from '../../styles/header/DropDown';

function DropDown() {
  return (
    <DropDownBody>
      <DropDownSectionTop>
        <DropDownTopText>PUBLIC</DropDownTopText>
      </DropDownSectionTop>
      <DropDownSection href="/questions">
        <WorldIconImg />
        <DropDownText1>Questions</DropDownText1>
      </DropDownSection>
      <DropDownSection href="/tags">
        <DropDownText2>Tags</DropDownText2>
      </DropDownSection>
      <DropDownSection href="/users">
        <DropDownText2>Users</DropDownText2>
      </DropDownSection>
    </DropDownBody>
  );
}

export default DropDown;

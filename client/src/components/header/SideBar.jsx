import React from 'react';

import {
  SideBarBody,
  WorldIconImg,
  SideBarTopSection,
  SideBarSection,
  SideBarText,
} from '../../styles/header/SideBar';

function SideBar() {
  return (
    <SideBarBody>
      <SideBarTopSection>
        PUBLIC
      </SideBarTopSection>
      <SideBarSection href="/questions">
        <WorldIconImg />
        Questions
      </SideBarSection>
      <SideBarSection href="/tags">
        <SideBarText>
          Tags
        </SideBarText>
      </SideBarSection>
      <SideBarSection href="/users">
        <SideBarText>
          Users
        </SideBarText>
      </SideBarSection>
    </SideBarBody>
  );
}

export default SideBar;

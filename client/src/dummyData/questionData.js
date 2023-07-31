export const QuestionsData = {
  pageInfo: {
    page: '페이지 번호',
    totalElements: 5132,
    totalPages: '총 페이지 수',
  },
  results: [
    {
      id: 1,
      title: 'android ndk gdb loaded sharedlibraries missing *.oat',
      content: 'But oat files are loaded when debugging other devices like Huawei (FRD-AL00). Following is an excerpt of the output of show shared on such a device.',
      createAt: '1시 20분',
      tags: [
        'python',
        'javascript',
      ],
      userInfo: {
        id: 2,
        userImage: '유저 이미지',
        userName: '김태우',
      },
      votes: 2,
      answerCount: 2,
    },
    {
      id: 2,
      title: 'android ndk gdb loaded sharedlibraries missing *.oat',
      content: 'But oat files are loaded when debugging other devices like Huawei (FRD-AL00). Following is an excerpt of the output of show shared on such a device.',
      createAt: '1시 20분',
      tags: [
        'python',
        'javascript',
      ],
      userInfo: {
        id: '유저 코드',
        userImage: '유저 이미지',
        userName: '김태우',
      },
      votes: 2,
      answerCount: 2,
    },
    {
      id: 3,
      title: 'android ndk gdb loaded sharedlibraries missing *.oat',
      content: 'But oat files are loaded when debugging other devices like Huawei (FRD-AL00). Following is an excerpt of the output of show shared on such a device.',
      createAt: '1시 20분',
      tags: [
        'python',
        'javascript',
      ],
      userInfo: {
        id: '유저 코드',
        userImage: '유저 이미지',
        userName: '김태우',
      },
      votes: 2,
      answerCount: 2,
    },
    {
      id: 4,
      title: 'android ndk gdb loaded sharedlibraries missing *.oat',
      content: 'But oat files are loaded when debugging other devices like Huawei (FRD-AL00). Following is an excerpt of the output of show shared on such a device.',
      createAt: '1시 20분',
      tags: [
        'python',
        'javascript',
      ],
      userInfo: {
        id: '유저 코드',
        userImage: '유저 이미지',
        userName: '김태우',
      },
      votes: 2,
      answerCount: 2,
    },
  ],
};

export const QuestionsDetailData = {
  id: 1,
  title: 'Age in Years and Days',
  content: `Im looking for a way to display the ages of a person in Years and Days.

  EX: someone born January 26, 1934 is 89 years and 149 days.
  
  How would this be calculated in Javascript?
  
  Thanks, John
  
  I can calculate it in years, months and days. just don't know how for it to be just years and days.`,
  createAt: '2023/03/19',
  tags: [
    'python',
    'javascript',
  ],
  userInfo: {
    id: 1,
    userImage: '유저 이미지',
    userName: 'John',
  },
  votes: 5,
  answers: {
    answerCount: 2,
    answerList: [
      {
        content: `At document of np.arange

        arange(stop): Values are generated within the half-open interval [0, stop) (in other words, the interval including start but excluding stop).`,
        votes: 1,
        userInfo: {
          userImage: '유저 이미지',
          userName: 'minolee',
        },
      },
      {
        content: 'Python has a convention where, when specifying a range, it will iterate over that range from the start value to just before the end value (e.g. for x in range(0, 15) will assign x every value from 0 to 14--not 15). In your case, you can solve that by either setting the middle parameter (which correlates to the end value the iterator will stop just before) to be just over 1 (e.g. 1.1), or by manually appending 1. to the end like you mentioned.',
        answerVotes: 3,
        userInfo: {
          id: '유저 코드',
          userImage: '유저 이미지',
          userName: 'NelS',
        },
      },
    ],
  },
};

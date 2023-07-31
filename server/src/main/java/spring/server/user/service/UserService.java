package spring.server.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.server.advice.BusinessLogicException;
import spring.server.advice.ExceptionCode;
import spring.server.auth.CustomAuthorityUtils;
import spring.server.question.entity.Question;
import spring.server.question.repository.QuestionRepository;
import spring.server.user.dto.UserDto;
import spring.server.user.entity.User;
import spring.server.user.mapper.UserMapper;
import spring.server.user.repository.UserRepository;
import spring.server.utils.CustomBeanUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CustomBeanUtils<User> beanUtils;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;
    private final UserMapper mapper;
    private final QuestionRepository questionRepository;


    public User createUser(User user) {
        Optional<User> findUser = userRepository.findByUserEmail(user.getUserEmail());
        User.isExistEmail(findUser);                              // 동일한 이메일이 있는지 확인
        String encryptedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encryptedPassword);                         // 비밀번호 암호화 하기
        user.setRoles(authorityUtils.createRoles(user.getUserEmail()));
        return userRepository.save(user);
    }

    public User updateUser(User user){
        User findUser = findUser(user.getUserId());
//        User updateUser = findUser.changeUserInfo(user,  beanUtils);
        setUserInfos(findUser, user);

        return userRepository.save(findUser);
    }

    private void setUserInfos(User findUser, User user) {
        Optional.ofNullable(user.getUserName())
                .ifPresent(userName -> findUser.setUserName(userName));
        Optional.ofNullable(user.getUserImage())
                .ifPresent(userImage -> findUser.setUserImage(userImage));
        Optional.ofNullable(user.getUserPassword())
                .ifPresent(userPassword -> {
                    String encodedPassword = passwordEncoder.encode(userPassword);
                    findUser.setUserPassword(encodedPassword);
                });
        Optional.ofNullable(user.getUserStatus())
                .ifPresent(userStatus -> findUser.setUserStatus(userStatus));
    }

    @Transactional(readOnly = true)
    public User findUser(Long userId) {
//        User findUser = userRepository.
//                findById(userId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        }
        return optionalUser.get();
    }


    @Transactional(readOnly = true)
    public Page<User> findUsers(int page, int size){
        return userRepository.findAll(PageRequest.of(page, size, Sort.by("userId").ascending()));
    } //todo 정렬기준에 따라 정렬될 수 있게 수정해야함 -소희-


    public void deleteUser(Long userId) {
        User findUser = findUser(userId);
        userRepository.delete(findUser);
    }

    public boolean isExistUser(String email){
        return userRepository.findByUserEmail(email) == null;
    }



    public User findUserById(Long userId) { //질문삭제전에 작성자확인
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }

}





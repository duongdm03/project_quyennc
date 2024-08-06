package vn.duong.itech.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import tech.jhipster.security.RandomUtil;
import vn.duong.itech.config.Constants;
import vn.duong.itech.domain.Authority;
import vn.duong.itech.domain.User;
import vn.duong.itech.repository.AuthorityRepository;
import vn.duong.itech.repository.UserRepository;
import vn.duong.itech.security.AuthoritiesConstants;
import vn.duong.itech.security.SecurityUtils;
import vn.duong.itech.service.dto.AdminUserDTO;
import vn.duong.itech.service.dto.ResultDto;
import vn.duong.itech.service.dto.UserDTO;
import vn.duong.itech.service.dto.user.RegisterRequest;
import vn.duong.itech.service.dto.user.RegisterResponse;
import vn.duong.itech.service.dto.user.UserProfileDTO;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    public Optional<User> activateRegistration(String key) {
        //        log.debug("Activating user for activation key {}", key);
        //        return userRepository
        //            .findOneByActivationKey(key)
        //            .map(user -> {
        //                // activate given user for the registration key.
        //
        //                log.debug("Activated user: {}", user);
        //                return user;
        //            });
        return null;
    }

    public Optional<User> completePasswordReset(String newPassword, String key) {
        log.debug("Reset user password for reset key {}", key);
        //        return userRepository
        //            .findOneByResetKey(key)
        //            .filter(user -> user.getResetDate().isAfter(Instant.now().minus(1, ChronoUnit.DAYS)))
        //            .map(user -> {
        //                user.setPassword(passwordEncoder.encode(newPassword));
        //                user.setResetKey(null);
        //                user.setResetDate(null);
        //                return user;
        //            });
        return null;
    }

    public Optional<User> requestPasswordReset(String mail) {
        //        return userRepository
        //            .findOneByEmailIgnoreCase(mail)
        //            .filter(User::isActivated)
        //            .map(user -> {
        //                user.setResetKey(RandomUtil.generateResetKey());
        //                user.setResetDate(Instant.now());
        //                return user;
        //            });
        return null;
    }

    public User registerUser(AdminUserDTO userDTO, String password) {
        //        userRepository
        //            .findOneByLogin(userDTO.getLogin().toLowerCase())
        //            .ifPresent(existingUser -> {
        //                boolean removed = removeNonActivatedUser(existingUser);
        //                if (!removed) {
        //                    throw new UsernameAlreadyUsedException();
        //                }
        //            });
        //        userRepository
        //            .findOneByEmailIgnoreCase(userDTO.getEmail())
        //            .ifPresent(existingUser -> {
        //                boolean removed = removeNonActivatedUser(existingUser);
        //                if (!removed) {
        //                    throw new EmailAlreadyUsedException();
        //                }
        //            });
        User newUser = new User();
        String encryptedPassword = passwordEncoder.encode(password);
        //        newUser.setLogin(userDTO.getLogin().toLowerCase());
        //        // new user gets initially a generated password
        //        newUser.setPassword(encryptedPassword);
        //        newUser.setFirstName(userDTO.getFirstName());
        //        newUser.setLastName(userDTO.getLastName());
        //        if (userDTO.getEmail() != null) {
        //            newUser.setEmail(userDTO.getEmail().toLowerCase());
        //        }
        //        newUser.setImageUrl(userDTO.getImageUrl());
        //        newUser.setLangKey(userDTO.getLangKey());
        //        // new user is not active
        //        newUser.setActivated(false);
        //        // new user gets registration key
        //        newUser.setActivationKey(RandomUtil.generateActivationKey());
        //        Set<Authority> authorities = new HashSet<>();
        //        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
        //        newUser.setAuthorities(authorities);
        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    private boolean removeNonActivatedUser(User existingUser) {
        //        if (existingUser.isActivated()) {
        //            return false;
        //        }
        userRepository.delete(existingUser);
        userRepository.flush();
        return true;
    }

    public User createUser(AdminUserDTO userDTO) {
        User user = new User();
        //        user.setLogin(userDTO.getLogin().toLowerCase());
        //        user.setFirstName(userDTO.getFirstName());
        //        user.setLastName(userDTO.getLastName());
        //        if (userDTO.getEmail() != null) {
        //            user.setEmail(userDTO.getEmail().toLowerCase());
        //        }
        //        user.setImageUrl(userDTO.getImageUrl());
        //        if (userDTO.getLangKey() == null) {
        //            user.setLangKey(Constants.DEFAULT_LANGUAGE); // default language
        //        } else {
        //            user.setLangKey(userDTO.getLangKey());
        //        }
        //        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        //        user.setPassword(encryptedPassword);
        //        user.setResetKey(RandomUtil.generateResetKey());
        //        user.setResetDate(Instant.now());
        //        user.setActivated(true);
        //        if (userDTO.getAuthorities() != null) {
        //            Set<Authority> authorities = userDTO
        //                .getAuthorities()
        //                .stream()
        //                .map(authorityRepository::findById)
        //                .filter(Optional::isPresent)
        //                .map(Optional::get)
        //                .collect(Collectors.toSet());
        //            user.setAuthorities(authorities);
        //        }
        userRepository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

    /**
     * Update all information for a specific user, and return the modified user.
     *
     * @param userDTO user to update.
     * @return updated user.
     */
    public Optional<AdminUserDTO> updateUser(AdminUserDTO userDTO) {
        //        return Optional.of(userRepository.findById(userDTO.getId()))
        //            .filter(Optional::isPresent)
        //            .map(Optional::get)
        //            .map(user -> {
        //                user.setLogin(userDTO.getLogin().toLowerCase());
        //                user.setFirstName(userDTO.getFirstName());
        //                user.setLastName(userDTO.getLastName());
        //                if (userDTO.getEmail() != null) {
        //                    user.setEmail(userDTO.getEmail().toLowerCase());
        //                }
        //                user.setImageUrl(userDTO.getImageUrl());
        //                user.setActivated(userDTO.isActivated());
        //                user.setLangKey(userDTO.getLangKey());
        //                Set<Authority> managedAuthorities = user.getAuthorities();
        //                managedAuthorities.clear();
        //                userDTO
        //                    .getAuthorities()
        //                    .stream()
        //                    .map(authorityRepository::findById)
        //                    .filter(Optional::isPresent)
        //                    .map(Optional::get)
        //                    .forEach(managedAuthorities::add);
        //                userRepository.save(user);
        //                log.debug("Changed Information for User: {}", user);
        //                return user;
        //            })
        //            .map(AdminUserDTO::new);
        return null;
    }

    public void deleteUser(String login) {
        //        userRepository
        //            .findOneByLogin(login)
        //            .ifPresent(user -> {
        //                userRepository.delete(user);
        //                log.debug("Deleted User: {}", user);
        //            });
        return;
    }

    /**
     * Update basic information (first name, last name, email, language) for the current user.
     *
     * @param firstName first name of user.
     * @param lastName  last name of user.
     * @param email     email id of user.
     * @param langKey   language key.
     * @param imageUrl  image URL of user.
     */
    public void updateUser(String firstName, String lastName, String email, String langKey, String imageUrl) {
        //        SecurityUtils.getCurrentUserLogin()
        //            .flatMap(userRepository::findOneByLogin)
        //            .ifPresent(user -> {
        //                user.setFirstName(firstName);
        //                user.setLastName(lastName);
        //                if (email != null) {
        //                    user.setEmail(email.toLowerCase());
        //                }
        //                user.setLangKey(langKey);
        //                user.setImageUrl(imageUrl);
        //                userRepository.save(user);
        //                log.debug("Changed Information for User: {}", user);
        //            });
    }

    @Transactional
    public void changePassword(String currentClearTextPassword, String newPassword) {
        //        SecurityUtils.getCurrentUserLogin()
        //            .flatMap(userRepository::findOneByLogin)
        //            .ifPresent(user -> {
        //                String currentEncryptedPassword = user.getPassword();
        //                if (!passwordEncoder.matches(currentClearTextPassword, currentEncryptedPassword)) {
        //                    throw new InvalidPasswordException();
        //                }
        //                String encryptedPassword = passwordEncoder.encode(newPassword);
        //                user.setPassword(encryptedPassword);
        //                log.debug("Changed password for User: {}", user);
        //            });
    }

    @Transactional(readOnly = true)
    public Page<AdminUserDTO> getAllManagedUsers(Pageable pageable) {
        //        return userRepository.findAll(pageable).map(AdminUserDTO::new);
        return null;
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllPublicUsers(Pageable pageable) {
        //        return userRepository.findAllByIdNotNullAndActivatedIsTrue(pageable).map(UserDTO::new);
        return null;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
        //        return userRepository.findOneWithAuthoritiesByLogin(login);
        return null;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        //        return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneWithAuthoritiesByLogin);
        return null;
    }

    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        //        userRepository
        //            .findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant.now().minus(3, ChronoUnit.DAYS))
        //            .forEach(user -> {
        //                log.debug("Deleting not activated user {}", user.getLogin());
        //                userRepository.delete(user);
        //            });
    }

    /**
     * Gets a list of all the authorities.
     * @return a list of all the authorities.
     */
    @Transactional(readOnly = true)
    public List<String> getAuthorities() {
        return authorityRepository.findAll().stream().map(Authority::getName).toList();
    }

    public ResultDto registerUser(RegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
            return new ResultDto(errorMessage, "VALIDATION_ERROR", false);
        }
        User newUser = new User();
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            return new ResultDto("Nhap lai mat khau khong hop le", "PASS_ERRROR", false);
        }
        Integer count = userRepository.countAllByUserName(registerRequest.getUsername());
        if (count > 0) {
            return new ResultDto("Tài khoản đã tồn tại", "PASS_ERRROR", false);
        }

        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPhone(registerRequest.getPhoneNumber());
        newUser.setName(registerRequest.getFullName());
        String encryptedPassword = passwordEncoder.encode(registerRequest.getPassword());
        newUser.setPassword(encryptedPassword);
        newUser.setStatus(true);
        newUser = userRepository.save(newUser);
        RegisterResponse userResponse = new RegisterResponse(newUser.getId(), newUser.getUsername(), newUser.getName());
        return new ResultDto("Đăng ký tài khoản thành công", "SUCCESS", true, userResponse);
    }

    public UserProfileDTO findUserByUserName(String username) {
        User user = userRepository.findUserByUserName(username);
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }
}

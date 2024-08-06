package vn.duong.itech.web.rest.vm;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.duong.itech.domain.User;
import vn.duong.itech.service.UserService;
import vn.duong.itech.service.dto.user.UserProfileDTO;

@RestController
@RequestMapping("/api")
public class ProfileResource {

    private final UserService userService;

    public ProfileResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserProfileDTO user = userService.findUserByUserName(username);
        return ResponseEntity.ok().body(user);
    }
}

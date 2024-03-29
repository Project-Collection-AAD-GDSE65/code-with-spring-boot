package lk.ijse.gdse.aad65.HelloSpringBoot.contoller;

import lk.ijse.gdse.aad65.HelloSpringBoot.service.AuthenticationService;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure.SignIn;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {
   private final AuthenticationService authenticationService;
    //signup
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
       return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }
    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam ("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}

package lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.authObj;

import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure.SignIn;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
}

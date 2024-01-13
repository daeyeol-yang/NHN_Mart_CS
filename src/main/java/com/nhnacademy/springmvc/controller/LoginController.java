package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.repository.AdminRepository;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.repository.UserRepository;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    public LoginController( AdminRepository adminRepository,
                           CustomerRepository customerRepository) {

        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }



    @GetMapping("/login")
    public String login(@CookieValue(value = "SESSION", required = false) String session,
                        @CookieValue(value = "ROLE", required = false) String role,
                        Model model) {
        if (StringUtils.hasText(session)) {
            if (role.equals("ADMIN")) {
                model.addAttribute("id", session);
                model.addAttribute("role", role);

                return "admin/adminMain";
            }
            else{
                return "customerMain";
            }

        } else {
            return "loginForm";
        }
    }



    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (adminRepository.matches(id,pwd)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            Cookie cookieRole = new Cookie("ROLE","ADMIN");
            response.addCookie(cookie);
            response.addCookie(cookieRole);

            modelMap.put("id", session.getId());
            modelMap.put("ROLE", "ADMIN");
            return "admin/adminMain";
        } else if (customerRepository.matches(id,pwd)) {
            HttpSession session = request.getSession(true);
            Cookie cookie = new Cookie("SESSION", session.getId());

            response.addCookie(cookie);

            modelMap.put("id", session.getId());

            return "customerMain";

        } else {
            return "redirect:/login";
        }
    }

}

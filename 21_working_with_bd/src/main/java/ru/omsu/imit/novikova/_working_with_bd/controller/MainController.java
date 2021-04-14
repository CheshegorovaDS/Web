package ru.omsu.imit.novikova._working_with_bd.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.omsu.imit.novikova._working_with_bd.dao.UserDAO;
import ru.omsu.imit.novikova._working_with_bd.entity.User;
import ru.omsu.imit.novikova._working_with_bd.exception.UserException;
import ru.omsu.imit.novikova._working_with_bd.form.ChangePhoneForm;
import ru.omsu.imit.novikova._working_with_bd.model.UserInfo;

@Controller
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<Object[]> list = userDAO.listUserInfo();
        List<UserInfo> users = new ArrayList();
        list.forEach(user -> {
            int id = (int) user[0];
            String phone = ((String) user[1]);
            String email = ((String) user[2]);
            Date date = (Date) user[3];
            users.add(new UserInfo(id, phone, email, date));
        });

        model.addAttribute("userInfos", users);

        return "usersPage";
    }

    @RequestMapping(value = "/changePhone", method = RequestMethod.GET)
    public String viewChangePhonePage(Model model) {
        ChangePhoneForm form = new ChangePhoneForm("89111114455", "89111111111");
        model.addAttribute("changePhoneForm", form);
        return "changePhonePage";
    }

    @RequestMapping(value = "/changePhone", method = RequestMethod.POST)
    public String processChangePhone(Model model, ChangePhoneForm changePhoneForm) {
        System.out.println("Change Phone::" + changePhoneForm.getOldPhone());
        try {
            userDAO.changeUserPhone(changePhoneForm.getOldPhone(), changePhoneForm.getNewPhone());
        } catch (UserException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/changePhonePage";
        }
        return "redirect:/";
    }
}

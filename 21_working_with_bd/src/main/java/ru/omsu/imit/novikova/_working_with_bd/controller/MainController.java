package ru.omsu.imit.novikova._working_with_bd.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.omsu.imit.novikova._working_with_bd.dao.UserDAO;
import ru.omsu.imit.novikova._working_with_bd.entity.User;
import ru.omsu.imit.novikova._working_with_bd.model.UserInfo;

@Controller
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<UserInfo> list = userDAO.listUserInfo();//из-за этого
//        UserInfo uI = (UserInfo)list.get(0);
//        String phone = uI.getPhone();

        list.clear();
        list.add(new UserInfo(3, "lddkld", "lkdokod", new Date(16176897770L)));
        model.addAttribute("userInfos", list);

        return "usersPage";
    }

//    @RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
//    public String viewSendMoneyPage(Model model) {
//
//        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);
//
//        model.addAttribute("sendMoneyForm", form);
//
//        return "sendMoneyPage";
//    }

//    @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
//    public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {
//
//        System.out.println("Send Money::" + sendMoneyForm.getAmount());
//
//        try {
//            bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
//                    sendMoneyForm.getToAccountId(), //
//                    sendMoneyForm.getAmount());
//        } catch (BankTransactionException e) {
//            model.addAttribute("errorMessage", "Error: " + e.getMessage());
//            return "/sendMoneyPage";
//        }
//        return "redirect:/";
//    }
}

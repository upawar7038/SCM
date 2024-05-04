package com.contactmanager.ContactManager.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PageContoller {
    @RequestMapping("/home")
  fun home(model:Model):String{
        model.addAttribute("name","umesh Ramchandra")
        model.addAttribute("sname","pawar")
        return "home"
  }
    @RequestMapping("/about")
    fun aboutPage():String{
        return "about"
    }

    @RequestMapping("/services")
    fun servicesPage():String{
        return "services"
    }

    @RequestMapping("/contact")
    fun contactPage():String="contact"
    @RequestMapping("/login")
    fun loginPage():String="login"
    @RequestMapping("/singup")
    fun singupPage():String="singup"


}
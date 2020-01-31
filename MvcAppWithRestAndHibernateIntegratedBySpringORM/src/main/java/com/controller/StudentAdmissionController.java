package com.controller;

import com.dao.StudentDAO;
import com.dao.StudentDAOHibernateImpl;
import com.factory.HibernateFactoryutil;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StudentAdmissionController {

    @Autowired
    private HibernateFactoryutil hibernateFactoryUtil;

    @Autowired
    StudentDAO studentDAOHibernateImpl;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView testMethod() {

        ModelAndView modelview = new ModelAndView("hellopage");
        modelview.addObject("msg", "welcome");

        return modelview;
    }


    @RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
    public ModelAndView admissionMethod() {

        ModelAndView modelview = new ModelAndView("admissionForm");
        return modelview;
    }


    @InitBinder
    public void initmethod(WebDataBinder databinder) {
        //databinder.setDisallowedFields(new String[]{"studentDob"});

        databinder.registerCustomEditor(Date.class, "studentDob", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
        //databinder.registerCustomEditor(String.class,"sname",new StudentNameEditor());
    }


    @ModelAttribute
    public void addCommonObject(Model model) {

        model.addAttribute("headermsg", "this is header msg");
    }

    @RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitMethod(@Valid @ModelAttribute("student") Student student, BindingResult results) {

        System.out.println(student);

        if (results.hasErrors()) {
            return new ModelAndView("admissionForm");
        }

        Integer id = studentDAOHibernateImpl.addStudent(student);

        ModelAndView modelview = new ModelAndView("admissionSuccess");
        modelview.addObject("returnId",id);

        return modelview;
    }

    private Integer addStudent(Student student) {
        Session session = hibernateFactoryUtil.getSfactory().openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

            returnId = (Integer) session.save(student);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("student return id="+returnId);

        return  returnId;

    }
}

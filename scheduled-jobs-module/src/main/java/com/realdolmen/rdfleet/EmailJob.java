package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Service
public class EmailJob {

    private final String MAIL_SUBJECT = "Your carlease is running to an end";
    private final String CONTENT = "You need a new car--> Go get it!";

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    private MimeMessageHelper mimeMessageHelper;

    @Scheduled(cron = "0 0 * * * ")//runs every 24 hours at 12 o'clock PM
    public void checkIfEmployeesCarLeaseIsNearlyExpiredAndSendEmailIfTrue() {
//        List<Employee> employeesInNeedOfANewCar = getAllEmployeesWhoNeedANewCar();
//        try {
//            mimeMessageHelper = setUpMail();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        employeesInNeedOfANewCar.forEach(employee -> {
//            try {
//                setRecipientAndSendMail(employee.getEmail(), mimeMessageHelper);
//                employee.setReceivedMailForNewCar(true);
//                employeeRepository.save(employee);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//        });
    }

//    public List<Employee> getAllEmployeesWhoNeedANewCar() {
//        LocalDate date = LocalDate.now(ZoneId.systemDefault());
//        date = date.plusMonths(4);//Adds 4 months by default
//        return employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);//Methode aanmaken in employeerepository die op basis van date gaat querien.
//    }


    public MimeMessageHelper setUpMail() throws MessagingException {
        MimeMessageHelper mimeMessageHelper = null;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject(MAIL_SUBJECT);
        mimeMessageHelper.setText(CONTENT, true);
        return mimeMessageHelper;
    }

    public void setRecipientAndSendMail(String recipient, MimeMessageHelper mimeMessageHelper) throws MessagingException {
        mimeMessageHelper.setTo(recipient);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }
}


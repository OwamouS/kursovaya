package com.ifmo.isdb;

import com.ifmo.isdb.DB.DAO.AdministrationDao;
import com.ifmo.isdb.DB.Service.*;
import com.ifmo.isdb.DB.pojo.*;
import com.ifmo.isdb.DB.repos.NotificationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    PassengerService passengerService;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    PassengerApplicationService passengerApplicationService;
    @Autowired
    Answer answer;
    @Autowired
    AdministrationApplicationService administrationApplicationService;
    @Autowired
    High_CouncilApplicationService high_CouncilApplicationService;
    @Autowired
    NotificationsService notificationsService;
    @Autowired
    AdministrationMessagesService administrationMessagesService;
    @Autowired
    AdministrationMembersService administrationMembersService;
    @Autowired
    AdministrationService administrationService;
    @Autowired
    AdministrationDao administrationDao;
    @Autowired
    HighCouncilMembersService highCouncilMembersService;
    @Autowired
    High_CouncilService high_councilService;
    @PostMapping(value = "/adduser")
    public void addNewUser(@RequestBody Passenger passenger) {
        if(!passengerService.isPassenger(passenger.getLogin())&&passenger.getLogin().indexOf(" ")==-1) {
            System.out.println(passenger.getPassword());
            this.passengerService.addPassenger(passenger);
        }
        String race = passenger.getRace();
        if(!administrationDao.findAll().stream().anyMatch(administrations -> race.equals(administrations.getRace()))){
            Administration administration = new Administration();
            administration.setRace(race);
            this.administrationService.addAdministration(administration);
        }
        if(passenger.getPermission()==1){
            administrationMembersService.AddMember(administrationService.getAdministrationByRace(race).getId(),passenger.getId(),passenger.getPermission());
        }
        if(passenger.getPermission()==2){
            highCouncilMembersService.AddMember(1,passenger.getId(),passenger.getPermission());
        }

    }

    @PostMapping(value = "/sentPassengerApplication")
    public void sentPassengerApp(@RequestBody Application application) {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        Passenger passenger = passengerService.getPassenger(login);
        int app_id = applicationService.addApplication(application);
        passengerApplicationService.addPassengerApplication(passenger.getId(), app_id);
    }
    @GetMapping(value = "/getPassengerApplications")
    public ArrayList<Application> getPassengerApp() {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        Passenger passenger = passengerService.getPassenger(login);
        return passengerApplicationService.getApplications(passenger.getId());
    }
    @GetMapping(value = "/getPassengerApplicationsForAdministration")
    public ArrayList<Application> getPassengerApplicationsForAdministration() {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        Passenger passenger = passengerService.getPassenger(login);
        return administrationApplicationService.getApplicationsForAdministration(passenger.getRace());
    }

    @PostMapping(value = "/setStatusAndResult")
    public void setStatusAndResult(@RequestBody Application application) {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        Passenger passenger = passengerService.getPassenger(login);
        administrationApplicationService.setStatusAndResult(application.getId(),application.getStatus(),application.getResult());
        if(!administrationApplicationService.existsAdministrationApplicationById(application.getId())){
            administrationApplicationService.addAdministrationApplication(administrationService.getAdministrationByRace(passenger.getRace()).getId(),application.getId());
        }
    }
    @PostMapping(value = "/highCouncilSetStatusAndResult")
    public void highCouncilSetStatusAndResult(@RequestBody Application application) {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        Passenger passenger = passengerService.getPassenger(login);
        high_CouncilApplicationService.setHigh_CouncilStatusAndResult(application.getId(),application.getStatus(),application.getResult());
        high_CouncilApplicationService.addHighCouncilApplication(1,application.getId(),application.getStatus());
    }
    @GetMapping(value = "/getPassengerApplicationsForHigh_Council")
    public ArrayList<Application> getPassengerApplicationsForHigh_Council() {
        return high_CouncilApplicationService.getApplicationsForHigh_Council();
    }
    @GetMapping(value = "/getNotifications")
    public ArrayList<Notification> getNotifications() {
        return notificationsService.getNotifications();
    }
    @GetMapping(value = "/getMessages")
    public ArrayList<AdministrationMessage> getMessages() {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        Passenger passenger = passengerService.getPassenger(login);
        int member_id = administrationMembersService.getMember(passenger.getId());
        return administrationMessagesService.getMessages(member_id);
    }
    @PostMapping(value = "/addMessage")
    public void addMessage(@RequestBody MessageToAdministration message) {
        Passenger passenger = passengerService.getPassenger(message.getLogin());
        int member_id = administrationMembersService.getMember(passenger.getId());
        administrationMessagesService.addMessage(member_id, message.getMessage());
    }

    @PostMapping(value = "/addNotification")
    public void addNotification(@RequestBody Answer text) {
        notificationsService.addNotification(text.getAnswer());
    }

    @PostMapping(value = "/deleteNotifications")
    public void deleteNotification() {
        notificationsService.deleteNotifications();
    }
}

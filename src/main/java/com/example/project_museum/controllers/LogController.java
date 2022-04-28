package com.example.project_museum.controllers;

import com.example.project_museum.models.entities.LogEntity;
import com.example.project_museum.models.requests.LogRequest;
import com.example.project_museum.repositories.LogEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/hub/logs")
public class LogController {

    private final LogEntityRepository logEntityRepository;

    public LogController(LogEntityRepository logEntityRepository) {
        this.logEntityRepository = logEntityRepository;
    }

    @PostMapping()
    public LogEntity insert(@RequestBody LogRequest logRequest){
        return logEntityRepository.save(new LogEntity(logRequest.getAction(), Timestamp.valueOf(LocalDateTime.now())));

    }

    @GetMapping("/active")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Integer getActiveUsers(){
        return logEntityRepository.countAction("login") - logEntityRepository.countAction("logout");
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getStatistics(){
        Map<String, ArrayList<String>> statistics = new LinkedHashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        int j = 0;
        int currentHour = LocalDateTime.now().getHour() + 2;
        System.out.println(currentHour);
        List<Integer> hours = new ArrayList<>();
        String h1="",h2="";
        for(int i = currentHour+1; i < 24 ; i++) {

            if( i < 9){
                h1 = "0" + i;
                h2 = "0" + (i+1);
            }
            else if(i == 9){
                h1 = "0" + i;
                h2 = "" + (i+1);
            }
            else{
                h1 = "" + i;
                h2 = "" + (i+1);
            }

            System.out.println(h1 + " " + h2);
            keys.add(h1);
            values.add(logEntityRepository.activeUsersForHourYesterday("" + h1 + ":00:00","" + h2 + ":00:00") + "");
            //statistics.put(h1, logEntityRepository.activeUsersForHourYesterday("" + h1 + ":00:00","" + h2 + ":00:00"));
        }
        for(int i = 0; i <=currentHour ; i++) {
            if( i < 9){
                h1 = "0" + i;
                h2 = "0" + (i+1);
            }
            else if(i == 9){
                h1 = "0" + i;
                h2 = "" + (i+1);
            }
            else{
                h1 = "" + i;
                h2 = "" + (i+1);
            }
            System.out.println(h1 + " " + h2);
            keys.add(h1);
            values.add(logEntityRepository.activeUsersForHourYesterday("" + h1 + ":00:00","" + h2 + ":00:00") + "");
            //statistics.put(h1, logEntityRepository.activeUsersForHourToday("" + h1 + ":00:00","" + h2 + ":00:00"));
        }
        statistics.put("keys", keys);
        statistics.put("values", values);
        return ResponseEntity.ok(statistics);

    }


}

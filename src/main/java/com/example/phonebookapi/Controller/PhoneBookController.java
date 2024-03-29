package com.example.phonebookapi.Controller;

import com.example.phonebookapi.Entity.Database;
import com.example.phonebookapi.Dtos.DatabaseDto;
import com.example.phonebookapi.Service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/data")
public class PhoneBookController {
    private final PhoneService phoneService;

    public PhoneBookController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<DatabaseDto>> pageResponseEntity(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Page<DatabaseDto> dtoPage = phoneService.find(page, size);
        return ResponseEntity.ok(dtoPage);
    }

    @PostMapping("/add")
    public ResponseEntity<DatabaseDto> saveDatabase(@RequestBody DatabaseDto databaseDto) {
        databaseDto.setAprove(false);
        DatabaseDto savedata = phoneService.save(databaseDto);
        URI savedUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedata.getId())
                .toUri();
        return ResponseEntity.created(savedUri).body(savedata);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Database>> find(@RequestParam(name = "name") String name,
                                               @RequestParam(name = "surname") String surname) {

        List<Database> result = phoneService.findByname(name,surname);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatabaseDto> getDetails(@PathVariable Long id){
        return phoneService.getDataByid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

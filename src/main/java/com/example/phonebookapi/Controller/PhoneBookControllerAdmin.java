package com.example.phonebookapi.Controller;

import com.example.phonebookapi.Dtos.DatabaseDto;
import com.example.phonebookapi.Service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class PhoneBookControllerAdmin {
    private final PhoneService phoneService;

    public PhoneBookControllerAdmin(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/acceptable")
    public ResponseEntity<Page<DatabaseDto>> pageResponseEntity(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Page<DatabaseDto> dtoPage = phoneService.findAproveFalse(page, size);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/acceptable/{id}")
    public ResponseEntity<DatabaseDto> getDetails(@PathVariable Long id) {
        return phoneService.getDataByid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all-data")
    public ResponseEntity<Page<DatabaseDto>> getAllAdmin(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        Page<DatabaseDto> findAllAdmin = phoneService.findAllAdmin(page,size);
        return ResponseEntity.ok(findAllAdmin);
    }

    @PutMapping("/acceptable/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DatabaseDto databaseDto){
        return phoneService.updateData(id, databaseDto)
                .map(c->ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}


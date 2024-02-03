package com.example.phonebookapi.Controller;

import com.example.phonebookapi.Entity.DatabaseDto;
import com.example.phonebookapi.Service.PhoneService;
import jakarta.persistence.Id;
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

    @PutMapping("/acceptable/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DatabaseDto databaseDto){
        return phoneService.updateData(id, databaseDto)
                .map(c->ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }
}


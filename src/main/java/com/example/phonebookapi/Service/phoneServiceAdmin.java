package com.example.phonebookapi.Service;

import com.example.phonebookapi.Repozytory.PhoneRepozytory;
import org.springframework.stereotype.Service;

@Service
public class phoneServiceAdmin {
    private final PhoneRepozytory phoneRepozytory;

    public phoneServiceAdmin(PhoneRepozytory phoneRepozytory) {
        this.phoneRepozytory = phoneRepozytory;
    }

}

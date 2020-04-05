package com.lighthms.lighthmsservice.cases;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping(name = "/cases")
public class CaseController {

    private final CaseRepository caseRepository;

    @PutMapping("/{case_id}/add-event")
    public ResponseEntity<?> addEvent(@PathVariable("case_id") Case caseObject, @RequestBody CaseEvent event) {
        Case aCase = caseObject.addEvent(event);
        caseRepository.save(aCase);
        return ResponseEntity.ok(aCase);
    }
}

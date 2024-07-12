package com.kaiwa.contactservice.controller;

import com.kaiwa.contactservice.payload.request.ContactRequest;
import com.kaiwa.contactservice.payload.response.ContactResponse;
import com.kaiwa.contactservice.payload.response.WebResponse;
import com.kaiwa.contactservice.service.ContactService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WebResponse<ContactResponse>> create(@RequestBody @Valid ContactRequest contactRequest) {
        ContactResponse contactResponse = contactService.create(contactRequest);
        return ResponseEntity.ok(WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build());
    }

    @GetMapping(
            path = "/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WebResponse<List<ContactResponse>>> findAllByUserId(@PathVariable(value = "userId", required = true) String userId) {
        List<ContactResponse> contactResponses = contactService.findAllByUserId(userId);
        return ResponseEntity.ok(WebResponse.<List<ContactResponse>>builder()
                .data(contactResponses)
                .build());
    }

}
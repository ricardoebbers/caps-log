package com.ebbers.capslog.rest.controller;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.service.LogService;
import com.ebbers.capslog.rest.resource.LogListResource;
import com.ebbers.capslog.rest.resource.LogResource;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Log by Id"),
            @ApiResponse(responseCode = "404", description = "Log not found")
    })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LogResource> get(@PathVariable Long id) {
        return service.findById(id)
                .map(LogResource::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all logs")
    })
    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public Page<LogListResource> list() {
        return LogListResource.fromPage(service.findAll(Pageable.unpaged()));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all logs")
    })
    @GetMapping(value = "/level", produces = APPLICATION_JSON_VALUE)
    public Page<LogListResource> listByLevel(
            @RequestParam Level level,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "ASC") Direction direction,
            @RequestParam(defaultValue = "", required = false) String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, (sort.isEmpty()) ? Sort.unsorted() : Sort.by(direction, sort));
        return LogListResource.fromPage(service.findByLevel(level, pageable));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Saved log"),
            @ApiResponse(responseCode = "404", description = "Log not found")
    })
    @PostMapping(value = "/", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LogResource create(@RequestBody LogResource resource) {
        return LogResource.fromEntity(service.save(resource.toEntity()));
    }
}

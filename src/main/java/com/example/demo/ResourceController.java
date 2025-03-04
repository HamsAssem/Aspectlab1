package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private String resource = "Default Data";

    // GET Request
    @GetMapping
    public Response getResource() {
        return new Response("Data retrieved successfully", resource, Instant.now().toString());
    }

    // POST Request
    @PostMapping
    public Response createResource(@RequestBody RequestData newData) {
        // Simulate data creation by using the received data
        return new Response("Data created successfully", newData, Instant.now().toString());
    }

    // PUT Request
    @PutMapping
    public String updateResource(@RequestBody String updatedResource) {
        this.resource = updatedResource;
        return "Resource Updated: " + resource;
    }

    // DELETE Request
    @DeleteMapping
    public String deleteResource() {
        this.resource = "Deleted";
        return "Resource Deleted";
    }

    // Custom response object to return JSON
    public static class Response {
        private String message;
        private Object data;
        private String timestamp;

        public Response(String message, Object data, String timestamp) {
            this.message = message;
            this.data = data;
            this.timestamp = timestamp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }

    // RequestData class to handle incoming data in POST request
    public static class RequestData {
        private int id;
        private String name;
        private String description;

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

package com.santosh.springbootjpa;

import com.santosh.springbootjpa.dto.request.DepartmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DepartmentTest extends AbstractTest {

    public static void main(String[] args) {

        DepartmentTest departmentTest = new DepartmentTest();

        departmentTest.testGetAllDepartments();
        departmentTest.testGetDepartment();
        departmentTest.testGetDepartmentByQueryParams();
        departmentTest.testPostDepartment();
        departmentTest.testPutDepartment();
        departmentTest.testDeleteDepartment();
    }

    private void testGetAllDepartments() {

        String finalUrl = buildPath("departments");

        ResponseEntity<String> response = restTemplate.getForEntity(finalUrl, String.class);

        String result = response.getBody();

        log.info("Result : {}", result);
    }

    private void testGetDepartment() {

        String finalUrl = buildPath("departments/{id}");

        int departmentId = 1;

        ResponseEntity<String> response = restTemplate.getForEntity(finalUrl, String.class, departmentId);

        String result = response.getBody();

        log.info("Result : {}", result);
    }

    private void testGetDepartmentByQueryParams() {

        String finalUrl = buildPath("departments/query?id={id}");

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", 1);

        ResponseEntity<String> response = restTemplate.getForEntity(finalUrl, String.class, queryParams);

        String result = response.getBody();

        log.info("Result : {}", result);
    }

    private void testPostDepartment() {
        String finalUrl = buildPath("departments");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        DepartmentRequest departmentRequest = DepartmentRequest.builder()
                .name("Research")
                .build();

        HttpEntity<DepartmentRequest> request =
                new HttpEntity<>(departmentRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(finalUrl, request, String.class);

        String result = response.getBody();

        log.info("Result : {}", result);
    }

    private void testPutDepartment() {
        String finalUrl = buildPath("departments");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        DepartmentRequest departmentRequest = DepartmentRequest.builder()
                .id(1)
                .name("Marketing")
                .build();

        HttpEntity<DepartmentRequest> request =
                new HttpEntity<>(departmentRequest, headers);

        ResponseEntity<String> response = restTemplate
                .exchange(finalUrl, HttpMethod.PUT, request, String.class);

        String result = response.getBody();

        log.info("Result : {}", result);
    }

    private void testDeleteDepartment() {
        String finalUrl = buildPath("departments/{id}");

        int departmentId = 1;

        restTemplate.delete(finalUrl, departmentId);
    }
}

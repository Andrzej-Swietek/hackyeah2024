package com.hackyeah2024.feed.project;

import com.hackyeah2024.feed.company.CompanyDTO;
import com.hackyeah2024.feed.company.NgoDTO;
import com.hackyeah2024.feed.company.PopulateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@FeignClient(
        name = "project-service",
        url = "${application.config.project-url}"
)
public interface ProjectClient {

    @PostMapping("/api/v1/company/populate")
    Optional<List<CompanyDTO>> populateCompany(@RequestBody PopulateRequest requestBody);

}

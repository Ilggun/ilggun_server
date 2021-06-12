package com.ilggun.backend.data.controller;

import com.ilggun.backend.data.domain.Data;
import com.ilggun.backend.data.dto.DataListResponseDto;
import com.ilggun.backend.data.dto.DataSaveRequestDto;
import com.ilggun.backend.data.service.DataService;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.SingleResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"3. Data"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/data")
public class DataController {
    private final DataService dataService;

    @ApiOperation(value = "데이터 등록", notes = "데이터를 등록합니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SingleResult<Data> save(@RequestBody DataSaveRequestDto requestDto) {
        return dataService.save(requestDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 access_token",
                    required = true,
                    dataType = "String",
                    paramType = "header")
    })
    @ApiOperation(value = "제품 id로 데이터 검색", notes = "제품의 id로 데이터를 검색합니다.")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ListResult<DataListResponseDto> getPageOfData(
            @RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "page", required = true) Long page
    ) {
        return dataService.findByProductIdLike(id, page);
    }
}

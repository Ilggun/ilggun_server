package com.ilggun.backend.product.controller;

import com.ilggun.backend.product.dto.ProductSaveRequestDto;
import com.ilggun.backend.product.domain.Product;
import com.ilggun.backend.product.dto.ProductUpdateRequestDto;
import com.ilggun.backend.product.service.ProductService;
import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.SingleResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2. Product"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @ApiOperation(value = "제품 등록", notes = "제품을 등록합니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SingleResult<Product> save(@RequestBody ProductSaveRequestDto requestDto) {
        return productService.save(requestDto);
    }

    @ApiOperation(value = "모든 제품 검색", notes = "모든 제품을 검색합니다.")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ListResult<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    @ApiOperation(value = "제품 id로 제품 정보 검색", notes = "제품의 id로 제품의 정보를 검색합니다.")
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleResult<Product> findByProductId(@ApiParam(value = "제품의 고유 id", required = true) @PathVariable Long id) {
        return productService.findByProductId(id);
    }

    @ApiOperation(value = "사용자 보유 제품 정보 검색", notes = "사용자의 id로 사용자가 보유하고 있는 제품들의 정보를 출력합니다.")
    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ListResult<Product> findByUserId(@ApiParam(value = "사용자의 고유 id", required = true) @PathVariable Long id) {
        return productService.findByUserId(id);
    }

    @ApiOperation(value = "제품 id로 제품 정보 변경", notes = "제품의 정보를 변경합니다.")
    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleResult<Product> update(@ApiParam(value = "제품 고유 id", required = true) @PathVariable Long id, @RequestBody ProductUpdateRequestDto requestDto) {
        return productService.update(id, requestDto);
    }

    @ApiOperation(value = "제품 id로 제품 정보 삭제", notes = "제품의 정보를 삭제합니다.")
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommonResult deleteByProductId(@ApiParam(value = "제품 고유 id", required = true) @PathVariable Long id) {
        return productService.deleteByProductId(id);
    }
}

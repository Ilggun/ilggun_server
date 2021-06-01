package com.ilggun.backend.data.service;

import com.ilggun.backend.advice.exception.CProductNotFoundException;
import com.ilggun.backend.data.domain.Data;
import com.ilggun.backend.data.domain.DataRepository;
import com.ilggun.backend.data.dto.DataListResponseDto;
import com.ilggun.backend.data.dto.DataSaveRequestDto;
import com.ilggun.backend.product.domain.Product;
import com.ilggun.backend.product.domain.ProductRepository;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.ResponseService;
import com.ilggun.backend.response.SingleResult;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DataService {
    private final ProductRepository productRepository;
    private final DataRepository dataRepository;
    private final ResponseService responseService;

    private ModelMapper modelMapper;

    @Transactional
    public SingleResult<Data> save(DataSaveRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getProductId()).orElseThrow(CProductNotFoundException::new);
        Data data = new Data(
                product,
                requestDto.getGas(),
                requestDto.getHumidity(),
                requestDto.getSmoke(),
                requestDto.getTemperature()
        );
        return responseService.getSingleResult(dataRepository.save(data));
    }

    @Transactional
    public ListResult<DataListResponseDto> findByProductIdLike(Long productId, Long page) {
        Page<Data> data = dataRepository.findAllByProductId(productId, PageRequest.of(page.intValue(), 10, Sort.by("createDate").descending()));
        return responseService.getListResult(
                data.getContent().stream().map(
                        DataListResponseDto::new
                ).collect(Collectors.toList()));
    }

    @Transactional
    public ListResult<DataListResponseDto> findAllByProductId(Long productId) {
        return responseService.getListResult(
                dataRepository.findByProductId(productId).stream()
                        .map(DataListResponseDto::new)
                        .collect(Collectors.toList())
        );
    }

    private <R, T> T sourceToDestination(R source, T destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}

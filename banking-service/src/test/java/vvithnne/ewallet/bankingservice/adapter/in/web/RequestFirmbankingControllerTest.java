package vvithnne.ewallet.bankingservice.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.request.RequestFirmbankingRequest;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.response.RequestFirmbankingResponse;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking.FirmbankingStatus;
import vvithnne.ewallet.common.constant.BankType;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RequestFirmbankingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private static final String REQUEST_FIRMBANKING_URI = "/banking/firmbanking/request";

    private static final RequestFirmbankingRequest 펌뱅킹_요청 = new RequestFirmbankingRequest(
            BankType.KAKAOBANK.getCode(),
            "333312345678",
            BankType.WOORI.getCode(),
            "1002123456789",
            new BigDecimal(10000)
    );

    private static final RequestFirmbankingResponse 펌뱅킹_응답 = new RequestFirmbankingResponse(
            1L,
            펌뱅킹_요청.fromBankCode(),
            펌뱅킹_요청.fromBankAccountNumber(),
            펌뱅킹_요청.toBankCode(),
            펌뱅킹_요청.toBankAccountNumber(),
            펌뱅킹_요청.moneyAmount(),
            FirmbankingStatus.COMPLETED.getCode(),
            null
    );

    @Test
    void requestFirmbanking() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post(REQUEST_FIRMBANKING_URI)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(펌뱅킹_응답))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.requestedFirmbankingId", org.hamcrest.Matchers.is(1)));
    }
}

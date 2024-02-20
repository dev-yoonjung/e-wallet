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
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.request.RegisterBankAccountRequest;
import vvithnne.ewallet.bankingservice.adapter.in.web.dto.response.RegisterBankAccountResponse;
import vvithnne.ewallet.common.constant.BankType;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterBankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private static final String BANK_ACCOUNT_URI = "/banking/account";

    private static final RegisterBankAccountRequest 카카오뱅크_요청 = new RegisterBankAccountRequest(
            1L,
            BankType.KAKAOBANK.getCode(),
            "333312345678"
    );

    private static final RegisterBankAccountResponse 카카오뱅크_응답 = new RegisterBankAccountResponse(
            1L,
            카카오뱅크_요청.membershipId(),
            카카오뱅크_요청.bankCode(),
            카카오뱅크_요청.bankAccountNumber(),
            true
    );

    @Test
    void registerBankAccount() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post(BANK_ACCOUNT_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(카카오뱅크_요청))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(카카오뱅크_응답)));
    }
}
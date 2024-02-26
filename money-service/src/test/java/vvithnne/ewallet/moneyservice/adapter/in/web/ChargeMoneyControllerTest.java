package vvithnne.ewallet.moneyservice.adapter.in.web;

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
import vvithnne.ewallet.moneyservice.adapter.in.web.dto.request.ChargeMoneyRequest;
import vvithnne.ewallet.moneyservice.adapter.in.web.dto.response.ChargeMoneyResponse;
import vvithnne.ewallet.moneyservice.common.constant.ChangingStatus;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ChargeMoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private static final String MONEY_CHARGE_URI = "/money/charge";

    public static final ChargeMoneyRequest 충전_요청 = new ChargeMoneyRequest(
            1L,
            new BigDecimal(10000)
    );

    public static final ChargeMoneyResponse 충전_응답 = new ChargeMoneyResponse(
            1L,
            충전_요청.amount(),
            ChangingStatus.COMPLETED.getCode()
    );

    @Test
    void chargeMoney() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post(MONEY_CHARGE_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(충전_요청))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(충전_응답)));
    }

}
